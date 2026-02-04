package com.shopdi.inventory.service;

import com.shopdi.inventory.model.Stock;
import com.shopdi.inventory.model.StockHistory;
import com.shopdi.inventory.repository.StockHistoryRepository;
import com.shopdi.inventory.viewmodel.product.ProductInfoVm;
import com.shopdi.inventory.viewmodel.stock.StockQuantityVm;
import com.shopdi.inventory.viewmodel.stockhistory.StockHistoryListVm;
import com.shopdi.inventory.viewmodel.stockhistory.StockHistoryVm;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockHistoryService {
    private final StockHistoryRepository stockHistoryRepository;

    private final ProductService productService;

    public StockHistoryService(StockHistoryRepository stockHistoryRepository,
            ProductService productService) {
        this.stockHistoryRepository = stockHistoryRepository;
        this.productService = productService;
    }

    public void createStockHistories(final List<Stock> stocks,
            final List<StockQuantityVm> stockQuantityVms) {
        List<StockHistory> stockHistories = new ArrayList<>();

        for (final Stock stock : stocks) {
            StockQuantityVm stockQuantityVm = stockQuantityVms
                    .parallelStream()
                    .filter(stockQuantityVm1 -> stockQuantityVm1.stockId().equals(stock.getId()))
                    .findFirst()
                    .orElse(null);

            if (stockQuantityVm == null) {
                continue;
            }

            stockHistories.add(
                    StockHistory.builder()
                            .productId(stock.getProductId())
                            .note(stockQuantityVm.note())
                            .adjustedQuantity(stockQuantityVm.quantity())
                            .warehouse(stock.getWarehouse())
                            .build());
        }
        stockHistoryRepository.saveAll(stockHistories);
    }

    public StockHistoryListVm getStockHistories(final Long productId,
            final Long warehouseId) {
        List<StockHistory> stockHistories = stockHistoryRepository.findByProductIdAndWarehouseIdOrderByCreatedOnDesc(
                productId,
                warehouseId);
        ProductInfoVm productInfoVm = productService.getProduct(productId);

        return new StockHistoryListVm(
                stockHistories.stream().map(
                        stockHistory -> StockHistoryVm.fromModel(
                                stockHistory,
                                productInfoVm))
                        .toList());
    }
}
