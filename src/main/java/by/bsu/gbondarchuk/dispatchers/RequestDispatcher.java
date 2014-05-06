package by.bsu.gbondarchuk.dispatchers;

import by.bsu.gbondarchuk.model.enums.ResponseType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface RequestDispatcher extends javax.servlet.RequestDispatcher {
    public void forwardWithCode(ServletRequest request, ServletResponse response, ResponseType result);
}
