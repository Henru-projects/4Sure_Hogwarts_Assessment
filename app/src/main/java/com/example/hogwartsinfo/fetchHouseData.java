package com.example.hogwartsinfo;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchHouseData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed ="";
    String schoolGriff ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //Getting json
            URL url = new URL("https://www.potterapi.com/v1/houses?key=%242a%2410%241JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP%2FIUZWIVwfsaF7y");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //Getting data without parsing
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            //parsing
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i<JA.length(); i++)
            {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  "Name: " + JO.get("name") + "\n" +
                                "School: " + "Hogwarts" + "\n" +
                                "Mascot: " + JO.get("mascot") + "\n" +
                                "Head of House: " + JO.get("headOfHouse") + "\n" +
                                "House Ghost: " + JO.get("houseGhost") + "\n" +
                                "Founder: " + JO.get("founder") + "\n" +
                                "Values: " + JO.get("values") + "\n" +
                                "Colours: " + JO.get("colors")  + " " + " " +
                                "↓" + "\n";

                dataParsed = dataParsed + singleParsed + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        HousesMain.houseData.setText(this.dataParsed);
    }
}
