package com.shopdi.promotion.repository;

import com.shopdi.promotion.model.PromotionUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionUsageRepository extends JpaRepository<PromotionUsage, Long> {
    boolean existsByPromotionId(Long promotionId);
}
