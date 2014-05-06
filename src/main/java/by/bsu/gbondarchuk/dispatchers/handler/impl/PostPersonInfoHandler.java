package by.bsu.gbondarchuk.dispatchers.handler.impl;

import by.bsu.gbondarchuk.model.ActionHandler;
import by.bsu.gbondarchuk.model.Contact;
import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.model.enums.ObjectKey;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.dispatchers.handler.RequestHandler;
import by.bsu.gbondarchuk.model.RequestData;
import by.bsu.gbondarchuk.model.AppStorage;

@ActionHandler(action = Action.REGISTER_NAME)
public class PostPersonInfoHandler implements RequestHandler {
    @Override
    public ResponseType handleRequest(RequestData requestData) {
        Contact contact = (Contact) AppStorage.getObject(ObjectKey.PERSON);
        if (contact == null) {
            return ResponseType.FAIL;
        }
        contact.setFirstName(requestData.firstName);
        contact.setLastName(requestData.lastName);
        AppStorage.writeObject(ObjectKey.PERSON, contact);
        return ResponseType.SUCCESS;
    }
}
