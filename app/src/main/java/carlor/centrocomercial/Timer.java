package carlor.centrocomercial;

/**
 * Created by Usuario on 04/05/2016.
 */
public class Timer extends Thread {
    long imme;
    boolean sw;
    long ini;
    long fin;
    public Timer(long imme){
        this.imme=imme;
    }
    public void run() {
        fin=System.currentTimeMillis()+imme;
        ini=System.currentTimeMillis();
         sw=true;
        while(fin>ini){
            ini=System.currentTimeMillis();
        }
        if (sw == true) {
            sw=false;
        }
    }
}