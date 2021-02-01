package com.example.covid_19info.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19info.Adapter.CountryAdapter;
import com.example.covid_19info.Model.CountryModel;
import com.example.covid_19info.Model.StateModel;
import com.example.covid_19info.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CountryFrag extends Fragment {

    RecyclerView recyclerView;
    ArrayList<CountryModel> arrayList;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_country, container, false);

        viewInit();
        getCountryDataAPI();

        return view;
    }

    private void getCountryDataAPI() {

        String url = "https://corona.lmao.ninja/v2/countries?yesterday&sort";

        arrayList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray jsonArray = new JSONArray(response);


                    for(int i=0;i<jsonArray.length();i++){

                        JSONObject data = jsonArray.getJSONObject(i);


                        arrayList.add(new CountryModel(data.getString("country"),data.getString("cases")));

                    }viewInit();


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

        Volley.newRequestQueue(getActivity()).add(stringRequest);

    }

    private void viewInit() {

        recyclerView = view.findViewById(R.id.recyclerViewCountry);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CountryAdapter countryAdapter = new CountryAdapter(arrayList);
        recyclerView.setAdapter(countryAdapter);

    }
}