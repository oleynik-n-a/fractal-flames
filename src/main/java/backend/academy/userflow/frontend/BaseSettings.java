package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Setter;

@Setter
public abstract class BaseSettings implements Printable {
    protected boolean incorrectInput;

    protected BaseSettings() {
        incorrectInput = false;
    }

    @Override
    public void print() {
        PrintHandler.INSTANCE
            .printMessage(incorrectInput ? "Incorrect input!" + System.lineSeparator() + System.lineSeparator() : "");
    }
}
