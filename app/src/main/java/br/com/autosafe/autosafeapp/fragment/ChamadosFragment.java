package br.com.autosafe.autosafeapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.autosafe.autosafeapp.R;
import livroandroid.lib.fragment.BaseFragment;

/**
 * Created by François on 3/25/2016.
 */
public class ChamadosFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chamados, container, false);
        return view;
    }

}
