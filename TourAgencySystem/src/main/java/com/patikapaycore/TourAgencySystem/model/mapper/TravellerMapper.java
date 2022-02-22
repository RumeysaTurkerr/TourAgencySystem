package com.patikapaycore.TourAgencySystem.model.mapper;

import com.patikapaycore.TourAgencySystem.model.TravellerDTO;
import com.patikapaycore.TourAgencySystem.model.entity.Traveller;
import org.mapstruct.Mapper;

@Mapper
public interface TravellerMapper {
    TravellerDTO toDto(Traveller entity);

    Traveller toEntity(TravellerDTO dto);
}
