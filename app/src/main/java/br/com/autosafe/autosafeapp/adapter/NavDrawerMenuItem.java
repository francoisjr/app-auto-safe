package br.com.autosafe.autosafeapp.adapter;

import java.util.ArrayList;
import java.util.List;

import br.com.autosafe.autosafeapp.R;

/**
 * Created by François on 3/25/2016.
 */
public class NavDrawerMenuItem {

    //titulo: R.string.xxx
    public int title;
    //figura: R.drawable.xxx
    public int img;
    //para colocar um fundo cinza quando a linha está selecionada
    public boolean selected;

    public NavDrawerMenuItem(int title, int img) {
        this.title = title;
        this.img = img;
    }

    //cria a lista com os items de menu
    public static List<NavDrawerMenuItem> getList() {
        List<NavDrawerMenuItem> list = new ArrayList<NavDrawerMenuItem>();
        list.add(new NavDrawerMenuItem(R.string.home, R.drawable.ic_menu_manage));
        list.add(new NavDrawerMenuItem(R.string.consulta_chamados, R.drawable.ic_menu_manage));
        list.add(new NavDrawerMenuItem(R.string.oficinas, R.drawable.ic_menu_manage));
        list.add(new NavDrawerMenuItem(R.string.meus_dados, R.drawable.ic_menu_manage));
        list.add(new NavDrawerMenuItem(R.string.config, R.drawable.ic_menu_manage));
        list.add(new NavDrawerMenuItem(R.string.ajuda, R.drawable.ic_menu_manage));
        list.add(new NavDrawerMenuItem(R.string.sobre, R.drawable.ic_menu_manage));
        list.add(new NavDrawerMenuItem(R.string.termos, R.drawable.ic_menu_manage));

        return list;
    }
}
