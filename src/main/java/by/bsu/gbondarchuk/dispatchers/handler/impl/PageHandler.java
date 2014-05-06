package by.bsu.gbondarchuk.dispatchers.handler.impl;

import by.bsu.gbondarchuk.model.ActionHandler;
import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.dispatchers.handler.RequestHandler;
import by.bsu.gbondarchuk.dispatchers.handler.valuelist.ValueListHandler;
import by.bsu.gbondarchuk.dispatchers.handler.valuelist.impl.ValueListHandlerImpl;
import by.bsu.gbondarchuk.model.Contact;
import by.bsu.gbondarchuk.model.RequestData;
import by.bsu.gbondarchuk.model.AppStorage;

@ActionHandler(action = Action.UPDATE_LIST)
public class PageHandler implements RequestHandler {

    private ValueListHandler vlHandler = new ValueListHandlerImpl();

    @Override
    public ResponseType handleRequest(RequestData requestData) {
        Contact[] contacts;
        if (requestData.navDir == 0) {
            contacts = vlHandler.first().toArray();
        } else if (requestData.navDir == 1) {
            contacts = vlHandler.previous().toArray();
        } else if (requestData.navDir == 2) {
            contacts = vlHandler.next().toArray();
        } else if (requestData.navDir == 3) {
            contacts = vlHandler.last().toArray();
        } else {
            return ResponseType.FAIL;
        }
        AppStorage.writeObject(requestData.sessionID, contacts);
        return ResponseType.SUCCESS;
    }
}
