package io.krmcbride.hexample.core;

import java.io.Serializable;
import java.util.Objects;

public class Foo {

    private final Integer id;

    public Foo(Integer id) {
        Objects.requireNonNull(id, "id must not be null");
        this.id = id;
    }

    @Override
    public String toString() {
        return "Foo{" +
            "id=" + id +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Foo)) {
            return false;
        }
        Foo account = (Foo) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

}
