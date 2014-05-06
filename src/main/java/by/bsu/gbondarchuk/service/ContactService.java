package by.bsu.gbondarchuk.service;

import by.bsu.gbondarchuk.model.Contact;

import java.util.List;

public interface ContactService {

    public void save(Contact contact);

    public List<Contact> loadRange(int first, int last);
}
