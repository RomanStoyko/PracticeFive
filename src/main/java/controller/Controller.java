package controller;

import model.Model;
import model.entities.Note;
import model.util.InputUtility;
import view.View;
import view.utility.Localization;
import view.utility.key_words.KeyWords;

import java.util.List;
import java.util.Locale;

import static view.utility.MenuStatus.*;

public class Controller {
    private View view;
    private Model model;
    private KeyWords keyWords;
    private List<Note> notes;

    public Controller() {
    }

    public Controller(View view, Model model,List<Note> notes) {
        this.view = view;
        this.model = model;
        this.notes = notes;
    }

    public void work(){
        view.printMessage(Localization.INSTANCE.getString(keyWords.WELCOME));
        chengeLocalization();
        printMenu();
        int status = 0;
        while (status != EXIT){
            status = Integer.valueOf(InputUtility.inputStringValueWithScanner(
                                            view,
                                            Localization.INSTANCE.getString(keyWords.INPUT_INT_DATA),
                                            Localization.INSTANCE.getString(keyWords.WRONG_INPUT_DATA),
                                            Localization.INSTANCE.getString(keyWords.REG_MENU)
                                        )
                     );

            switch (status){
                case LOCALIZATION:
                    chengeLocalization();
                    printMenu();
                    break;
                case INPUT:
                    inputNote();
                    printMenu();
                    break;
                case PRINT_ALL:
                    printAllNotes();
                    printMenu();
                    break;
            }
        }


    }

    private void printAllNotes() {
        for (Note note:notes) {
            System.out.println(note);
        }
    }

    private void inputNote() {
        String[] inputData = new String[keyWords.CHECKER.length];
        for (int i = 0; i < keyWords.CHECKER.length; i++) {

            view.printMessage(Localization.INSTANCE.getString(keyWords.CHECKER[i][0]));
            view.printMessage(Localization.INSTANCE.getString(keyWords.CHECKER[i][0] + keyWords.FORMAT));
            if(!keyWords.CHECKER[i][0].equals(keyWords.DATE)) {
                inputData[i] = InputUtility.inputStringValueWithScanner(
                        view,
                        Localization.INSTANCE.getString(keyWords.CHECKER[i][1]),
                        Localization.INSTANCE.getString(keyWords.CHECKER[i][2]),
                        Localization.INSTANCE.getString(keyWords.CHECKER[i][3])
                );
            }else {
                do {
                    inputData[i] = InputUtility.inputStringValueWithScanner(
                            view,
                            Localization.INSTANCE.getString(keyWords.CHECKER[i][1]),
                            Localization.INSTANCE.getString(keyWords.CHECKER[i][2]),
                            Localization.INSTANCE.getString(keyWords.CHECKER[i][3])
                    );
                }while (!model.isValid(inputData[i],Localization.INSTANCE.getString(keyWords.REG_DATE_SIMPLE),view));
            }
        }
        notes.add(new Note(inputData[0],inputData[1],inputData[2],inputData[4],inputData[4]));

    }


    private void chengeLocalization() {
        printLengMenu();
        String langNumber = InputUtility.inputStringValueWithScanner(
                view,
                Localization.INSTANCE.getString(keyWords.INPUT_INT_DATA),
                Localization.INSTANCE.getString(keyWords.WRONG_INPUT_DATA),
                Localization.INSTANCE.getString(keyWords.REG_LANG)
        );

        int leng = Integer.parseInt(langNumber);
        Locale locale = model.getLocale(leng);
        Localization.INSTANCE.changeResource(locale);
        view.printMessage(Localization.INSTANCE.getString(keyWords.LENG_MENU_FINISH));
    }



    private void printMenu(){
        view.printMessage(Localization.INSTANCE.getString(keyWords.MENU_GRITING));
        view.printMessage(Localization.INSTANCE.getString(keyWords.MENU_ONE));
        view.printMessage(Localization.INSTANCE.getString(keyWords.MENU_TWO));
        view.printMessage(Localization.INSTANCE.getString(keyWords.MENU_THREE));
        view.printMessage(Localization.INSTANCE.getString(keyWords.MENU_FOUR));
    }


    private void printLengMenu(){
        view.printMessage(Localization.INSTANCE.getString(keyWords.LENG_MENU_GRITING));
        view.printMessage(Localization.INSTANCE.getString(keyWords.LENG_MENU_ONE));
        view.printMessage(Localization.INSTANCE.getString(keyWords.LENG_MENU_TWO));
        view.printMessage(Localization.INSTANCE.getString(keyWords.LENG_MENU_THREE));
    }
}
