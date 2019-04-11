package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
/**
 * @author      Malik Alwan
 * @version     1.1
 * @since       1.2
 */
public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();

    /**
     * Setup for the edit text variables
     *
     * @param  savedInstanceState of Bundle
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }

    /**
     * Setup for the edit text variables
     *
     * @param  v View
     * @return void
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
        //AsyncWeatherDownloader.doInBackground(getLocation(), this);
    }

    /**
     * Sets temp variable
     *
     * @param  newTemp
     * @return void
     */
    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }

    /**
     * Sets the Wind variable
     *
     * @param  newWind
     * @return void
     */
    public void setWind(String newWind) {
        etWind.setText(newWind);
    }

    /**
     * Gets the  Location variable
     *
     * @return location
     */
    public String getLocation() {
        return etLoc.getText().toString();
    }


    /**
     * Sets a new status
     *
     * @param  newStatus
     * @return void
     */
    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}