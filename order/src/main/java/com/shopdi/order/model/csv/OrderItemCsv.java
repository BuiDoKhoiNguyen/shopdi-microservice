package com.shopdi.order.model.csv;

import com.shopdi.commonlibrary.csv.BaseCsv;
import com.shopdi.commonlibrary.csv.anotation.CsvColumn;
import com.shopdi.commonlibrary.csv.anotation.CsvName;
import com.shopdi.order.model.enumeration.DeliveryStatus;
import com.shopdi.order.model.enumeration.OrderStatus;
import com.shopdi.order.model.enumeration.PaymentStatus;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@CsvName(fileName = "Orders")
@SuperBuilder
@Getter
@Setter
public class OrderItemCsv extends BaseCsv {

    @CsvColumn(columnName = "Order status")
    private OrderStatus orderStatus;

    @CsvColumn(columnName = "Payment status")
    private PaymentStatus paymentStatus;

    @CsvColumn(columnName = "Email")
    private String email;

    @CsvColumn(columnName = "Phone")
    private String phone;

    @CsvColumn(columnName = "Order total")
    private BigDecimal totalPrice;

    @CsvColumn(columnName = "Shipping status")
    private DeliveryStatus deliveryStatus;

    @CsvColumn(columnName = "Created on")
    private ZonedDateTime createdOn;
}