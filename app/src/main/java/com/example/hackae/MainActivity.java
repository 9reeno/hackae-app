package com.example.hackae;

import java.util.Set;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter BA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BA = BluetoothAdapter.getDefaultAdapter();

        // If BA is null, that means that the user's phone does not have BT support
        if (BA == null) {
            Toast.makeText(getApplicationContext(), "Bluetooth not supported", Toast.LENGTH_LONG).show();
            return;
        }

        // Prompt user to enable Bluetooth, if it's not enabled already
        if (!BA.isEnabled()) {
            Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetoothIntent, 1);
        }

        Set<BluetoothDevice> devices = BA.getBondedDevices();
    }
}
