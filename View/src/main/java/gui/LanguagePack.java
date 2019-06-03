package gui;


import java.util.ListResourceBundle;

public class LanguagePack extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"b2", "Easy"},
                {"b3", "Medium"},
                {"b4", "Hard"},
                {"b5", "Polski"},
                {"b6", "English"},
                {"b7", "Run Saved Game"},
                {"verifyButton","Verify"},
                {"saveGame","Save Game"},
                {"homeButton","Go Back"},
                {"setTitleAlert-Correct","Well Done!"},
                {"setContentTextAlert-Correct","Your solution is correct!"},
                {"setTitleAlert-Wrong","Failure!"},
                {"setContentTextAlert-Correct","Try Again"},
                {"languages","Languages"},
                {"difficulty","Difficulty"},







        };
    }
}