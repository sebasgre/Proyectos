package Programacion4.POO;



import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TimerEjemplo  {

    private final Timer timer = new Timer();

    public TimerEjemplo() {
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("La hora exacta es: " + new Date());
            }
        };
        timer.schedule(tarea,0,1000);
    }


    public static void main(String[] args) {
        new TimerEjemplo();
    }


}
