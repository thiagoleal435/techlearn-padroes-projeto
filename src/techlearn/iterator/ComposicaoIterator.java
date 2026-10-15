package techlearn.iterator;

import java.util.ArrayDeque;
import java.util.Deque;

import techlearn.composite.ComponenteCatalogo;

public class ComposicaoIterator implements Iterator<ComponenteCatalogo> {
    private final Deque<Iterator<ComponenteCatalogo>> pilha = new ArrayDeque<>();

    public ComposicaoIterator(ComponenteCatalogo raiz) {
        pilha.push(raiz.criarIterator());
    }

    @Override
    public boolean hasNext() {
        while (!pilha.isEmpty()) {
            Iterator<ComponenteCatalogo> atual = pilha.peek();
            if (atual.hasNext()) {
                return true;
            }
            pilha.pop();
        }
        return false;
    }

    @Override
    public ComponenteCatalogo next() {
        if (!hasNext()) {
            return null;
        }

        ComponenteCatalogo componente = pilha.peek().next();
        pilha.push(componente.criarIterator());
        return componente;
    }
}
