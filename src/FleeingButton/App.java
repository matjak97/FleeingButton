package FleeingButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
//import javax.swing.border.Border;
//import javax.swing.border.EmptyBorder;

public class App extends JFrame {

    final private JPanel contentPane;
    private final int win_h = 500;
    private final int win_w = 500;
    private final int but_w = 500;
    private final int but_h = 100;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                App frame = new App();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public App() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int win_y = 100;
        int win_x = 100;
        setBounds(win_x, win_y, win_w, win_h);
        contentPane = new JPanel();

        setContentPane(contentPane);
        JButton button=new JButton("click");
        contentPane.add(button);
        contentPane.setLayout(null);
        button.setBounds((win_w-but_w)/2,(win_h-but_h)/2,but_w, but_h);
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                Point p = new Point(contentPane.getMousePosition());
                button.setLocation(flee(p, button));
                button.setText("X"+ p.getX()+ "Y"+ p.getY());
            }

        });
    }

    public Point onBorder(Point p){
        int bor_w = but_w+15;
        int bor_h = but_h+35;
        if(p.getX() > win_w - bor_w)
            p.x = win_w - bor_w;
        if(p.getX() < 0)
            p.x = 0;
        if(p.getY() < 0)
            p.y = 0;
        if(p.getY() > win_h - bor_h)
            p.y = win_h - bor_h;
        return p;
    }

    public Point flee(Point p, JButton b){
//        Point mouse = b.getMousePosition();
        p.translate(-10, -10);
        return onBorder(p);
    }
}