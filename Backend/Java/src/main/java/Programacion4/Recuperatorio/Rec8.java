package Programacion4.Recuperatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rec8 {
    public static void main(String[] args) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int a, b, c, d;
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());
        System.out.println("DIFERENCA = " + (a*b - c*d));
    }
}
