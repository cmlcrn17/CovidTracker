package com.cmlcrn17.covidtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CoronaAdapter extends ArrayAdapter<CoronaCountry> {

    private CoronaCountry[] coronaList;
    private int resource;
    private Context context;

    public CoronaAdapter(@NonNull Context context, int resource, @NonNull CoronaCountry[] coronaList) {
        super(context, resource, coronaList);
        this.resource = resource;
        this.coronaList = coronaList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View item;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        item = layoutInflater.inflate(resource, null);

        /*ImageView flag = (ImageView) item.findViewById(R.id.img_Flag);*/
        TextView country = (TextView) item.findViewById(R.id.txt_Country);
        TextView totalcases = (TextView) item.findViewById(R.id.txt_TotalCases);
        //TextView newCases = (TextView) item.findViewById(R.id.txt_NewCases);
        TextView activeCases = (TextView) item.findViewById(R.id.txt_ActiveCases);
        TextView totaldeaths = (TextView) item.findViewById(R.id.txt_TotalDeaths);
        //TextView newDeaths = (TextView) item.findViewById(R.id.txt_NewDeaths);
        TextView totalRecovered = (TextView) item.findViewById(R.id.txt_TotalRecovered);


        CoronaCountry coronaClass = coronaList[position];

        /*if (coronaClass.country.trim() == "China") {
            flag.setImageResource(R.mipmap.china_foreground);
        } else if (coronaClass.country.trim() == "Italy") {
            flag.setImageResource(R.mipmap.italy_foreground);
        }*/

        country.setText("Country                        : " + coronaClass.country);
        totalcases.setText("Total Cases                 : " + coronaClass.totalCases);
        //newCases.setText(coronaClass.newCases);
        activeCases.setText("Active Cases              : " + coronaClass.activeCases);
        totaldeaths.setText("Total Deaths               : " + coronaClass.totalDeaths);
        //newDeaths.setText(coronaClass.newDeaths);
        totalRecovered.setText("Total Recovered        : " + coronaClass.totalRecovered);

        return item;
    }


}
