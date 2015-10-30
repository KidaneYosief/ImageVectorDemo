/*
 * Copyright (C) Telly, Inc. and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
