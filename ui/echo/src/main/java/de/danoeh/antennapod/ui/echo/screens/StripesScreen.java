package de.danoeh.antennapod.ui.echo.screens;

import android.graphics.Canvas;
import androidx.annotation.NonNull;

public class StripesScreen extends BaseScreen {
    protected static final int NUM_PARTICLES = 15;

    public StripesScreen() {
        for (int i = 0; i < NUM_PARTICLES; i++) {
            particles.add(new Particle(2f * i / NUM_PARTICLES - 1f, 0, 0));
        }
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        paintParticles.setStrokeWidth(0.05f * getBounds().width());
        super.draw(canvas);
    }

    @Override
    protected void drawParticle(@NonNull Canvas canvas, Particle p,
                                float innerBoxX, float innerBoxY, float innerBoxSize) {
        float width = getBounds().width();
        float height = getBounds().height();
        float strokeWidth = 0.05f * getBounds().width();
        float x = (float) (width * p.positionX);
        canvas.drawLine(x, -strokeWidth, x + width, height + strokeWidth, paintParticles);
    }

    @Override
    protected void particleTick(Particle p, long timeSinceLastFrame) {
        p.positionX += 0.00005 * timeSinceLastFrame;
        if (p.positionX > 1f) {
            p.positionX -= 2f;
        }
    }
}