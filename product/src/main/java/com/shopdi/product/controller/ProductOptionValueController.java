package com.shopdi.product.controller;

import com.shopdi.commonlibrary.exception.NotFoundException;
import com.shopdi.product.model.Product;
import com.shopdi.product.repository.ProductOptionValueRepository;
import com.shopdi.product.repository.ProductRepository;
import com.shopdi.product.utils.Constants;
import com.shopdi.product.viewmodel.error.ErrorVm;
import com.shopdi.product.viewmodel.product.ProductOptionValueGetVm;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOptionValueController {
    private final ProductOptionValueRepository productOptionValueRepository;
    private final ProductRepository productRepository;

    public ProductOptionValueController(
            ProductOptionValueRepository productOptionValueRepository,
            ProductRepository productRepository) {
        this.productOptionValueRepository = productOptionValueRepository;
        this.productRepository = productRepository;
    }

    @GetMapping({ "/backoffice/product-option-values" })
    public ResponseEntity<List<com.shopdi.product.viewmodel.productoption.ProductOptionValueGetVm>> listProductOptionValues() {
        List<com.shopdi.product.viewmodel.productoption.ProductOptionValueGetVm> productOptionGetVms = productOptionValueRepository
                .findAll().stream()
                .map(com.shopdi.product.viewmodel.productoption.ProductOptionValueGetVm::fromModel)
                .toList();
        return ResponseEntity.ok(productOptionGetVms);
    }

    @GetMapping({ "/storefront/product-option-values/{productId}" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = com.shopdi.product.viewmodel.productoption.ProductOptionValueGetVm.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = ErrorVm.class))),
    })
    public ResponseEntity<List<ProductOptionValueGetVm>> listProductOptionValueOfProduct(
            @PathVariable("productId") Long productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.PRODUCT_NOT_FOUND, productId));
        List<ProductOptionValueGetVm> productVariations = productOptionValueRepository
                .findAllByProduct(product).stream()
                .map(ProductOptionValueGetVm::fromModel)
                .toList();
        return ResponseEntity.ok(productVariations);
    }
}
