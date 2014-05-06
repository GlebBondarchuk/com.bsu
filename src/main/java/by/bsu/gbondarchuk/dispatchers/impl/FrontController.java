package by.bsu.gbondarchuk.dispatchers.impl;

import by.bsu.gbondarchuk.dispatchers.RequestDispatcher;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.factory.HttpRequestHandlerFactory;
import by.bsu.gbondarchuk.dispatchers.handler.RequestHandler;
import by.bsu.gbondarchuk.helper.HttpRequestHelper;
import by.bsu.gbondarchuk.model.RequestData;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FrontController {

    private RequestDispatcher dispatcher = new RequestDispatcherImpl();

    public FrontController(RequestDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        RequestData data = HttpRequestHelper.getRequestData((HttpServletRequest)req);

        RequestHandler handler = HttpRequestHandlerFactory.getHandler(data);
        ResponseType code = handler.handleRequest(data);
        dispatcher.forwardWithCode(req, resp, code);
    }
}
