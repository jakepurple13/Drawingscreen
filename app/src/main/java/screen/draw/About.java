package screen.draw;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class About extends Activity {
	
	TextView qwe;
	TextView des;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
		setContentView(R.layout.activity_about);
		
		
		qwe = (TextView) findViewById(R.id.textView2);
		des = (TextView) findViewById(R.id.textView1);
		qwe.setVisibility(View.GONE);
        des.setVisibility(View.GONE);
		/*des.setText(Html.fromHtml("<small><br><b>Programmer:</b><br> Jacob E. Rein<br><br><b>" +
				"Graphic Designer:</b><br> Evan Choe<br><br><b>" +
				"Inspiration:</b><br> Ryan Hall<br>" +
				"<br><b>Head Coach:</b><br> Kevin Killian<br>" +
				"<br><b>Mentors:<\b><br></b>Ilene Rein, Lisa Ruggieri</small>"));
		des.setGravity(Gravity.CENTER);*/
		System.out.println("");
		
		String asdf;// = new StyleSpan(Typeface.ITALIC);
		
		//qwe.setText("This app was programmed by Jacob E. Rein, " + R.string.first + " Team 1676 Pascack Pi-oneers");
		//qwe.setText(Html.fromHtml("\u00a9 Copyright 2015 Jacob E. Rein, <br> <i>FIRST</i> Team 1676 Pascack Pi-oneers"));
		//qwe.setGravity(Gravity.CENTER);
		
	}
	
	
	
	
	@Override  
	public void onBackPressed() {
	    super.onBackPressed();   
	    // Do extra stuff here
	      /*Intent i = new Intent(About.this, FingerPaintActivity.class);
		  startActivity(i);
		  About.this.finish();*/
		  /*new Handler().postDelayed(new Runnable() {
			  @Override
			  public void run() {

			    //Create an intent that will start the main activity.
			    Intent mainIntent = new Intent(About.this, FingerPaintActivity.class);
			    About.this.startActivity(mainIntent);

			    //Finish splash activity so user cant go back to it.
			    About.this.finish();

			    //Apply splash exit (fade out) and main entry (fade in) animation transitions.
			    overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout);
			  }
			}, 1000);*/
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

}
