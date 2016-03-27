package br.com.autosafe.autosafeapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.autosafe.autosafeapp.R;
import br.com.autosafe.autosafeapp.domain.Apolice;

/**
 * Created by François on 3/25/2016.
 */

// Herda de RecyclerView.Adapter e declara o tipo genérico <ApoliceAdapter.ApoliceViewHolder>
public class ApoliceAdapter extends RecyclerView.Adapter<ApoliceAdapter.ApolicesViewHolder> {

    private final List<Apolice> apolices;
    private final Context context;


    private ApoliceOnClickListener apoliceOnClickListener;

    public ApoliceAdapter(Context context, List<Apolice> apolices, ApoliceOnClickListener apoliceOnClickListener) {
        this.context = context;
        this.apolices = apolices;
        this.apoliceOnClickListener = apoliceOnClickListener;
    }

    @Override
    public int getItemCount() {
        return this.apolices != null ? this.apolices.size() : 0;
    }

    @Override
    public ApolicesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Infla a view do layout
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_apolice, viewGroup, false);

        CardView cardView = (CardView) view.findViewById(R.id.card_view);

        // Cria o ViewHolder
        ApolicesViewHolder holder = new ApolicesViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final ApolicesViewHolder holder, final int position) {
        // Atualiza a view
        Apolice a = apolices.get(position);

        holder.tNumApolice.setText(a.getId());
        holder.tModeloCarro.setText(a.getVeiculo().getModelo());
        holder.tDataApolice.setText(a.getDataValidade());

        holder.progress.setVisibility(View.VISIBLE);
        //faz o download da foto e mostra o progreesBar
        Picasso.with(context).load(R.drawable.carro_generico).fit().into(holder.img, new Callback() {
            @Override
            public void onSuccess() {
                holder.progress.setVisibility(View.GONE); //download ok
            }

            @Override
            public void onError() {
                holder.progress.setVisibility(View.GONE);
            }
        });
        // Click
        if (apoliceOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    apoliceOnClickListener.onClickApolice(holder.itemView, position); // A variável position é final
                }
            });
        }
    }

    public interface ApoliceOnClickListener {
        public void onClickApolice(View view, int idx);
    }


    // ViewHolder com as views
    public static class ApolicesViewHolder extends RecyclerView.ViewHolder {
        public TextView tNumApolice;
        public TextView tModeloCarro;
        public TextView tDataApolice;

        ImageView img;
        ProgressBar progress;
        CardView cardView;

        public ApolicesViewHolder(View view) {
            super(view);
            // Cria as views para salvar no ViewHolder
            tNumApolice = (TextView) view.findViewById(R.id.textNumApolice);
            tModeloCarro = (TextView) view.findViewById(R.id.textModeloCarro);
            tDataApolice = (TextView) view.findViewById(R.id.dataApolice);
            img = (ImageView) view.findViewById(R.id.img);
            progress = (ProgressBar) view.findViewById(R.id.progressImg);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }

}
