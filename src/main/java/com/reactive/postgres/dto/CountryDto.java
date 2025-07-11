package com.reactive.postgres.dto;

import java.time.OffsetDateTime;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryDto {

	private Integer countryId;

	private String country;

	private OffsetDateTime lastUpdate;

	private Set<CityDto> countryCities;

}
