package backend.academy.render;

import backend.academy.models.FractalImage;
import backend.academy.models.Pixel;
import backend.academy.models.Point;
import backend.academy.models.Rect;
import backend.academy.postprocess.Correction;
import backend.academy.transformations.Transformation;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class SequentialRenderer {
    private final ArrayList<Transformation> transformations;

    public SequentialRenderer(ArrayList<Transformation> transformations, Set<Correction> postProcessors) {
        this.transformations = transformations;
    }

    public void render(
        FractalImage canvas,
        Rect world,
        int samples,
        int iterations,
        long seed
    ) {
        if (transformations.isEmpty()) {
            throw new RenderException("No transformations available");
        }

        Random random = new Random(seed);
        Affine affine = new Affine();
        for (int i = 0; i < samples; ++i) {
            Point point = Point.generateRandom(world);
            for (int j = 0; j < iterations; ++j) {
                Transformation transform = transformations.get(random.nextInt(transformations.size()));
                point = affine.apply(point);
                point = transform.apply(point);

                if (!world.contains(point)) {
                    continue;
                }

                Pixel pixel = canvas.getPixel(world, point);
//                if (pixel.hitCount() == 0) {
//                    pixel.setColor(transform.color());
//                } else {
//                    pixel.setColor(
//                        (pixel.color().r() + transform.color().red()) / 2,
//                        (pixel.color().g() + transform.color().green()) / 2,
//                        (pixel.color().b() + transform.color().blue()) / 2
//                    );
//                }
                pixel.increaseHitCount();
            }
        }
    }
}
