package mod.menu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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

//******************gay sex button*********************************************
import android.widget.Button;
import android.os.Handler;
import android.widget.Button;
import android.widget.FrameLayout;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import android.util.Log;
import android.view.Gravity;
import android.content.Context;
import android.widget.Toast;


public class Menu {

    public Context context;


    int MENU_WIDTH = 1280 - (1280 / 4);
    int MENU_HEIGHT = 720 - (720 / 4);
    int POS_X = 0;
    int POS_Y = 100;

    boolean overlayRequired;


    WindowManager mWindowManager, mWindowManager2, mWindowManager3;
    WindowManager.LayoutParams vmParams, vmParams2, vmParams3;
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
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("khung_menu_blur2.png");
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
        tv1.setText("HOME");
        tv1.setGravity(Gravity.CENTER | Gravity.RIGHT);
        tv1.setTextSize(convertDipToPixels(12));
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

    Button backgroudButton;
    private View addNewButton() {
        backgroudButton = new Button(context);
        setButtonBackground(backgroudButton, "close0.png");
        final String[] images = {"close0.png", "close1.png", "close2.png", "close3.png"};
        final int[] currentIndex = {0};
        Handler handler = new Handler();
        Runnable changeImageRunnable = new Runnable() {
            @Override
            public void run() {
                currentIndex[0] = (currentIndex[0] + 1) % images.length;
                setButtonBackground(backgroudButton, images[currentIndex[0]]);
                handler.postDelayed(this, 400);
            }
        };
        handler.postDelayed(changeImageRunnable, 150);
//        newButton.setBackgroundColor(0xffffffff);

        backgroudButton.setOnTouchListener(new View.OnTouchListener() {
            private float initialX, initialTouchX;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (rootFrame.getVisibility() == View.GONE) return false;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialTouchX = motionEvent.getRawX();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        float deltaX = motionEvent.getRawX() - initialTouchX;
                        if (deltaX < -50) {
                            rootFrame.setVisibility(View.GONE);
                            backgroudButton.setVisibility(View.GONE);
                            return true;
                        }
                        return false;

                    case MotionEvent.ACTION_UP:
                        return true;

                    default:
                        return false;
                }
            }
        });
        return backgroudButton;
    }




    private void setButtonBackground(Button button, String imageName) {
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(imageName);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
            drawable.setTileModeXY(null, null);
            button.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    //******************gay sex icon*********************************************
    int initialWidth;
    int defoultleftMargin;
    boolean isRunShow = false;
    boolean isRunShowHide = false;
    private View GaySex69Icon() {
        FrameLayout customFrameLayout = new FrameLayout(context);
        customFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, dp(60)));
        customFrameLayout.setBackground(createRectangleBackground());

        customFrameLayout.addView(createCircleBackground());
        customFrameLayout.addView(createIconImageView());
        customFrameLayout.addView(createNameTextView());

        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable showToastRunnable = new Runnable() {
            @Override
            public void run() {
                isRunShowHide = true;
                if (initialWidth == 0) initialWidth = nameTextView.getWidth();
                nameParams = (FrameLayout.LayoutParams) nameTextView.getLayoutParams(); // Sử dụng biến nameParams đã có
                if (defoultleftMargin == 0) defoultleftMargin = nameParams.leftMargin;

                ValueAnimator widthAnimator = ValueAnimator.ofInt(initialWidth, 0);
                widthAnimator.setDuration(1000);
                widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int animatedValue = (int) animation.getAnimatedValue();
                        ViewGroup.LayoutParams layoutParams = nameTextView.getLayoutParams();
                        layoutParams.width = animatedValue;
                        nameTextView.setLayoutParams(layoutParams);
                    }
                });

                ValueAnimator marginAnimator = ValueAnimator.ofInt(defoultleftMargin, 0);
                marginAnimator.setDuration(1000);
                marginAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int animatedValue = (int) animation.getAnimatedValue();
                        nameParams.leftMargin = animatedValue;
                        nameTextView.setLayoutParams(nameParams);
                    }
                });
                marginAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.d("ModMenu", "animation start");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.d("ModMenu", "animation end");
                        isRunShowHide = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.d("ModMenu", "animation cancel");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Log.d("ModMenu", "animation repeat");
                    }
                });

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(widthAnimator, marginAnimator);
                animatorSet.start();
            }
        };
        handler.postDelayed(showToastRunnable, 5000);

        customFrameLayout.setOnTouchListener(new View.OnTouchListener() {
            private float initialTouchX, initialTouchY;
            private int initialX, initialY;
            private long startTime;

            public boolean onTouch(View view, MotionEvent motionEvent) {

                handler.removeCallbacks(showToastRunnable);
                handler.postDelayed(showToastRunnable, 5000);


                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = vmParams2.x;
                        initialY = vmParams2.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        startTime = System.currentTimeMillis();

                        if (!isRunShow && !isRunShowHide) animateViewFromZero();
                        return true;
                    case MotionEvent.ACTION_UP:
                        long duration = System.currentTimeMillis() - startTime; // Tính thời gian nhấn
                        if (duration <= 150) {
                            if (rootFrame.getVisibility() == View.GONE) {
                                rootFrame.setVisibility(View.VISIBLE);
                                backgroudButton.setVisibility(View.VISIBLE);
                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
                        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
                        int borderX = 20;
                        int borderY = 40;

                        int NewX = initialX + (int) (motionEvent.getRawX() - initialTouchX);
                        int NewY = initialY + (int) (motionEvent.getRawY() - initialTouchY);

                        if (NewX < borderX) NewX = borderX;
                        if (NewY < borderY) NewY = borderY;
                        if (NewX > screenWidth - borderX) NewX = screenWidth - borderX;
                        if (NewY > screenHeight - borderY) NewY = screenHeight - borderY;

                        vmParams2.x = NewX;
                        vmParams2.y = NewY;
                        mWindowManager2.updateViewLayout(view, vmParams2);
                        return true;
                    default:
                        return false;
                }
            }
        });

        return customFrameLayout;
    }
    private void animateViewFromZero() {
        if (nameTextView.getWidth() != initialWidth && initialWidth != 0) {

            isRunShow = true;
            nameParams = (FrameLayout.LayoutParams) nameTextView.getLayoutParams();

            ValueAnimator widthAnimator = ValueAnimator.ofInt(0, initialWidth);
            widthAnimator.setDuration(1000);
            widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int animatedValue = (int) animation.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = nameTextView.getLayoutParams();
                    layoutParams.width = animatedValue;
                    nameTextView.setLayoutParams(layoutParams);
                }
            });

            ValueAnimator marginAnimator = ValueAnimator.ofInt(0, defoultleftMargin);
            marginAnimator.setDuration(1000);
            marginAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int animatedValue = (int) animation.getAnimatedValue();
                    nameParams.leftMargin = animatedValue;
                    nameTextView.setLayoutParams(nameParams);
                }
            });
            widthAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.d("ModMenu", "animation start");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.d("ModMenu", "animation end");
                    isRunShow = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    Log.d("ModMenu", "animation cancel");
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    Log.d("ModMenu", "animation repeat");
                }
            });

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(marginAnimator, widthAnimator);
            animatorSet.start();
        }
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

    TextView nameTextView;
    FrameLayout.LayoutParams nameParams;
    private TextView createNameTextView() {
        nameTextView = new TextView(context);
        nameTextView.setText("Android Mod");
        nameTextView.setTextColor(Color.WHITE);
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        nameTextView.setTypeface(null, Typeface.BOLD);
        nameTextView.setPadding(dp(10), 0, 0, 0);
        nameTextView.setShadowLayer(dp(2), dp(2), dp(2), Color.WHITE);

        nameTextView.setSingleLine(true);

        nameParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        nameParams.gravity = Gravity.CENTER_VERTICAL;
        nameParams.leftMargin = dp(60);
        nameParams.rightMargin = dp(20);
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

        vmParams2 = new WindowManager.LayoutParams(-2, -2, iparams, 8, -3);
        vmParams2.gravity = 51;
        vmParams2.x = POS_X;
        vmParams2.y = POS_Y;

        mWindowManager2 = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        mWindowManager2.addView(GaySex69Icon(), vmParams2);

        vmParams = new WindowManager.LayoutParams(MENU_WIDTH, MENU_HEIGHT, iparams, 8, -3);
        vmParams.gravity = 51;
        vmParams.x = POS_X;
        vmParams.y = POS_Y;

        mWindowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        mWindowManager.addView(rootFrame, vmParams);


        vmParams3 = new WindowManager.LayoutParams(dp(80), dp(60), iparams, 8, -3);
        vmParams3.gravity = Gravity.CENTER;
        vmParams3.x = -(MENU_WIDTH / 2) - dp(40);
        vmParams3.y = 0;

        mWindowManager3 = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        mWindowManager3.addView(addNewButton(), vmParams3);


        overlayRequired = true;
    }

    @SuppressLint("WrongConstant")
    public void SetWindowManagerActivity() {

        vmParams2 = new WindowManager.LayoutParams(-2, -2,
                0,
                0,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                        WindowManager.LayoutParams.FLAG_SPLIT_TOUCH,
                PixelFormat.TRANSPARENT
        );
        vmParams2.gravity = 51;
        vmParams2.x = POS_X;
        vmParams2.y = POS_Y;

        mWindowManager2 = ((Activity) context).getWindowManager();
        mWindowManager2.addView(GaySex69Icon(), vmParams2);

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

        vmParams3 = new WindowManager.LayoutParams(dp(80), dp(60),
                -(MENU_WIDTH / 2) - dp(40),
                0,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                        WindowManager.LayoutParams.FLAG_SPLIT_TOUCH,
                PixelFormat.TRANSPARENT
        );
        vmParams3.gravity = Gravity.CENTER;

        mWindowManager3 = ((Activity) context).getWindowManager();
        mWindowManager3.addView(addNewButton(), vmParams3);

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