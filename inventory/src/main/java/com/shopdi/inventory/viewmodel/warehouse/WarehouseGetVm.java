package com.shopdi.inventory.viewmodel.warehouse;

import com.shopdi.inventory.model.Warehouse;

public record WarehouseGetVm(Long id, String name) {

    public static WarehouseGetVm fromModel(Warehouse warehouse) {
        return new WarehouseGetVm(warehouse.getId(), warehouse.getName());
    }
}