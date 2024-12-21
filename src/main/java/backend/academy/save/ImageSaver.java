package backend.academy.save;

import backend.academy.models.FractalImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import javax.imageio.ImageIO;

public final class ImageSaver {
    public static final ImageSaver INSTANCE = new ImageSaver();
    public static final String SEPARATOR = FileSystems.getDefault().getSeparator();

    private ImageSaver() {
    }

    public void save(FractalImage image, File file, ImageFormat format) {
        BufferedImage bufferedImage = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < image.width(); ++x) {
            for (int y = 0; y < image.height(); ++y) {
                bufferedImage.setRGB(x, y, image.getPixel(x, y).color().convertToIntRgb());
            }
        }

        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (!parentDir.mkdirs()) {
                    throw new SaveException("Unable to create directory: " + parentDir);
                }
            }

            boolean success = file.createNewFile();
            if (!success) {
                throw new SaveException("Unable to create file");
            }
            ImageIO.write(bufferedImage, format.toString(), file);
        } catch (IllegalArgumentException e) {
            throw new SaveException("Some param is null: " + e.getMessage());
        } catch (IOException e) {
            throw new SaveException("IO exception: " + e.getMessage());
        }
    }
}
