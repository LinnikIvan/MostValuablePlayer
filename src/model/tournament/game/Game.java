package model.tournament.game;

import model.Player;
import model.Team;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class Game {
    protected WinningCriteria winningCriteria;
    protected final Set<Team> teams = new HashSet<>(2);
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
        System.out.println("create teams");
        Team newTeam;
        for (Player player : players) {
//            System.out.println(player);
            newTeam = new Team(player.getTeamName());
            teams.add(newTeam);

            for (Team existingTeam : teams) {
                existingTeam.addPlayer(player);
            }

        }

        for (Team t : teams) {
            System.out.println(t.getName());
            for (Player player : t.getPlayers()) {
                System.out.println(player);
            }
        }

//        System.out.println(teams);
    }

    protected abstract void defineWinnerTeam();

    public Set<Team> getTeams() {
        return teams;
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

    @Override
    protected void defineWinnerTeam() {
        Team winnerTeam = null;
        int winnerTeamPoints = 0;

        for (Team currentTeam : teams) {
            if (winnerTeam == null) winnerTeam = currentTeam;
            int currentTeamPoints = 0;

            for (Player player : players) {
//                currentTeamPoints += player.getTeamWinningPoints();
            }

            if (currentTeamPoints > winnerTeamPoints) {
                winnerTeamPoints = currentTeamPoints;
                winnerTeam = currentTeam;
            }
        }


    }

}

abstract class MostGoalsMadeGame extends Game {
    {
        winningCriteria = WinningCriteria.MOST_GOALS_MADE;
    }

    public MostGoalsMadeGame(List<String> playersStats) {
        super(playersStats);
    }

    @Override
    protected void defineWinnerTeam() {

    }
}
