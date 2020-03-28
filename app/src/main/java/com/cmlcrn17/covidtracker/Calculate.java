package com.cmlcrn17.covidtracker;

public class Calculate {

    //TOTAL CASE CALCULATOR
    public static double calculate_TotalCase(CoronaCountry[] coronaCountries) {

        double valueTotalCases;
        valueTotalCases = 000.000;

        try {

            for (int i = 0; i <= coronaCountries.length; i++) {

                if (coronaCountries[i].totalCases == "" || coronaCountries[i].totalCases == null || coronaCountries[i].totalCases.isEmpty()) {
                    coronaCountries[i].totalCases = "0";
                }

                if (coronaCountries[i].totalCases.contains(",")) {
                    coronaCountries[i].totalCases = coronaCountries[i].totalCases.replace(",", ".");
                } else if (coronaCountries[i].totalCases.length() == 3) {
                    coronaCountries[i].totalCases = "000." + coronaCountries[i].totalCases;
                } else if (coronaCountries[i].totalCases.length() == 2) {
                    coronaCountries[i].totalCases = "000.0" + coronaCountries[i].totalCases;
                } else if (coronaCountries[i].totalCases.length() == 1) {
                    coronaCountries[i].totalCases = "000.00" + coronaCountries[i].totalCases;
                } else {
                    coronaCountries[i].totalCases = coronaCountries[i].totalCases;
                }

                valueTotalCases = valueTotalCases + Double.parseDouble(coronaCountries[i].totalCases.replace(",", "."));
                //System.out.println("CALL TOTAL CASE - Sayac :" + " " + i + " Ülke: " + coronaCountries[i].country + "  TotalCase: " + coronaCountries[i].totalCases + " Total: " + valueTotalCases);
            }

        } catch (Exception e) {
            e.toString();
        }

        return valueTotalCases;
    }

    //TOTAL DEATHS CALCULATOR
    public static double calculate_TotalDeaths(CoronaCountry[] coronaCountries) {

        double valueTotalDeaths;
        valueTotalDeaths = 0.0;

        try {

            for (int i = 0; i <= coronaCountries.length; i++) {

                if (coronaCountries[i].totalDeaths == "" || coronaCountries[i].totalDeaths == null || coronaCountries[i].totalDeaths.isEmpty()) {
                    coronaCountries[i].totalDeaths = "0";
                }

                if (coronaCountries[i].totalDeaths.contains(",")) {
                    coronaCountries[i].totalDeaths = coronaCountries[i].totalDeaths.replace(",", ".");
                } else if (coronaCountries[i].totalDeaths.length() == 3) {
                    coronaCountries[i].totalDeaths = "000." + coronaCountries[i].totalDeaths;
                } else if (coronaCountries[i].totalDeaths.length() == 2) {
                    coronaCountries[i].totalDeaths = "000.0" + coronaCountries[i].totalDeaths;
                } else if (coronaCountries[i].totalDeaths.length() == 1) {
                    coronaCountries[i].totalDeaths = "000.00" + coronaCountries[i].totalDeaths;
                } else {
                    coronaCountries[i].totalDeaths = coronaCountries[i].totalDeaths;
                }

                valueTotalDeaths = valueTotalDeaths + Double.parseDouble(coronaCountries[i].totalDeaths.replace(",", "."));
                //System.out.println("CALL TOTAL CASE - Sayac :" + " " + i + " Ülke: " + coronaCountries[i].country + "  TotalCase: " + coronaCountries[i].totalDeaths + " Total: " + valueTotalDeaths);
            }

        } catch (Exception e) {
            e.toString();
        }

        return valueTotalDeaths;
    }

    //TOTAL RECOVERED CALCULATOR
    public static double calculate_TotalRecovered(CoronaCountry[] coronaCountries) {

        double valueTotalRecovered;
        valueTotalRecovered = 0.0;

        try {

            for (int i = 0; i <= coronaCountries.length; i++) {

                if (coronaCountries[i].totalRecovered == "" || coronaCountries[i].totalRecovered == null || coronaCountries[i].totalRecovered.isEmpty()) {
                    coronaCountries[i].totalRecovered = "0";
                }

                if (coronaCountries[i].totalRecovered.contains(",")) {
                    coronaCountries[i].totalRecovered = coronaCountries[i].totalRecovered.replace(",", ".");
                } else if (coronaCountries[i].totalRecovered.length() == 3) {
                    coronaCountries[i].totalRecovered = "000." + coronaCountries[i].totalRecovered;
                } else if (coronaCountries[i].totalRecovered.length() == 2) {
                    coronaCountries[i].totalRecovered = "000.0" + coronaCountries[i].totalRecovered;
                } else if (coronaCountries[i].totalRecovered.length() == 1) {
                    coronaCountries[i].totalRecovered = "000.00" + coronaCountries[i].totalRecovered;
                } else {
                    coronaCountries[i].totalRecovered = coronaCountries[i].totalRecovered;
                }

                valueTotalRecovered = valueTotalRecovered + Double.parseDouble(coronaCountries[i].totalRecovered.replace(",", "."));
                //System.out.println("CALL TOTAL CASE - Sayac :" + " " + i + " Ülke: " + coronaCountries[i].country + "  TotalCase: " + coronaCountries[i].totalRecovered + " Total: " + valueTotalRecovered);
            }

        } catch (Exception e) {
            e.toString();
        }

        return valueTotalRecovered;
    }
}
