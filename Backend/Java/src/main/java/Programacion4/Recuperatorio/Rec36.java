package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec36 {
    public static void main(String[] args) {
        String a, b, c;
        Scanner sc =new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        c = sc.next();

        if (a.equals("vertebrado")  && b.equals("ave") && c.equals("carnivoro")) {
            System.out.print("aguia\n");
        }
        if (a.equals("vertebrado") && b.equals("ave") && c.equals("onivoro")) {
            System.out.print("pomba\n");
        }
        if (a.equals("vertebrado") && b.equals("mamifero") && c.equals("onivoro")) {
            System.out.print("homem\n");
        }
        if (a.equals("vertebrado") && b.equals("mamifero") && c.equals("herbivoro")) {
            System.out.print("vaca\n");
        }

        if (a.equals("invertebrado") && b.equals("inseto") && c.equals("hematofago")) {
            System.out.print("pulga\n");
        }
        if (a.equals("invertebrado") && b.equals("inseto") && c.equals("herbivoro")) {
            System.out.print("lagarta\n");
        }
        if (a.equals("invertebrado") && b.equals("anelideo") && c.equals("hematofago")) {
            System.out.print("sanguessuga\n");
        }
        if (a.equals("invertebrado") && b.equals("anelideo") && c.equals("onivoro")) {
            System.out.print("minhoca\n");
        }
    }

}
