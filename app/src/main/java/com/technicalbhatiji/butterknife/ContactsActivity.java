/*
 * Copyright (c)  2017 Technical Bhati Ji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.technicalbhatiji.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Contact> contacts = new ArrayList<>();
    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // binding the view
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdapter = new ContactsAdapter(contacts);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareContacts();
    }

    private void prepareContacts() {
        String[] names = new String[]{"Keith Castro", "Emily Black", "Robert Hill",
                "Jack Ellis", "Christian Fowler", "Deborah Palmer", "Denise Fernandez",
                "Ashley Fisher", "Christopher Mills", "Jesse Vargas", "Albert Patel"};

        String[] mobiles = new String[]{"(164) 341 3502", "(340) 207 5511", "(114) 110 1910",
                "(323) 941 2554", "(976) 613 1516", "(218) 243 1078", "(168) 521 1663",
                "(424) 162 6385", "(538) 779 4107", "(639) 698 6701", "(782) 651 2715"};

        for (int i = 0; i < names.length; i++) {
            Contact contact = new Contact(names[i], mobiles[i]);
            contacts.add(contact);
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
