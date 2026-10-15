package techlearn.iterator;

/**
 * Null Object iterator used by Composite leaf nodes.
 *
 * @param <T> the element type
 */
public class NullIterator<T> implements Iterator<T> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
