package model.tournament.game;

import model.Team;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Game implements Playable {
    protected WinningCriteria winningCriteria;
    protected final Set<Team> teams = new HashSet<>(2);
    List<String> playerStats;

    public void setPlayersStats(List<String> playerStats) {
        this.playerStats = playerStats;
        for (String stats : playerStats) {
            System.out.print("\"" + stats + "\"" + ":");
        }
        System.out.println();
//        List<String> stats = new ArrayList<>();
//        String[] stats = playerStats
//        stats.addAll();
    }

    @Override
    public Team defineWinnerTeam() {
        return null;
    }


    public Game playTheGame(GameType gameType) {
        Game game = null;

//      do the methods

//        game.defineWinnerTeam();

        return game;
    }

}

