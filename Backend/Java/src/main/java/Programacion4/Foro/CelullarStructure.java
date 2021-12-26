package Programacion4.Foro;

import java.util.Scanner;

public class CelullarStructure {
    private static String str = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            str = sc.nextLine();
            int t = calculate(0, str.length() - 1);
            switch (t) {
                case 0:
                    System.out.println("MUTANT");
                    break;
                case 1:
                    System.out.println("SIMPLE");
                    break;
                case 2:
                    System.out.println("FULLY-GROWN");
                    break;
                case 3:
                    System.out.println("MUTAGENIC");
                    break;
            }
        }
    }

    private static int calculate(int front, int back) {
        // 0:Mutant
        // 1:Simple
        // 2:Fully-Grown
        // 3:Mutagenic

        if (front == back && str.charAt(front) == 'A') return 1;

        if (str.charAt(back) == 'B' && str.charAt(back - 1) == 'A') {   // 判斷是否為Fully Grown
            if (front == back - 1) return 0;         // 如果為"AB"，那麼是Mutant
            else if (calculate(front, back - 2) != 0) return 2;
        }
        if (str.charAt(front) == 'B' && str.charAt(back) == 'A') {   // 判斷是否為Mutagenic
            if (front + 1 == back) return 0;        // 如果為"BA"，那麼是Mutant
            else if (calculate(front + 1, back - 1) != 0) return 3;
        }
        return 0;
    }
}
