package by.bsu.gbondarchuk.dispatchers.handler.impl;

import by.bsu.gbondarchuk.model.ActionHandler;
import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.dispatchers.handler.RequestHandler;
import by.bsu.gbondarchuk.model.RequestData;

@ActionHandler(action = Action.DEFAULT)
public class RequestHandlerImpl implements RequestHandler {
    @Override
    public ResponseType handleRequest(RequestData requestData) {
        return ResponseType.FAIL;
    }
}
