package com.one.desafio.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.one.desafio.literAlura.model.dto.LivroDto;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record  ResponseApi (


        @JsonAlias("results") List<LivroDto> livros
){}
