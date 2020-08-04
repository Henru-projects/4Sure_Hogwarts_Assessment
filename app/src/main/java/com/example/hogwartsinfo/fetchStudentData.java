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

public class fetchStudentData extends AsyncTask<Void, Void, Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://www.potterapi.com/v1/characters?key=$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i = 0; i < JA.length(); i++)
            {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name:" + JO.get("name")+ "\n";
                               //"Role:" + JO.get("role")+ "\n";
                               //"House:" + JO.get("house")+ "\n";
                               //"School:" + JO.get("school")+ "\n";
                               //"Ministry of Magic:" + JO.get("ministryOfMagic")+ "\n" +
                               //"Order of the Phoenix:" + JO.get("orderOfThePhoenix")+ "\n" +
                               //"Dumbledores Army:" + JO.get("dumbledoresArmy")+ "\n" +
                               //"Death Eater:" + JO.get("deathEater")+ "\n" +
                               //"Blood Status:" + JO.get("bloodStatus")+ "\n" +
                               //"Species:" + JO.get("species")+ "\n";

                dataParsed = dataParsed + singleParsed + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        StudentMain.studentData.setText(this.dataParsed);
    }
}
