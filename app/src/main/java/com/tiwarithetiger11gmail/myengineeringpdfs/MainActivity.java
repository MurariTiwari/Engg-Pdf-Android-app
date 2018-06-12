package com.tiwarithetiger11gmail.myengineeringpdfs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private List<modal> modals;
    private RecyclerAdapter adapter;
    private apiInterface apiinterface;
    TextView t;
    String branch;
    int sem;
    String description="E BOOKS";
    static ReaquestBody user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t=(TextView)findViewById(R.id.title);
        Bundle b= getIntent().getExtras();
        branch=b.getString("branch");
        sem=b.getInt("sem");
        perform();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String url = "http://10.0.2.2:3000";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }
       else if(id==R.id.syll){
            Intent i=new Intent(this,WebView.class);
            i.putExtra("url","http:10.0.2.2:3000/asyllabus?sem="+sem+"&branch="+branch);
            startActivity(i);
        }

        else if(id==R.id.nptel)
        {
            String url = "http://nptel.ac.in/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }
        else if(id==R.id.ndl)
        {
            String url = "https://ndl.iitkgp.ac.in/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }
        else if(id==R.id.edx)
        {
            String url = "https://www.edx.org/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.syll) {
            description = "SYLLABUS";
        } else if (id == R.id.ebook) {
            description = "E BOOKS";
        } else if (id == R.id.notes) {
            description = "NOTES";
        } else if (id == R.id.qes) {
            description = "QUESTION PAPER";
        } else if (id == R.id.sol) {
            description = "SOLVED PAPER";
        } else if (id == R.id.prac) {
            description = "PRACTICAL FILES";
        }

        perform();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;


    }
        void perform(){

        t.setText(description);
        user= new ReaquestBody(sem,branch,description);
        recyclerView=(RecyclerView)findViewById(R.id.r_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        apiinterface=ApiClient.getApiClient().create(apiInterface.class);
        Call<List<modal>> call=apiinterface.getmodal(user);
        call.enqueue(new Callback<List<modal>>() {
                         @Override
                         public void onResponse(Call<List<modal>> call, Response<List<modal>> response) {
                             modals = response.body();
                             adapter = new RecyclerAdapter(modals, MainActivity.this);
                             recyclerView.setAdapter(adapter);
                             recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                                 @Override
                                 public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                                     return false;
                                 }

                                 @Override
                                 public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                                 }

                                 @Override
                                 public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                                 }
                             });
                         }

            @Override
            public void onFailure(Call<List<modal>> call, Throwable t) {

            }
        });

                   }}
