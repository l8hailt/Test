package com.example.test.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TestCustomView extends View {

    private Paint paint;
    private RectF rectF;

    public TestCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(48f);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4f);

        rectF = new RectF(20, 20, 280, 280);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(300, 300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = this.getMeasuredWidth() / 2;
        int centerY = this.getMeasuredHeight() / 2;

        canvas.drawArc(rectF, 180, 30, false, paint);
//        canvas.drawText("Test", centerX, centerY, paint);
//        canvas.drawCircle(centerX, centerY, 50, paint);
//        canvas.drawLine(0, 150, 250, 150, paint);
    }
}
