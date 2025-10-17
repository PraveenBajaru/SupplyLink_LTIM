import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { SupplierComponent } from "./components/supplier/supplier.component";
import { WarehouseComponent } from "./components/warehouse/warehouse.component";
import { ProductComponent } from "./components/product/product.component";
import { SupplierEditComponent } from "./components/supplieredit/supplieredit.component";
import { WarehouseEditComponent } from "./components/warehouseedit/warehouseedit.component";

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forChild(routes) , DashboardComponent , SupplierComponent , WarehouseComponent , ProductComponent , SupplierEditComponent , WarehouseEditComponent],
  exports: [RouterModule],
})
export class SupplyLinkRoutingModule {}
