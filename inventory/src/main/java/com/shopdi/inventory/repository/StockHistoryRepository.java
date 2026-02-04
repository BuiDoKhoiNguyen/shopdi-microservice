package com.shopdi.inventory.repository;

import com.shopdi.inventory.model.StockHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockHistoryRepository extends JpaRepository<StockHistory, Long> {
    List<StockHistory> findByProductIdAndWarehouseIdOrderByCreatedOnDesc(Long productId,
            Long warehouseId);
}
