import { HttpErrorResponse } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { FormGroup, UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoBreadcrumb, PoModalComponent,  PoModalAction, PoPageAction, PoNotificationService, PoTableColumn } from '@po-ui/ng-components';
import { PoToaster } from '@po-ui/ng-components/lib/services/po-notification/po-toaster/po-toaster.interface';
import { ClientFacadeService } from 'src/app/application/challenge/abstraction/client-facade.service';
import { Constants } from 'src/app/application/constants';
import { Client } from 'src/app/domain/challenge/model/client';
import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { Phone } from 'src/app/domain/challenge/model/phone';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {
  @ViewChild(PoModalComponent, { static: true }) poModal!: PoModalComponent;
  @ViewChild('reactiveFormData', { static: true }) reactiveFormModal!: PoModalComponent;

  clientForm!: UntypedFormGroup;
  phoneForm!: FormGroup;

  phone?: string;
  columns: Array<PoTableColumn> = [{ property: 'number', label: 'Telefones' }];
  phones: Phone[] = [];
  title: string = 'Novo Cliente'  
  poBreadcrumb?: PoBreadcrumb;
  isDisabled: boolean = true;

  content!: string;  
  primaryActionLabel!: string;
  primaryActionProperties!: Array<string>;
  secondaryActionLabel!: string;
  secondaryActionProperties!: Array<string>;

  primaryAction: PoModalAction = {
    action: () => {
      this.poModal.close();
      this.router.navigateByUrl('');   
    },
    label: 'Confirmar'
  }; 

  secondaryAction: PoModalAction = {
    action: () => {
      this.poModal.close();
    },
    label: 'Cancelar'
  }; 

  constructor(public poNotification: PoNotificationService, private service: ClientFacadeService, private router: Router, private fb: UntypedFormBuilder) {
    this.createReactiveForm();
  }

  createReactiveForm() {
    this.clientForm = this.fb.group({
      name: ['', Validators.compose([Validators.required, Validators.minLength(10)])],
      address: ['', Validators.compose([Validators.required, Validators.minLength(5)])],
      number: ['', Validators.compose([Validators.required, Validators.min(1), Validators.max(99999)])],
      district: ['', Validators.compose([Validators.required, Validators.minLength(5)])]
    });

    this.phoneForm = this.fb.group({
      phone: ['', [Validators.required, this.telefoneValidator()]],
    });    
  } 

  ngOnInit(): void {
    this.poBreadcrumb = { items: [Constants.breadcrumb.start, Constants.breadcrumb.configurator, Constants.breadcrumb.client, Constants.breadcrumb.newClient] }
  }
  
  async validateNameRedundant(name: string): Promise<string> {
    try {
      const response = await this.service.getClientName(name).toPromise();

      return response && response.length > 0
        ? 'Ops! Parece que esse cliente já foi cadastrado. Verifique os detalhes e tente novamente.'
        : '';
    } catch (error) {
      return `Erro ao obter a lista de clientes: ${error}`;
    }
  }

  async insertClient(){
    const message = await this.validateNameRedundant(this.clientForm.get('name')?.value);
    if (message) {
      const toster: PoToaster = {message: message, orientation:1, duration: 3, position: 0, type: 0};
      this.poNotification.createToaster(toster);
      return;
    }
    let client: Client = new Client();
    client.name = this.clientForm.get('name')?.value;
    client.address = this.clientForm.get('address')?.value+ ', '+ this.clientForm.get('number')?.value;
    client.district = this.clientForm.get('district')?.value;
    client.phones = this.phones;

    this.service.insertClient(client).subscribe(
      (response: Client) => {
        this.insertClientJSON(response);
      },
      (error: HttpErrorResponse) => {
        const toster: PoToaster = {message: error.error, orientation:1, position: 0, type: 0};
        this.poNotification.createToaster(toster);        
      }
    );    
  }

  insertClientJSON(client: Client){
    this.service.insertClientJSON(client).subscribe(
      (response: Client) => {
        const toster: PoToaster = {message: 'Cliente inserido com sucesso', orientation:1, duration: 9000, position: 0, type: 2};
        this.poNotification.createToaster(toster);        
        this.router.navigateByUrl(''); 
      },
      (error: HttpErrorResponse) => {
        const toster: PoToaster = {message: error.error, orientation:1, position: 0, type: 0};
        this.poNotification.createToaster(toster);        
      }
    );   

  }

  cancel(): void {
    this.content = 'Deseja cancelar a inserção do cliente?';
    this.primaryActionLabel = 'Sim';
    this.secondaryActionLabel = 'Não';
    this.primaryAction.label = this.primaryActionLabel;
    this.secondaryAction.label = this.secondaryActionLabel;
    this.poModal.open();
  }

  async addPhone()  {
    if (this.phoneForm.valid) {
      const message = await this.validatePhoneRedundant(this.phoneForm.get('phone')?.value);
      if (message) {
        const toster: PoToaster = {message: message, orientation:1, duration: 3, position: 0, type: 0};
        this.poNotification.createToaster(toster);
        return;
      }      
      this.phones.push({number: String(this.phoneForm.get('phone')?.value)});
    }
  }

  telefoneValidator(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const telefonePattern = /\(\d{2}\)\d{4,5}-\d{4}/;
  
      if (control.value && !telefonePattern.test(control.value)) {
        return { telefoneInvalido: true };
      }
  
      return null;
    };
  }  

  async validatePhoneRedundant(phone: string): Promise<string> {
    const telefoneExistente = this.phones.some(item => item.number === phone);
    if (telefoneExistente) {
      return 'Ops! Parece que esse telefone já foi inserido. Verifique os detalhes e tente novamente.' 
    }
    const resposta = await this.service.getAllClient().toPromise();
    if (resposta instanceof Array) {
      const clienteEncontrado = resposta.find(cliente =>
        cliente.phones.some(ph => ph.number === phone)
      );
      if (clienteEncontrado) {
        return 'Ops! Parece que esse telefone já foi cadastrado. Verifique os detalhes e tente novamente.' 
      }    
    }  
    return ''
  }  
}

