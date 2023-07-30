package org.example.checking_algoritms;

import org.example.user.UserType;

public class HorizontalWinAlgorithmImpl implements WinAlgorithm {
    @Override
    public boolean doCheck(String[][] gameDesk, UserType userType) {
        for (String[] array1: gameDesk) {
            int counter = 0;

            for (String arr: array1 ) {
                if(arr != null && arr.equals(userType.name())) {
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
