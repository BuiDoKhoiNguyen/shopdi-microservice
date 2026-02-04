package com.shopdi.search.consumer;

import static com.shopdi.commonlibrary.kafka.cdc.message.Operation.CREATE;
import static com.shopdi.commonlibrary.kafka.cdc.message.Operation.DELETE;
import static com.shopdi.commonlibrary.kafka.cdc.message.Operation.UPDATE;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.shopdi.commonlibrary.kafka.cdc.message.ProductCdcMessage;
import com.shopdi.commonlibrary.kafka.cdc.message.ProductMsgKey;
import com.shopdi.search.kafka.consumer.ProductSyncDataConsumer;
import com.shopdi.commonlibrary.kafka.cdc.message.Product;
import com.shopdi.search.service.ProductSyncDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ProductSyncDataConsumerTest {

    @InjectMocks
    private ProductSyncDataConsumer productSyncDataConsumer;

    @Mock
    private ProductSyncDataService productSyncDataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSync_whenCreateAction_createProduct() {
        // When
        long productId = 1L;
        productSyncDataConsumer.sync(
                ProductMsgKey.builder().id(productId).build(),
                ProductCdcMessage.builder()
                        .after(Product.builder().id(productId).build())
                        .op(CREATE)
                        .build());

        // Then
        verify(productSyncDataService, times(1)).createProduct(productId);
    }

    @Test
    void testSync_whenUpdateAction_updateProduct() {
        // When
        long productId = 2L;
        productSyncDataConsumer.sync(
                ProductMsgKey.builder().id(productId).build(),
                ProductCdcMessage.builder()
                        .after(Product.builder().id(productId).build())
                        .op(UPDATE)
                        .build());

        // Then
        verify(productSyncDataService, times(1)).updateProduct(productId);
    }

    @Disabled("Handle later once elasticsearch sync delete complete")
    @Test
    void testSync_whenDeleteAction_deleteProduct() {
        // When
        final long productId = 3L;
        productSyncDataConsumer.sync(
                ProductMsgKey.builder().id(productId).build(),
                ProductCdcMessage.builder()
                        .after(Product.builder().id(productId).build())
                        .op(DELETE)
                        .build());

        // Then
        verify(productSyncDataService, times(1)).deleteProduct(productId);
    }
}
