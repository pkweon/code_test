public class ShortestPath {
    public int solution(int[][] grid) {
        int answer = 0;

        int[][] mincost = new int[grid.length][grid[0].length];
        mincost[0][0] = grid[0][0];

        for (int y = 1; y < mincost[0].length; y++) {
            mincost[0][y] = mincost[0][y-1] + grid[0][y];
        }
        for (int x = 1; x < mincost.length; x++) {
            mincost[x][0] = mincost[x-1][0] + grid[x][0];
        }

        for (int x = 1; x < mincost.length; x++) {
            for (int y = 1; y < mincost[0].length; y++) {
                mincost[x][y] = grid[x][y] + Math.min(mincost[x-1][y], mincost[x][y -1]);
            }
        }
        answer = mincost[mincost.length-1][mincost[0].length-1];
        return answer;
    }

    int cost(int[][] grid, int x, int y) {
        System.out.println("(" + x + ", " + y + ")");
        if (x == 0 && y == 0) return grid[x][y];
        else {
            if (x == 0) {
                return grid[0][y] + cost(grid, 0, y -1);
            } else if (y == 0) {
                return grid[x][0] + cost(grid, x-1, 0);
            }
            return grid[x][y] + Math.min( cost(grid, x-1, y), cost(grid, x, y -1) );
        }
    }
}
