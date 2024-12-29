package mod.menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class Menu {

    public Context context;


    int MENU_WIDTH = 1280 - (1280 / 4);
    int MENU_HEIGHT = 720 - (720 / 4);
    int POS_X = 0;
    int POS_Y = 100;

    boolean overlayRequired;


    WindowManager mWindowManager;
    WindowManager.LayoutParams vmParams;
    FrameLayout rootFrame;




    public Menu(Context context) {
        this.context = context;
        rootFrame = new FrameLayout(context);

//
//        FrameLayout linBGColor = new FrameLayout(context);
//        linBGColor.setBackgroundColor(Color.parseColor("#99000000"));
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.MATCH_PARENT,
//                FrameLayout.LayoutParams.MATCH_PARENT
//        );
//        params.topMargin = 10;
//        params.bottomMargin = 3;
//        params.leftMargin = 3;
//        params.rightMargin = 3;
//
//        linBGColor.setLayoutParams(params);
//        rootFrame.addView(linBGColor);
//
//        FrameLayout linBGIMG = new FrameLayout(context);
////        linBGIMG.setPadding(5, 15, 5, 5);
//        rootFrame.addView(linBGIMG);

        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("khung_menu_blur2.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            rootFrame.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    @SuppressLint("WrongConstant")
    public void SetWindowManagerWindowService() {
        int iparams = Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O ? 2038 : 2002;
        vmParams = new WindowManager.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, iparams, 8, -3);
        vmParams.gravity = 51;
        vmParams.x = POS_X;
        vmParams.y = POS_Y;

        mWindowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        mWindowManager.addView(rootFrame, vmParams);
        overlayRequired = true;
    }

    @SuppressLint("WrongConstant")
    public void SetWindowManagerActivity() {
        vmParams = new WindowManager.LayoutParams(MENU_WIDTH, MENU_HEIGHT,
                0,
                0,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                        WindowManager.LayoutParams.FLAG_SPLIT_TOUCH,
                PixelFormat.TRANSPARENT
        );
        vmParams.gravity = Gravity.CENTER;

        mWindowManager = ((Activity) context).getWindowManager();
        mWindowManager.addView(rootFrame, vmParams);
    }

    private int convertDipToPixels(int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) i, context.getResources().getDisplayMetrics());
    }
}