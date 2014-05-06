package by.bsu.gbondarchuk.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Filter {
    public void doFilter(ServletRequest request, ServletResponse response);
}
