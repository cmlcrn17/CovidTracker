package com.cmlcrn17.covidtracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoronaCountry {

    @SerializedName("country")
    @Expose
    public String country;

    @SerializedName("totalcases")
    @Expose
    public String totalCases;

    @SerializedName("newCases")
    @Expose
    public String newCases;

    @SerializedName("totaldeaths")
    @Expose
    public String totalDeaths;

    @SerializedName("newDeaths")
    @Expose
    public String newDeaths;

    @SerializedName("totalRecovered")
    @Expose
    public String totalRecovered;

    @SerializedName("activeCases")
    @Expose
    public String activeCases;


    public CoronaCountry(String country, String totalcases, String newCases, String totalDeaths, String newDeaths, String totalRecovered, String activeCases) {
        this.country = country;
        this.totalCases = totalcases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.activeCases = activeCases;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTotalcases() {
        return totalCases;
    }

    public void setTotalcases(String totalcases) {
        this.totalCases = totalcases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getTotaldeaths() {
        return totalDeaths;
    }

    public void setTotaldeaths(String totaldeaths) {
        this.totalDeaths = totaldeaths;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }
}
