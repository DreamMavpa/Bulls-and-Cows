package org.example;


import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

        isAnswerValid validator = new isAnswerValid();
        Loger loger = new Loger(new BufferedReader(new InputStreamReader(System.in)),new FileWriter("games.txt", true));

        int lastGameNumber = loger.getLastGameNumber();

        String answer;
        boolean isInputValid;
        String randomizedAnswer;
        do {
            Generator generator = new Generator();
            randomizedAnswer = generator.generateAnswer();
            isInputValid = validator.Valid(randomizedAnswer);
        } while (!isInputValid);

        System.out.println("Для выхода отправь q");
        System.out.println("Программа загадала строку.");
        System.out.println("Начинаем игру!");

        int tries = 0;
        String input;
        boolean guessed = false;

        do {
            input = loger.reader.readLine();
            tries++;

            if (input.toLowerCase().equals("q")) {
                break;
            }

            if (!validator.Valid(input)) {
                System.out.println("Ошибка! Введите число из 4 разных цифр.");
                continue;
            }


            int bulls = 0, cows = 0;
            for (int i = 0; i < 4; i++) {
                char c = input.charAt(i);
                if (c == randomizedAnswer.charAt(i)) {
                    bulls++;
                } else if (randomizedAnswer.indexOf(c) != -1) {
                    cows++;
                }
            }

            if (bulls == 4) {
                guessed = true;
                System.out.println("Поздравляю! Вы угадали число за " + tries + " попытки(ок)!");
                loger.fileWriter.write(loger.getGameInfo(++lastGameNumber, randomizedAnswer, tries));
                loger.fileWriter.flush();
            } else {
                String cowsStr = "коров", bullsStr = "быков";

                if (cows == 1) {
                    cowsStr = "корова";
                } else if (cows >= 2 && cows <= 4) {
                    cowsStr = "коровы";
                } else if (cows > 4) {
                    cowsStr = "коров";
                }

                if (bulls == 1) {
                    bullsStr = "бык";
                } else if (bulls >=2 && bulls <= 4) {
                    bullsStr = "быка";
                } else if (bulls > 4) {
                    bullsStr = "быков";
                }

                System.out.println(cowsStr + ':' + " " + cows +"\n"+ bullsStr + ':' + " " + bulls);
            }

        } while (!guessed);

        loger.reader.close();
        loger.fileWriter.close();
    }

}