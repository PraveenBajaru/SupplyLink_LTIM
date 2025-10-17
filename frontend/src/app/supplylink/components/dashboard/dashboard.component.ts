
import { Component, OnInit } from '@angular/core';
import { SupplyLinkService } from '../../services/supplylink.service';
import { Supplier } from '../../types/Supplier';
import { Warehouse } from '../../types/Warehouse';
import { Product } from '../../types/Product';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
    suppliers: Supplier[] = [];
    warehouses: Warehouse[] = [];
    products: Product[] = [];

    userSupplier: Supplier;
    supplierWarehouses: Warehouse[] = [];
    selectedWarehouseProducts: Product[] = [];
    selectedWarehouseId: number | undefined;

    role: string | null;
    userId: number;

    
    showProductPopup: boolean = false;
    productForm: FormGroup;
    currentProduct: Product | null = null;

    constructor(private supplyLinkService: SupplyLinkService, private router: Router, private formBuilder: FormBuilder) { }

    ngOnInit(): void {
        this.role = localStorage.getItem("role");
        this.userId = Number(localStorage.getItem("user_id"));
        this.productForm = this.formBuilder.group({
            productName: ['', Validators.required],
            productDescription: ['', Validators.required],
            quantity: [0, Validators.required],
            price: [0, Validators.required]
        });
        if (this.role === 'ADMIN') {
            this.loadAdminData();
        } else {
            this.loadUserData();
        }
    }

    loadAdminData(): void {
        this.supplyLinkService.getAllSuppliers().subscribe({
            next: (response) => {
                this.suppliers = response;
            },
            error: (error) => console.log('Error loading suppliers', error)
        });

        this.supplyLinkService.getAllWarehouses().subscribe({
            next: (response) => {
                this.warehouses = response;
            },
            error: (error) => console.log('Error loading warehouses', error)
        });

        this.supplyLinkService.getAllProducts().subscribe({
            next: (response) => {
                this.products = response;
            },
            error: (error) => console.log('Error loading products', error)
        });
    }

    loadUserData(): void {
        this.supplyLinkService.getSupplierById(this.userId).subscribe({
            next: (supplier) => {
                this.userSupplier = supplier;
                this.supplyLinkService.getWarehousesBySupplier(supplier.supplierId!).subscribe({
                    next: (warehouses) => {
                        this.supplierWarehouses = warehouses;
                        this.selectedWarehouseId = this.supplierWarehouses[0].warehouseId;
                        this.loadProductsForWarehouse(this.selectedWarehouseId);
                    },
                    error: (error) => console.error('Error loading warehouses for supplier:', error)
                })
            },
            error: (error) => console.error('Error loading supplier data:', error)
        });
    }

    loadProductsForWarehouse(warehouseId: number): void {
        this.supplyLinkService.getAllProductByWarehouse(warehouseId).subscribe({
            next: (products) => {
                this.selectedWarehouseProducts = products;
            },
            error: (error) => console.error(`Error loading products for warehouse ${warehouseId}:`, error)
        })
    }
}
