package util;

import model.tournament.Tournament;

import java.util.List;
import java.util.Map;

public class GamesHost {
    public static void main(String[] args) {
        System.out.println("The game will start soon\n");
        Tournament tournament = new Tournament();

        Map<String, List<String>> tournamentInfo = null;
        boolean isWrongFilesFormat = false;
        try {
            tournamentInfo = Reader.readFilesSet("resources");
        } catch (WrongFilesFormatException e) {
            isWrongFilesFormat = true;
            e.printStackTrace();
        }

        if (isWrongFilesFormat) {
            System.out.println("Sorry, this tournament will not calculate the MVP. " +
                    "Check the input data.");
        } else {
            tournament.playTournament(tournamentInfo);
            System.out.println("\nThe most valuable player is " + tournament.getMostValuablePlayer());
        }

    }
}
