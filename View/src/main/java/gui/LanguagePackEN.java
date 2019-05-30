package gui;

import java.util.ListResourceBundle;

public class LanguagePackEN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"b2", "Łatwy"},
                {"b3", "Średni"},
                {"b4", "Trudny"},
                {"b5", "English"},
                {"b6", "Polski"},
        };
    }
}