package org.example;

import java.io.*;
import java.util.Date;

public class Loger{

    BufferedReader reader ;
    FileWriter fileWriter ;

    public Loger() throws IOException {
    }

    static int getLastGameNumber() throws IOException {
        FileReader fileReader = new FileReader("games.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        int lastGameNumber = 0;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Game №")) {
                lastGameNumber = Integer.parseInt(line.split("\\s+")[1].replaceAll("\\D+",""));
            }
        }

        reader.close();
        return lastGameNumber;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public Loger(BufferedReader reader, FileWriter fileWriter) throws IOException {
        this.reader = reader;
        this.fileWriter = fileWriter;
    }

    public static String getGameInfo(int gameNumber, String answer, int tries) {
        Date date = new Date(); // текущая дата и время
        return String.format("Game №%d %tF %tT Загаданная строка %s\n", gameNumber, date, date, answer) +
                String.format("  Игра закончена за %d попытк(и/у)\n", tries);
    }
}
