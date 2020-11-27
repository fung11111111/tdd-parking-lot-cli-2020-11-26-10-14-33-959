package com.oocl.cultivation;

public class NotEnoughPosition extends Throwable {
    public NotEnoughPosition(){
        super("Not enough position.");
    }
}
