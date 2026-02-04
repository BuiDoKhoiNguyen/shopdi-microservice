package com.shopdi.payment.mapper;

import com.shopdi.commonlibrary.mapper.EntityCreateUpdateMapper;
import com.shopdi.payment.model.PaymentProvider;
import com.shopdi.payment.viewmodel.paymentprovider.PaymentProviderVm;
import com.shopdi.payment.viewmodel.paymentprovider.UpdatePaymentVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdatePaymentProviderMapper extends
        EntityCreateUpdateMapper<PaymentProvider, UpdatePaymentVm, PaymentProviderVm> {
}