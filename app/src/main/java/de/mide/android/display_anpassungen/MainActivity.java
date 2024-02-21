package de.mide.android.display_anpassungen;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;


/**
 * Demo zur verschiedenen Möglichkeiten, eine App an verschiedene
 * Bildschirm-Größen/Ausrichtungen anzupassen.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity {

    /**
     * Lifecycle-Methode für Aufbau der UI.
     * Liest Display-Metrics aus und schreibt sie in TextView.
     * Wird neu ausgeführt, wenn Display gedreht wird
     * (im Simualtor: STRG+PfeilLinks).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // *** DisplayMetrics-Objekt abfragen ***
        WindowManager  windowManager = getWindowManager();
        Display        display       = windowManager.getDefaultDisplay();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        // *** Display-Eigenschaften auslesen ***
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("x_pixels=" + displayMetrics.widthPixels  + ", " );
        stringBuffer.append("y_pixels=" + displayMetrics.heightPixels + "\n" );

        stringBuffer.append("x_dpi=" + displayMetrics.xdpi + ", " );
        stringBuffer.append("y_dpi=" + displayMetrics.ydpi + "\n" );

        stringBuffer.append("Density: ");

        switch (displayMetrics.densityDpi) {

            case DisplayMetrics.DENSITY_LOW:    // 120 dpi
                stringBuffer.append("LOW");
                break;
            case DisplayMetrics.DENSITY_MEDIUM: // 160 dpi = DisplayMetrics.DENSITY_DEFAULT
                stringBuffer.append("MEDIUM");
                break;
            case DisplayMetrics.DENSITY_TV:     // 213 dpi
                stringBuffer.append("TV");
                break;
            case DisplayMetrics.DENSITY_HIGH:   // 240 dpi
                stringBuffer.append("HIGH");
                break;
            case DisplayMetrics.DENSITY_XHIGH:  // 320 dpi
                stringBuffer.append("XHIGH");
                break;
            case DisplayMetrics.DENSITY_XXHIGH: // 480 dpi
                stringBuffer.append("XXHIGH");
                break;
            default:
                stringBuffer.append("Unexpected value");
        }
        stringBuffer.append(" (ca. " + displayMetrics.densityDpi + " DPI)\n");

        stringBuffer.append("Logical Density: " + displayMetrics.density + "\n");
        // This is a scaling factor for the Density Independent Pixel unit,
        // where one DIP is one pixel on an approximately 160 dpi screen.

        TextView textView = findViewById(R.id.textview_mit_metriken);
        textView.setText(stringBuffer);
    }

};
