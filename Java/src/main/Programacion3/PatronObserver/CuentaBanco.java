package Programacion3.PatronObserver;

import java.beans.PropertyChangeSupport;

public class CuentaBanco {
    private int saldo;
    private String cliente;

    private PropertyChangeSupport cambios;
//    private final static Logger logger = LogManager.getLogger();

    public CuentaBanco(String clt, int i) {
        cliente = clt;
        saldo = i;
        cambios = new PropertyChangeSupport(this);
    }

    public void addObserver(PromocionComercial promo) {
        cambios.addPropertyChangeListener(promo);
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + ", Saldo: " + saldo + " Bs";
    }

    public void depositar(int i) {
        int oldSaldo = saldo;
        saldo += i;

        cambios.firePropertyChange("SALDO", oldSaldo, saldo);
//        logger.info("Aqui se modifica el valor del saldo " + oldSaldo + " cambia a " + saldo);
    }

    public void sacar(int i) {
        int oldSaldo = saldo;
        saldo -= i;

        cambios.firePropertyChange("SALDO", oldSaldo, saldo);
//        logger.info("Aqui se modifica el valor del saldo " + oldSaldo + " cambia a " + saldo);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
