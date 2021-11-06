package model.tournament;

import model.Player;
import model.Team;
import model.tournament.game.Game;
import util.GameCreator;

import java.util.*;

public class Tournament {
    private final List<Game> games = new ArrayList<>();
    private final Set<Team> teams = new HashSet<>();
    private final Set<Player> players = new HashSet<>();

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

        for (Game game : games) {
            teams.addAll(game.getTeams());
            players.addAll(game.getPlayers());
        }

        for (Game game : games) {
            game.playGame();
        }



    }

}
