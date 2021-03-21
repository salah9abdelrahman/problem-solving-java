package graphs;

import java.util.*;

/**
 * graphs.theSeasonalWar
 */
public class theSeasonalWar {

    static int n;
    static boolean[][] visited;
    static char[][] nodes;
    static int[] dx = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n][n];
        nodes = new char[n][n];
        int eagles = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                nodes[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && nodes[i][j] == '1') {
                    dfs(i, j);
                    eagles++;
                }
            }
        }

        System.out.println(eagles);
    }

    static boolean validIndex(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }

    static void dfs(int i, int j) {
        if (visited[i][j])
            return;
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int xi = dx[k] + i;
            int yi = dy[k] + j;
            if (validIndex(xi, yi) && !visited[xi][yi] && nodes[xi][yi] == '1') {
                dfs(xi, yi);
            }
        }
    }
}

