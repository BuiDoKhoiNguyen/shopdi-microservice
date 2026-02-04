package com.shopdi.payment.mapper;

import com.shopdi.commonlibrary.mapper.BaseMapper;
import com.shopdi.payment.model.PaymentProvider;
import com.shopdi.payment.viewmodel.paymentprovider.PaymentProviderVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentProviderMapper extends BaseMapper<PaymentProvider, PaymentProviderVm> {
}