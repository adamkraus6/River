package kraus_adam.river;

import javafx.scene.layout.GridPane;
import kraus_adam.river.Areas.LandArea;
import kraus_adam.river.Areas.Unused;

import java.beans.PropertyChangeListener;

public class RiverSim {
    private int timeSinceReset;
    private int funds;
    private int filled;
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
        filled = 0;
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
        timeSinceReset = 0;
        genSim();
    }

    public int getYear() {
        return timeSinceReset / 12;
    }

    public int getMonth() {
        return (timeSinceReset % 12) + 1;
    }

    public int getFunds() {
        return funds;
    }

    public int getFilled() {
        return filled;
    }

    public void addObserver(int col, int row, PropertyChangeListener obs) {
        sim[row][col].addObserver(obs);
    }

    public void nextMonth() {
        timeSinceReset++;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(j != cols/2) {
                    sim[i][j].nextMonth();
                }
            }
        }
    }


    public void setTile(int col, int row, String selected) {
        filled++;
        sim[row][col].setTile(selected);
    }

    public Tile getTile(int col, int row) {
        return sim[row][col];
    }
}
