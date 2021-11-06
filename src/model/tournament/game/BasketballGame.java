package model.tournament.game;

import model.Player;
import model.Team;

public class BasketballGame extends Game {

    public BasketballGame() {
//        this.winningCriteria = WinningCriteria.HIGHEST_SCORED_POINTS;
//        System.out.println("create basketball game");
    }


    @Override
    protected void createPlayers() {
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
    }

    @Override
    protected void createTeams() {

    }

    @Override
    protected void defineWinnerTeam() {
    }
}

class BasketballTeam extends Team {

}

class BasketballPlayer extends Player {
    //    player 1;nick1;4;Team A;10;2;7
    private int scoredPoints;
    private int rebounds;
    private int assists;


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
        System.out.println(this);
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

    //    private BasketballPlayer(String name, String nickname, int number, String teamName) {
//        super(name, nickname, number, teamName);
//    }
}
