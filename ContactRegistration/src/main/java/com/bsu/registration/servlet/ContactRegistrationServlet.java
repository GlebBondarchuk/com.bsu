package com.bsu.registration.servlet;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * User: gbondarchuk
 * Date: 28.02.14
 */

public class ContactRegistrationServlet extends HttpServlet {

    public static final String ACTION = "action";
    public static final String A_COMPANY = "aCompany";
    public static final String A_PERSONAL_INFO = "aPersonalInfo";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String COMPANY_NAME = "companyName";
    public static final String A_SAVE = "aSave";
    public static final String RELATIVE_VIEW_PATH = "/WEB-INF/views/";


    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        setResponseHeaders(response);

        HttpSession session = request.getSession();
        String action = request.getParameter(ACTION);

        if (StringUtils.isNotBlank(action)) {
            session.setAttribute(ACTION, action);
            switch (action) {
                case A_COMPANY:
                    forward(request, response, "company.jsp");
                    break;
                case A_PERSONAL_INFO:
                    forward(request, response, "personal.jsp");
                    break;
                case A_SAVE:
                    forward(request, response, "contact.jsp");
                    break;
            }
        } else {
            forward(request, response, "registration.jsp");
        }
    }

    /**
     * Forwards a request from a servlet to another resource.
     *
     * @param request      a ServletRequest object that represents the request the client makes of the servlet
     * @param response     a ServletResponse object that represents the response the servlet returns to the client
     * @param resourceName a String specifying the name to the resource.
     * @throws ServletException
     * @throws java.io.IOException
     */
    private void forward(HttpServletRequest request, HttpServletResponse response, String resourceName)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(RELATIVE_VIEW_PATH + resourceName);
        dispatcher.forward(request, response);
    }

    /**
     * Set response headers.
     *
     * @param response Response object.
     */
    private void setResponseHeaders(HttpServletResponse response) {
        response.setContentType("text/html");
    }
}


