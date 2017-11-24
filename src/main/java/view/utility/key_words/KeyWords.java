package view.utility.key_words;

public interface KeyWords extends KeyWordsReg,KeyWordsInput,KeyWordsMenu{



    String[][] CHECKER = {
            {FIRST_NAME, INPUT_STRING_DATA, WRONG_INPUT_DATA, REG_NAMES},
            {SECOND_NAME, INPUT_STRING_DATA, WRONG_INPUT_DATA, REG_NAMES,},
            {TELEPHONE, INPUT_STRING_DATA, WRONG_INPUT_DATA, REG_PHONE},
            {DATE, INPUT_STRING_DATA, WRONG_INPUT_DATA, REG_DATE},
            {ADRESS, INPUT_STRING_DATA, WRONG_INPUT_DATA, REG_ADRESS}
    };
}
