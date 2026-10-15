package techlearn.iterator;

import java.util.function.Predicate;

import techlearn.composite.ComponenteCatalogo;

public class FiltroIterator implements Iterator<ComponenteCatalogo> {
    private final Iterator<ComponenteCatalogo> iterator;
    private final Predicate<ComponenteCatalogo> predicado;
    private ComponenteCatalogo proximo;
    private boolean proximoPreparado;

    public FiltroIterator(Iterator<ComponenteCatalogo> iterator,
                          Predicate<ComponenteCatalogo> predicado) {
        this.iterator = iterator;
        this.predicado = predicado;
    }

    @Override
    public boolean hasNext() {
        prepararProximo();
        return proximoPreparado;
    }

    @Override
    public ComponenteCatalogo next() {
        if (!hasNext()) {
            return null;
        }

        ComponenteCatalogo resultado = proximo;
        proximo = null;
        proximoPreparado = false;
        return resultado;
    }

    private void prepararProximo() {
        if (proximoPreparado) {
            return;
        }

        while (iterator.hasNext()) {
            ComponenteCatalogo candidato = iterator.next();
            if (predicado.test(candidato)) {
                proximo = candidato;
                proximoPreparado = true;
                return;
            }
        }
    }
}
