package com.one.desafio.literAlura.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDto(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year")  Integer nascimento,
        @JsonAlias("death_year") Integer falecimento

) {
}
