package backend.academy.render;

import backend.academy.models.Color;
import backend.academy.models.FractalImage;
import backend.academy.models.Pixel;
import backend.academy.models.Point;
import backend.academy.models.Rect;
import backend.academy.postprocess.Correction;
import backend.academy.transformations.Transformation;
import java.util.ArrayList;
import java.util.Random;

public final class SingleThreadRenderer extends Renderer {
    public SingleThreadRenderer(ArrayList<Transformation> transformations, ArrayList<Correction> corrections) {
        super(transformations, corrections);
    }

    @Override
    public void render(
        FractalImage canvas,
        Rect world,
        ArrayList<Affine> affines,
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
            for (int j = -STEPS_FOR_NORMALIZATION; j < iterations; ++j) {
                Transformation transform = transformations.get(random.nextInt(transformations.size()));
                point = affine.apply(point);
                point = transform.apply(point);

                if (j < 0 || !world.contains(point)) {
                    continue;
                }

                Pixel pixel = canvas.getPixel(world, point);

                if (pixel.hitCount() == 0) {
                    pixel.setColor(affine.color());
                } else {
                    pixel.setColor(new Color(
                            (pixel.color().r() + affine.color().r()) / 2,
                            (pixel.color().g() + affine.color().g()) / 2,
                            (pixel.color().b() + affine.color().b()) / 2
                        )
                    );
                }
                pixel.increaseHitCount();
            }
        }
    }
}
