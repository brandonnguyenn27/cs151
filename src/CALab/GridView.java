package CALab;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class GridView extends View {
    CellView[][] cellViews; //unsure if this is correct

    public GridView(Grid grid) {
        super(grid);
        model = grid;
        int dim = ((Grid)model).getDim();
        cellViews = new CellView[dim][dim];
        this.setLayout((new GridLayout(dim, dim)));
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = ((Grid)model).getCell(row, col);
                cell.row = row;
                cell.col = col;
                cellViews[row][col] = new CellView(cell);
                this.add(cellViews[row][col]);
            }
        }
    }

    public void update() {
        for (int row = 0; row < ((Grid)model).getDim(); row++) {
            for (int col = 0; col < ((Grid)model).getDim(); col++) {
                cellViews[row][col].update();
            }
        }
        //repaint();
    }
    @Override
    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);

        int dim = ((Grid)model).getDim();
        cellViews = new CellView[dim][dim];
        this.setLayout((new GridLayout(dim, dim)));
        this.removeAll();
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = ((Grid)model).getCell(row, col);
                cell.row = row;
                cell.col = col;
                cellViews[row][col] = new CellView(cell);
                this.add(cellViews[row][col]);
            }
        }
    }

}
