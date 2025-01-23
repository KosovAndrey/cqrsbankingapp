package com.kosovandrey.cqrsbankingapp.web.dto.mapper;

import com.kosovandrey.cqrsbankingapp.domain.model.Client;
import com.kosovandrey.cqrsbankingapp.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
