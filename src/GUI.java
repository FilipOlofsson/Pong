import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class GUI extends Canvas {

    private JFrame frame;
    JPanel panel;

    GUI(int width, int height) {
        frame = new JFrame();
        panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
                g2d.fill(Engine.ball.circle);
                g2d.fill(Engine.player.paddle.rect);
                g2d.fill(Engine.ai.paddle.rect);
                if(!Engine.running) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
                    FontMetrics fontMetrics = g.getFontMetrics();
                    String str = "The " + Engine.winner + " is the winner!";
                    int x = (int) (Engine.width - fontMetrics.getStringBounds(str, g).getWidth())/2;
                    int y = Engine.height/2 - fontMetrics.getHeight()/2;
                    g.drawString(str, x, y);

                }
            }
        };
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                Engine.player.paddle.move((int) (e.getY() - Engine.player.paddle.rect.getCenterY()));
            }
        });
        frame.add(panel);
        frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
