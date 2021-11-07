package model.tournament.game;

import model.Player;

import java.util.List;

public class HandballGame extends Game {
    public HandballGame(List<String> playersStats) {
        super(playersStats);
    }

    @Override
    protected void calculatePlayerRatingPoints() {
        HandballPlayer handballPlayer;
        for (Player player : players) {
            handballPlayer = ((HandballPlayer) player);
            player.addRatingPoints(
                    handballPlayer.getGoalsMade() * 2 -
                            ((HandballPlayer) player).getGoalsReceived()
            );
            System.out.println(player);
        }
    }

    @Override
    protected void createPlayers() {
        for (String playerStats : playersStats) {
            String[] stats = playerStats.split(";");
            String name = stats[0];
            String nickName = stats[1];
            int number = Integer.parseInt(stats[2]);
            String teamName = stats[3];
            int goalsMade = Integer.parseInt(stats[4]);
            int goalsReceived = Integer.parseInt(stats[5]);
            players.add(new HandballPlayer
                    (name, nickName, number, teamName, goalsMade, goalsReceived));
        }
    }
}

class HandballPlayer extends Player {
    private final int goalsMade;
    private final int goalsReceived;

    public HandballPlayer(String name,
                          String nickname,
                          int number,
                          String teamName,
                          int goalsMade,
                          int goalsReceived) {
        super(name, nickname, number, teamName);
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    @Override
    public int getTeamEffectivePoints() {
        return goalsMade;
    }

    public int getGoalsMade() {
        return goalsMade;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    @Override
    public String toString() {
        return "HandballPlayer{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", number=" + number +
                ", teamName='" + teamName + '\'' +
                ", ratingPoints=" + ratingPoints +
                ", goalsMade=" + goalsMade +
                ", goalsReceived=" + goalsReceived +
                '}';
    }
}
