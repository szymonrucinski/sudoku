package gui;


import java.util.ListResourceBundle;

public class LanguagePack extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"b2", "Easy"},
                {"b3", "Medium"},
                {"b4", "Easy"},
                {"b5", "Polish"},
                {"b6", "English"},
                {"b7", "LoadGame"},


        };
    }
}