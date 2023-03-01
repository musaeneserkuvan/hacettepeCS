import java.util.Timer;
import java.util.TimerTask;

public interface OperationTimer {

    default void DelayTime(Datas datas) {

        Timer Count = new Timer("Count");
        TimerTask changeTimer = new TimerTask() {
            public void run() {
                for(int i=0; i< 10; i++) {

                    if(i == 1) {

                        Count.cancel();
                        break;
                    }
                    datas.resetLoginCount();
                }
            }
        };
        Count.schedule(changeTimer, datas.getBlocktime()* 1000L);
    }
}
