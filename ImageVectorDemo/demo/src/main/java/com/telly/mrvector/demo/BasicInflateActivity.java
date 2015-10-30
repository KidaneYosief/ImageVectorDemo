
package com.telly.mrvector.demo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.telly.mrvector.MrVector;

import java.util.Random;


public class BasicInflateActivity extends ActionBarActivity implements View.OnClickListener {
  private static final Random sRandom = new Random(System.currentTimeMillis());
  private static final int[] sDrawables = {
      R.drawable.logo,
      R.drawable.vector_android,
      R.drawable.heart
  };
  private ImageButton mButton;
  private int mLastResId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_basic_inflate);

    mButton = (ImageButton)findViewById(R.id.button);
    mButton.setOnClickListener(this);
    nextDrawable();
  }

  @Override
  public void onClick(View v) {
    nextDrawable();
  }

  private void nextDrawable() {
    int resId;
    do {
      resId = sDrawables[sRandom.nextInt(sDrawables.length)];
    } while (resId == mLastResId);
    mLastResId = resId;
    Drawable drawable = MrVector.inflate(getResources(), resId);
    mButton.setImageDrawable(drawable);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    final int id = item.getItemId();
    switch (id) {
      default:
        return super.onOptionsItemSelected(item);
    }
  }

}
