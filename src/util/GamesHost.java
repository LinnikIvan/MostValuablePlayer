package util;

import model.tournament.Tournament;

import java.util.List;
import java.util.Map;

public class GamesHost {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        boolean isWrongFilesFormat = false;

//        System.out.println("The game will start soon\n");

        Map<String, List<String>> tournamentInfo = null;
        try {
            tournamentInfo = Reader.readFilesSet("resources");
        } catch (WrongFilesFormatException e) {
            isWrongFilesFormat = true;
            e.printStackTrace();
        }

        if (!isWrongFilesFormat) {
            tournament.playGames(tournamentInfo);
//            System.out.println("\nThe most valuable player is " + tournament.getMostValuablePlayer());
        } else {
            System.out.println("Sorry, this tournament will not calculate the MVP." +
                    "Check the input data.");
        }

    }
}
