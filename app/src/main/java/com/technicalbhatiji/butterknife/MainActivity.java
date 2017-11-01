/*
 * Copyright (c)  2017 Technical Bhati Ji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.technicalbhatiji.butterknife;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.logo)
    ImageView imgLogo;

    @BindView(R.id.lbl_title)
    TextView lblTitle;

    @BindView(R.id.input_name)
    EditText inputName;

    @BindDrawable(R.mipmap.ic_launcher)
    Drawable drawableLogo;

    @BindString(R.string.app_name)
    String appName;

    @BindColor(R.color.colorPrimaryDark)
    int colorTitle;

    @BindInt(R.integer.distance)
    int distance;

    @BindViews({R.id.lbl1, R.id.lbl2, R.id.lbl3})
    List<TextView> lblArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind the view using butterknife
        ButterKnife.bind(this);

        /**
         * 1. setting label color
         * */
        lblTitle.setTextColor(colorTitle);

        lblTitle.setText( "" + distance);

        /** 2. displaying logo using drawable
         * */
        imgLogo.setImageDrawable(drawableLogo);


        /** 3. applying to text to group of labels
         * */

        final String[] lblText = new String[]{"Cat", "Dog", "Rat"};

        ButterKnife.Action<TextView> APPLY_TEXT = new ButterKnife.Action<TextView>() {
            @Override
            public void apply(TextView view, int index) {
                view.setText(lblText[index]);
            }
        };

        // applying filter to array of labels
        ButterKnife.apply(lblArray, APPLY_TEXT);

        /**
         * 4. Applying color to group of labels
         * */
        ButterKnife.Action<TextView> APPLY_COLOR = new ButterKnife.Action<TextView>() {
            @Override
            public void apply(@NonNull TextView view, int index) {
                view.setTextColor(colorTitle);
            }
        };

        ButterKnife.apply(lblArray, APPLY_COLOR);
    }

    /**
     * 5. On click event of button using butter knife
     * method has to be public always
     */
    @OnClick(R.id.btn_enter)
    public void onButtonClick(View view) {
        Toast.makeText(getApplicationContext(), "You have entered: " + inputName.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_show_list) {
            startActivity(new Intent(MainActivity.this, ContactsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}