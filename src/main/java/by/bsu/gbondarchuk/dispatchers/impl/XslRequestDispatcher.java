package by.bsu.gbondarchuk.dispatchers.impl;

import by.bsu.gbondarchuk.dispatchers.RequestDispatcher;
import by.bsu.gbondarchuk.model.enums.Action;
import by.bsu.gbondarchuk.model.enums.ResponseType;
import by.bsu.gbondarchuk.model.enums.XslScript;
import by.bsu.gbondarchuk.helper.XslDispatcherHelper;
import by.bsu.gbondarchuk.model.ViewModel;
import by.bsu.gbondarchuk.xsl.XslHelper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class XslRequestDispatcher implements RequestDispatcher {
    @Override
    public void forwardWithCode(ServletRequest request, ServletResponse response, ResponseType result) {
        ViewModel model = XslDispatcherHelper.prepare(request, result);
        XslScript script = XslScript.COMMON_PAGE_SCRIPT;
        if (result == ResponseType.FAIL) {
            script = XslScript.ERROR_PAGE_SCRIPT;
        } else if (Action.resolve(model.pageEntity.action) == Action.REGISTER_HOBBY) {
            script = XslScript.INFO_PAGE;
        }
        try {
            XslHelper.transform(script, model, response.getOutputStream());
            XslHelper.transform(script, model, System.out);
        } catch (IOException e) {
            System.out.println("Could not send response");
            e.printStackTrace();
        }
    }

    @Override
    public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        throw new NotImplementedException();
    }

    @Override
    public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        throw new NotImplementedException();
    }
}
