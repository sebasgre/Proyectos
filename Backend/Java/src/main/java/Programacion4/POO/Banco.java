package Programacion4.POO;

import java.util.ArrayList;

public class Banco {
    private final ArrayList<Cliente> clientes = new ArrayList();

    public static void main(String[] args) {
        Banco bn = new Banco();
        bn.agregarClientes(158, 000, 800);
        bn.agregarClientes(252,003,0);
        bn.bancoClient(1000, 158, 000, 100);
        bn.bancoClient(2000,252,003,2500);
    }

    public void agregarClientes(int num, int cod, int sal) {
        Cliente cl = new Cliente(num, cod, sal);
        clientes.add(cl);
    }

    public void bancoClient(int monto, int cnt, int cod, int dinero) {
        boolean bol = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNumeroCuenta() == cnt && clientes.get(i).getCodigo() == cod) {
                System.out.println(clientes.get(i).depositarDinero(dinero));
                System.out.println(clientes.get(i).retirarDinero(monto));
                bol = true;
            }
        }

        if (bol == false)
            System.out.println("El cliente no existe ");
    }

}
