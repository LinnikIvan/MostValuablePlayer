package util;

import model.tournament.game.BasketballGame;
import model.tournament.game.Game;
import model.tournament.game.HandballGame;

import java.util.List;

public class GameCreator {

    public Game createGame(String gameType, List<String> playersStats) {
        Game game;
        switch (GameType.valueOf(gameType)) {
            case BASKETBALL:
                game = new BasketballGame();
                break;
            case HANDBALL:
                game = new HandballGame();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gameType);
        }

        game.setPlayersStats(playersStats);
        return game;
    }
}

enum GameType {
    BASKETBALL,
    HANDBALL
}
