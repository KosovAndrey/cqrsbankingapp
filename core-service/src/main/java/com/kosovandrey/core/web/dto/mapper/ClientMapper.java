package com.kosovandrey.core.web.dto.mapper;

import com.kosovandrey.common.domain.model.Client;
import com.kosovandrey.core.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
