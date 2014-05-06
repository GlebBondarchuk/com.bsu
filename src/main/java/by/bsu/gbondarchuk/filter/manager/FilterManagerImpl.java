package by.bsu.gbondarchuk.filter.manager;

import by.bsu.gbondarchuk.dispatchers.impl.FrontController;
import by.bsu.gbondarchuk.filter.Filter;
import by.bsu.gbondarchuk.filter.FilterChain;
import by.bsu.gbondarchuk.filter.impl.FilterChainImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class FilterManagerImpl implements FilterManager {
    private FilterChain preFilterChain;
    private FrontController target;

    public FilterManagerImpl(FrontController target, Filter... filters) {
        preFilterChain = new FilterChainImpl(filters);
        this.target = target;
    }

    @Override
    public void doFiltering(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        preFilterChain.filter(request, response);
        target.service(request, response);
    }
}
