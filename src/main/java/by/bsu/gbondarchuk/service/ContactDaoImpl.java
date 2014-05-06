package by.bsu.gbondarchuk.service;

import by.bsu.gbondarchuk.model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ContactDaoImpl implements ContactDao {
    private List<Contact> contacts = new ArrayList<>();

    @Override
    public void save(Contact entity) {
        contacts.add(entity);
    }

    @Override
    public void delete(Integer id) {
        Iterator iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = (Contact) iterator.next();
            if (contact.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public Contact load(Integer id) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact update(Contact entity) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(entity.getId())) {
                contact.setLastName(entity.getLastName());
                contact.setCompanyName(entity.getCompanyName());
                contact.setFirstName(entity.getFirstName());
                contact.setHobby(entity.getHobby());
                return contact;
            }
        }
        return null;
    }


    @Override
    public List<Contact> find() {
        return contacts;
    }
}
