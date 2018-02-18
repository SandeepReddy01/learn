package com.amar.org.getdata;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private DataAdapter dataAdapter;
    private List<Menu> menuList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        getMenu();
    }

    private void getMenu() {

        showProgressDialog();

        MenuApiClient.getApiService().getMenu().enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                dismissProgressDialog();

                if (response.isSuccessful()){
                    menuList = response.body();
                   ArrayList<Menu> dataList = new ArrayList<Menu>();

                    for (int i = 0; i < menuList.size(); i++){
                        dataList.add(new Menu(menuList.get(i).getId(),menuList.get(i).getName(),
                                menuList.get(i).getPrice(), menuList.get(i).getDesctiption(),
                                menuList.get(i).getThumbnail()));
                    }

                    dataAdapter = new DataAdapter(MainActivity.this, dataList);
                    recyclerView.setAdapter(dataAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                dismissProgressDialog();

                Toast.makeText(MainActivity.this, "Something went wrong, pls try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void showProgressDialog() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Processing");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    public void dismissProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }
}
