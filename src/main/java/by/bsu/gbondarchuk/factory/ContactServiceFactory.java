package by.bsu.gbondarchuk.factory;

import by.bsu.gbondarchuk.service.ContactService;
import by.bsu.gbondarchuk.service.impl.ContactServiceImpl;

public class ContactServiceFactory {
    private static ContactService contactService = new ContactServiceImpl();

    public static ContactService getContactService() {
        return contactService;
    }
}
