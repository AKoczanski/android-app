package com.example.akproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    EditText city;
    TextView weather;
    TextView cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        city = (EditText)findViewById(R.id.cityName);
        weather = (TextView)findViewById(R.id.weatherView);
        cityName = (TextView) findViewById(R.id.cityView);
    }

    public void get(View v){
        String lookingCity = city.getText().toString();
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+lookingCity+"&appid=ddbf071c3cd3d6e5a1a9373851c1b8fe";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    JSONObject sys = response.getJSONObject("sys");
                    String temperature = object.getString("temp");
                    String countryName = sys.getString("country");
                    Double temp = Double.parseDouble(temperature) - 273.15;
                    weather.setText(temp.toString().substring(0,4) + " degrees Celsius");
                    cityName.setText("Country: " + countryName);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Invalid city name!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WeatherActivity.this, "Invalid city name!", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
}

