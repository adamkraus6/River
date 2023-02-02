package kraus_adam.river;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import javax.swing.*;

public class Controller {
    private Layout layout;
    private RiverSim model;
    public Controller(RiverSim model, Layout layout) {
        this.model = model;
        this.layout = layout;

        layout.nextMonth.addEventHandler(ActionEvent.ACTION, new nextMonthFilter());
        for (Button button : layout.resizeButtons) {
            button.addEventHandler(ActionEvent.ACTION, new resizeSim());
        }
    }

    private class nextMonthFilter implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("NEXT MONTH");
            model.nextMonth();
        }
    }

    private class resizeSim implements  EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button source = (Button)event.getSource();
            System.out.println(source.getText());
        }
    }

    private class changeLandArea implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }
}
