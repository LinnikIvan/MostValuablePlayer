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

    public void playTournament(Map<String, List<String>> initialData) {
        if (initialData == null) System.out.println("No data for tournament");

        createGames(initialData);
        playGames();
        calculateEachPlayerTotalRating();
        defineMVP();
    }

    private void createGames(Map<String, List<String>> initialData) {
        for (Map.Entry<String, List<String>> entry : initialData.entrySet()) {
            String gameType = entry.getKey();
            List<String> playersStats = entry.getValue();
            games.add(gameCreator.createGame(gameType, playersStats));
        }
    }

    private void playGames() {
        games.forEach(Game::playGame);
    }

    private void calculateEachPlayerTotalRating() {
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
    }

    private void defineMVP() {
        for (Player player : players.values()) {
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
