package com.shopdi.order.mapper;

import com.shopdi.order.model.Checkout;
import com.shopdi.order.model.CheckoutItem;
import com.shopdi.order.viewmodel.checkout.CheckoutItemPostVm;
import com.shopdi.order.viewmodel.checkout.CheckoutItemVm;
import com.shopdi.order.viewmodel.checkout.CheckoutPostVm;
import com.shopdi.order.viewmodel.checkout.CheckoutVm;
import java.math.BigDecimal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CheckoutMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checkout", ignore = true)
    CheckoutItem toModel(CheckoutItemPostVm checkoutItemPostVm);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checkoutState", ignore = true)
    Checkout toModel(CheckoutPostVm checkoutPostVm);

    @Mapping(target = "checkoutId", source = "checkout.id")
    CheckoutItemVm toVm(CheckoutItem checkoutItem);

    @Mapping(target = "checkoutItemVms", ignore = true)
    CheckoutVm toVm(Checkout checkout);

    default BigDecimal map(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
}
