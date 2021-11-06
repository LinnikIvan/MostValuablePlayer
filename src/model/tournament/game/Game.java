package model.tournament.game;

import model.Player;
import model.Team;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Game {
    //    protected WinningCriteria winningCriteria;
    protected final Set<Team> teams = new HashSet<>(2);
    protected Set<Player> players = new HashSet<>();
    protected List<String> playersStats;

    public void setPlayersStats(List<String> playersStats) {
        this.playersStats = playersStats;

//        for (String stats : playersStats) System.out.println(stats);
    }

    protected abstract void createPlayers();

    protected abstract void createTeams();

    protected abstract void defineWinnerTeam();

    public Set<Team> getTeams() {
        return teams;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void playGame() {
        createPlayers();
        createTeams();
        defineWinnerTeam();
    }
}

////TODO remove criteria. its may be unneeded
//enum WinningCriteria {
//    HIGHEST_SCORED_POINTS,
//    MOST_GOALS_MADE
//}
