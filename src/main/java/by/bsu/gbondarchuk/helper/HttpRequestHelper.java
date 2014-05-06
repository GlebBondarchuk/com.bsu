package by.bsu.gbondarchuk.helper;

import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.model.RequestData;
import by.bsu.gbondarchuk.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestHelper {
    public static RequestData getRequestData(HttpServletRequest request) {
        RequestData data = new RequestData();
        data.firstName = request.getParameter(Constants.FIRST_NAME);
        data.lastName = request.getParameter(Constants.LAST_NAME);
        data.companyName = request.getParameter(Constants.COMPANY_NAME);
        data.hobby = request.getParameter(Constants.HOBBY);
        data.formId = request.getParameter(Constants.FORM_ID);
        data.requestAction = extractAction(request);
        data.hasValidMark = (Boolean)request.getAttribute(Constants.VALID_MARK);
        data.sessionID = request.getSession().getId();
        String tableNav = request.getParameter(Constants.TABLE_NAV);
        if (tableNav != null) {
            data.requestAction = Action.UPDATE_LIST;
            data.navDir = tableNav.equals("first") ? 0 :
                    tableNav.equals("prev") ? 1 :
                            tableNav.equals("next") ? 2 : 3;
        }
        return data;
    }

    public static Action extractAction(HttpServletRequest request) {
        String action = request.getParameter(Constants.ACTION);
        if (action == null) {
            action = (String)request.getAttribute(Constants.ACTION);
        }
        if (action == null) {
            action = (String)request.getSession().getAttribute(Constants.ACTION);
        }
        if (action == null) {
            return Action.START_REGISTRATION;
        }
        return Action.resolve(action);
    }

}
