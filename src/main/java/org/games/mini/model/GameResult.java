package org.games.mini.model;

import lombok.Data;
import org.games.mini.games.Game;

@Data
public class GameResult {

    private final Game game;
    private final GameResultInfo gameResultInfo;

}
