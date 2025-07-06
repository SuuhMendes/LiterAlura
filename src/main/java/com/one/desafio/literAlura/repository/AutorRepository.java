package com.one.desafio.literAlura.repository;

import com.one.desafio.literAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :ano AND a.anoFalecimento >= :ano")
    List<Autor> findAllByYear(int ano);
}

