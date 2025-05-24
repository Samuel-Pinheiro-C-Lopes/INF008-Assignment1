package samuel.inf008.assignment1.abstractions;

import samuel.inf008.assignment1.interfaces.IEntity;

public abstract class Entity implements IEntity {
    private final Integer id;
    private final String name;

    protected Entity(String name) {
        this.id = this.getCurrentId();
        this.name = name;
    }

    protected abstract Integer getCurrentId();

    @Override
    public boolean equals(Object o) {
        if (o instanceof Entity)
            return this.id.equals(((Entity) o).getId());
        return super.equals(o);
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void printSelf() {
        System.out.print(this.name);
    }
}
