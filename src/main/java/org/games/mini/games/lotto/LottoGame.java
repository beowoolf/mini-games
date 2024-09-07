package org.games.mini.games.lotto;

import lombok.Data;
import org.games.mini.games.Game;
import org.games.mini.games.lotto.input.LottoInputReceiver;
import org.games.mini.games.lotto.logic.LottoHitNumberCalculator;
import org.games.mini.games.lotto.logic.LottoRandomGenerator;
import org.games.mini.games.lotto.messageprovider.LottoMessageProvider;
import org.games.mini.model.GameResult;
import org.games.mini.model.GameResultInfo;

import java.util.Scanner;
import java.util.Set;

import static org.games.mini.games.lotto.messageprovider.LottoMessageProvider.GAME_NAME;

@Data
public class LottoGame implements Game {

    private final LottoInputReceiver lottoInputReceiver;
    private final LottoRandomGenerator randomGenerator;
    private final LottoHitNumberCalculator lottoHitNumberCalculator;
    private final Scanner scanner;

    public GameResult startGame() {
        System.out.printf((LottoMessageProvider.GAME_S_STARTED) + "%n", GAME_NAME);
        final GameResultInfo gameResultInfo = getHitNumbers();
        return getGameResult(gameResultInfo);
    }

    private GameResultInfo getHitNumbers() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        final Set<Integer> randomNumbers = randomGenerator.getRandomSixNumbers();
        return lottoHitNumberCalculator.getHitNumbers(inputNumbers, randomNumbers);
    }

    private GameResult getGameResult(GameResultInfo gameResultInfo) {
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        System.out.println(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }

}
