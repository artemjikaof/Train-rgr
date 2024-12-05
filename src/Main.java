import controller.*;
import model.Model;
import view.Frame;
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Frame frame = new Frame();

        new Controller(model, frame);

    }
}
