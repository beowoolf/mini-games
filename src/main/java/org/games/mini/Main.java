package org.games.mini;

import org.games.mini.games.Game;
import org.games.mini.games.lotto.LottoGame;
import org.games.mini.games.lotto.input.LottoInputReceiver;
import org.games.mini.games.lotto.logic.LottoHitNumberCalculator;
import org.games.mini.games.lotto.logic.LottoRandomGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Game lottoGame = getLottoGame();
        lottoGame.startGame();
    }

    private static Game getLottoGame() {
        final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoHitNumberCalculator lottoHitNumberCalculator = new LottoHitNumberCalculator();
        final Scanner scanner = new Scanner(System.in);
        return new LottoGame(lottoInputReceiver, randomGenerator, lottoHitNumberCalculator, scanner);
    }

}