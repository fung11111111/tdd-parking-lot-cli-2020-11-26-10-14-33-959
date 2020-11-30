package com.oocl.cultivation.Exception;

import java.util.function.Supplier;

public class NotEnoughPosition extends Throwable {
    public NotEnoughPosition() {
        super("Not enough position.");
    }
}
