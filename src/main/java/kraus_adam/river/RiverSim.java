package kraus_adam.river;

import kraus_adam.river.Areas.*;

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

    private Tile[][] sim;

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
        funds = 0;
        genSim();
    }

    public int getTime() {
        return timeSinceReset;
    }

    public int getFunds() {
        return funds;
    }

    public int getFilled() {
        filled = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(j != cols/2) {
                    if(!sim[i][j].getName().equals("Unused")) {
                        filled++;
                    }
                }
            }
        }
        return filled;
    }

    public void addObserver(int col, int row, PropertyChangeListener obs) {
        sim[row][col].addObserver(obs);
    }

    public void nextMonth() {
        timeSinceReset++;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int month = timeSinceReset % 12;
                if(month == 2 && (j == (cols/2)-1 || j == (cols/2)+1)) {
                    // if month 3 and next to river, set to flooded
                    setTile(j, i, "Flooded");
                } else if(month == 3 && (j == (cols/2)-1 || j == (cols/2)+1)) {
                    // if month 4 and next to river, set to unused
                    setTile(j, i, "Unused");
                } else if(j != cols/2) {
                    funds += sim[i][j].nextMonth();
                }
            }
        }
    }


    public void setTile(int col, int row, String selected) {
        LandArea area;
        switch(selected) {
            case "Agriculture":
                area = new Agriculture(timeSinceReset);
                funds -= 300;
                break;
            case "Recreation":
                area = new Recreation(timeSinceReset);
                funds -= 10;
                break;
            case "Flooded":
                area = new Flooded();
                break;
            default:
            case "Unused":
                area = new Unused(timeSinceReset);
                break;
        }
        sim[row][col].setTile(area);
    }

    public Tile getTile(int col, int row) {
        return sim[row][col];
    }
}
