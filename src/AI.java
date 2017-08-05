class AI {
    Paddle paddle;

    private int speed = 6;

    AI(int x, int y, int width, int height) {
        paddle = new Paddle(x, y, width, height);
    }

    void update() {
        for(int i = 0; i < speed; i++) {
            if(Engine.ball.circle.getCenterY() < paddle.rect.getCenterY()) {
                paddle.move(-1);
            } else if(Engine.ball.circle.getCenterY() > paddle.rect.getCenterY()) {
                paddle.move(1);
            }
        }
    }

}
