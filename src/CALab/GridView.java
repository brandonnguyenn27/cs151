package CALab;

import mvc.Model;
import mvc.View;

public class GridView extends View {
    CellView[][] cellViews; //unsure if this is correct
    Grid model;
    public GridView(Model grid) {
        super(grid);
        model = (Grid)grid;
        cellViews = new CellView[((Grid) grid).dim][((Grid) grid).getDim()]; //not sure if this is correct
        // ^ maybe I should be looping through grid and creating cellViews for each cell?
    }



}
