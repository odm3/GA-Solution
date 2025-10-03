import java.util.*;

public class GridNeighborhood {

    public record Cell(int row, int col) {
    }

    public int getCellsInNeighborhood(List<List<Integer>> grid, Set<Cell> positiveCells, int neighborhoodThreshold) {

        if (grid.isEmpty() || neighborhoodThreshold < 0)
            return 0;

        Set<Cell> covered = new HashSet<>();

        for (Cell cell : positiveCells) {
            int _row = cell.row(); // row coordinate of center
            int _col = cell.col(); // col coordinate of center

            if (_row < 0 || _row >= grid.size() || _col < 0 || _col >= grid.get(0).size())
                continue;

            int rowMin = Math.max(0, _row - neighborhoodThreshold);
            int rowMax = Math.min(grid.size() - 1, _row + neighborhoodThreshold);

            for (int rr = rowMin; rr <= rowMax; rr++) {

                // How far vertically are we from the center?
                int verticalDistanceFromCenter = Math.abs(rr - _row);

                // Given that vertical offset, how many horizontal steps remain before we exceed
                int remaining = neighborhoodThreshold - verticalDistanceFromCenter;

                // Compute the leftmost and rightmost columns on this row that are
                // within the diamond
                int cMin = Math.max(0, _col - remaining);
                int cMax = Math.min(grid.get(0).size() - 1, _col + remaining);

                // Mark all cells in that contiguous horizontal band
                for (int cc = cMin; cc <= cMax; cc++) {
                    covered.add(new Cell(rr, cc));
                }
            }
        }

        // The size of the covered set is the total number of unique cells in
        // all neighborhoods
        return covered.size();
    }

    public Set<GridNeighborhood.Cell> getPositiveCells(List<List<Integer>> grid) {
        Set<Cell> positiveCells = new HashSet<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) > 0) {
                    positiveCells.add(new Cell(i, j));
                }
            }
        }
        return positiveCells;
    }
}