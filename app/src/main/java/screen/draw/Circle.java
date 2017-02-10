package screen.draw;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class Circle extends View implements OnTouchListener {

	public Circle(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

	}

	
	int radius;
    int centerX;
    int centerY;
    static int num = -1;
    Paint mCirclePaint = new Paint();

    public Circle(Context context,int centerX, int centerY, int radius) {
    	super(context);
    	this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
        num++;
        mCirclePaint.setColor(Color.BLUE);
    }
    
    public void draw(Canvas c) {
    	c.drawCircle(20, 20, 20, mCirclePaint);
    }

    @Override
    public String toString() {
        return "Circle[" + centerX + ", " + centerY + ", " + radius + "]";
    }
	
	
	
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	
        boolean handled = false;

        Circle touchedCircle = this;
        int xTouch;
        int yTouch;
        int pointerId;
        int actionIndex = event.getActionIndex();

        // get touch event coordinates and make transparent circle from it
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                // it's the first pointer, so clear all existing pointers data
               // clearCirclePointer();

                xTouch = (int) event.getX(0);
                yTouch = (int) event.getY(0);

                // check if we've touched inside some circle
               // touchedCircle = obtainTouchedCircle(xTouch, yTouch);
                touchedCircle.centerX = xTouch;
                touchedCircle.centerY = yTouch;
              //  mCirclePointer.put(event.getPointerId(0), touchedCircle);

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                //Log.w(TAG, "Pointer down");
                // It secondary pointers, so obtain their ids and check circles
                pointerId = event.getPointerId(actionIndex);

                xTouch = (int) event.getX(actionIndex);
                yTouch = (int) event.getY(actionIndex);

                // check if we've touched inside some circle
                //touchedCircle = obtainTouchedCircle(xTouch, yTouch);

                //mCirclePointer.put(pointerId, touchedCircle);
                touchedCircle.centerX = xTouch;
                touchedCircle.centerY = yTouch;
                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_MOVE:
                final int pointerCount = event.getPointerCount();

                //Log.w(TAG, "Move");

                for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {
                    // Some pointer has moved, search it by pointer id
                    pointerId = event.getPointerId(actionIndex);

                    xTouch = (int) event.getX(actionIndex);
                    yTouch = (int) event.getY(actionIndex);

                    //touchedCircle = mCirclePointer.get(pointerId);

                    if (null != touchedCircle) {
                        touchedCircle.centerX = xTouch;
                        touchedCircle.centerY = yTouch;
                    }
                }
                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_UP:
                
                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_UP:
                // not general pointer was up
                pointerId = event.getPointerId(actionIndex);

                
                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_CANCEL:
                handled = true;
                break;

            default:
                // do nothing
                break;
        }

        return super.onTouchEvent(event) || handled;
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	
    
    
    
 
 
}
