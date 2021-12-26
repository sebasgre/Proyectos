package Programacion4.Ejercicios;

import java.util.Scanner;

public class e12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario = "Sebastian";
        String contraseña = "HolaMundo";
        int intentos = 3;
        String mensaje = "";
        while (intentos > 0) {
            System.out.println("Ingrese su nombre por favor");
            String nombre = sc.nextLine();
            System.out.println("Ingrese su contraseña");
            String clave = sc.nextLine();
            if (clave.equals(contraseña) && usuario.equals(nombre)) {
                mensaje = "Bienvenido " + nombre + "!";
                System.out.println(mensaje);
                break;
            }else {
                intentos--;
                if (intentos == 0) {
                    mensaje = "SU CUENTA HA SIDO BLOQUEADA";
                }else {
                    if (!nombre.equals(usuario) && !clave.equals(contraseña))
                        mensaje = "Datos incorrectos en el nombre de usuario y contraseña";
                    else if(!nombre.equals(usuario))
                        mensaje = "Nombre de usuario incorrecto";
                    else
                        mensaje = "Contraseña incorrecta";
                }
                System.out.println(mensaje);
            }
        }
    }
}
