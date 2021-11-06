package model.tournament;

import model.Player;
import model.tournament.game.Game;
import util.GameCreator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tournament {
    private final List<Game> games = new ArrayList<>();
    private final Map<String, Player> players = new LinkedHashMap<>();

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
            for (Player player : game.getPlayers()) {
                String nick = player.getNickname();
                Player tournamentPlayer;
                if (!players.containsKey(nick)) {
                    tournamentPlayer = new TournamentPlayer(
                            player.getName(),
                            player.getNickname(),
                            player.getNumber(),
                            player.getTeamName());

                    tournamentPlayer.addRatingPoints(player.getRatingPoints());
                    players.put(nick, tournamentPlayer);
                } else {
                    tournamentPlayer = players.get(nick);
                    tournamentPlayer.addRatingPoints(player.getRatingPoints());
                }
            }

        }

        defineMVP();
    }

    private void defineMVP() {
        for (Player player : players.values()) {
            System.out.println(player);

            if (mostValuablePlayer == null) mostValuablePlayer = player;

            if (player.getRatingPoints() > mostValuablePlayer.getRatingPoints())
                mostValuablePlayer = player;
        }
    }

    public Player getMostValuablePlayer() {
        return mostValuablePlayer;
    }

}

class TournamentPlayer extends Player {
    protected TournamentPlayer(String name, String nickname, int number, String teamName) {
        super(name, nickname, number, teamName);
    }

    @Override
    public int getTeamEffectivePoints() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "TournamentPlayer{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", number=" + number +
                ", teamName='" + teamName + '\'' +
                ", ratingPoints=" + ratingPoints +
                '}';
    }
}
