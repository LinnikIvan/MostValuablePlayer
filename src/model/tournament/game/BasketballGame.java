package model.tournament.game;

import model.Player;
import model.Team;

public class BasketballGame extends Game {

    public BasketballGame() {
        this.winningCriteria = WinningCriteria.HIGHEST_SCORED_POINTS;
        System.out.println("create basketball game");
    }

}

class BasketballTeam extends Team {

}

class BasketballPlayer extends Player {

}
