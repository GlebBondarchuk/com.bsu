package by.bsu.gbondarchuk.factory;

import by.bsu.gbondarchuk.model.ActionHandler;
import by.bsu.gbondarchuk.dispatchers.handler.RequestHandler;
import by.bsu.gbondarchuk.dispatchers.handler.impl.RequestHandlerImpl;
import by.bsu.gbondarchuk.model.RequestData;
import by.bsu.gbondarchuk.utils.ClassUtils;

import java.util.Collection;

public class HttpRequestHandlerFactory {

    public static RequestHandler getHandler(RequestData request) {
        if (!request.hasValidMark) {
            return new RequestHandlerImpl();
        }
        Collection<Class> classes = ClassUtils.getAllClasses(RequestHandlerImpl.class.getPackage());
        for (Class cls : classes) {
            ActionHandler annotation = (ActionHandler)cls.getAnnotation(ActionHandler.class);
            if (annotation != null && annotation.action() == request.requestAction) {
                try {
                    return RequestHandler.class.cast(cls.newInstance());
                } catch (IllegalAccessException e) {
                    System.out.println("Could not instantiate handler instance: " + cls.getName());
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    System.out.println("Could not instantiate handler instance: " + cls.getName());
                    e.printStackTrace();
                }
            }
        }
        return new RequestHandlerImpl();
    }
}
