package br.com.autosafe.autosafeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.autosafe.autosafeapp.R;
import br.com.autosafe.autosafeapp.adapter.NavDrawerMenuAdapter;
import br.com.autosafe.autosafeapp.adapter.NavDrawerMenuItem;
import br.com.autosafe.autosafeapp.domain.Apolice;
import br.com.autosafe.autosafeapp.domain.Cliente;
import br.com.autosafe.autosafeapp.fragment.ApolicesFragment;
import br.com.autosafe.autosafeapp.fragment.ChamadosFragment;
import livroandroid.lib.fragment.NavigationDrawerFragment;

public class MenuActivity extends BaseActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavDrawerFragment;
    private NavDrawerMenuAdapter listAdapter;
    private Cliente cliente;
    private ArrayList<Apolice> apolices;
    private String nome;
    private String email;

    public static ArrayList<Apolice> getApolices(Cliente c) {
        ArrayList<Apolice> apolices = c.getApolices();
        return apolices;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setUpToolbar();
        // Nav Drawer
        mNavDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_fragment);
        // configura o drawer layout
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavDrawerFragment.setUp(drawerLayout);
        //cor de fundo da barra de status
        drawerLayout.setStatusBarBackground(R.color.dark_primary_color);
        cliente = (Cliente) getIntent().getSerializableExtra("cliente");
        apolices = (ArrayList<Apolice>) getIntent().getSerializableExtra("apolices");
        //preenche o cabecalho com o logo, nome e email.
        RelativeLayout navigationView = (RelativeLayout) findViewById(R.id.containerNavDrawerListViewHeader);

        nome = cliente.getNome();
        email = cliente.getEmail();

        ((TextView) navigationView.findViewById(R.id.tUserName)).setText(nome);
        ((TextView) navigationView.findViewById(R.id.tUserEmail)).setText(email);
        ((ImageView) navigationView.findViewById(R.id.imgUserPhoto)).setImageDrawable(getDrawable(R.mipmap.ic_launcher_auto_safe));
    }

    @Override
    public NavigationDrawerFragment.NavDrawerListView getNavDrawerView(NavigationDrawerFragment navDrawerFrag, LayoutInflater inflater, ViewGroup container) {
        View view = getLayoutInflater().inflate(R.layout.nav_drawer_listview, container, false);
        //deve retornar a view e o identificador do ListView
        return new NavigationDrawerFragment.NavDrawerListView(view, R.id.listView);
    }

    @Override
    public ListAdapter getNavDrawerListAdapter(NavigationDrawerFragment navDrawerFrag) {
        //este metodo deve retornar o adapter que vai preencher o ListView
        List<NavDrawerMenuItem> list = NavDrawerMenuItem.getList();
        //deixa o primeiro item selecionado
        list.get(0).selected = true;
        this.listAdapter = new NavDrawerMenuAdapter(this, list);
        return listAdapter;
    }

    @Override
    public void onNavDrawerItemSelected(NavigationDrawerFragment navDrawerFrag, int position) {
        //metodo chamado ao selecionar um item do ListView
        List<NavDrawerMenuItem> list = NavDrawerMenuItem.getList();
        NavDrawerMenuItem selectedItem = list.get(position);
        //seleciona a linha
        this.listAdapter.setSelected(position, true);

        switch (position) {
            case 0:
                // Dados a serem passados
                // ArrayList<Apolice> apolices = cliente.getApolices();
                Intent intent = new Intent(this, ApolicesFragment.class);
                intent.putExtra("apolices", apolices);
                //  startActivity(intent);
                // finish();
                replaceFragment(new ApolicesFragment());
                break;

            case 1:
                replaceFragment(new ChamadosFragment());
                break;

            case 2:
                replaceFragment(new ApolicesFragment());
                break;

            default:
                replaceFragment(new ApolicesFragment());
        }
        toast("Clicou no item:" + getString(selectedItem.title));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            toast("Clicou no sobre");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //adiciona o fragment no centro da tela
    private void replaceFragment(Fragment frag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_drawer_container, frag, "TAG").commit();
    }
}
