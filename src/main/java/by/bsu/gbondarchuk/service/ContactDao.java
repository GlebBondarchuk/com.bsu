package by.bsu.gbondarchuk.service;

import by.bsu.gbondarchuk.model.Contact;

import java.util.List;

public interface ContactDao {

    void save(Contact entity);

    void delete(Integer id);

    Contact load(Integer id);

    Contact update(Contact entity);

    List<Contact> find();
}
