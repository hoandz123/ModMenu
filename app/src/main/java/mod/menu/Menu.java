package mod.menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("khung_menu_blur85.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            rootFrame.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinearLayout main1 = new LinearLayout(context);
        main1.setOrientation(LinearLayout.HORIZONTAL);
        main1.setBackgroundColor(Color.TRANSPARENT);
        main1.setPadding(dp(12), dp(25), 3, dp(10));
        rootFrame.addView(main1);


        LinearLayout maintab = new LinearLayout(context);
        maintab.setOrientation(LinearLayout.VERTICAL);
        maintab.setBackgroundColor(Color.TRANSPARENT);
        maintab.setPadding(0, dp(25), 0, dp(25));
        main1.addView(maintab, MENU_WIDTH / 5, -1);



        LinearLayout tab1 = new LinearLayout(context);
        tab1.setGravity(Gravity.CENTER | Gravity.RIGHT);
        tab1.setPadding(dp(10), dp(0), dp(10), dp(0));
        maintab.addView(tab1, -1, dp(35));
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("img_1.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            tab1.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView tv1 = new TextView(context);
        tv1.setText("Home");
        tv1.setTextSize(convertDipToPixels(15));
//        tv1.setTextColor(Color.parseColor("#FFFFFFFF"));
        try {
            Typeface customFont = Typeface.createFromAsset(context.getAssets(), "staccato.ttf");
            tv1.setTypeface(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        tv1.setShadowLayer(10, 0, 0, Color.parseColor("#FF000000"));
        tv1.setLayerType(View.LAYER_TYPE_SOFTWARE, null); // Bắt buộc để áp dụng hiệu ứng vẽ

// Lấy Paint để tùy chỉnh
        Paint paint = tv1.getPaint();

// Vẽ nền chữ đen
        paint.setStyle(Paint.Style.FILL); // Vẽ nền chữ
        tv1.setTextColor(Color.BLACK); // Màu nền chữ là đen

// Vẽ viền trắng
        paint.setStyle(Paint.Style.STROKE); // Vẽ viền
        paint.setStrokeWidth(3); // Độ rộng của viền
        paint.setColor(Color.WHITE);
        tab1.addView(tv1);




        LinearLayout tab2 = new LinearLayout(context);
        maintab.addView(tab2, -1, dp(35));
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("img_1.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            tab2.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinearLayout tab3 = new LinearLayout(context);
        maintab.addView(tab3, -1, dp(35));
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("img_1.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            tab3.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinearLayout tab4 = new LinearLayout(context);
        maintab.addView(tab4, -1, dp(35));
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("img_1.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            tab4.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinearLayout tab5 = new LinearLayout(context);
        maintab.addView(tab5, -1, dp(35));
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("img_1.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            tab5.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }



        LinearLayout vachke1 = new LinearLayout(context);
        android.graphics.drawable.GradientDrawable STKOYM = new android.graphics.drawable.GradientDrawable();
        STKOYM.setCornerRadii(new float[]{ (float) 0,(float) 0,(float) 0,(float) 0,(float) 0,(float) 0,(float) 0,(float) 0 });
        STKOYM.setStroke(2,Color.parseColor("#FF444444"));
        STKOYM.setColor(Color.parseColor("#FF6F6F6F"));
        vachke1.setBackground(STKOYM);
        main1.addView(vachke1, 7, -1);


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