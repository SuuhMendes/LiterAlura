package com.one.desafio.literAlura;

import com.one.desafio.literAlura.repository.AutorRepository;
import com.one.desafio.literAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private final LivroRepository livroRepository;
	@Autowired
	private final AutorRepository autorRepository;

    public LiterAluraApplication(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
			MenuPrincipal principal=new MenuPrincipal(livroRepository,autorRepository);
			principal.exibeMenu();

	}
}
