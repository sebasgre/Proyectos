package Java.Programacion3.TorresHanoi;

public class Ejemplo {
    public void torresHanoi(int discos, int torre1, int torre2, int torre3) {
        //Caso base
        if (discos == 1)
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        else {
            //Dominio (Recursividad)
            torresHanoi(discos - 1, torre1, torre3, torre2);
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}
