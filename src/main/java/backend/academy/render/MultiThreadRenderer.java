package backend.academy.render;

import backend.academy.models.FractalImage;
import backend.academy.models.Rect;
import backend.academy.transformations.Transformation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public final class MultiThreadRenderer extends Renderer {
    private final int threadQuantity;

    public MultiThreadRenderer(
        ArrayList<Transformation> transformations,
        boolean useGammaCorrection,
        int threadQuantity
    ) {
        super(transformations, useGammaCorrection);
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
        AtomicInteger reminder = new AtomicInteger(samples % threadQuantity);
        List<CompletableFuture<Void>> futures = IntStream.range(0, threadQuantity).mapToObj(_ -> {
            SingleThreadRenderer singleRenderer = new SingleThreadRenderer(transformations, useGammaCorrection);
            return CompletableFuture.runAsync(() -> singleRenderer.render(
                canvas,
                world,
                affines,
                samples / threadQuantity + (reminder.getAndDecrement() > 0 ? 1 : 0),
                iterPerSample,
                seed
            ));
        }).toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
    }
}
