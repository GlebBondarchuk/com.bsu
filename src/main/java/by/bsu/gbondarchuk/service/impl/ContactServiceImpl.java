package by.bsu.gbondarchuk.service.impl;

import by.bsu.gbondarchuk.model.Contact;
import by.bsu.gbondarchuk.service.ContactDao;
import by.bsu.gbondarchuk.service.ContactDaoImpl;
import by.bsu.gbondarchuk.service.ContactService;

import java.util.List;

public class ContactServiceImpl extends ContactDaoImpl implements ContactService {

    private ContactDao contactDao = new ContactServiceImpl();

    @Override
    public List<Contact> loadRange(int first, int last) {
        return contactDao.find();
    }
}
