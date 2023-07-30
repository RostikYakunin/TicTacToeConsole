package org.example.service;

import org.example.checking_algoritms.*;
import org.example.user.UserType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DeskService {
    public static final String EMPTY_CELL = "-";
    public final int SIZE = 3;
    public static List<WinAlgorithm> winAlgorithmList = List.of(
            new DiagonalWinAlgorithmImpl(),
            new HorizontalWinAlgorithmImpl(),
            new VerticalWinAlgorithmImpl(),
            new NobodyWinAlgorithmImpl()
    );


    private String createGameField() {
        return """
                                                                              _1____2____3__
                                                                          |       |    |
                                                                         1|    %s  | %s  | %s
                                                                          |   ____|____|____
                                                                          |       |    |
                                                                         2|    %s  | %s  | %s
                                                                          |   ____|____|____
                                                                          |       |    |
                                                                         3|    %s  | %s  | %s
                                                                          |       |    |
                """;
    }

    public void showGameFieldWithValues(String[][] gameTable) {
        System.out.printf(
                createGameField(),
                (Object[]) fillDeskValues(gameTable)
        );
    }


    private String[] fillDeskValues(String[][] gameTable) {
        String[] tableValues = new String[SIZE * SIZE];

        if (checkGameTableIsEmpty(gameTable)) {
            Arrays.fill(tableValues, EMPTY_CELL);
            return tableValues;
        }

        insertValuesToGameDesk(gameTable, tableValues);

        return tableValues;
    }

    private boolean checkGameTableIsEmpty(String[][] gameTable) {
        for (String[] strings : gameTable) {
            for (String string : strings) {
                if (string != null) {
                    return false;
                }
            }
        }
        return true;
    }

    private void insertValuesToGameDesk(String[][] gameTable, String[] tableValues) {
        int k = 0;
        for (String[] deskValue : gameTable) {
            for (String s : deskValue) {
                tableValues[k] = Objects.requireNonNullElse(s, EMPTY_CELL);
                k++;
            }
        }
    }

    public boolean checkMove(String[][] gameTable, UserType userType) {
        for (WinAlgorithm winAlgorithm : winAlgorithmList) {
            if (winAlgorithm.doCheck(gameTable, userType)) {
                return true;
            }
        }

        return false;
    }
}
