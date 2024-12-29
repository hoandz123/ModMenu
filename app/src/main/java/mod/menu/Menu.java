package mod.menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

//******************gay sex icon*********************************************
import java.io.IOException;
import java.io.InputStream;
import android.view.Gravity;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import android.graphics.PorterDuff;
import android.graphics.BitmapFactory;
import android.content.res.AssetManager;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

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
    LinearLayout maintab;

    native void Init(Context context, TextView title, TextView subTitle);

    native String Icon();

    native String IconWebViewData();

    native String[] GetFeatureList();

    native String[] SettingsList();

    native boolean IsGameLibLoaded();

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
            GaySex69Icon();
        }
        GaySex69Icon();

        LinearLayout main1 = new LinearLayout(context);
        main1.setOrientation(LinearLayout.HORIZONTAL);
        main1.setBackgroundColor(Color.TRANSPARENT);
        main1.setPadding(dp(12), dp(25), 3, dp(10));
        rootFrame.addView(main1);


        maintab = new LinearLayout(context);
        maintab.setOrientation(LinearLayout.VERTICAL);
        maintab.setBackgroundColor(Color.TRANSPARENT);
        maintab.setPadding(0, dp(25), 0, dp(25));
        main1.addView(maintab, MENU_WIDTH / 5, -1);



        LinearLayout tab1 = new LinearLayout(context);
        tab1.setGravity(Gravity.CENTER | Gravity.RIGHT);
        tab1.setPadding(dp(15), dp(0), dp(15), dp(0));
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
        tv1.setGravity(Gravity.CENTER | Gravity.RIGHT);
        tv1.setTextSize(convertDipToPixels(15));
        tv1.setTextColor(Color.parseColor("#FFFFFFFF"));
        try {
            Typeface customFont = Typeface.createFromAsset(context.getAssets(), "staccato.ttf");
            tv1.setTypeface(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tv1.setShadowLayer(5, 0, 0, Color.parseColor("#FF000000"));
        tab1.addView(tv1, -1, -1);




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

        loadMenu();
    }

    //******************gay sex icon*********************************************
    private void GaySex69Icon() {
        FrameLayout customFrameLayout = new FrameLayout(context);
        customFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(dp(170), dp(60)));
        customFrameLayout.setBackground(createRectangleBackground());

        customFrameLayout.addView(createCircleBackground());
        customFrameLayout.addView(createIconImageView());
        customFrameLayout.addView(createNameTextView());

        rootFrame.addView(customFrameLayout);
    }

    private GradientDrawable createRectangleBackground() {
        GradientDrawable background = new GradientDrawable();
        background.setShape(GradientDrawable.RECTANGLE);
        background.setCornerRadius(dp(50));
        background.setColor(Color.parseColor("#80000000"));
        background.setStroke(dp(1), Color.parseColor("#80ffffff"));
        return background;
    }

    private ImageView createCircleBackground() {
        ImageView circleBackground = new ImageView(context);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(Color.parseColor("#20ffffff"));
        drawable.setStroke(dp(1), Color.WHITE);
        circleBackground.setImageDrawable(drawable);

        FrameLayout.LayoutParams circleParams = new FrameLayout.LayoutParams(dp(60), dp(60));
        circleParams.gravity = Gravity.CENTER_VERTICAL | Gravity.START;
        circleBackground.setLayoutParams(circleParams);

        return circleBackground;
    }

    private ImageView createIconImageView() {
        ImageView iconImageView = new ImageView(context);
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("gaysexicon.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            iconImageView.setImageBitmap(getCircularBitmap(bitmap));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FrameLayout.LayoutParams iconParams = new FrameLayout.LayoutParams(dp(50), dp(50));
        iconParams.gravity = Gravity.CENTER_VERTICAL | Gravity.START;
        iconParams.leftMargin = dp(5);
        iconImageView.setLayoutParams(iconParams);

        return iconImageView;
    }

    private TextView createNameTextView() {
        TextView nameTextView = new TextView(context);
        nameTextView.setText("đọc là bị gay lỏ");
        nameTextView.setTextColor(Color.WHITE);
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        nameTextView.setTypeface(null, Typeface.BOLD);
        nameTextView.setPadding(dp(10), 0, 0, 0);
        nameTextView.setShadowLayer(dp(2), dp(2), dp(2), Color.WHITE);

        FrameLayout.LayoutParams nameParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        nameParams.gravity = Gravity.CENTER_VERTICAL;
        nameParams.leftMargin = dp(70);
        nameParams.rightMargin = dp(10);
        nameParams.topMargin = dp(5);
        nameParams.bottomMargin = dp(5);
        nameTextView.setLayoutParams(nameParams);

        return nameTextView;
    }

    private Bitmap getCircularBitmap(Bitmap bitmap) {
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);

        canvas.drawCircle(size / 2, size / 2, size / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (size - bitmap.getWidth()) / 2, (size - bitmap.getHeight()) / 2, paint);

        return output;
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





    void loadMenu() {
        String[] listFature = GetFeatureList();
        for (int i = 0; i < listFature.length; i++) {
            String[] list = listFature[i].split("_");
            for (int j = 0; j < list.length; j++) {
                Log.d("ModMenu", list[j]);
            }
        }
    }





    private int convertDipToPixels(int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) i, context.getResources().getDisplayMetrics());
    }
}