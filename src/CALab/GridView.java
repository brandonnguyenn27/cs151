package CALab;

import mvc.Model;
import mvc.View;

public class GridView extends View {
    CellView[][] cellViews; //unsure if this is correct
    Grid model;
    public GridView(Model grid) {
        super(grid);
        model = (Grid)grid;
        for (int row = 0; row < model.getDim(); row++) {
            for (int col = 0; col < model.getDim(); col++) {
                cellViews[row][col] = new CellView(model.getCell(row, col));
            }
        }

    }

    public void update() {
        for (int row = 0; row < model.getDim(); row++) {
            for (int col = 0; col < model.getDim(); col++) {
                cellViews[row][col].update();
            }
        }
    }



}
