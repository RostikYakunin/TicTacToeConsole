package org.example.checking_algoritms;

import org.example.user.UserType;

public class DiagonalWinAlgorithmImpl implements WinAlgorithm {
    @Override
    public boolean doCheck(String[][] gameDesk, UserType userType) {
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < gameDesk.length; i++) {
            if (gameDesk[i][i] != null && gameDesk[i][i].equals(userType.name())) {
                counter1++;
            }

            if (gameDesk[i][gameDesk.length - i - 1] != null && gameDesk[i][gameDesk.length - i - 1].equals(userType.name())) {
                counter2++;
            }
        }

        if(counter1 == 3 || counter2 == 3){
            System.err.println("User " + userType.name() + " win !!!");
            return true;
        }

        return false;
    }
}
