package backend.academy.postprocess;

public enum CorrectionType {
    GAMMA("Gamma"),
    LOGARITHMIC("Logarithmic");

    private final String name;

    CorrectionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

