package br.com.digitalhouse.recyclerviewlistener.contacts.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.recyclerviewlistener.R;
import br.com.digitalhouse.recyclerviewlistener.contacts.RecyclerViewClickListerner;
import br.com.digitalhouse.recyclerviewlistener.contacts.model.Contact;

public class RecyclerViewContactsAdapter extends RecyclerView.Adapter<RecyclerViewContactsAdapter.ViewHolder> {

    private List<Contact> contacts;
    private RecyclerViewClickListerner listerner;

    public RecyclerViewContactsAdapter(List<Contact> contacts, RecyclerViewClickListerner listerner) {
        this.contacts = contacts;
        this.listerner = listerner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_recyclerview_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Contact contact = contacts.get(position);
        viewHolder.bind(contact);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listerner.onClick(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewFoto;
        private TextView textViewNome;
        private TextView textViewTelefone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewTelefone = itemView.findViewById(R.id.textViewTelefone);
        }

        public void bind(Contact contact){
            imageViewFoto.setImageDrawable(ContextCompat.getDrawable(imageViewFoto.getContext(), contact.getFoto()));
            textViewNome.setText(contact.getNome());
            textViewTelefone.setText(contact.getNumero());
        }
    }
}
