package br.com.autosafe.autosafeapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.autosafe.autosafeapp.R;
import br.com.autosafe.autosafeapp.domain.Apolice;
import livroandroid.lib.fragment.BaseFragment;

/**
 * Created by François on 3/27/2016.
 */
public class ApoliceFragment extends BaseFragment {

    private Apolice apolice;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apolice, container, false);
        return view;
    }

    // metodo publico chamado pela activity para atulizar os dados da apolice
    public void setApolice(Apolice apolice) {
        if (apolice != null) {
            this.apolice = apolice;
            setTextString(R.id.txtModelo, apolice.getVeiculo().getModelo());
            setTextString(R.id.txtChassi, apolice.getVeiculo().getChassi());
            setTextString(R.id.txtCor, apolice.getVeiculo().getCor());
            setTextString(R.id.txtFabricante, apolice.getVeiculo().getFabricante());
            setTextString(R.id.txtRastreador, apolice.getVeiculo().getPossuiRastreador());
            setTextString(R.id.txtAno, apolice.getVeiculo().getAno());
            setTextString(R.id.txtPlaca, apolice.getVeiculo().getPlaca());
            setTextString(R.id.txtRenavam, apolice.getVeiculo().getRenavam());
            setTextString(R.id.txtNumApolice, apolice.getId());
            setTextString(R.id.txtDataValidade, apolice.getDataValidade());
            setTextString(R.id.txtPernoite, apolice.getLocaldaPernoite());
            setTextString(R.id.txtDescUsoVeiculo, apolice.getDescricaoUsoVeiculo());
            setTextString(R.id.btChamado, "Abrir chamado");
            final ImageView imgView = (ImageView) getView().findViewById(R.id.img);
            Picasso.with(getContext()).load(R.drawable.carro_generico).fit().into(imgView);
        }
    }
}
