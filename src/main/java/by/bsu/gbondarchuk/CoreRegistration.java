package by.bsu.gbondarchuk;

import by.bsu.gbondarchuk.dispatchers.impl.FrontController;
import by.bsu.gbondarchuk.dispatchers.impl.XslRequestDispatcher;
import by.bsu.gbondarchuk.filter.impl.PreMarkerFilter;
import by.bsu.gbondarchuk.filter.impl.SessionFilter;
import by.bsu.gbondarchuk.filter.manager.FilterManager;
import by.bsu.gbondarchuk.filter.manager.FilterManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CoreRegistration extends HttpServlet {

    private FilterManager filterManager;

    @Override
    public void init() throws ServletException {
        super.init();
        FrontController target = new FrontController(new XslRequestDispatcher());
        filterManager = new FilterManagerImpl(target, new SessionFilter(), new PreMarkerFilter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        filterManager.doFiltering(req, resp);
    }
}
