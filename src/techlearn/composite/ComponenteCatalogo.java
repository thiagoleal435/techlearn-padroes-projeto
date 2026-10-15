package techlearn.composite;

import techlearn.iterator.Iterator;

public abstract class ComponenteCatalogo {
    public void adicionar(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operação não suportada neste nível.");
    }

    public void remover(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operação não suportada neste nível.");
    }

    public String getNome() {
        throw new UnsupportedOperationException();
    }

    public int getDuracaoMinutos() {
        throw new UnsupportedOperationException();
    }

    public abstract void exibirDetalhes();

    public abstract Iterator<ComponenteCatalogo> criarIterator();
}
