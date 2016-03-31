package br.com.autosafe.autosafeapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.autosafe.autosafeapp.R;
import br.com.autosafe.autosafeapp.activity.ApoliceActivity;
import br.com.autosafe.autosafeapp.adapter.ApoliceAdapter;
import br.com.autosafe.autosafeapp.domain.Apolice;
import livroandroid.lib.fragment.BaseFragment;

/**
 * Created by François on 3/25/2016.
 */
public class ApolicesFragment extends BaseFragment {

    protected RecyclerView recyclerView;
    private ArrayList<Apolice> apolices;
    private LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apolices, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDados();
    }

    private void taskDados() {
        //busca os dados necessarios para abrir a home(cliente e dependentes, login, apolices, veiculo)
        this.apolices = (ArrayList<Apolice>) getActivity().getIntent().getSerializableExtra("apolices");
        //atualiza a lista
        recyclerView.setAdapter(new ApoliceAdapter(getContext(), apolices, onClickApolice()));
    }

    private ApoliceAdapter.ApoliceOnClickListener onClickApolice() {
        return new ApoliceAdapter.ApoliceOnClickListener() {
            @Override
            public void onClickApolice(View view, int idx) {
                Apolice a = apolices.get(idx);
                Toast.makeText(getContext(), "Apolice: " + a.getId(), Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getContext(), ApoliceActivity.class);
                intent.putExtra("apolice", a);
                startActivity(intent);
                Toast.makeText(getContext(), "Apolice: " + a.getId(), Toast.LENGTH_SHORT).show();
            }
        };
    }

}
