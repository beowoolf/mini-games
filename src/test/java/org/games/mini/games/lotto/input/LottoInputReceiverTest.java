package org.games.mini.games.lotto.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LottoInputReceiverTest {

    LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

    @Test
    void shouldReturnNumbersInSetWhenAllInRange() {
        // given
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        String givenNumbers = "1 2 3 4 5 101 6";
        Scanner userNumbers = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(userNumbers);
        // then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void shouldReturnNumbersInSetWhenOneNotInRange() {
        // given
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 15);
        String givenNumbers = "1 2 3 4 5 101 15";
        Scanner scanner = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        // then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void shouldReturnZeroNumbersInSetWhenAllNotInRange() {
        // given
        Set<Integer> expectedNumbers = Collections.emptySet();
        String givenNumbers = "0 -1 103 103 104 105 106";
        Scanner scanner = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        // then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void shouldThrowNotANumberExceptionWhenStringWasGiven() {
        // given
        String givenInput = "asdasd";
        String expectedExceptionMessage = "Not a number was given!";
        Scanner scanner = mockScannerIn(givenInput);
        // when
        Throwable thrown = catchThrowable(() -> lottoInputReceiver.getSixNumbers(scanner));
        // then
        assertThat(thrown).isInstanceOf(NotANumberException.class)
                .hasMessageContaining(expectedExceptionMessage);
    }

    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }

}
