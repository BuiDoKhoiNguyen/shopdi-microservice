package com.shopdi.product.repository;

import com.shopdi.product.model.Product;
import com.shopdi.product.model.ProductOptionValue;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOptionValueRepository extends JpaRepository<ProductOptionValue, Long> {
    List<ProductOptionValue> findAllByProduct(Product product);

    void deleteByProductIdAndValue(Long productId, String value);

    void deleteAllByProductId(Long productId);

}
