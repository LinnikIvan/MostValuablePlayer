package model.tournament.game;

import model.Player;
import model.Team;

public class HandballGame extends Game {

    public HandballGame() {
//        this.winningCriteria = WinningCriteria.MOST_GOALS_MADE;
//        System.out.println("create handball game");
    }

    @Override
    protected void createPlayers() {

    }

    @Override
    protected void createTeams() {

    }

    @Override
    protected void defineWinnerTeam() {
    }
}

class HandballTeam extends Team {

}

class HandballPlayer extends Player {

    protected HandballPlayer(String name, String nickname, int number, String teamName) {
        super(name, nickname, number, teamName);
    }


}
