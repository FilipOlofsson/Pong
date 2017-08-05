import java.io.IOException;

public class Engine {

    static Ball ball;
    private static GUI gui;
    static Player player;
    static AI ai;

    private static int ballRadius = 10;
    static boolean running = true;
    static String winner = "";

    static int width = 1024;
    static int height = 720;

    private static int paddleWidth = 30;
    private static int paddleHeight = 100;
    private static int paddleY = height/2 - paddleHeight/2;

    private static int playerX = width/50;
    private static int AIX = width - playerX - paddleWidth;

    final static int FPS = 58;

    public static void main(String[] args) throws InterruptedException {
        init();
        run();
    }

    private static void init() {
        gui = new GUI(width, height);
        ball = new Ball(width/2 - ballRadius, height/2 - ballRadius, ballRadius);
        player = new Player(playerX, paddleY, paddleWidth, paddleHeight);
        ai = new AI(AIX, paddleY, paddleWidth, paddleHeight);
    }

    private static void run() throws InterruptedException {
        while(running) {
            ball.update();
            ai.update();
            gui.panel.repaint();
            Thread.sleep((int) Math.floor(1000/FPS));
        }
    }

}
