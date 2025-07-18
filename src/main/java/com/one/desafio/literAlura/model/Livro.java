package com.one.desafio.literAlura.model;

import com.one.desafio.literAlura.model.dto.LivroDto;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer downloads;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro() {
    }

    public Livro(LivroDto dadosLivro) {

        var livro = new Livro();
        Autor autores=new Autor(dadosLivro.autores().get(0));
        this.autor= autores;
        this.titulo = dadosLivro.titulo();
        this.downloads = dadosLivro.numerDownload();

        if (!dadosLivro.idioma().isEmpty()) {
            idioma = dadosLivro.idioma().get(0);
        }
    }

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return """
        
        ---------------- DADOS DO LIVRO ----------------
        Título : %s
        Autor  : %s
        Idioma : %s
        Número de Downloads : %d
        ------------------------------------------------
        """.formatted(titulo, autor, idioma, downloads);

    }
}

