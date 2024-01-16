package com.example.retrofitapi;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    myAPI api;
    String url = "https://jsonplaceholder.typicode.com/";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        tv.setText("");

        //this will take the null value when running the patchMethod()
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(myAPI.class);

//        getModels();
//        postModels();
//        putModels();
        deleteMethod();
    }

    public void getModels(){
        Call<List<Model>> callGet = api.getModels();
        callGet.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> data = response.body();
                for (int i = 0; i < data.size(); i++) {
                    tv.append("ID: " + data.get(i).getId() + "\n Title: " + data.get(i).getTitle() + "\n Body: " + data.get(i).getBody() + "\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });
    }

    private void postModels() {
        Call<Model> callPost = api.postModels(10, "POST", "This is giant mushroom");
        callPost.enqueue(new Callback<Model>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model data = response.body();
                tv.setText("Code: " + response.code() + "\n ID: " + data.getId() + "\n Title: " + data.getTitle() + "\n Body: " + data.getBody() + "\n\n\n");
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });
    }

    private void putModels() {
        Model model = new Model(12, null, "This is a giant shark");
        Call<Model> callPut = api.putModels(5, model); //Change the method as needed, use putModels() or patchModels()
        callPut.enqueue(new Callback<Model>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model data = response.body();
                tv.setText("Code: " + response.code() + "\n ID: " + data.getId() + "\n Title: " + data.getTitle() + "\n Body: " + data.getBody() + "\n\n\n");
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });
    }

    private void deleteMethod() {
        Call<Void> callDelete = api.deleteMethod(5);
        callDelete.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                tv.setText("Code: " + response.code());
                Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });
    }
}