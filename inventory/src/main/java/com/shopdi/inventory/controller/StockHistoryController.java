package com.shopdi.inventory.controller;

import com.shopdi.inventory.constants.ApiConstant;
import com.shopdi.inventory.service.StockHistoryService;
import com.shopdi.inventory.viewmodel.stockhistory.StockHistoryListVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.STOCK_HISTORY_URL)
public class StockHistoryController {
    private final StockHistoryService stockHistoryService;

    public StockHistoryController(StockHistoryService stockHistoryService) {
        this.stockHistoryService = stockHistoryService;
    }

    @GetMapping
    public ResponseEntity<StockHistoryListVm> getStockHistories(@RequestParam Long productId,
            @RequestParam Long warehouseId) {
        return ResponseEntity.ok(
                stockHistoryService.getStockHistories(
                        productId,
                        warehouseId));
    }
}
