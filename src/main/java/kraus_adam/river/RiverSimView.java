package kraus_adam.river;

import javafx.scene.layout.*;

public class RiverSimView extends GridPane {
    private RiverSim model;

    /**
     * Sets the model for this view
     * 
     * @param model RiverSim model
     */
    public void setModel(RiverSim model) {
        this.model = model;
    }

    /**
     * Makes the contents of the RiverSim grid
     */
    public void makeContents() {
        int rows = model.getRows();
        int cols = model.getCols();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j != cols / 2) {
                    TileView TV = new TileView();
                    TV.setModel(model.getTile(j, i));
                    TV.setPrefSize(1000, 1000);
                    add(TV, j, i);
                }
            }
        }
        Pane river = new Pane();
        river.setStyle("-fx-background-color: BLUE");
        add(river, cols / 2, 0, 1, rows);

        RowConstraints RC = new RowConstraints();
        for (int i = 0; i < rows; i++) {
            RC.setPercentHeight(100.0 / rows);
            getRowConstraints().add(RC);
        }

        ColumnConstraints CC;
        double tileWidth = 100.0 / ((double) cols - 0.5);
        double riverWidth = 100.0 - (tileWidth * (cols - 1.0));
        for (int j = 0; j < cols; j++) {
            CC = new ColumnConstraints();
            double percent = j == cols / 2 ? riverWidth : tileWidth;
            CC.setPercentWidth(percent);
            getColumnConstraints().add(CC);
        }
    }

    /**
     * Resizes the model and gridpane
     * 
     * @param cols New columns
     * @param rows New rows
     */
    public void resize(int cols, int rows) {
        // create new model
        model.resize(cols, rows);
        // clear gridpane
        getChildren().clear();
        getRowConstraints().clear();
        getColumnConstraints().clear();
        // assemble new gridpane
        makeContents();
    }
}
