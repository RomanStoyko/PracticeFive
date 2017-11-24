package model;

import view.View;
import view.utility.Localization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static view.utility.key_words.KeyWordsInput.WRONG_INPUT_DATA;

public class Model {

    public boolean isValidString(String chekString, String reg){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(chekString);
        return matcher.find();
    }

    /**
     * for cheking data
     * @param chekString - input string
     * @param datePattern - data pattern
     * @return
     */
    public boolean isValid(String chekString, String datePattern, View view) {

        if (chekString == null || datePattern == null || datePattern.length() <= 0) {
            return false;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
        formatter.setLenient(false);

        try {
            formatter.parse(chekString);
        } catch (ParseException e) {
            view.printMessage(Localization.INSTANCE.getString(WRONG_INPUT_DATA));
            return false;

        }
        return true;
    }

    public Locale getLocale(int command) {
        switch (command) {
            case 3:
                return new Locale("en", "GB");
            case 2:
                return new Locale("uk", "UA");
            default:
                return Locale.getDefault();
        }
    }
}
