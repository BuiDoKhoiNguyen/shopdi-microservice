package com.shopdi.recommendation.vector.product.store;

import com.shopdi.recommendation.service.ProductService;
import com.shopdi.recommendation.vector.common.store.SimpleVectorRepository;
import com.shopdi.recommendation.vector.product.document.ProductDocument;
import com.shopdi.recommendation.viewmodel.ProductDetailVm;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

/**
 * Component for managing vector store operations specifically for
 * {@link ProductDocument}.
 */
@Component
public class ProductVectorRepository extends SimpleVectorRepository<ProductDocument, ProductDetailVm> {

    private final ProductService productService;

    public ProductVectorRepository(VectorStore vectorStore, ProductService productService) {
        super(ProductDocument.class, vectorStore);
        this.productService = productService;
    }

    @Override
    public ProductDetailVm getEntity(Long id) {
        return productService.getProductDetail(id);
    }
}
