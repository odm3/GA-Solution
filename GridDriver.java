
import java.util.List;

public class GridDriver {
    public static void main(String[] args) {
        GridNeighborhood gn = new GridNeighborhood();

        List<List<Integer>> grid1 = List.of(
                List.of(0, 1, 0, 0),
                List.of(0, 0, 1, 0),
                List.of(0, 0, 0, 1),
                List.of(1, 0, 0, 0));
        System.out.println("Grid 1, N=1: " + gn.getCellsInNeighborhood(grid1, gn.getPositiveCells(grid1), 1)); // Expect
                                                                                                               // 8

        List<List<Integer>> grid2 = List.of(
                List.of(0, 0, 0, 0, 0),
                List.of(0, 1, 0, 1, 0),
                List.of(0, 0, 0, 0, 0),
                List.of(0, 1, 0, 1, 0),
                List.of(0, 0, 0, 0, 0));
        System.out.println("Grid 2, N=1: " + gn.getCellsInNeighborhood(grid2, gn.getPositiveCells(grid2), 1)); // Expect
                                                                                                               // 12

        List<List<Integer>> adjacent = List.of(
                List.of(0, 1, 1, 0), // Two adjacent positive values
                List.of(0, 0, 0, 0),
                List.of(0, 0, 0, 0));
        System.out.println(
                "Adjacent positives, N=1: " + gn.getCellsInNeighborhood(adjacent, gn.getPositiveCells(adjacent), 3)); // Expect
                                                                                                                      // 15

        List<List<Integer>> corners = List.of(
                List.of(1, 0, 0, 1), // Positive values in corners
                List.of(0, 0, 0, 0),
                List.of(1, 0, 0, 1) // More corner values
        );
        System.out.println(
                "Corner positives, N=2: " + gn.getCellsInNeighborhood(corners, gn.getPositiveCells(corners), 2)); // Expect
                                                                                                                  // 13

        List<List<Integer>> single = List.of(
                List.of(1) // 1x1 array
        );
        System.out
                .println("Single positive, N=1: " + gn.getCellsInNeighborhood(single, gn.getPositiveCells(single), 1)); // Expect
                                                                                                                        // 1

        List<List<Integer>> wide = List.of(
                List.of(1, 0, 1, 0, 1) // 1x5 array
        );
        System.out.println("Wide array, N=1: " + gn.getCellsInNeighborhood(wide, gn.getPositiveCells(wide), 1)); // Expect
                                                                                                                 // 5

        List<List<Integer>> zeroRadius = List.of(
                List.of(1, 0, 1),
                List.of(0, 0, 0),
                List.of(1, 0, 1));
        System.out.println(
                "Zero radius, N=0: " + gn.getCellsInNeighborhood(zeroRadius, gn.getPositiveCells(zeroRadius), 0)); // Expect
                                                                                                                   // 4

    }
}
