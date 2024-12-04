package controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.RailroadCrossingModel;
import view.Frame;
public class RailroadCrossingController {
    private RailroadCrossingModel model;
    private Frame view;

    public RailroadCrossingController(RailroadCrossingModel model, Frame view) {
        this.model = model;
        this.view = view;

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.moveTrain();
            }
        });
        timer.start();
    }
}
