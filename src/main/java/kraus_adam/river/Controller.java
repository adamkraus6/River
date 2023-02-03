package kraus_adam.river;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;

public class Controller {
    private Layout layout;
    private RiverSim model;
    public Controller(RiverSim model, Layout layout) {
        this.model = model;
        this.layout = layout;

        layout.nextMonth.addEventHandler(ActionEvent.ACTION, new nextMonthHandler());
        for (Button button : layout.resizeButtons) {
            button.addEventHandler(ActionEvent.ACTION, new resizeSimHandler());
        }
        for (MenuItem resizeItem : layout.resizeItems) {
            resizeItem.addEventHandler(ActionEvent.ACTION, new resizeSimHandler());
        }
        attachSimViewButtonHandlers();
        setInfoBar();
    }

    public void setInfoBar() {
        int time = model.getTime();
        int month = (time % 12) + 1;
        int year = time / 12;
        layout.infoBarText.setText("Year: " + year + " Month: " + month +
                "\nFilled: " + model.getFilled() + "\nFunds: $" + model.getFunds() + "k");
    }

    private void attachSimViewButtonHandlers() {
        for (Node child : layout.simView.getChildren()) {
            if(child instanceof Button) {
                child.addEventHandler(ActionEvent.ACTION, new changeLandAreaHandler());
            }
        }
    }

    private class nextMonthHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            model.nextMonth();
            setInfoBar();
        }
    }

    private class resizeSimHandler implements  EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Object source = event.getSource();
            String newSize = "";
            if(source instanceof Button) {
                Button buttonSrc = (Button)event.getSource();
                newSize = buttonSrc.getText();
            } else if(source instanceof MenuItem) {
                MenuItem menuSrc = (MenuItem)event.getSource();
                newSize = menuSrc.getText();
            }
            switch (newSize) {
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
            setInfoBar();
        }
    }

    private class changeLandAreaHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            TileView source = (TileView)event.getSource();
            int row = layout.simView.getRowIndex(source);
            int col = layout.simView.getColumnIndex(source);
            if(layout.add.isSelected()) {
                String selected = ((RadioButton)layout.landAreas.getSelectedToggle()).getText();
                model.setTile(col, row, selected);
                setInfoBar();
            } else {
                String landInfo = source.getTileDetails();
                layout.landInfoText.setText(landInfo);
            }
        }
    }
}
