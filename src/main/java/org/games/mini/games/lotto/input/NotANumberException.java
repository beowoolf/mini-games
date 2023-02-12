package org.games.mini.games.lotto.input;

public class NotANumberException extends RuntimeException {

    private static final String NOT_A_NUMBER_MESSAGE = "Not a number was given!";

    public NotANumberException() {
        super(NOT_A_NUMBER_MESSAGE);
    }

}
