package techlearn.iterator;

import java.util.List;

import techlearn.composite.ComponenteCatalogo;

public class ModuloIterator implements Iterator<ComponenteCatalogo> {
    private final List<ComponenteCatalogo> componentes;
    private int posicao = 0;

    public ModuloIterator(List<ComponenteCatalogo> componentes) {
        this.componentes = componentes;
    }

    @Override
    public boolean hasNext() {
        return posicao < componentes.size();
    }

    @Override
    public ComponenteCatalogo next() {
        return componentes.get(posicao++);
    }
}
