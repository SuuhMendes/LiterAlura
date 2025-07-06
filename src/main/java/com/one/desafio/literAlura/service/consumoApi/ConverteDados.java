package com.one.desafio.literAlura.service.consumoApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {

    @Override
    public <T> T converteDados(String json, Class<T> classe) {
         ObjectMapper mapper = new ObjectMapper();
        if (json == null || json.isBlank()) {
            throw new RuntimeException("o json esta vazio");

        }
        try {

            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
