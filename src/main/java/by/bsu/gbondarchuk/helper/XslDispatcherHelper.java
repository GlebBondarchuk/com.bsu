package by.bsu.gbondarchuk.helper;

import by.bsu.gbondarchuk.model.Contact;
import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.model.enums.Messages;
import by.bsu.gbondarchuk.model.enums.ObjectKey;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.model.ViewModel;
import by.bsu.gbondarchuk.model.AppStorage;
import by.bsu.gbondarchuk.utils.Constants;
import by.bsu.gbondarchuk.utils.MessageUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class XslDispatcherHelper {

    public static ViewModel prepare(ServletRequest request, ResponseType code) {
        Action action = HttpRequestHelper.extractAction((HttpServletRequest) request);
        ViewModel viewModel = new ViewModel();
        Contact contact = (Contact) AppStorage.getObject(ObjectKey.PERSON);
        fillWithCommonData(viewModel);
        viewModel.pageEntity.requestURL = ((HttpServletRequest) request).getRequestURL().toString();
        viewModel.contact = contact;
        if (code == ResponseType.FAIL) {
            clearSession((HttpServletRequest) request);
            viewModel.pageEntity.title = MessageUtils.getMessage(Messages.ERROR_PAGE_TITLE);
            viewModel.pageEntity.pageHeader = MessageUtils.getMessage(Messages.DEFAULT_ERROR_TEXT);
            return viewModel;
        }
        switch (action) {
            case START_REGISTRATION:
                return prepareNameRegistration(viewModel);
            case REGISTER_NAME:
                return prepareCompanyRegistration(viewModel);
            case REGISTER_COMPANY:
                return prepareHobbyRegistration(viewModel);
            case REGISTER_HOBBY:
            case UPDATE_LIST:
                return finishRegistration(request, viewModel);
            default:
                return viewModel;
        }
    }

    private static ViewModel updateList(ServletRequest request, ViewModel viewModel) {
        String key = ((HttpServletRequest)request).getSession().getId();
        viewModel.pageEntity.contacts = (Contact[]) AppStorage.getObject(key);
        viewModel.pageEntity.action = Action.REGISTER_HOBBY.getActionName();
        return viewModel;
    }

    private static ViewModel prepareNameRegistration(ViewModel viewModel) {
        viewModel.pageEntity.btnTitle = "Next";
        viewModel.pageEntity.pageHeader = "Contact Registration";
        return viewModel;
    }

    private static ViewModel prepareCompanyRegistration(ViewModel viewModel) {
        viewModel.pageEntity.btnTitle = "Next";
        viewModel.pageEntity.pageHeader = "Company Registration";
        return viewModel;
    }

    private static ViewModel prepareHobbyRegistration(ViewModel viewModel) {
        viewModel.pageEntity.btnTitle = "Save";
        viewModel.pageEntity.pageHeader = "Personal Info Registration";
        return viewModel;
    }

    private static ViewModel finishRegistration(ServletRequest request, ViewModel viewModel) {
        String key = ((HttpServletRequest)request).getSession().getId();
        clearSession((HttpServletRequest) request);
        viewModel.pageEntity.contacts = (Contact[]) AppStorage.getObject(key);
        viewModel.pageEntity.action = Action.REGISTER_HOBBY.getActionName();
        return viewModel;
    }

    private static void fillWithCommonData(ViewModel viewModel) {
        viewModel.pageEntity.companyNameLabel = MessageUtils.getMessage(Messages.COMPANY_NAME_LABEL);
        viewModel.pageEntity.firstNameLabel = MessageUtils.getMessage(Messages.FIRST_NAME_LABEL);
        viewModel.pageEntity.lastNameLabel = MessageUtils.getMessage(Messages.LAST_NAME_LABEL);
        viewModel.pageEntity.title = MessageUtils.getMessage(Messages.TITLE);
        viewModel.pageEntity.hobbyLabel = MessageUtils.getMessage(Messages.HOBBY_LABEL);
        viewModel.pageEntity.congreteMessage = MessageUtils.getMessage(Messages.CONGRETE_MESSAGE);
        viewModel.pageEntity.successMessage = MessageUtils.getMessage(Messages.SUCCESS_MESSAGE);
        viewModel.pageEntity.linkText = MessageUtils.getMessage(Messages.LINK_CAPTION);
        viewModel.pageEntity.formId = (String) AppStorage.getObject(ObjectKey.CURRENT_FORM_ID);
    }

    private static void clearSession(HttpServletRequest req) {
        req.getSession().removeAttribute(Constants.COMPANY_NAME);
        req.getSession().removeAttribute(Constants.FIRST_NAME);
        req.getSession().removeAttribute(Constants.LAST_NAME);
        req.getSession().removeAttribute(Constants.HOBBY);
        req.getSession().removeAttribute(Constants.ACTION);
    }

}
