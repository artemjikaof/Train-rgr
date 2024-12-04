package view;

import javax.swing.*;
import java.awt.*;
import model.RailroadCrossingModel;
import java.util.Observable;
import java.util.Observer;

public class TrainPanel extends JPanel implements  Observer {
    private RailroadCrossingModel model;

    public TrainPanel() {
        this.model = model;
        //createAndShowGUI();
    }

    /*private void createAndShowGUI() {
        JFrame frame = new JFrame("Railroad Crossing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRoad(g);
                drawTrafficLight(g);
                drawTrain(g);
            }
        };
        panel.setBackground(Color.WHITE);

        frame.add(panel);
        Timer timer = new Timer(30, e -> panel.repaint());
        timer.start();

        frame.setVisible(true);
    }*/

    public void drawRoad(Graphics g) {
        // Рисуем дорогу
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 325, 800, 50);

        // Переезд
        g.setColor(Color.BLACK);
        g.fillRect(350, 325, 100, 50);

        // Маркер
        g.setColor(Color.RED);
        g.fillRect(250, 325, 10, 50);
    }

    public void drawTrafficLight(Graphics g) {
        int x = 350, y = 100;

        // Светофор
        g.setColor(Color.BLACK);
        g.fillRect(x - 20, y - 20, 150, 150);

        // Светло-голубой
        g.setColor(model.isWhiteOn() ? Color.CYAN : Color.GRAY);
        g.fillOval(x + 30, y, 50, 50);

        // Красные огни
        g.setColor(model.isRedLeftOn() ? Color.RED : Color.GRAY);
        g.fillOval(x, y + 60, 50, 50);
        g.setColor(model.isRedRightOn() ? Color.RED : Color.GRAY);
        g.fillOval(x + 60, y + 60, 50, 50);
    }

    public void drawTrain(Graphics g) {
        int x = model.getTrainX();
        g.setColor(Color.BLUE);
        g.fillRect(x, 300, 200, 50);

        g.setColor(Color.BLACK);
        g.fillOval(x + 20, 340, 30, 30);
        g.fillOval(x + 150, 340, 30, 30);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
