package com.kosovandrey.cqrsbankingapp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
public class ClientDto {

    private UUID id;

    @NotNull(message = "Name must be not null.")
    @Length(
            min = 1,
            max = 255,
            message = "Name length must be in {min} and {max}."
    )
    private String name;

    @Email(message = "Username must be a valid email.")
    @NotNull(message = "Username must be not null.")
    @Length(
            min = 1,
            max = 255,
            message = "Username length must be in {min} and {max}."
    )
    private String username;

    @NotNull(message = "Password must be not null.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
