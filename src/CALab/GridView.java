package CALab;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class GridView extends View {
    CellView[][] cellViews; //unsure if this is correct
    Grid model;
    public GridView(Grid grid) {
        super(grid);
        model = (Grid)grid;
        int dim = grid.getDim();
        cellViews = new CellView[dim][dim];
        setLayout(new GridLayout(dim,dim));
        for(int i=0;i<dim;i++)
        {
            for(int j=0;j<dim;j++)
            {
                add(cellViews[i][j]);
            }
        }
    }



}
