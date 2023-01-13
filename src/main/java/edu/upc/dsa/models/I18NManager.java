package edu.upc.dsa.models;

import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {
    private static I18NManager instance;

    public HashMap<String, ResourceBundle> languages;

    private I18NManager() {
        this.languages = new HashMap<>();
    }

    public static I18NManager getInstance() {
        if (instance == null) instance = new I18NManager();
        return instance;
    }

    public void clear() {
        languages.clear();
    }

    public String getText(String language, String l) {
        ResourceBundle bundle = ResourceBundle.getBundle(language);
        languages.put(language, bundle);
        return bundle.getString(l);
    }
}
