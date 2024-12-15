package backend.academy.models;

public record Color(int r, int g, int b) {
    public static final int COLOR_SPECTRE = 256;

    public int convertToIntRgb() {
        return (r << 16) | (g << 8) | b;
    }
}
