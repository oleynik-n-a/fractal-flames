package backend.academy;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.stream.handlers.PrintHandler;
import backend.academy.userflow.backend.ChangeSettings;
import backend.academy.userflow.frontend.Settings;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        PrintHandler.INSTANCE().setPrintStream(System.out);
        InputHandler.INSTANCE().setInputStream(System.in);

        ChangeSettings settingsChanger = new ChangeSettings(Settings.INSTANCE());
        settingsChanger.act();
    }
}
