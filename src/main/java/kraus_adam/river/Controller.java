package kraus_adam.river;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

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
        attachSimViewButtonHandlers();
    }

    private class nextMonthFilter implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("NEXT MONTH");
            model.nextMonth();
        }
    }

    private void attachSimViewButtonHandlers() {
        for (Node child : layout.simView.getChildren()) {
            if(child instanceof Button) {
                child.addEventHandler(ActionEvent.ACTION, new changeLandArea());
            }
        }
    }

    private class resizeSim implements  EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button source = (Button)event.getSource();
            switch (source.getText()) {
                case "5X3":
                    layout.simView.resize(5, 3);
                    break;
                case "7X5":
                    layout.simView.resize(7, 5);
                    break;
                case "9X7":
                    layout.simView.resize(9, 7);
                    break;
            }
            attachSimViewButtonHandlers();
        }
    }

    private class changeLandArea implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button source = (Button)event.getSource();
            int row = layout.simView.getRowIndex(source);
            int col = layout.simView.getColumnIndex(source);
            System.out.println(col + " " + row);
            // if add checkbox selected
            // get which radio button
            // model.setTile(col, row, new Whatever());
        }
    }
}
