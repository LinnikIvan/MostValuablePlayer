package model.tournament.game;

import model.Player;
import model.Team;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class Game {
    protected WinningCriteria winningCriteria;
    protected final Set<Team> teams = new LinkedHashSet<>(2);
    protected Set<Player> players = new LinkedHashSet<>();
    protected List<String> playersStats;

    public Game(List<String> playersStats) {
        this.playersStats = playersStats;
    }

    public void playGame() {
        createPlayers();
        createTeams();
        defineWinnerTeam();
    }

    protected abstract void createPlayers();

    protected void createTeams() {
        for (Player player : players) {
            teams.add(new Team(player.getTeamName()));
            teams.forEach(existingTeam -> existingTeam.addPlayer(player));
        }
    }

    protected void defineWinnerTeam() {
        Team winnerTeam = null;
        int winnerTeamPoints = 0;

        for (Team currentTeam : teams) {
            int currentTeamPoints = 0;

            for (Player player : currentTeam.getPlayers()) {
                currentTeamPoints += player.getTeamEffectivePoints();
            }

            if (currentTeamPoints > winnerTeamPoints) {
                winnerTeamPoints = currentTeamPoints;
                winnerTeam = currentTeam;
            }

        }
        System.out.println(getClass().getSimpleName() + " winner: " + winnerTeam.getName() + " - " + winnerTeamPoints);
    }

    public Set<Player> getPlayers() {
        return players;
    }
}

enum WinningCriteria {
    HIGHEST_SCORED_POINTS,
    MOST_GOALS_MADE
}

abstract class HighestScoredPointsGame extends Game {
    {
        winningCriteria = WinningCriteria.HIGHEST_SCORED_POINTS;
    }

    public HighestScoredPointsGame(List<String> playersStats) {
        super(playersStats);
    }

}

abstract class MostGoalsMadeGame extends Game {
    {
        winningCriteria = WinningCriteria.MOST_GOALS_MADE;
    }

    public MostGoalsMadeGame(List<String> playersStats) {
        super(playersStats);
    }

}
