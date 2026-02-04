package com.shopdi.product.repository;

import com.shopdi.product.model.Product;
import com.shopdi.product.model.attribute.ProductAttributeValue;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValue, Long> {
    List<ProductAttributeValue> findAllByProduct(Product product);
}
