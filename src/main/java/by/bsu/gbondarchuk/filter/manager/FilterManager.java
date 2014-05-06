package by.bsu.gbondarchuk.filter.manager;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface FilterManager {
    void doFiltering(ServletRequest request, ServletResponse response) throws ServletException, IOException;
}
