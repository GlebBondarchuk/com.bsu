package by.bsu.gbondarchuk.filter.impl;

import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.filter.Filter;
import by.bsu.gbondarchuk.utils.Constants;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response) {
        if (request.getParameter(Constants.ACTION) == null) {
            request.setAttribute(Constants.ACTION, Action.START_REGISTRATION.getActionName());
        }
    }
}
