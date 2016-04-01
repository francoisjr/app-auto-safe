package br.com.autosafe.autosafeapp.activity;

import android.os.Bundle;

import br.com.autosafe.autosafeapp.R;
import br.com.autosafe.autosafeapp.domain.Apolice;
import br.com.autosafe.autosafeapp.domain.Veiculo;
import br.com.autosafe.autosafeapp.fragment.ApoliceFragment;

public class ApoliceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apolice);

        //configura a toolbar como action bar
        setUpToolbar();

        //atualiza a apolice no fragment
        ApoliceFragment af = (ApoliceFragment) getSupportFragmentManager().findFragmentById(R.id.ApoliceFragment);
        Apolice a = (Apolice) getIntent().getSerializableExtra("apolice");
        af.setApolice(a);

        // Título da toolbar e botão up navigation
        getSupportActionBar().setTitle(a.getVeiculo().getModelo());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
