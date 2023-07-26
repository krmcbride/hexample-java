package io.krmcbride.hexample.core;

import io.krmcbride.hexample.core.support.Repository;
import java.util.List;

public interface HamburgerRepository extends Repository<Hamburger, String> {
    List<Hamburger> findByOrderId();
}
