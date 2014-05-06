package by.bsu.gbondarchuk.dispatchers.handler;

import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.model.RequestData;

public interface RequestHandler {
    public ResponseType handleRequest(RequestData requestData);
}
