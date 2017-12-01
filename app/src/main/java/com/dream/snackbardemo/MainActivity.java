package com.dream.snackbardemo;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    View container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.snackbar1).setOnClickListener(this);
        findViewById(R.id.snackbar2).setOnClickListener(this);
        findViewById(R.id.snackbar3).setOnClickListener(this);
        findViewById(R.id.snackbar4).setOnClickListener(this);
        findViewById(R.id.snackbar5).setOnClickListener(this);

        container = findViewById(R.id.container);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.snackbar1:
                Snackbar.make(container, " Snackbar1 可以左滑取消哦~", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;

            case R.id.snackbar2:
                Snackbar.make(container, "Snackbar2 ActionClick", Snackbar.LENGTH_LONG)
                        .setAction("Click me", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v, " Snackbar2 Click test ", Snackbar.LENGTH_LONG).show();
                            }
                        }).show();
                break;

            case R.id.snackbar3: {
                Snackbar snackbar = Snackbar.make(container, "Snackbar3 change brackgroudcolor ", Snackbar.LENGTH_SHORT);
                ColoredSnackbar.alert(snackbar).show();
            }
            break;
            case R.id.snackbar4: {
                Snackbar snackbar = Snackbar.make(container, "Snackbar4 change text and action text color", Snackbar.LENGTH_LONG).setAction("click me", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar = Snackbar.make(v, "ActionClick", Snackbar.LENGTH_LONG);
                        setSnackbarMessageTextColor(snackbar, Color.parseColor("#FF0000"));
                        snackbar.show();
                    }
                });
                setSnackbarMessageTextColor(snackbar, Color.parseColor("#FF00FF"));
                setSnackbarActionTextColor(snackbar, Color.parseColor("#FFFF00"));
                snackbar.show();
            }
                break;
            case R.id.snackbar5:{
                Snackbar snackbar = SnackbarUtil.ShortSnackbar(container,"Snackbar4 add image",SnackbarUtil.Warning)
                        .setActionTextColor(Color.RED)
                        .setAction("再次点击", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SnackbarUtil.LongSnackbar(v,"hello!!!",SnackbarUtil.Alert).setActionTextColor(Color.WHITE).show();
                    }
                });

                SnackbarUtil.SnackbarAddView(snackbar,R.layout.snackbar_addview,0);

                SnackbarUtil.SnackbarAddView(snackbar,R.layout.snackbar_addview,2);

                snackbar.show();
            }

                break;
        }
    }

    public static void setSnackbarMessageTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(color);
    }

    public static void setSnackbarActionTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        ((Button) view.findViewById(R.id.snackbar_action)).setTextColor(color);
    }
}
