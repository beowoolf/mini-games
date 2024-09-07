package org.games.mini.games.lotto.input;

import org.games.mini.games.lotto.messageprovider.LottoMessageProvider;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.games.mini.games.lotto.config.LottoGameConfiguration.*;

public class LottoInputReceiver {

    private static final String NEGATIVE_AND_POSITIVE_NUMBER_REGEX = "^-?\\d*\\.{0,1}\\d+$";

    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInput(scanner);
        scanner.close();
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbersFromUserInput(Scanner in) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.printf((LottoMessageProvider.PLEASE_GIVE_NUMBERS) + "%n", HOW_MANY_NUMBERS_FROM_USER);
        while (areLessThanSixNumbersGiven(givenNumbers)) {
            System.out.println(LottoMessageProvider.GIVE_NUMBER);
            while (!in.hasNextInt()) {
                System.out.printf(LottoMessageProvider.NOT_IN_RANGE, LOWER_BOUND, UPPER_BOUND);
                if (!in.hasNext()) {
                    return Collections.emptySet();
                }
                String next = in.next();
                if (!next.contains(NEGATIVE_AND_POSITIVE_NUMBER_REGEX)) {
                    throw new NotANumberException();
                }
            }
            final int userInput = in.nextInt();
            validateNumber(givenNumbers, userInput);
        }
        return givenNumbers;
    }

    private void validateNumber(Set<Integer> givenNumbers, int userInput) {
        if (isInRange(userInput)) {
            givenNumbers.add(userInput);
        } else {
            System.out.printf(LottoMessageProvider.NOT_IN_RANGE_WITH_GIVEN_NUMBER, userInput, LOWER_BOUND, UPPER_BOUND);
        }
    }

    private boolean areLessThanSixNumbersGiven(Set<Integer> numbers) {
        return numbers.size() < HOW_MANY_NUMBERS_FROM_USER;
    }

    private boolean isInRange(int givenNumber) {
        return givenNumber >= LOWER_BOUND && givenNumber <= UPPER_BOUND;
    }

}
