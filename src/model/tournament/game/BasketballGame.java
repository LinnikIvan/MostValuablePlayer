package model.tournament.game;

import model.Player;

import java.util.List;

public class BasketballGame extends HighestScoredPointsGame {

    public BasketballGame(List<String> playersStats) {
        super(playersStats);
    }

    @Override
    protected void createPlayers() {
//        System.out.println("create players");
        for (String playerStats : playersStats) {
            String[] stats = playerStats.split(";");
            String name = stats[0];
            String nickName = stats[1];
            int number = Integer.parseInt(stats[2]);
            String teamName = stats[3];
            int scoredPoints = Integer.parseInt(stats[4]);
            int rebounds = Integer.parseInt(stats[5]);
            int assists = Integer.parseInt(stats[6]);
            players.add(new BasketballPlayer
                    (name, nickName, number, teamName, scoredPoints, rebounds, assists));
        }
//        System.out.println(players);
    }

}

class BasketballPlayer extends Player {
    private final int scoredPoints;
    private final int rebounds;
    private final int assists;

    public BasketballPlayer(String name,
                            String nickname,
                            int number,
                            String teamName,
                            int scoredPoints,
                            int rebounds,
                            int assists) {
        super(name, nickname, number, teamName);
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
//        System.out.println(this);
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", number=" + number +
                ", teamName='" + teamName + '\'' +
                ", ratingPoints=" + ratingPoints +
                ", scoredPoints=" + scoredPoints +
                ", rebounds=" + rebounds +
                ", assists=" + assists +
                '}';
    }

}
