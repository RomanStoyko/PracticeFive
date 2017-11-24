package model.util;

import view.View;
import view.utility.key_words.KeyWords;
import view.utility.Localization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtility {
    private static Scanner scanner = new Scanner(System.in);
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static KeyWords keyWords;

    public static int inputIntValueWithScanner(View view, String msg, String errorMsg, Pattern pattern) {
        view.printMessage(msg);
        while (!scanner.hasNextInt()) {
            view.printMessage(errorMsg +
                    msg);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String inputStringValueWithScanner(View view, String msg, String errorMsg, String sPattern) {
        view.printMessage(msg);
        scanner.useDelimiter("\n");

        while (!scanner.hasNext(sPattern)) {
            view.printMessage(errorMsg +
                    msg);
            scanner.next();
        }
        return scanner.next(sPattern);
    }

}
