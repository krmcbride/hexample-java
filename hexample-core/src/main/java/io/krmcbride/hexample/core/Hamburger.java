package io.krmcbride.hexample.core;

import java.util.List;
import java.util.Optional;

public interface Hamburger {
    String getOrderId();
    List<String> getToppings();
    Optional<String> getCustomizations();
}
