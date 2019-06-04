package br.com.digitalhouse.recyclerviewlistener.contacts.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.digitalhouse.recyclerviewlistener.R;
import br.com.digitalhouse.recyclerviewlistener.contacts.model.Contact;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Contact contact = getIntent().getParcelableExtra("CONTACT");

            if (contact != null) {

            }
        }
    }
}
