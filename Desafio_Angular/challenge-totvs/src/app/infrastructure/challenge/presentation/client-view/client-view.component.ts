import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { PoBreadcrumb, PoButtonComponent } from '@po-ui/ng-components';
import { filter } from 'rxjs/operators';
import { ClientFacadeService } from 'src/app/application/challenge/abstraction/client-facade.service';
import { Constants } from 'src/app/application/constants';

@Component({
  selector: 'app-client-view',
  templateUrl: './client-view.component.html',
  styleUrls: ['./client-view.component.css']
})
export class ClientViewComponent implements OnInit {
  @ViewChild(PoButtonComponent, { static: true })
  button: PoButtonComponent = new PoButtonComponent;
  title: string = 'Cadastro de Clientes'
  poBreadcrumb?: PoBreadcrumb;

  columns = [
    { property: 'name', label: 'Nome', width: '150', required: true },
    { property: 'address', label: 'Endereço', width: 150, required: true},
    { property: 'district', label: 'Bairro', width: 100, required: true },
    { property: 'phones', label: 'Telefones', align: 'center', width: 200 },
  ];

  data: {name: string, address: string, district: string, phones: string}[] = [];

  constructor(private service: ClientFacadeService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.poBreadcrumb = { items: [Constants.breadcrumb.start, Constants.breadcrumb.configurator, Constants.breadcrumb.client] }
    this.getListClient();
  }  

  async getListClient(): Promise<void> {
    try {
      const resposta = await this.service.getAllClient().toPromise();
  
      if (resposta) {
        resposta.map(data => {
          this.data.push({
            name: data.name,
            address: data.address,
            district: data.district,
            phones: data.phones.map(data => data.number).toString()
          });
        });
      } else {
        console.error('A resposta é undefined.');
      }
    } catch (error) {
      console.error('Erro ao obter a lista de clientes:', error);
    }
  }

  focusButton(): void {
    this.button.focus();
  }

  insertClient(): void{
    this.router.navigateByUrl('/client/new');
  }

}
