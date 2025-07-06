package com.one.desafio.literAlura.model;

import com.one.desafio.literAlura.model.dto.AutorDto;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor")
    private Set<Livro> livros;

    public Autor(AutorDto autorDto) {

        this.id = id;
        this.nome = autorDto.nome();
        this.anoNascimento = autorDto.nascimento();
        this.anoFalecimento = autorDto.falecimento();
    }

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    @Override
    public String toString() {
        return
        "\n Nome: " + nome +
        "\n Ano de Nascimento: " + anoNascimento + "\n Ano de Falecimento: " + anoFalecimento + "\n";
    }

}
