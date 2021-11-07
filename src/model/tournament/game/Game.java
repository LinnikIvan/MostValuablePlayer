package model.tournament.game;

import model.Player;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class Game {
    protected final Set<Team> teams = new LinkedHashSet<>(2);
    protected Set<Player> players = new LinkedHashSet<>();
    protected List<String> playersStats;
    private final static int TEAM_WIN_POINTS = 10;

    public Game(List<String> playersStats) {
        this.playersStats = playersStats;
    }

    public void playGame() {
        createPlayers();
        createTeams();
        defineWinnerTeam();
        calculatePlayerRatingPoints();
    }

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
        increaseWinnerPlayersRating(winnerTeam);
        System.out.println(getClass().getSimpleName() + " winner: " + winnerTeam.getName() +
                " - " + winnerTeamPoints + " pts");
    }

    private void increaseWinnerPlayersRating(Team team) {
        team.getPlayers().forEach(player -> player.addRatingPoints(TEAM_WIN_POINTS));
    }

    protected abstract void calculatePlayerRatingPoints();

    protected abstract void createPlayers();

    public Set<Player> getPlayers() {
        return players;
    }
}
