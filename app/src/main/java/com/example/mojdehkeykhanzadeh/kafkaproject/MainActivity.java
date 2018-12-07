package com.example.mojdehkeykhanzadeh.kafkaproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
private EditText text1;
private EditText text2;
private EditText text3;
private String topic1;
private String topic2;
private String topic3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSave1 = (Button) findViewById(R.id.buttonSend1);
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Stream started", Toast.LENGTH_SHORT).show();
                saveTopic1();
            }
        });
        Button btnSave2= (Button) findViewById(R.id.buttonSend2);
        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Stream started", Toast.LENGTH_SHORT).show();
                saveTopic2();
            }
        });
        Button btnSave3= (Button) findViewById(R.id.buttonSend3);
        btnSave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Stream started", Toast.LENGTH_SHORT).show();
                saveTopic3();
            }
        });

    }
    public void saveTopic1(){
        String URL = "endpoint1";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        text1 = findViewById(R.id.editText1);
        topic1 = text1.getText().toString();

        StringRequest objectRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", response);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                response, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                    }) {
                        // this is the relevant method
                        @Override
                        public byte[] getBody() {
                            String httpPostBody=topic1 ;
                            return httpPostBody.getBytes();
                        }

                };
        requestQueue.add(objectRequest);
    }
    public void saveTopic2(){
        String URL = "endpoint2";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        text2 = findViewById(R.id.editText2);
        topic2 = text2.getText().toString();

        StringRequest objectRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", response);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                response, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }) {
            // this is the relevant method
            @Override
            public byte[] getBody() {
                String httpPostBody=topic2 ;
                return httpPostBody.getBytes();
            }

        };
        requestQueue.add(objectRequest);
    }
    public void saveTopic3(){
        String URL = "endpoint3";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        text3 = findViewById(R.id.editText3);
        topic3=text3.getText().toString();

        StringRequest objectRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", response);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                response, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }) {
            // this is the relevant method
            @Override
            public byte[] getBody() {
                String httpPostBody= topic3;
                return httpPostBody.getBytes();
            }

        };
        requestQueue.add(objectRequest);
    }



}
