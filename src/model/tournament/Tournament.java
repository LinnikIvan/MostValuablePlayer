package model.tournament;

import model.Player;
import model.tournament.game.Game;
import util.GameCreator;

import java.util.*;

public class Tournament {
    private final List<Game> games = new ArrayList<>();
    //    private final Set<Team> teams = new HashSet<>();
    private final Set<Player> players = new HashSet<>();

    private final GameCreator gameCreator = new GameCreator();

    private Player mostValuablePlayer;

    public void playGames(Map<String, List<String>> initialData) {
        if (initialData == null) {
            System.out.println("No data for tournament");
        }

        for (Map.Entry<String, List<String>> entry : initialData.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            games.add(gameCreator.createGame(key, value));
        }

        games.forEach(Game::playGame);

        for (Game game : games) {
            //todo add player in tournament in other way
            players.addAll(game.getPlayers());
        }

        defineMVP();


    }

    private Player defineMVP() {

        //calculating

        return mostValuablePlayer;
    }


    public Player getMostValuablePlayer() {
        return mostValuablePlayer;
    }

}
