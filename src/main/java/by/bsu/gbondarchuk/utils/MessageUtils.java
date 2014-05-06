package by.bsu.gbondarchuk.utils;

import by.bsu.gbondarchuk.model.enums.Messages;

import java.io.IOException;
import java.util.PropertyResourceBundle;

public class MessageUtils {
    private static PropertyResourceBundle bundle;

    public static String getMessage(Messages key) {
        if (bundle == null) {
            try {
                bundle = new PropertyResourceBundle(
                        MessageUtils.class.getClassLoader()
                                .getResourceAsStream("messages.properties"));
            } catch (IOException e) {
                System.out.println("Could not read properties file");
                e.printStackTrace();
            }
        }
        return bundle.getString(key.getKey());
    }
}
