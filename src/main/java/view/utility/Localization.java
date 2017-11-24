package view.utility;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Localization {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourseName = "property.text";

    private Localization(){
        resourceBundle = ResourceBundle.getBundle(
                                    resourseName, new Locale("uk", "UA"));
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(
                                         resourseName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

}
