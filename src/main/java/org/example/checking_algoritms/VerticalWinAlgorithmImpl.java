package org.example.checking_algoritms;

import org.example.user.UserType;

public class VerticalWinAlgorithmImpl implements WinAlgorithm {
    @Override
    public boolean doCheck(String[][] gameDesk, UserType userType) {
        for (int i = 0; i < gameDesk.length; i++) {
            int counter = 0;

            for (String[] strings : gameDesk) {
                if (strings[i] != null && strings[i].equals(userType.name())) {
                    counter++;
                }

                if (counter == 3) {
                    System.err.println("User " + userType.name() + " win !!!");
                    return true;
                }
            }
        }
        return false;
    }
}
