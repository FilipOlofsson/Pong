import java.awt.geom.Ellipse2D;
import java.util.Random;

class Ball {

    Ellipse2D circle;

    private double xVel = 8;
    private double yVel = 1;

    private Random rnd = new Random();

    Ball(int x, int y, int radius) {
        circle = new Ellipse2D.Double(x, y, radius*2, radius*2);
    }

    void update() {
        if(playerWon()) {
            Engine.running = false;
            Engine.winner = "Player";
        }
        if(aiWon()) {
            Engine.running = false;
            Engine.winner = "AI";
        }
        if(touchingPaddle())
            xVel *= -1;
        if(touchingY())
            yVel *= -1;
        circle.setFrame(circle.getX() + xVel, circle.getY() + yVel, circle.getWidth(), circle.getWidth());
    }

    private boolean touchingPaddle() {
        if(circle.intersects(Engine.player.paddle.rect)) {
            if(rnd.nextInt(5) == 0)
                yVel += (yVel >= 0) ? -1 : -1;
            return true;
        }
        if(circle.intersects(Engine.ai.paddle.rect)) {
            if(rnd.nextInt(5) == 0)
                yVel += (yVel >= 0) ? 1 : -1;
            return true;
        }

        return false;
    }

    private boolean touchingY() {
        if(circle.getY() < 0) {
            if(rnd.nextInt(5) == 0)
                xVel += (xVel >= 0) ? 1 : -1;
            return true;
        }
        if(circle.getY() + circle.getHeight() > Engine.height) {
            if(rnd.nextInt(5) == 0)
                xVel += (xVel >= 0) ? 1 : -1;
            return true;
        }

        return false;
    }

    private boolean aiWon() {
        if(circle.getX() < 0)
            return true;
        return false;
    }

    private boolean playerWon() {
        if(circle.getX() + circle.getWidth() > Engine.width)
            return true;
        return false;
    }

}
