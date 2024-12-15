package backend.academy.userflow.backend;

public final class Exit implements Action {
    @Override
    public void act() {
        System.exit(0);
    }
}
