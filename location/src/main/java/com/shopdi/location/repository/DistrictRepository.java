package com.shopdi.location.repository;

import com.shopdi.location.model.District;
import com.shopdi.location.viewmodel.district.DistrictGetVm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<DistrictGetVm> findAllByStateProvinceIdOrderByNameAsc(Long stateProvinceId);
}
