package by.bsu.gbondarchuk.model;

import by.bsu.gbondarchuk.model.enums.Action;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ActionHandler {
    Action action();
}
