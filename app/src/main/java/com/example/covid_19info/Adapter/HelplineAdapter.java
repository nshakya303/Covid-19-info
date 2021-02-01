package com.example.covid_19info.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19info.Model.HelpModel;
import com.example.covid_19info.Model.StateModel;
import com.example.covid_19info.R;

import java.util.ArrayList;

public class HelplineAdapter extends RecyclerView.Adapter<HelplineAdapter.ViewHolder> {


    private ArrayList<HelpModel> arrayList;

    public HelplineAdapter(ArrayList<HelpModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HelplineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.state_helpline,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelplineAdapter.ViewHolder holder, int position) {

        HelpModel helpModel=arrayList.get(position);
        holder.stateName.setText(helpModel.getStateName());
        holder.helpNo.setText(helpModel.getHelpNo());

    }

    @Override
    public int getItemCount() {
        return arrayList!=null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView stateName,helpNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            helpNo=itemView.findViewById(R.id.helpNo);
            stateName=itemView.findViewById(R.id.stateHelpName);
        }
    }
}
