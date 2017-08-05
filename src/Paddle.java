import java.awt.*;

class Paddle {

    Rectangle rect;

    Paddle(int x, int y, int width, int height) {
        rect = new Rectangle(x, y, width, height);
    }

    void move(int deltaY) {
        rect.setLocation((int) rect.getX(), (int) rect.getY() + deltaY);
    }

}
