package Programacion4.Foro;

public class SantaClus {
    private static int total = 0;

    private static void solve(int[][] adj, int[] path, int index) {
        if (index == 8) {
            for (int i = 1; i <= 8; i++) {
                System.out.print(path[i]);
            }
            System.out.println("2");
            total++;
            return;
        }

        for (int i = 1; i < adj.length; i++) {
            if (adj[path[index]][i] == 1) {
                adj[path[index]][i] = 0;
                path[index + 1] = i;

                solve(adj, path, index + 1);

                adj[path[index]][i] = 1;
            } else if (adj[i][path[index]] == 1) {
                adj[i][path[index]] = 0;
                path[index + 1] = i;

                solve(adj, path, index + 1);

                adj[i][path[index]] = 1;
            }
        }
    }

    private static void run() {
        int[][] adj = new int[6][6];
        adj[1][2] = 1;
        adj[1][3] = 1;
        adj[1][5] = 1;
        adj[2][3] = 1;
        adj[2][5] = 1;
        adj[3][4] = 1;
        adj[3][5] = 1;
        adj[4][5] = 1;

        int[] path = new int[9];
        path[1] = 1;

        solve(adj, path, 1);

        // System.err.println("total: " + total);
    }

    public static void main(String[] args) {
        run();
    }


}
