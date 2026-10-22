package br.edu.uniessa.biblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/livros")
    public List<Livro> listarLivros() {
        return livroService.listar();
    }

    @PostMapping("/livros")
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return livroService.cadastrar(livro);
    }

    @GetMapping("/livro")
    public Livro obterLivro() {
        return livroService.obterLivroPrincipal();
    }

    @GetMapping("/livro/emprestar")
    public Livro emprestarLivro() {
        Livro livro = livroService.obterLivroPrincipal();
        livro.emprestar();
        return livro;
    }

    @GetMapping("/livro/devolver")
    public Livro devolverLivro() {
        Livro livro = livroService.obterLivroPrincipal();
        livro.devolver();
        return livro;
    }
}