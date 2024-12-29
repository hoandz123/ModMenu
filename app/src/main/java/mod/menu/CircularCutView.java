package mod.menu;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CircularCutView extends FrameLayout {
    private Paint paint;
    private Path path;
    private int currentRadius;
    private int maxRadius;

    public CircularCutView(Context context) {
        super(context);
        init();
    }

    public CircularCutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircularCutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Max radius is the smallest side (width or height)
        maxRadius = Math.min(w, h) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Cắt theo đường tròn
        path.reset();
        path.addCircle(getWidth() / 2, getHeight() / 2, currentRadius, Path.Direction.CW);
        canvas.clipPath(path);

        // Vẽ các thành phần con
        super.onDraw(canvas);
    }

    public void startCircleAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, maxRadius);
        animator.setDuration(1000); // Thời gian cho hiệu ứng thu nhỏ
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentRadius = (int) animation.getAnimatedValue();
                invalidate(); // Yêu cầu vẽ lại view với radius mới
            }
        });
        animator.start();
    }
}
