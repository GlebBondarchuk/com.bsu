package by.bsu.gbondarchuk.dispatchers.handler.valuelist.impl;

import by.bsu.gbondarchuk.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ValueList extends ArrayList<Contact> {

    public ValueList(List<Contact> loaded) {
        super(loaded);
    }

    public Contact[] toArray() {
        Contact[] contacts = new Contact[size()];
        return toArray(contacts);
    }
}
