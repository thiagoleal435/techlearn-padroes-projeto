package techlearn.composite;

import techlearn.iterator.Iterator;
import techlearn.iterator.NullIterator;

public class Aula extends ComponenteCatalogo {
    private final String nome;
    private final int duracaoMinutos;

    public Aula(String nome, int duracaoMinutos) {
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("  - Aula: " + nome + " (" + duracaoMinutos + " min)");
    }

    @Override
    public Iterator<ComponenteCatalogo> criarIterator() {
        return new NullIterator<>();
    }
}
