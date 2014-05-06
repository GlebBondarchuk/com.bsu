package by.bsu.gbondarchuk.dispatchers.handler.valuelist;


import by.bsu.gbondarchuk.dispatchers.handler.valuelist.impl.ValueList;

public interface ValueListHandler {
    public ValueList next();

    public ValueList previous();

    public ValueList first();

    public ValueList last();

    public ValueList current();

}
