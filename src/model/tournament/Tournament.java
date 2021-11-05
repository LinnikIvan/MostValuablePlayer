package model.tournament;

import model.Player;
import model.Team;
import model.tournament.game.Game;
import util.GameCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tournament {
    private List<Game> games = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    private Player mostValuablePlayer;

    public Player getMostValuablePlayer() {
        return mostValuablePlayer;
    }

    public void playGames(Map<String, List<String>> initialData) {
        if (initialData == null) {
            System.out.println("No data for tournament");
        }

        GameCreator gameCreator = new GameCreator();

        for (Map.Entry<String, List<String>> entry : initialData.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
//            System.out.println(key);
//            System.out.println(value);
            games.add(gameCreator.createGame(key, value));
        }


    }

}
