package com.shopdi.media.mapper;

import com.shopdi.commonlibrary.mapper.BaseMapper;
import com.shopdi.media.model.Media;
import com.shopdi.media.viewmodel.MediaVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MediaVmMapper extends BaseMapper<Media, MediaVm> {
}
