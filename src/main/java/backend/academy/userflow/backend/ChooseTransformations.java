package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.Settings;
import backend.academy.userflow.frontend.TransformationsSettings;

public final class ChooseTransformations extends SettingsBasedAction<TransformationsSettings> {
    public ChooseTransformations(TransformationsSettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        Integer input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE.tryReadInteger();
            if (input == null || input < 1 || input > Settings.INSTANCE.transformations().size() + 1) {
                settings.incorrectInput(true);
                continue;
            }
            if (input == Settings.INSTANCE.transformations().size() + 1) {
                settings.incorrectInput(false);
                return;
            }
            if (Settings.INSTANCE.transformations().get(settings.transformationsBySettings().get(input))) {
                Settings.INSTANCE.transformations().put(settings.transformationsBySettings().get(input), false);
            } else {
                Settings.INSTANCE.transformations().put(settings.transformationsBySettings().get(input), true);
            }
        }
    }
}
