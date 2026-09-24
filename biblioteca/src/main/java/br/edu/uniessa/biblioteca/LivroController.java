package br.edu.uniessa.biblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    private Livro livro = new Livro(
        "O Hobbit",
        "J. R. R. Tolkien",
        true
    );

    @GetMapping("/livro")
    public Livro obterLivro() {
        return livro;
    }

    @GetMapping("/livro/emprestar")
    public Livro emprestarLivro() {
        livro.emprestar();
        return livro;
    }

    @GetMapping("/livro/devolver")
    public Livro devolverLivro() {
        livro.devolver();
        return livro;
    }
}