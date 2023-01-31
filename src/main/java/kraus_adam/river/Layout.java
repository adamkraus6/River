package kraus_adam.river;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Layout {
    public Pane makeContents() {
        VBox outer = new VBox();
        outer.setAlignment(Pos.BOTTOM_CENTER);

        HBox upper = new HBox();
        upper.setAlignment(Pos.CENTER);

        RiverSimView simView = new RiverSimView();
        GridPane.setHgrow(simView, Priority.ALWAYS);
        GridPane.setVgrow(simView, Priority.ALWAYS);
        HBox.setHgrow(simView, Priority.ALWAYS);

        VBox right = new VBox();
        right.setMinWidth(175);

        VBox landInfo = new VBox();
        landInfo.setAlignment(Pos.CENTER);
        VBox.setVgrow(landInfo, Priority.ALWAYS);

        Label landInfoText = new Label("Unused\nLast changed: 0-1\nAge: 0-1\nTotal Cost: $0k\nTotal Revenue: $0k");
        landInfo.getChildren().add(landInfoText);

        VBox actionCommands = new VBox();
        actionCommands.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(actionCommands, Priority.ALWAYS);
        // button
        Button nextMonth = new Button("Next Month");
        // spacer
        Region spacer1 = new Region();
        VBox.setVgrow(spacer1, Priority.ALWAYS);
        // radio buttons
        ToggleGroup landAreas = new ToggleGroup();
        RadioButton ag = new RadioButton("Agriculture");
        ag.setToggleGroup(landAreas);
        ag.setSelected(true);
        RadioButton rec = new RadioButton("Recreation");
        rec.setToggleGroup(landAreas);
        RadioButton un = new RadioButton("Unused");
        un.setToggleGroup(landAreas);
        // spacer
        Region spacer2 = new Region();
        VBox.setVgrow(spacer2, Priority.ALWAYS);
        // add checkbox
        CheckBox add = new CheckBox("Add");
        // spacer
        Region spacer3 = new Region();
        VBox.setVgrow(spacer3, Priority.ALWAYS);
        // resize buttons
        HBox resizing = new HBox();
        resizing.setAlignment(Pos.CENTER_LEFT);
        Label resize = new Label("Resize:");
        Region spacer4 = new Region();
        HBox.setHgrow(spacer4, Priority.ALWAYS);
        Button re1 = new Button("5X3");
        Button re2 = new Button("7X5");
        Button re3 = new Button("9X7");
        resizing.getChildren().addAll(resize, spacer4, re1, re2, re3);
        resizing.setPadding(new Insets(2));
        actionCommands.getChildren().addAll(nextMonth, spacer1, ag, rec, un, spacer2, add, spacer3, resizing);

        right.getChildren().addAll(landInfo, actionCommands);

        upper.getChildren().addAll(simView, right);

        VBox lower = new VBox();
        lower.setAlignment(Pos.CENTER);
        Label infoBar = new Label("Year: 0 Month: 1\nFilled: 0\nFunds: $0k");
        infoBar.setMinHeight(65);
        infoBar.setPadding(new Insets(5));
        lower.getChildren().add(infoBar);
        outer.getChildren().addAll(upper, lower);

        return outer;
    }


}
