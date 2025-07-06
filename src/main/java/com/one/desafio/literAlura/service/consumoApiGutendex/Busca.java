package com.one.desafio.literAlura.service.consumoApiGutendex;

import com.one.desafio.literAlura.model.dto.LivroDto;
import com.one.desafio.literAlura.model.ResponseApi;
import com.one.desafio.literAlura.service.consumoApi.ConsumoApi;
import com.one.desafio.literAlura.service.consumoApi.ConverteDados;

import java.util.Optional;
import java.util.Scanner;


public class Busca {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final static String ENDERECO = "https://gutendex.com/books/";

    public LivroDto buscaPorTitulo(){
         System.out.println("Digite o nome do livro para busca:");
       var livro = scanner.nextLine();
        System.out.println("\nCarregando Livro ⌛\n");
    var json = consumo.obterDados(ENDERECO +"?search="+ livro.replace(" ", "+"));

    var dados = conversor.converteDados(json, ResponseApi.class);
    Optional<LivroDto> dadosLivro = dados.livros().stream()
            .filter(l -> l.titulo().toLowerCase().contains(livro.toLowerCase()))
            .findFirst();
if (dadosLivro.isEmpty()){
    return null;
}else {
    return dadosLivro.get();
}
}}
