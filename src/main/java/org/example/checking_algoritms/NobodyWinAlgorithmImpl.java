package org.example.checking_algoritms;

import org.example.user.UserType;

public class NobodyWinAlgorithmImpl implements WinAlgorithm {
    @Override
    public boolean doCheck(String[][] gameDesk, UserType userType) {
        int counter = 0;

        for (String[] strings : gameDesk) {
            for (String string : strings) {
                if (string != null) {
                    counter++;
                }
            }
        }

        if(counter>=8) {
            System.err.println("                                               Nobody win !!!");
            return true;
        }

        return false;
    }
}
