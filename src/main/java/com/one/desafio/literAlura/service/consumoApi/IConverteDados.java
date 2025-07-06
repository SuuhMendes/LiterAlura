package com.one.desafio.literAlura.service.consumoApi;

public interface IConverteDados  {
    <T> T  converteDados(String json, Class<T> classe);
}
