package gui;

import java.util.ListResourceBundle;

public class LanguagePackPL extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"b2", "Łatwy"},
                {"b3", "Średni"},
                {"b4", "Trudny"},
                {"b5", "Polski"},
                {"b6", "English"},
                {"b7", "Uruchom Zapis"},
                {"verifyButton","Sprawdź"},
                {"saveGame","Zapisz"},
                {"homeButton","Powrót"},
                {"setTitleAlert-Correct","Brawo!"},
                {"setContentTextAlert-Correct","Poprawnie rozwiązałeś SUDOKU"},
                {"setTitleAlert-Wrong","ŹLE!"},
                {"setContentTextAlert-Correct","SPRÓBUJ PONOWNIE"},
                {"languages","Jezyki"},
                {"difficulty","Trudnosc"},
        };
    }
}