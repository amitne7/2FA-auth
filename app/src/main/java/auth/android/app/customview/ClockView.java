package auth.android.app.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import event.msvc.android.R;


/**
 * Created by sudhirharit on 29/03/18.
 */

public class ClockView extends View {
    private Paint p;
    int c, h, m;
    private int fontSize = 0;
    private int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};
    private Rect rect = new Rect();
    private int radius = 0;
    private int height, width = 0;


    public ClockView(Context context) {
        super(context);
        c = Color.parseColor("#F44336");
        h = 17;
        m = 0;
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ClockView);
        c = arr.getColor(R.styleable.ClockView_clockColor, Color.parseColor("#F44336"));
        h = arr.getInteger(R.styleable.ClockView_h, 17);
        m = arr.getInteger(R.styleable.ClockView_m, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        int center_w = (getMeasuredWidth() / 2);
        int center_h = (getMeasuredHeight() / 2);
        int len = (getMeasuredWidth() / 2) - 3;
        float f = (getMeasuredWidth()/2)-10;
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStyle(Paint.Style.FILL);
        p.setColor(c);
        //canvas.drawCircle(center_w, center_h, len, p);
        p.setColor(Color.WHITE);
//        canvas.drawCircle(center_w, center_h, (float) (int) (len * 0.8), p);
        //canvas.drawCircle(center_w, center_h, f, p);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(4f);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setColor(c);
        drawNumeral(canvas);        //p.setColor(getResources().getColor(R.color.textColorSecondary));
        canvas.drawLine(center_w, center_h, center_w + getMinuteX(len), center_h + getMinuteY(len), p);
        //p.setColor(getResources().getColor(R.color.textColorPrimary));
        canvas.drawLine(center_w, center_h, center_w + getHourX(len), center_h + getHourY(len), p);
    }

    public void setHour(int h) {
        this.h = h;
    }

    public void setMinute(int m) {
        this.m = m;
    }

    public void setClockColor(int c) {
        this.c = c;
    }

    private float getMinuteX(int l) {
        int c = 0;
        if (m < 15) {
            c = m + 45;
        } else {
            c = m - 15;
        }
        double angle = Math.toRadians(c * 6);
        return (float) (0.6 * l * Math.cos(angle));
    }

    private float getMinuteY(int l) {
        int c = 0;
        if (m < 15) {
            c = m + 45;
        } else {
            c = m - 15;
        }
        double angle = Math.toRadians(c * 6);
        return (float) (0.6 * l * Math.sin(angle));
    }

    private float getHourX(int l) {
        double angle = Math.toRadians(((h * 60) + m) / 2 - 90);
        return (float) (0.4 * l * Math.cos(angle));
    }

    private float getHourY(int l) {
        double angle = Math.toRadians(((h * 60) + m) / 2 - 90);
        return (float) (0.4 * l * Math.sin(angle));
    }

    private void drawNumeral(Canvas canvas) {
        p.setTextSize(fontSize);

        for (int number : numbers) {
            String tmp = String.valueOf(number);
            p.getTextBounds(tmp, 0, tmp.length(), rect);
            double angle = Math.PI / 6 * (number - 3);
            int x = (int) (width / 2 + Math.cos(angle) * radius - rect.width() / 2);
            int y = (int) (height / 2 + Math.sin(angle) * radius + rect.height() / 2);
            canvas.drawText(tmp, x, y, p);
        }
    }


}
