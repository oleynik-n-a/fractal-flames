package backend.academy.transformations;

public enum TransformationType {
    SINUSOIDAL("Sinusoidal"),
    SPHERICAL("Spherical"),
    POLAR("Polar"),
    HEART("Heart"),
    DISK("Disk");

    private final String name;

    TransformationType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
