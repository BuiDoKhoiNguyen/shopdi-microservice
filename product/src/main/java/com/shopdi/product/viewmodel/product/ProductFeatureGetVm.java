package com.shopdi.product.viewmodel.product;

import java.util.List;

public record ProductFeatureGetVm(List<ProductThumbnailGetVm> productList, int totalPage) {
}
