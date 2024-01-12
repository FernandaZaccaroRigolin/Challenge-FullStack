import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { PoBreadcrumb, PoBreadcrumbItem, PoMenuComponent, PoMenuItem, PoMenuPanelItem, PoPageAction } from '@po-ui/ng-components';
import { Constants } from './application/constants';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{
  title: string = 'Desafio';
  triggeredRoute: boolean = false

  PoBreadcrumb?: PoBreadcrumb;
  PoBreadcrumbMenu?: PoBreadcrumb;
  isCadastrarCliente: boolean = false;
  isvisualizarClientes: boolean = false;
  
  public readonly menuItems: Array<PoMenuPanelItem> = [
    { label: 'Configurador', action: this.changeTitle.bind(this), icon: 'po-icon-settings' }
  ];

  constructor(private router: Router) {}

  triggerRoute(route: string): void {
    this.router.navigateByUrl(route);
    this.triggeredRoute = true;
  }  

  changeTitle(menu: PoMenuPanelItem) {
    this.triggeredRoute = false;
    this.title = menu.label;
    this.PoBreadcrumbMenu = {items:[Constants.breadcrumb.start, Constants.breadcrumb.configurator]}
    this.PoBreadcrumb = this.PoBreadcrumbMenu;
  }
}
