package model.tournament.game;

import model.Player;
import model.Team;

public class HandballGame extends Game {

    public HandballGame() {
        this.winningCriteria = WinningCriteria.MOST_GOALS_MADE;
        System.out.println("create handball game");
    }

}

class HandballTeam extends Team {

}

class HandballPlayer extends Player {

}
