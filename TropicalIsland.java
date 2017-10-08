
public class TropicalIsland {

    private Integer[][] current_island;
    private Integer[][] hyp_island;
    private int volume;
    private int max_i, max_j;

    public int getWaterVolume(Integer[][] island) {

        hyp_island = new Integer[island.length][island[0].length];
        fillHypIsland(island[0].length, island.length);

        this.current_island = island;

        max_i = island[0].length - 1;
        max_j = island.length - 1;

        for (int i = 1; i < max_i; i++)
            cell(0, i, 0);
        for (int i = 1; i < max_j; i++)
            cell(max_i, i, 0);
        for (int i = 1; i < max_i; i++)
            cell(i, 0, 0);
        for (int i = 1; i < max_j; i++)
            cell(i, max_j, 0);

        for (int i = 0; i < max_j; i++) {
            for (int j = 0; j < max_i; j++) {
                volume += hyp_island[j][i] - current_island[j][i];
            }
        }

        return volume;
    }

    private void fillHypIsland(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                hyp_island[i][j] = 1000;
            }
        }
    }

    private void cell(int x, int y, int depth) {

        if (x < 0 || y < 0 || x > max_i || y > max_j)
            return;
        if (hyp_island[y][x] <= depth)
            return;

        if (depth < current_island[y][x])
            depth = current_island[y][x];

        hyp_island[y][x] = depth;

        cell(x - 1, y, depth);
        cell(x + 1, y, depth);
        cell(x, y - 1, depth);
        cell(x, y + 1, depth);
    }

}
