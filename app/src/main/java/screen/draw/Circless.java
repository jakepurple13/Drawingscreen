package screen.draw;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnTouchListener;

public class Circless extends RectF implements OnTouchListener {
	
	int radius;
    int centerX;
    int centerY;
    static int num = -1;
    Paint mCirclePaint = new Paint();
    
    RectF qwe = new RectF(20, 20, 20, 20);
    
    public RectF create() {
    	return qwe;
    }
	
    private final class MyTouchListener implements OnTouchListener {
    	 public boolean onTouch(View view, MotionEvent motionEvent) {
    	  if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
    	    ClipData data = ClipData.newPlainText("", "");
    	    DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
    	    view.startDrag(data, shadowBuilder, view, 0);
    	    view.setVisibility(View.INVISIBLE);
    	    return true;
    	  } else {
    	    return false;
    	  }
    	 }
    	}
	


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		boolean handled = false;

        Circless touchedCircle = this;
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

                //invalidate();
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
                //invalidate();
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
                //invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_UP:
                
                
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_UP:
                // not general pointer was up
                pointerId = event.getPointerId(actionIndex);

                
              
                handled = true;
                break;

            case MotionEvent.ACTION_CANCEL:
                handled = true;
                break;

            default:
                // do nothing
                break;
        }
		return false;
	}

}
