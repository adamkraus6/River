package kraus_adam.river;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Layout {
    private RiverSim model;
    public VBox root;
    public Button nextMonth;
    public RiverSimView simView;
    public Button[] resizeButtons;
    public ToggleGroup landAreas;
    public CheckBox add;
    public Label landInfoText;
    public Label infoBarText;

    public Layout(RiverSim model) {
        this.model = model;
        makeContents();
    }

    public void makeContents() {
        root = new VBox();
        root.setAlignment(Pos.BOTTOM_CENTER);

        HBox upper = new HBox();
        upper.setAlignment(Pos.CENTER);

        // sim view, upper -> left
        simView = new RiverSimView();
        simView.setModel(model);
        simView.makeContents();
        GridPane.setHgrow(simView, Priority.ALWAYS);
        GridPane.setVgrow(simView, Priority.ALWAYS);
        HBox.setHgrow(simView, Priority.ALWAYS);
        VBox right = new VBox();
        right.setMinWidth(175);

        // land info, upper -> upper right
        VBox landInfo = new VBox();
        landInfo.setAlignment(Pos.CENTER);
        VBox.setVgrow(landInfo, Priority.ALWAYS);
        landInfoText = new Label("Unused\nLast changed: 0-1\nAge: 0-1\nTotal Cost: $0k\nTotal Revenue: $0k");
        landInfo.getChildren().add(landInfoText);

        // action commands, upper -> lower right
        VBox actionCommands = new VBox();
        actionCommands.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(actionCommands, Priority.ALWAYS);
        nextMonth = new Button("Next Month");
        Region spacer1 = new Region();
        VBox.setVgrow(spacer1, Priority.ALWAYS);
        landAreas = new ToggleGroup();
        RadioButton ag = new RadioButton("Agriculture");
        ag.setToggleGroup(landAreas);
        ag.setSelected(true);
        RadioButton rec = new RadioButton("Recreation");
        rec.setToggleGroup(landAreas);
        RadioButton un = new RadioButton("Unused");
        un.setToggleGroup(landAreas);
        Region spacer2 = new Region();
        VBox.setVgrow(spacer2, Priority.ALWAYS);
        add = new CheckBox("Add");
        Region spacer3 = new Region();
        VBox.setVgrow(spacer3, Priority.ALWAYS);
        HBox resizing = new HBox();
        resizing.setAlignment(Pos.CENTER_LEFT);
        Label resize = new Label("Resize:");
        Region spacer4 = new Region();
        HBox.setHgrow(spacer4, Priority.ALWAYS);
        resizeButtons = new Button[3];
        resizeButtons[0] = new Button("5X3");
        resizeButtons[1] = new Button("7X5");
        resizeButtons[2] = new Button("9X7");
        resizing.getChildren().addAll(resize, spacer4, resizeButtons[0], resizeButtons[1], resizeButtons[2]);
        resizing.setPadding(new Insets(2));
        actionCommands.getChildren().addAll(nextMonth, spacer1, ag, rec, un, spacer2, add, spacer3, resizing);

        right.getChildren().addAll(landInfo, actionCommands);

        upper.getChildren().addAll(simView, right);

        // info bar, lower
        VBox infoBar = new VBox();
        infoBar.setAlignment(Pos.CENTER);
        infoBarText = new Label();
        infoBarText.setMinHeight(65);
        infoBarText.setPadding(new Insets(5));
        infoBar.getChildren().add(infoBarText);
        root.getChildren().addAll(upper, infoBar);
    }
}
