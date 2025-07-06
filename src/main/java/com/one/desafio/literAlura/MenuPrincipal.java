package com.one.desafio.literAlura;

import com.one.desafio.literAlura.model.Autor;
import com.one.desafio.literAlura.model.Livro;
import com.one.desafio.literAlura.repository.AutorRepository;
import com.one.desafio.literAlura.repository.LivroRepository;
import com.one.desafio.literAlura.service.consumoApiGutendex.Busca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner = new Scanner(System.in);
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;


    String menu = """
            ""*********Bem-Vindo*******************
            
            1 -✍🏻 Buscar livro pelo título
            2 - 📚Listar livros registrados
            3 - 👨🏻‍💼Lista autores registrados
            4 - 📅Listar autores vivos em determinado ano
            5 - 🧑‍💻Listar livros em determinado idioma
            6 - 🔥Listar Top 5 dos livros mais baixados
            
            0 - Sair
            
            ******************************************
            """;

    public MenuPrincipal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println(menu);
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {

                    case 1:
                        buscarLivroPorTitulo();
                        break;
                    case 2:
                        listarLivrosRegistrados();
                        break;

                    case 3:
                        listarAutores();
                        break;
                    case 4:
                        listarAutoresnoAnoDeterminado();
                        break;

                    case 5:
                        listalivrosEmDdeterminadoIdioma();
                        break;

                    case 6:
                        listarTop5sMaisBaixados();
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Digite apenas de 0 á 6");

                }

            } catch (InputMismatchException e) {
                System.out.println(" ❌ Opss.. Entrada Inválida. Digite apenas Números!");
                scanner.nextLine();

            }
        }
    }

    private void buscarLivroPorTitulo() {
        Busca buscador = new Busca();
        var dadosLivro = buscador.buscaPorTitulo();
        if (dadosLivro == null) {
            System.out.println("------------------- Nenhum livro encontrado❌ -------------------\n ");
            return;
        }

        Autor autor = new Autor(dadosLivro.autores().get(0));
        Livro livro = new Livro(dadosLivro);
        System.out.println(livro);
        livroRepository.save(livro);
        autorRepository.save(livro.getAutor());

    }

    private void listarLivrosRegistrados() {
        var listaLivro = livroRepository.findAll();
        if (listaLivro.isEmpty()) {
            System.out.println("------------------- Lista Vazia  -------------------");
        } else {
            System.out.println(listaLivro);
        }
    }

    private void listarAutores() {
        if (autorRepository.findAll().isEmpty()) {
            System.out.println("------------------- Nenhum Autor Encontrado ❌ -------------------");
        }
        var listaAutores = autorRepository.findAll();
        System.out.println("Autores: " + listaAutores);
    }

    private void listarAutoresnoAnoDeterminado() {
        try {
            System.out.println("Digite ano para busca do autor:");
            var ano = Integer.parseInt(scanner.nextLine());
            if (ano < 1000 || ano > 2025) {
                System.out.println("  Digite um ano entre 1000 e 2025");
                return;
            }
            var listaAutor = autorRepository.findAllByYear(ano);
            if (listaAutor.isEmpty()) {
                System.out.println("-------------------❌ Ops..Nenhum autor encontrado-------------------\n");
                System.out.println("Adicione mais livros para poder aproveitar melhor esta função");
                return;
            }
            System.out.println(listaAutor);
        } catch (NumberFormatException e) {
            System.out.println(" ❌ Entrada inválida! Digite apenas números para o ano (ex: 2020).");
        }
    }

    private void listalivrosEmDdeterminadoIdioma() {
        String menu = """  
                      Escolha o idioma:
                     pt => Português
                     en => Inglês
                     es => Espanhol
                     fr => Francês
                
                     Digite Apenas as Siglas:
                
                """;
        System.out.println(menu);
        var idioma = scanner.nextLine().trim().toLowerCase();
        var idiomaBuscado = livroRepository.findByIdioma(idioma);

        if (idiomaBuscado.isEmpty()) {
            System.out.println("-------------------Idioma nao encontrado❌ -------------------");
            return;
        }
        for (Livro livro : idiomaBuscado) {
            System.out.println(livro);
        }
    }

    private void listarTop5sMaisBaixados() {
        var livrosMaisBaixados = livroRepository.findTop5ByOrderByDownloadsDesc();
        if (livrosMaisBaixados.isEmpty()) {
            System.out.println("-------------------Nenhum livro encontrado ❌-------------------\n");
            return;
        }
        System.out.println("\nListando os livros mais baixados...");
        System.out.println("\n-------------------✅TOP 5 LIVROS MAIS BAIXADOS  -------------------");
        System.out.println(livrosMaisBaixados);
    }

}

