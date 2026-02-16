package com.pointdoacai.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pointdoacai.R;
import com.pointdoacai.model.Produto;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    private List<Produto> listaProdutos;

    public ProdutoAdapter(List<Produto> lista) {
        this.listaProdutos = lista;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_produto, parent, false);
        return new ProdutoViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = listaProdutos.get(position);
        holder.nome.setText(produto.getNome());
        holder.preco.setText(String.format("R$ %.2f", produto.getPreco()));
        holder.imagem.setImageResource(produto.getImagemResId());
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder {
        TextView nome, preco;
        ImageView imagem;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNomeProduto);
            preco = itemView.findViewById(R.id.textPrecoProduto);
            imagem = itemView.findViewById(R.id.imageProduto);
        }
    }
}