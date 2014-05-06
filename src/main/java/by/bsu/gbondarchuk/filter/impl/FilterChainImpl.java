package by.bsu.gbondarchuk.filter.impl;

import by.bsu.gbondarchuk.filter.Filter;
import by.bsu.gbondarchuk.filter.FilterChain;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FilterChainImpl implements FilterChain {

    private List<Filter> filters = new ArrayList<Filter>();

    public FilterChainImpl(Filter ... filters) {
        for (Filter filter : filters) {
            addFilter(filter);
        }
    }

    @Override
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public void filter(ServletRequest request, ServletResponse response) {
        for (Filter filter : filters) {
            filter.doFilter(request, response);
        }
    }
}
