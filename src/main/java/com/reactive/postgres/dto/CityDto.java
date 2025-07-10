package com.reactive.postgres.dto;

import java.time.OffsetDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CityDto {
	
	private String city;

    private OffsetDateTime lastUpdate;


    private CountryDto country;


}
