package Java.Programacion3.PatronObserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PromocionComercial implements PropertyChangeListener {

    private int condicionParaPromo;
    private int incentivoPromo;
    private final static Logger logger = LogManager.getLogger();

    public PromocionComercial(int cada, int incentivo) {
        condicionParaPromo = cada;
        incentivoPromo = incentivo;
    }

    public int getCondicionParaPromo() {
        return condicionParaPromo;
    }

    public void setCondicionParaPromo(int condicionParaPromo) {
        this.condicionParaPromo = condicionParaPromo;
    }

    public int getIncentivoPromo() {
        return incentivoPromo;
    }

    public void setIncentivoPromo(int incentivoPromo) {
        this.incentivoPromo = incentivoPromo;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logger.info("Aqui notificamos al observador para que realice los cambios");
        CuentaBanco ctaBanco = (CuentaBanco)evt.getSource();

        if (!evt.getPropertyName().equals("SALDO"))
            return;

        int saldoInicial = (int)evt.getOldValue();
        int saldoFinal = (int)evt.getNewValue();

        if (saldoFinal > saldoInicial) {
            int deposito = saldoFinal-saldoInicial;
            int cuantasVecesCondicionParaPromo = deposito / condicionParaPromo;
            int promoFinal = incentivoPromo * cuantasVecesCondicionParaPromo;

            ctaBanco.setSaldo(saldoFinal + promoFinal);
        }
    }
}
