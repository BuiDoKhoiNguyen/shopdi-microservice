package com.shopdi.payment.mapper;

import com.shopdi.commonlibrary.mapper.EntityCreateUpdateMapper;
import com.shopdi.payment.model.PaymentProvider;
import com.shopdi.payment.viewmodel.paymentprovider.CreatePaymentVm;
import com.shopdi.payment.viewmodel.paymentprovider.PaymentProviderVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreatePaymentProviderMapper extends
        EntityCreateUpdateMapper<PaymentProvider, CreatePaymentVm, PaymentProviderVm> {

    @Mapping(target = "isNew", constant = "true")
    @Override
    PaymentProvider toModel(CreatePaymentVm vm);
}