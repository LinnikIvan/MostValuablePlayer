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
                game = new BasketballGame(playersStats);
                break;
            case HANDBALL:
                game = new HandballGame(playersStats);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gameType);
        }
        return game;
    }
}

enum GameType {
    BASKETBALL,
    HANDBALL
}
