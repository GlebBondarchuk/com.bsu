package by.bsu.gbondarchuk.helper;

import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.model.enums.ObjectKey;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.model.AppStorage;
import by.bsu.gbondarchuk.utils.Constants;
import by.bsu.gbondarchuk.utils.PageURI;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HttpDispatcherHelper {
    public static String prepare(ServletRequest request, ServletResponse response, ResponseType code) {
        setFormMark(request);
        if (code == ResponseType.FAIL) {
            clearSession((HttpServletRequest) request);
            return PageURI.ERROR_PAGE;
        }
        Action action = HttpRequestHelper.extractAction((HttpServletRequest) request);
        switch (action) {
            case START_REGISTRATION:
                return prepareNameRegistration(request);
            case REGISTER_NAME:
                return prepareCompanyRegistration(request);
            case REGISTER_COMPANY:
                return prepareHobbyRegistration(request);
            case REGISTER_HOBBY:
                return finishRegistration(request);
            default:
                return PageURI.ERROR_PAGE;
        }
    }

    private static void setFormMark(ServletRequest request) {
        String newId = (String) AppStorage.getObject(ObjectKey.CURRENT_FORM_ID);
        ((HttpServletRequest) request).getSession().setAttribute(Constants.FORM_ID, newId);
    }

    private static String prepareNameRegistration(ServletRequest request) {
        ((HttpServletRequest)request).getSession().setAttribute(Constants.PAGE_HEADER, "Contact Registration");
        ((HttpServletRequest)request).getSession().setAttribute(Constants.SUBMIT_BUTTON_CAPTION, "Next");
        return PageURI.COMMON_PAGE;
    }

    private static String prepareCompanyRegistration(ServletRequest request) {
        ((HttpServletRequest)request).getSession().setAttribute(Constants.FIRST_NAME, request.getParameter("firstname"));
        ((HttpServletRequest)request).getSession().setAttribute(Constants.LAST_NAME, request.getParameter("lastname"));
        ((HttpServletRequest)request).getSession().setAttribute(Constants.PAGE_HEADER, "Contact's Company Registration");
        ((HttpServletRequest)request).getSession().setAttribute(Constants.SUBMIT_BUTTON_CAPTION, "Next");
        return PageURI.COMMON_PAGE;
    }

    private static String prepareHobbyRegistration(ServletRequest request) {
        ((HttpServletRequest)request).getSession().setAttribute(Constants.COMPANY_NAME, request.getParameter("companyname"));
        ((HttpServletRequest)request).getSession().setAttribute(Constants.PAGE_HEADER, "Personal Info Registration");
        ((HttpServletRequest)request).getSession().setAttribute(Constants.SUBMIT_BUTTON_CAPTION, "Save");
        return PageURI.COMMON_PAGE;
    }

    private static String finishRegistration(ServletRequest request) {
        clearSession((HttpServletRequest) request);
        return PageURI.REGISTRATION_INFO_PAGE;
    }

    private static void clearSession(HttpServletRequest req) {
        req.getSession().removeAttribute(Constants.COMPANY_NAME);
        req.getSession().removeAttribute(Constants.FIRST_NAME);
        req.getSession().removeAttribute(Constants.LAST_NAME);
        req.getSession().removeAttribute(Constants.HOBBY);
        req.getSession().removeAttribute(Constants.ACTION);
    }
}
