package view;
import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    private TrainPanel trainPanel;

    public Frame(){
        /*setTitle("Train-rgr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);



        trainPanel = new TrainPanel();
        add(trainPanel);*/
        createAndShowGUI();
        private void createAndShowGUI(){
            JFrame frame = new JFrame("Railroad Crossing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    trainPanel.drawRoad(g);
                    trainPanel.drawTrafficLight(g);
                    trainPanel.drawTrain(g);
                }
            };
            panel.setBackground(Color.WHITE);

            frame.add(panel);
            Timer timer = new Timer(30, e -> panel.repaint());
            timer.start();

            frame.setVisible(true);
        }

    }

    public TrainPanel getTrainPanel() {
        return trainPanel;
    }
}
