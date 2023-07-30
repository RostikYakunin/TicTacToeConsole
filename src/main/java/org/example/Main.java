package org.example;

import org.example.service.DeskService;
import org.example.user.User;
import org.example.user.UserImpl;
import org.example.user.UserType;

import java.util.List;

public class Main {
    public static String[][] gameTable = new String[3][3];
    public static DeskService deskService = new DeskService();
    public static List<User> userList = List.of(new UserImpl(UserType.X), new UserImpl(UserType.O));

    public static void main(String[] args) {
        deskService.showGameFieldWithValues(gameTable);
        boolean gameOver = false;

        while (!gameOver) {
            for (User user : userList) {
                String[][] movingResult = user.doGameMove(gameTable);

                deskService.showGameFieldWithValues(movingResult);

                if (deskService.checkMove(gameTable, user.getUserType())) {
                    gameOver = true;
                    break;
                }
            }
        }
    }
}