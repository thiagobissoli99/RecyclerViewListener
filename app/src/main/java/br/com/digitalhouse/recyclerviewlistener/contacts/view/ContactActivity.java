package br.com.digitalhouse.recyclerviewlistener.contacts.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.recyclerviewlistener.R;
import br.com.digitalhouse.recyclerviewlistener.contacts.RecyclerViewClickListerner;
import br.com.digitalhouse.recyclerviewlistener.contacts.adapters.RecyclerViewContactsAdapter;
import br.com.digitalhouse.recyclerviewlistener.contacts.model.Contact;

public class ContactActivity extends AppCompatActivity implements RecyclerViewClickListerner {

    private RecyclerView recyclerView;
    private RecyclerViewContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewContactsAdapter(getContacts(), this);
        recyclerView.setAdapter(adapter);
    }

    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Mateus", "31-987049498", R.drawable.pp));
        contacts.add(new Contact("Nika", "31-987049498", R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Psyco", "31-987049498", R.drawable.pp));
        contacts.add(new Contact("Matias", "31-987049498", R.mipmap.ic_launcher_round));
        contacts.add(new Contact("Sycotias", "31-987049498", R.drawable.pp));
        contacts.add(new Contact("Outro", "31-987049498", R.mipmap.ic_launcher_round));

        return contacts;
    }

    @Override
    public void onClick(Contact contact) {
        Intent intent = new Intent(this, ContactDetailActivity.class);
        intent.putExtra("CONTACT", contact);
        startActivity(intent);
    }
}
