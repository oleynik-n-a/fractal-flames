package backend.academy.render;

import backend.academy.models.FractalImage;
import backend.academy.models.Rect;
import backend.academy.postprocess.Correction;
import backend.academy.transformations.Transformation;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class MultiThreadRenderer extends Renderer {
    private final int threadQuantity;

    public MultiThreadRenderer(
        ArrayList<Transformation> transformations,
        ArrayList<Correction> corrections,
        int threadQuantity
    ) {
        super(transformations, corrections);
        this.threadQuantity = threadQuantity;
    }

    @Override
    public void render(
        FractalImage canvas,
        Rect world,
        ArrayList<Affine> affines,
        int samples,
        int iterPerSample,
        long seed
    ) {
        ExecutorService service = Executors.newFixedThreadPool(threadQuantity);

        Random random = new Random(seed);
        ArrayList<Future<Boolean>> futures = new ArrayList<>();
        int reminder = samples % threadQuantity;
        for (int i = 0; i < threadQuantity; ++i) {
            int finalReminder = reminder;
            int threadSeed = random.nextInt();
            SingleThreadRenderer singleRenderer = new SingleThreadRenderer(transformations, corrections);
            futures.add(service.submit(() -> {
                singleRenderer.render(
                    canvas,
                    world,
                    affines,
                    samples / threadQuantity + (finalReminder % 2),
                    iterPerSample,
                    threadSeed
                );
                return true;
            }));
            reminder -= 1;
        }
        try {
            for (Future<Boolean> future : futures) {
                future.get();
            }
        } catch (InterruptedException | ExecutionException ignored) {

        } finally {
            service.shutdown();
        }
    }
}
