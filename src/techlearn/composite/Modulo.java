package techlearn.composite;

import java.util.ArrayList;
import java.util.List;

import techlearn.iterator.Iterator;
import techlearn.iterator.NullIterator;
import techlearn.logging.LoggerService;

public class Modulo extends ComponenteCatalogo {
    private final String nome;
    private final List<ComponenteCatalogo> subComponentes = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionar(ComponenteCatalogo componente) {
        subComponentes.add(componente);
        LoggerService.getInstance().log(
                "Item '" + componente.getNome() + "' adicionado ao módulo '" + nome + "'.");
    }

    @Override
    public void remover(ComponenteCatalogo componente) {
        subComponentes.remove(componente);
        LoggerService.getInstance().log(
                "Item '" + componente.getNome() + "' removido do módulo '" + nome + "'.");
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getDuracaoMinutos() {
        return subComponentes.stream()
                .mapToInt(ComponenteCatalogo::getDuracaoMinutos)
                .sum();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n[Módulo/Curso]: " + nome
                + " | Duração Total: " + getDuracaoMinutos() + " min");
        System.out.println("----------------------------------------");
        subComponentes.forEach(ComponenteCatalogo::exibirDetalhes);
    }

    @Override
    public Iterator<ComponenteCatalogo> criarIterator() {
        return new NullIterator<>();
    }
}
