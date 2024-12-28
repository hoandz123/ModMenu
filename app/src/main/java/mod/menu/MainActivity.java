package mod.menu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Main.StartWithoutPermission(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        LinearLayout lin = new LinearLayout(this);
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("img.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
            lin.setBackground(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setContentView(lin);
    }
}
