package org.example;

public class isAnswerValid {
    static boolean Valid(String answer) {
        if (answer.length() != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            char c = answer.charAt(i);
            if (answer.indexOf(c) != i) {
                return false;
            }
        }
        return true;
    }
}
