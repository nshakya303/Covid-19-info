package com.example.covid_19info.Fragment;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19info.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;


public class HomeFrag extends Fragment {


    TextView totalCase,totalDeath,totalRec,activeCases;
    View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_home, container, false);

        viewInit();
        getDataAPI();
        return view;
    }

    private void getDataAPI() {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        String url = "https://corona.lmao.ninja/v2/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);

                    totalCase.setText(jsonObject.getString("cases"));
                    activeCases.setText(jsonObject.getString("active"));
                    totalDeath.setText(jsonObject.getString("deaths"));
                    totalRec.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {

                    e.printStackTrace();

                    Toast.makeText(getActivity(),""+e,Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("tag",String.valueOf(error));
                Toast.makeText(getActivity(),""+error,Toast.LENGTH_LONG).show();

            }
        });

        requestQueue.add(stringRequest);
    }

    private void viewInit() {

        totalCase=view.findViewById(R.id.totalCaseN);
        activeCases=view.findViewById(R.id.activeCases);
        totalDeath=view.findViewById(R.id.totalDeathsN);
        totalRec=view.findViewById(R.id.totalRecoversN);

    }
}