package org.games.mini.games.lotto.logic;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

import static org.games.mini.games.lotto.config.LottoGameConfiguration.*;

public class LottoRandomGenerator {

    public Set<Integer> getRandomSixNumbers() {
        SecureRandom random = new SecureRandom();
        return random.ints(NUMBERS_TO_GENERATE, NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
                .boxed()
                .collect(Collectors.toSet());
    }

}
