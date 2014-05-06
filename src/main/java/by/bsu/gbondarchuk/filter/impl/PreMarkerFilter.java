package by.bsu.gbondarchuk.filter.impl;

import by.bsu.gbondarchuk.model.enums.ObjectKey;
import by.bsu.gbondarchuk.filter.Filter;
import by.bsu.gbondarchuk.model.AppStorage;
import by.bsu.gbondarchuk.utils.Constants;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PreMarkerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response) {
        String sFormId = (String)(AppStorage.getObject(ObjectKey.CURRENT_FORM_ID));
        String rFormId = request.getParameter(Constants.FORM_ID);
        boolean status = sFormId == null || rFormId == null || sFormId.equals(rFormId);
        request.setAttribute(Constants.VALID_MARK, status);
        AppStorage.writeObject(ObjectKey.CURRENT_FORM_ID, String.valueOf(System.currentTimeMillis()));
    }
}
