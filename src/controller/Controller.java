package controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;
import view.Frame;
public class Controller {
    private Model model;
    private Frame view;

    public Controller(Model model, Frame view) {
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
