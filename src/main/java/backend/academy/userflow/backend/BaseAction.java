package backend.academy.userflow.backend;

import backend.academy.userflow.frontend.BaseSettings;

public abstract class BaseAction<SettingsType> implements Action {
    protected SettingsType settings;

    public BaseAction(SettingsType settings) {
        this.settings = settings;
    }
}
