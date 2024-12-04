import controller.*;
import model.RailroadCrossingModel;
import view.Frame;
public class RailroadCrossingApp {
    public static void main(String[] args) {
        RailroadCrossingModel model = new RailroadCrossingModel();
        Frame frame = new Frame();

        new RailroadCrossingController(model, frame);

    }
}
