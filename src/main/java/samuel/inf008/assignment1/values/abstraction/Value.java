package samuel.inf008.assignment1.values.abstraction;

public abstract class Value<T> {
    private T value;

    protected Value(T value) {
        if (this.validateValue(value))
            this.value = value;
        else
            this.value = null;
    }

    public T get() {
        return this.value;
    }

    protected abstract boolean validateValue(T value);

}
