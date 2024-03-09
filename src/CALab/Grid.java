package CALab;

import java.awt.*;

import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() {
        return dim;
    }
    public int getTime() {
        return time;
    }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    public abstract Cell makeCell(boolean uniform);

    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() {
        this(20);
    }

    protected void populate() {
        // 1. use makeCell to fill in cells
        for (int row = 0; row < dim; row++){
            for (int col = 0; col < dim; col++){
                cells[row][col] = makeCell(true);
            }
        }
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int row = 0; row < dim; row++){
            for (int col = 0; col < dim; col++){
                cells[row][col].setNeighbors(getNeighbors(cells[row][col], 1));            }
        }
        repopulate(true);
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (randomly) {
                    // randomly set the status of each cell
                    int randomStatus = (int) Math.round(Math.random());
                    cells[row][col].setStatus(randomStatus);
                } else {
                    // set the status of each cell to 0 (dead)
                    cells[row][col].setStatus(0);
                }
            }
        }
        // notify subscribers
        notifySubscribers();
    }

        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        public Cell[][] getNeighbors(Cell asker, int radius) {
            int row = asker.getRow();
            int col = asker.getCol();
            Cell[][] neighbors = new Cell[20][20];
            int count = 0;
            for (int r = Math.max(0, row - radius); r <= Math.min(dim - 1, row + radius); r++) {
                for (int c = Math.max(0, col - radius); c <= Math.min(dim - 1, col + radius); c++) {
                    if (!(r == row && c == col)) {
                        neighbors[count / 20][count % 20] = cells[r][c];
                        count++;
                    }
                }
            }
            return neighbors;
        }

    // overide these
    @Override
    public int getStatus() {
        return 0;
    }
    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    // cell phases:

    public void observe() {
        // Call observe method of each cell
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].observe();
            }
        }
        // Notify subscribers
        notifySubscribers();
    }

    public void interact() {
        // Call interact method of each cell
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].interact();
            }
        }
    }

    public void update() {
        // Call update method of each cell
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].update();
            }
        }
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}

