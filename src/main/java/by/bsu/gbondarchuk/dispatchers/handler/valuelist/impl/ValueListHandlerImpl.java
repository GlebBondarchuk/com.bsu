package by.bsu.gbondarchuk.dispatchers.handler.valuelist.impl;

import by.bsu.gbondarchuk.factory.ContactServiceFactory;
import by.bsu.gbondarchuk.dispatchers.handler.valuelist.ValueListHandler;
import by.bsu.gbondarchuk.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ValueListHandlerImpl implements ValueListHandler {

    public static final int DEF_LIST_SIZE = 3;
    private int current = 0;
    private List<ValueList> lists = new ArrayList<ValueList>();

    @Override
    public ValueList next() {
        current++;
        if (current >= lists.size()) {
            List<Contact> loaded = ContactServiceFactory.getContactService()
                    .loadRange((current - 1) * DEF_LIST_SIZE, current * DEF_LIST_SIZE);
            if (loaded != null) {
                ValueList valueList = new ValueList(loaded);
                lists.add(valueList);
            } else {
                current--;
            }
        }
        return current();
    }

    @Override
    public ValueList previous() {
        current--;
        if (current < 1) {
            current = 1;
        }
        return current();
    }

    @Override
    public ValueList first() {
        current = 0;
        return current();
    }

    @Override
    public ValueList last() {
        int tCur;
        do {
            tCur = current;
            next();
        } while (tCur != current);
        return current();
    }

    @Override
    public ValueList current() {
        return lists.get(current - 1);
    }
}
