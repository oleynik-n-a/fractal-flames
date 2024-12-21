package backend.academy.userflow.backend;

import backend.academy.models.Rect;
import backend.academy.postprocess.GammaCorrection;
import backend.academy.render.Affine;
import backend.academy.render.MultiThreadRenderer;
import backend.academy.render.RenderException;
import backend.academy.render.Renderer;
import backend.academy.render.SingleThreadRenderer;
import backend.academy.save.ImageSaver;
import backend.academy.save.SaveException;
import backend.academy.stream.handlers.PrintHandler;
import backend.academy.transformations.Disk;
import backend.academy.transformations.Heart;
import backend.academy.transformations.Polar;
import backend.academy.transformations.Sinusoidal;
import backend.academy.transformations.Spherical;
import backend.academy.transformations.Transformation;
import backend.academy.transformations.TransformationType;
import backend.academy.userflow.frontend.Settings;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import static backend.academy.save.ImageSaver.SEPARATOR;

public final class ExecuteRender implements Action {
    private static final double WORLD_SIZE_SIDE = 24.0;

    private static final Map<TransformationType, Transformation> TRANSFORMATION_BY_TYPE = Map.of(
        TransformationType.SINUSOIDAL, new Sinusoidal(),
        TransformationType.SPHERICAL, new Spherical(),
        TransformationType.POLAR, new Polar(),
        TransformationType.HEART, new Heart(),
        TransformationType.DISK, new Disk()
    );

    @Override
    public void act() {
        Renderer renderer;

        var chosenTransformations = Settings.INSTANCE.transformations();

        ArrayList<Transformation> transformations = new ArrayList<>();
        boolean useGammaCorrection = Settings.INSTANCE.correction();

        for (var transformationType : chosenTransformations.keySet()) {
            if (chosenTransformations.get(transformationType)) {
                transformations.add(TRANSFORMATION_BY_TYPE.get(transformationType));
            }
        }

        if (Settings.INSTANCE.threads() > 1) {
            renderer = new MultiThreadRenderer(transformations, useGammaCorrection, Settings.INSTANCE.threads());
        } else {
            renderer = new SingleThreadRenderer(transformations, useGammaCorrection);
        }

        double width = WORLD_SIZE_SIDE;
        double height = WORLD_SIZE_SIDE;
        Rect world = new Rect(-width / 2, -height / 2, width, height);

        Random random = new Random(Settings.INSTANCE.seed());
        ArrayList<Affine> affines = new ArrayList<>(Settings.INSTANCE.affines());
        for (int i = 0; i < Settings.INSTANCE.affines(); ++i) {
            affines.add(new Affine(random));
        }

        try {
            PrintHandler.INSTANCE.printMessageLn("Rendering started on seed: " + Settings.INSTANCE.seed());

            renderer.render(Settings.INSTANCE.image(), world, affines, Settings.INSTANCE.samples(),
                Settings.INSTANCE.iterations(), Settings.INSTANCE.seed());

            if (useGammaCorrection) {
                GammaCorrection correction = new GammaCorrection();
                correction.process(Settings.INSTANCE.image());
            }

            PrintHandler.INSTANCE.printMessageLn("Rendering finished");
            PrintHandler.INSTANCE.printMessageLn(
                "Saving to: " + Settings.INSTANCE.path() + "." + Settings.INSTANCE.format());

            ImageSaver.INSTANCE.save(Settings.INSTANCE.image(),
                new File("results" + SEPARATOR + Settings.INSTANCE.path() + "." + Settings.INSTANCE.format()),
                Settings.INSTANCE.format());

            PrintHandler.INSTANCE.printMessageLn("Saving finished");
        } catch (RenderException | SaveException e) {
            PrintHandler.INSTANCE.printMessageLn(e.getMessage());
        }

        Settings.INSTANCE.image().clearData();
    }
}
