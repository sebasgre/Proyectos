package Programacion4.Recuperatorio;

public class LCS {
    public static void main(String[] args) {
        String X = "PHILOLOGIST";
        String Y = "LOLLIPOP";

        // Find the length of String
        int m = X.length();
        int n = Y.length();
        System.out.println("Longitud de Recuperatorio.LCS: " + lcs1(X, Y, m, n));
        lcs2(X,Y,m,n);
    }

    /**
     * Recursividad multicapa
     *
     * @param X PHILOLOGIST
     * @param Y LOLLIPOP
     * @return 4
     */

    public static int lcs1(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcs1(X, Y, m - 1, n - 1);
        else {
            return Math.max(lcs1(X, Y, m, n - 1),
                    lcs1(X, Y, m - 1, n));
        }
    }

    // Returns length of Recuperatorio.LCS for X[0..m-1], Y[0..n-1]
    public static void lcs2(String X, String Y, int m, int n)
    {
        int[][] L = new int[m+1][n+1];

        // Following steps build L[m+1][n+1] in bottom up fashion. Note
        // that L[i][j] contains length of Recuperatorio.LCS of X[0..i-1] and Y[0..j-1]
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        // Following code is used to print Recuperatorio.LCS
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs1 string
        char[] lcs = new char[index+1];
        lcs[index] = '\u0000'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs1[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of Recuperatorio.LCS
            if (X.charAt(i-1) == Y.charAt(j-1))
            {
                // Put current character in result
                lcs[index-1] = X.charAt(i-1);

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }

        // Print the lcs1
        System.out.print("Recuperatorio.LCS de "+X+" y "+Y+" es: ");
        for(int k=0;k<temp;k++)
            System.out.print(lcs[k]);
    }



}
