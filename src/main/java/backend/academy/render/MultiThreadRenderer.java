package backend.academy.render;

import backend.academy.models.FractalImage;
import backend.academy.models.Rect;
import backend.academy.transformations.Transformation;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadRenderer {
    public static void render(
        FractalImage canvas,
        Rect world,
        ArrayList<Transformation> variations,
        int samples,
        short iterPerSample,
        long seed,
        int threadQuantity
    ) {
        ExecutorService service = Executors.newFixedThreadPool(threadQuantity);

//        Random random = new Random(seed);
//        ArrayList<Future<Boolean>> futures = new ArrayList<>();
//        int reminder = samples % threadQuantity;
//        for (int i = 0; i < threadQuantity; ++i) {
//            int finalReminder = reminder;
//            int threadSeed = random.nextInt();
//            futures.add(service.submit(() -> {
//                render(
//                    canvas,
//                    world,
//                    variations,
//                    samples / threadQuantity + (finalReminder % 2),
//                    iterPerSample,
//                    threadSeed
//                );
//                return true;
//            }));
//            reminder -= 1;
//        }
//        try {
//            for (Future<Boolean> future : futures) {
//                future.get();
//            }
//        } catch (InterruptedException | ExecutionException ignored) {
//
//        } finally {
//            service.shutdown();
//        }
    }
}
