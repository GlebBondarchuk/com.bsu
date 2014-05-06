package by.bsu.gbondarchuk.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface FilterChain {
    public void addFilter(Filter filter);
    public void filter(ServletRequest request, ServletResponse response);
}
