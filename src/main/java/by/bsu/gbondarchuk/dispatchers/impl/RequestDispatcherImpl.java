package by.bsu.gbondarchuk.dispatchers.impl;

import by.bsu.gbondarchuk.dispatchers.RequestDispatcher;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.helper.HttpDispatcherHelper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class RequestDispatcherImpl implements RequestDispatcher {

    @Override
    public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        throw new NotImplementedException();
    }

    @Override
    public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        throw new NotImplementedException();
    }

    @Override
    public void forwardWithCode(ServletRequest request, ServletResponse response, ResponseType result) {
        try {
            String dispatcherPath = HttpDispatcherHelper.prepare(request, response, result);
            request.getRequestDispatcher(dispatcherPath).forward(request, response);
        } catch (IOException e) {
            System.out.println("IOException occurred while forwarding request");
            e.printStackTrace();
        } catch ( ServletException e) {
            System.out.println("ServletException occurred while forwarding request");
            e.printStackTrace();
        }
    }
}
