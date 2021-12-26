package Programacion4.POO;

public class Cliente {
    private int numeroCuenta = 0;
    private int codigo = 0;
    private int saldo = 0;

    public Cliente(int numeroCuenta, int codigo, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public String retirarDinero(int monto) {
        String mensaje = "";
        if (saldo >= monto) {
            this.saldo -= monto;
            mensaje = "Se realizo exitosamente el retiro y su saldo actual es de " + saldo;
        } else
            mensaje = "Usted no tiene saldo suficiente para acceder al monto";
        return mensaje;
    }


    public String depositarDinero(int dinero) {
        this.saldo += dinero;
        return "Se deposito " + dinero + " Bs exitosamente";
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getCodigo() {
        return codigo;
    }


}
