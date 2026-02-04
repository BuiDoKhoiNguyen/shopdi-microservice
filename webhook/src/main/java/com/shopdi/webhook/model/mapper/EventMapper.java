package com.shopdi.webhook.model.mapper;

import com.shopdi.webhook.model.Event;
import com.shopdi.webhook.model.viewmodel.webhook.EventVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventVm toEventVm(Event event);

}
