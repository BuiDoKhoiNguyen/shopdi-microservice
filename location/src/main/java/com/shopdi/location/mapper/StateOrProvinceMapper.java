package com.shopdi.location.mapper;

import com.shopdi.location.model.StateOrProvince;
import com.shopdi.location.viewmodel.stateorprovince.StateOrProvinceVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StateOrProvinceMapper {

    @Mapping(target = "countryId", source = "country.id")
    StateOrProvinceVm toStateOrProvinceViewModelFromStateOrProvince(StateOrProvince stateOrProvince);
}
