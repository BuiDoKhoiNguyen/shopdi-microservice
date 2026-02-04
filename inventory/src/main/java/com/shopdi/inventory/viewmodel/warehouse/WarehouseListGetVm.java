package com.shopdi.inventory.viewmodel.warehouse;

import java.util.List;

public record WarehouseListGetVm(
        List<WarehouseGetVm> warehouseContent,
        int pageNo,
        int pageSize,
        int totalElements,
        int totalPages,
        boolean isLast) {

}