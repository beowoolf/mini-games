package org.games.mini.games.lotto.model;

import lombok.Data;
import org.games.mini.games.lotto.messageprovider.LottoMessageProvider;
import org.games.mini.model.GameResultInfo;

import java.util.Set;

@Data
public class LottoGameResultInfo implements GameResultInfo {

    private final Set<Integer> userGivenNumbers;
    private final Set<Integer> randomSixNumbers;
    private final Set<Integer> finalHitNumbers;

    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessageProvider.LOTTO_RESULT, finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }

}
