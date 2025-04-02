package com.example.demorecycleview;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG= "OptionMenuExample";
    private SearchView searchView;

    private String lastQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu, menu);

        // If you want Icon display in Overflow Menu.
        // https://stackoverflow.com/questions/19750635/icon-in-menu-not-showing-in-android
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        this.searchView = (SearchView) menu.findItem(R.id.menuItem_search).getActionView();

        this.searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        // Need click "search" icon to expand SearchView.
        this.searchView.setIconifiedByDefault(true);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // Typing search text.
            public boolean onQueryTextChange(String newText) {
                // This is your adapter that will be filtered
                Log.i(LOG_TAG, "onQueryTextChange: " + newText);
                return true;
            }

            // Press Enter to search (Or something to search).
            public boolean onQueryTextSubmit(String query) {
                // IMPORTANT!
                // Prevent onQueryTextSubmit() method called twice.
                // https://stackoverflow.com/questions/34207670
                searchView.clearFocus();

                Log.i(LOG_TAG, "onQueryTextSubmit: " + query);
                return doSearch(query);
            }
        });

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "SearchView.onSearchClickListener!" );
            }
        }) ;

        return super.onCreateOptionsMenu(menu);
    }


    private boolean doSearch(String query) {
        if (query == null || query.isEmpty()) {
            return false; // Cancel search.
        }
        this.lastQuery = query;

        Toast.makeText(this, "Search: " + query, Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem_open:
                Toast.makeText(this, "Open ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_delete:
                Toast.makeText(this, "Delete ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_facebook:
                Toast.makeText(this, "Facebook Share ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_instagram:
                Toast.makeText(this, "Instagram Share ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_settings:
                Toast.makeText(this, "Settings ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_search:
                Log.i(LOG_TAG, "onOptionsItemSelected (R.id.menuItem_search)");
                Toast.makeText(this, "Search ...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}