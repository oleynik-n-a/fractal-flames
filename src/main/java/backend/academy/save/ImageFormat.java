package backend.academy.save;

public enum ImageFormat {
    PNG("png"),
    JPEG("jpeg");

    private final String formatName;

    ImageFormat(String formatName) {
        this.formatName = formatName;
    }

    @Override
    public String toString() {
        return formatName;
    }
}
