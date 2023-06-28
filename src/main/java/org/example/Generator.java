package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generator {
    static String generateAnswer() {
        List<Integer> digits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(digits);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(digits.get(i));
        }
        System.out.println("Ответ: " + sb);
        return sb.toString();
    }
}
