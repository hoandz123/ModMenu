package mod.menu;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;

public class Launcher extends Service {

    Menu menu;
    @Override
    public void onCreate() {
        super.onCreate();

        menu = new Menu(this);
        menu.SetWindowManagerWindowService();

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
               Thread();
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean isNotInGame() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance != 100;
    }

    private void Thread() {

    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopSelf();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_NOT_STICKY;
    }
}
