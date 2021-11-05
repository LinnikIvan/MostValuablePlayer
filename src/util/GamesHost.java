package util;

import model.tournament.Tournament;

import java.util.List;
import java.util.Map;

public class GamesHost {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        System.out.println("The game will start soon\n");

        Map<String, List<String>> tournamentInfo = null;
        try {
            tournamentInfo = Reader.readFilesSet("resources");
        } catch (WrongFilesFormatException e) {
            //TODO not calculate MVP
            e.printStackTrace();
        }

        tournament.playGames(tournamentInfo);


        System.out.println("\nThe most valuable player is " + tournament.getMostValuablePlayer());
    }
}
