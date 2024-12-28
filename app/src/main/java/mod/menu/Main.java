package mod.menu;

import android.app.Activity;
import android.content.Context;

public class Main {

    static {
//        System.loadLibrary("MyLibName");
    }

//    private static native void CheckOverlayPermission(Context context);

    public static void StartWithoutPermission(Context context) {
        if (context instanceof Activity) {
            Menu menu = new Menu(context);
            menu.SetWindowManagerActivity();
        } else {
//            CheckOverlayPermission(context);
        }
    }

    public static void Start(Context context) {
//        CheckOverlayPermission(context);
    }
}
