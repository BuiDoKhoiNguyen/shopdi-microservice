package com.shopdi.recommendation.vector.product.query;

import com.shopdi.recommendation.vector.common.query.VectorQuery;
import com.shopdi.recommendation.vector.product.document.ProductDocument;
import com.shopdi.recommendation.viewmodel.RelatedProductVm;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

/**
 * Service for performing related product searches using vector similarity.
 * Extends {@link VectorQuery} for {@link RelatedProductVm} results.
 */
@Service
public class RelatedProductQuery extends VectorQuery<ProductDocument, RelatedProductVm> {

    protected RelatedProductQuery(VectorStore vectorStore) {
        super(ProductDocument.class, RelatedProductVm.class);
    }
}
