package com.reactive.postgres.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.reactive.postgres.dto.CityDto;
import com.reactive.postgres.entity.City;

@Mapper
public interface CityMapper {
	
	public CityMapper INSTANCE  = Mappers.getMapper(CityMapper.class);
	
	public CityDto toDto(City city);

}
