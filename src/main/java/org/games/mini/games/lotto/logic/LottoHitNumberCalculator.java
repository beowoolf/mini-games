package org.games.mini.games.lotto.logic;

import org.games.mini.games.lotto.model.LottoGameResultInfo;

import java.util.HashSet;
import java.util.Set;

public class LottoHitNumberCalculator {

    public LottoGameResultInfo getHitNumbers(Set<Integer> userGivenNumbers, Set<Integer> randomSixNumbers) {
        Set<Integer> finalHitNumbers = new HashSet<>(userGivenNumbers);
        finalHitNumbers.retainAll(randomSixNumbers);
        return new LottoGameResultInfo(userGivenNumbers, randomSixNumbers, finalHitNumbers);
    }

}
