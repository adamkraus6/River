package kraus_adam.river;

import javafx.scene.layout.GridPane;
import kraus_adam.river.Areas.LandArea;
import kraus_adam.river.Areas.Unused;

import java.beans.PropertyChangeListener;

public class RiverSim {
    private int timeSinceReset;
    private int funds;

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    private int cols;
    private int rows;

    public Tile[][] getTiles() {
        return sim;
    }

    private Tile sim[][];

    public RiverSim(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        funds = 0;
        timeSinceReset = 0;

        genSim();
    }

    private void genSim() {
        sim = new Tile[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j != cols / 2) {
                    sim[i][j] = new Tile();
                }
            }
        }
    }

    public void resize(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;

        genSim();
    }

    public void addObserver(int col, int row, PropertyChangeListener obs) {
        sim[row][col].addObserver(obs);
    }

    public void nextMonth() {

    }


}
