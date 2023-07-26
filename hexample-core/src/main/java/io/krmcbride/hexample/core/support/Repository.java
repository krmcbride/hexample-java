package io.krmcbride.hexample.core.support;

import java.util.Optional;

public interface Repository<T, ID> {
    Optional<T> findById(ID id);
}
