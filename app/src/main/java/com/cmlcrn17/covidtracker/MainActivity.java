package com.cmlcrn17.covidtracker;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView list;
    CoronaAdapter adapter;
    TextView valTotalCases;
    TextView valTotalDeaths;
    TextView valTotalRecovered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        list = (ListView) findViewById(R.id.list);
        valTotalCases = (TextView) findViewById(R.id.txt_totalCases);
        valTotalDeaths = (TextView) findViewById(R.id.txt_totalDeaths);
        valTotalRecovered = (TextView) findViewById(R.id.txt_totalRecovered);

        DownloadData downloadData = new DownloadData();

        try {

            String url = "http://www.putran.com/Corona/API/CoronaCountry";

            downloadData.execute(url);

        } catch (Exception e) {
        }
    }

    private class DownloadData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;

            try {

                url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();

                while (data > 0) {

                    char character = (char) data;
                    result += character;

                    data = inputStreamReader.read();
                }

                return result;

            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                //First Party Test Code
                //ArrayList<CoronaCountry> arrayList_coronaCountries;
                //Gson gson = new Gson();
                //arrayList_coronaCountries = gson.fromJson(s, new TypeToken<ArrayList<CoronaCountry>>() {}.getType());
                //System.out.println("CallCorona - Country:" + coronaCountries.get(1).activeCases);

                //CONVERT DATA
                CoronaCountry[] coronaCountries;
                Gson gson = new Gson();

                coronaCountries = gson.fromJson(s, new TypeToken<CoronaCountry[]>() {
                }.getType());

                //TOTAL CASES
                double totalCases = Calculate.calculate_TotalCase(coronaCountries);

                if (totalCases == 0) {
                    valTotalCases.setText("0");
                } else {
                    String value = String.valueOf(totalCases);
                    valTotalCases.setText((value.replace(".",",")).substring(0, 8));
                }

                //TOTAL DEATHS
                double totalDeaths = Calculate.calculate_TotalDeaths(coronaCountries);

                if (totalDeaths == 0) {
                    valTotalDeaths.setText("0");
                } else {
                    String value = String.valueOf(totalDeaths);
                    valTotalDeaths.setText((value.replace(".",",")).substring(0, 6));
                }

                //TOTAL RECOVERED
                double totalRecovered = Calculate.calculate_TotalRecovered(coronaCountries);

                if (totalRecovered == 0) {
                    valTotalRecovered.setText("0");
                } else {
                    String value = String.valueOf(totalRecovered);
                    valTotalRecovered.setText((value.replace(".",",")).substring(0, 7));
                }


                //LIST
                adapter = new CoronaAdapter(getApplicationContext(), R.layout.customcoronalist, coronaCountries);
                list.setAdapter(adapter);

            } catch (Exception e) {
                e.toString();
            }
        }
    }

    public void btn_Copied(View v) {

        ClipboardManager cm = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText("16C7ZTL15V2H5E4M3Zyc55czZj7uGePEt3");
        Toast.makeText(getApplicationContext(), "Copied to Bitcoin Adress ", Toast.LENGTH_SHORT).show();
    }
}
