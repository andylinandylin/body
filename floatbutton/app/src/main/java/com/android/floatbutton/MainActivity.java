package com.android.floatbutton;

import android.app.Service;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Context;
import android.view.Gravity;
import android.graphics.PixelFormat;
import android.view.WindowManager.LayoutParams;
import android.app.ActivityManager;
import android.content.Intent;
import com.example.test.R;

public class MainActivity extends Activity{
    private WindowManager windowManager = null;
    private WindowManager.LayoutParams windowManagerParams = null;
    private FloatView floatView = null;
    static Integer fv = 0;

    DatabaseHandler dbHandler = new DatabaseHandler(this);

    Button startbutton, newbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(fv == 0) createView() ;
        fv = 1;

        try {
            startbutton = (Button) findViewById(R.id.button);
            newbutton = (Button) findViewById(R.id.button2);

            dbHandler.Add_Contact(new Contact("1",
                    "2", "3", "4"));



        } catch (Exception e) {
            // TODO: handle exception

        }

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // TODO Auto-generated method stub
                moveTaskToBack(true);
            }
        });

        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // TODO Auto-generated method stub
                Show_Toast("New");
            }
        });
    }


    private void createView() {
        try {
            floatView = new FloatView(getApplicationContext());
            floatView.setImageResource(R.drawable.ic_launcher);
            windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            windowManagerParams = ((FloatApplication) getApplication()).getWindowParams();
            windowManagerParams.type = LayoutParams.TYPE_PHONE;
            windowManagerParams.format = PixelFormat.RGBA_8888;
            windowManagerParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL
                    | LayoutParams.FLAG_NOT_FOCUSABLE;
            windowManagerParams.gravity = Gravity.LEFT | Gravity.TOP;
            windowManagerParams.x = 0;
            windowManagerParams.y = 0;
            windowManagerParams.width = LayoutParams.WRAP_CONTENT;
            windowManagerParams.height = LayoutParams.WRAP_CONTENT;
            windowManager.addView(floatView, windowManagerParams);
        } catch (Exception e) {
            // TODO: handle exception

        }

        floatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // TODO Auto-generated method stub

                Contact c = dbHandler.Get_Contact(1);
                Show_Toast(c.getLatitude());

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                getBaseContext().startActivity(intent);

            }
        });
    }

    public void Show_Toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
