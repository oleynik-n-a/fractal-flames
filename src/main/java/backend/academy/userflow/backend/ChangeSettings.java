package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.AffinesAmountSettings;
import backend.academy.userflow.frontend.CorrectionsSettings;
import backend.academy.userflow.frontend.FileFormatSettings;
import backend.academy.userflow.frontend.FilePathSettings;
import backend.academy.userflow.frontend.ImageSizeSettings;
import backend.academy.userflow.frontend.IterationsAmountSettings;
import backend.academy.userflow.frontend.SamplesAmountSettings;
import backend.academy.userflow.frontend.SeedSettings;
import backend.academy.userflow.frontend.Settings;
import backend.academy.userflow.frontend.ThreadsAmountSettings;
import backend.academy.userflow.frontend.TransformationsSettings;
import java.util.HashMap;
import java.util.Map;

public final class ChangeSettings extends SettingsBasedAction<Settings> {
    private final Map<Integer, Action> actions;

    public ChangeSettings(Settings settings) {
        super(settings);
        actions = new HashMap<>() {{
            put(1, new ExecuteRender());
            put(2, new SetFilePath(FilePathSettings.INSTANCE()));
            put(3, new SetFileFormat(FileFormatSettings.INSTANCE()));
            put(4, new SetThreadsAmount(ThreadsAmountSettings.INSTANCE()));
            put(5, new SetIterationsAmount(IterationsAmountSettings.INSTANCE()));
            put(6, new SetSamplesAmount(SamplesAmountSettings.INSTANCE()));
            put(7, new SetAffinesAmount(AffinesAmountSettings.INSTANCE()));
            put(8, new SetImageSize(ImageSizeSettings.INSTANCE()));
            put(9, new SetSeed(SeedSettings.INSTANCE()));
            put(10, new ChooseTransformations(TransformationsSettings.INSTANCE()));
            put(11, new ChooseCorrections(CorrectionsSettings.INSTANCE()));
            put(12, new Exit());
        }};
    }

    @Override
    public void act() {
        Integer input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE().tryReadInteger();
            if (input == null) {
                settings.incorrectInput(true);
                continue;
            }
            if (input <= 0 || input > actions.size()) {
                settings.incorrectInput(true);
                continue;
            }
            settings.incorrectInput(false);
            actions.get(input).act();
        }
    }
}
