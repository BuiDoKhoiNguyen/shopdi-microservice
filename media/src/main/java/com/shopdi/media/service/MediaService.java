package com.shopdi.media.service;

import com.shopdi.media.model.Media;
import com.shopdi.media.model.dto.MediaDto;
import com.shopdi.media.viewmodel.MediaPostVm;
import com.shopdi.media.viewmodel.MediaVm;
import java.util.List;

public interface MediaService {
    Media saveMedia(MediaPostVm mediaPostVm);

    MediaVm getMediaById(Long id);

    void removeMedia(Long id);

    MediaDto getFile(Long id, String fileName);

    List<MediaVm> getMediaByIds(List<Long> ids);
}
