package com.example.gatherwifi_new_down;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    /**
     * The wifi manager.
     */
    private WifiManager wifiManager;
    /**
     * The wifi info.
     */
    private WifiInfo wifiInfo;
    private static final int PERMISSIONS_REQUEST_CODE = 123;
    private TextView wifi;
    private final List<String> ALLOWED_SSIDS = Arrays.asList("TUD-facility", "tudelft-dastud", "eduroam");
    private String previousResult = "";  // to store the previous result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button C1 = (Button) findViewById(R.id.c1);
        Button C2 = (Button) findViewById(R.id.c2);
        Button C3 = (Button) findViewById(R.id.c3);
        Button C4 = (Button) findViewById(R.id.c4);
        Button C5 = (Button) findViewById(R.id.c5);
        Button C6 = (Button) findViewById(R.id.c6);
        Button C7 = (Button) findViewById(R.id.c7);
        Button C8 = (Button) findViewById(R.id.c8);
        Button C9 = (Button) findViewById(R.id.c9);
        Button C10 = (Button) findViewById(R.id.c10);
        Button C11 = (Button) findViewById(R.id.c11);
        Button C12 = (Button) findViewById(R.id.c12);
        Button C13 = (Button) findViewById(R.id.c13);
        Button C14 = (Button) findViewById(R.id.c14);
        Button C15 = (Button) findViewById(R.id.c15);
        Button C16 = (Button) findViewById(R.id.c16);
        Button refresh = (Button) findViewById(R.id.refresh);
        wifi = (TextView) findViewById(R.id.textView);

        // Set the wifi manager
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        // Request necessary permissions
        requestPermissions();

        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C1");
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C2");
            }
        });

        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C3");
            }
        });

        C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C4");
            }
        });

        C5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C5");
            }
        });

        C6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C6");
            }
        });

        C7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C7");
            }
        });

        C8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C8");
            }
        });

        C9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C9");
            }
        });

        C10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C10");
            }
        });

        C11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C11");
            }
        });

        C12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C12");
            }
        });

        C13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C13");
            }
        });

        C14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C14");
            }
        });

        C15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C15");
            }
        });

        C16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFI("C16");
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WIFIREFRESH("refresh");
            }
        });
    }

    private void requestPermissions() {
        // Check if Wi-Fi and location permissions are granted
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Request permissions
            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.CHANGE_WIFI_STATE,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMISSIONS_REQUEST_CODE);
        }
    }

    private void WIFI(String location) {
        // Check if the Wi-Fi feature is available
        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "Please enable Wi-Fi", Toast.LENGTH_SHORT).show();
            return;
        }
        // Set text.
        wifi.setText("\n\tScan all access points:");
        // Set wifi manager.
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        // Check if the necessary permissions are granted
        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(android.Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request permissions
            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.CHANGE_WIFI_STATE,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMISSIONS_REQUEST_CODE);
            return;
        }

        // Start a wifi scan
        boolean scanStarted = wifiManager.startScan();
        if (!scanStarted) {
            Toast.makeText(this, "Scan not started. Please try again.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get the scan results
        List<ScanResult> scanResults = wifiManager.getScanResults();

        // Filter and sort the scan results
        scanResults = scanResults.stream()
                .filter(scanResult -> ALLOWED_SSIDS.contains(scanResult.SSID)) // Filter allowed SSIDs
                .sorted((scanResult1, scanResult2) -> Integer.compare(scanResult2.level, scanResult1.level)) // Sort by RSSI level (descending)
                .collect(Collectors.toList());

        // Check if there are at least 20 access points
        if (scanResults.size() < 20) {
            Toast.makeText(this, "Not enough access points", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder resultFileBuilder = new StringBuilder();

        // Collect only first 20 results
        for (int i = 0; i < 20; i++) {
            ScanResult scanResult = scanResults.get(i);
            int rssi = scanResult.level;
            String bssid = scanResult.BSSID;

            // For TextView
            resultBuilder.append("SSID: ").append(scanResult.SSID).append(", BSSID: ").append(bssid).append(", RSSI: ").append(rssi).append("\n");
            // For File
            if (i == 0) resultFileBuilder.append(location).append("!");
            resultFileBuilder.append(bssid).append("!").append(rssi);
            if (i < 19) resultFileBuilder.append("!");
        }

        // Display the scan results
        wifi.setText(resultBuilder.toString());

        // Check if the result is same as the previous result
        if(resultFileBuilder.toString().equals(previousResult)) {
            Toast.makeText(this, "Data not changed", Toast.LENGTH_SHORT).show();
            return;
        } else {
            previousResult = resultFileBuilder.toString();
        }

        // Always save to "eastwest.csv"
        saveDataToFile(resultFileBuilder.toString(), "eastwest.csv");

        int sampleCount = countLocationInFile(location, "eastwest.csv");
        int samplesRequired = 200;
        int samplesLeft = samplesRequired - sampleCount;

        Toast.makeText(this, location + ", " + samplesLeft + " samples left for eastwest.csv", Toast.LENGTH_SHORT).show();

        // If the button is C4, C5 or C6, also save to "floors.csv" and "cells.csv"
        if ("C4".equals(location) || "C5".equals(location) || "C6".equals(location)) {
            saveDataToFile(resultFileBuilder.toString(), "floors.csv");
//            saveDataToFile(resultFileBuilder.toString(), "cells.csv");

            sampleCount = countLocationInFile(location, "floors.csv");
            samplesRequired = 300;
            samplesLeft = samplesRequired - sampleCount;

            Toast.makeText(this, location + ", " + samplesLeft + " samples left for floors.csv", Toast.LENGTH_SHORT).show();

//            sampleCount = countLocationInFile(location, "cells.csv");
//            samplesLeft = samplesRequired - sampleCount;
//
//            Toast.makeText(this, location + ", " + samplesLeft + " samples left for cells.csv", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveDataToFile(String data, String filename) {
        try {
            File documentsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File file = new File(documentsDirectory, filename);
            FileWriter writer = new FileWriter(file, true);
            writer.append(data).append("\n");
            writer.flush();
            writer.close();
            Toast.makeText(this, "Data saved in " + filename, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show();
        }
    }

    private int countLocationInFile(String location, String filename) {
        int count = 0;
        try {
            File documentsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File file = new File(documentsDirectory, filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(location)) {
                    count++;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error reading data", Toast.LENGTH_SHORT).show();
        }
        return count;
    }

    private void WIFIREFRESH(String location) {
        // Check if the Wi-Fi feature is available
        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "Please enable Wi-Fi", Toast.LENGTH_SHORT).show();
            return;
        }
        // Set text.
        wifi.setText("\n\tScan all access points:");
        // Set wifi manager.
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        // Check if the necessary permissions are granted
        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(android.Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request permissions
            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.CHANGE_WIFI_STATE,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMISSIONS_REQUEST_CODE);
            return;
        }

        // Start a wifi scan
        boolean scanStarted = wifiManager.startScan();
        if (!scanStarted) {
            Toast.makeText(this, "Scan not started. Please try again.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get the scan results
        List<ScanResult> scanResults = wifiManager.getScanResults();

        // Filter and sort the scan results
        scanResults = scanResults.stream()
                .filter(scanResult -> ALLOWED_SSIDS.contains(scanResult.SSID)) // Filter allowed SSIDs
                .sorted((scanResult1, scanResult2) -> Integer.compare(scanResult2.level, scanResult1.level)) // Sort by RSSI level (descending)
                .collect(Collectors.toList());

        // Check if there are at least 20 access points
        if (scanResults.size() < 20) {
            Toast.makeText(this, "Not enough access points", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder resultFileBuilder = new StringBuilder();

        // Collect only first 20 results
        for (int i = 0; i < 20; i++) {
            ScanResult scanResult = scanResults.get(i);
            int rssi = scanResult.level;
            String bssid = scanResult.BSSID;

            // For TextView
            resultBuilder.append("SSID: ").append(scanResult.SSID).append(", BSSID: ").append(bssid).append(", RSSI: ").append(rssi).append("\n");
            // For File
            if (i == 0) resultFileBuilder.append(location).append("!");
            resultFileBuilder.append(bssid).append("!").append(rssi);
            if (i < 19) resultFileBuilder.append("!");
        }

        // Display the scan results
        wifi.setText(resultBuilder.toString());

        // Check if the result is same as the previous result
        if(resultFileBuilder.toString().equals(previousResult)) {
            Toast.makeText(this, "Data not changed", Toast.LENGTH_SHORT).show();
            return;
        } else {
            previousResult = resultFileBuilder.toString();
        }

        // Choose the file name based on location
        String filename = "Refresh.csv";

        try {
            File documentsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File file = new File(documentsDirectory, filename);
            FileWriter writer = new FileWriter(file, true);
            writer.append(resultFileBuilder.toString()).append("\n");
            writer.flush();
            writer.close();
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show();
        }
    }
}