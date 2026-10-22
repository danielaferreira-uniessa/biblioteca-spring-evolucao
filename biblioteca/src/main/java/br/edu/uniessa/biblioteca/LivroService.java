package br.edu.uniessa.biblioteca;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final List<Livro> livros = new ArrayList<>();

    public LivroService() {
        livros.add(new Livro("O Hobbit", "J. R. R. Tolkien", true));
    }

    public List<Livro> listar() {
        return livros;
    }

    public Livro cadastrar(Livro livro) {
        livros.add(livro);
        return livro;
    }

    public Livro obterLivroPrincipal() {
        return livros.get(0);
    }
}