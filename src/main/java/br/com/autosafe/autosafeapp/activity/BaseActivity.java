package br.com.autosafe.autosafeapp.activity;

import android.support.v7.widget.Toolbar;

import br.com.autosafe.autosafeapp.R;


/**
 * Created by François on 2/20/2016.
 * classe de activity mãe, podendo colocar metodos e reutilizar em subclasses
 */
public class BaseActivity extends livroandroid.lib.activity.BaseActivity {

    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
