package screen.draw;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		    /*getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
			getActionBar().hide();*/
		setContentView(R.layout.activity_splash);
		
		
		
		new Handler().postDelayed(new Runnable() {
			  @Override
			  public void run() {

			    //Create an intent that will start the main activity.
			    Intent mainIntent = new Intent(Splash.this, FingerPaintActivity.class);
			    Splash.this.startActivity(mainIntent);

			    //Finish splash activity so user cant go back to it.
			    Splash.this.finish();

			    //Apply splash exit (fade out) and main entry (fade in) animation transitions.
			    overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout);
			  }
			}, 3500);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
