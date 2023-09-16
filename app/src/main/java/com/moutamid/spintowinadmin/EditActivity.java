package com.moutamid.spintowinadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class EditActivity extends AppCompatActivity {
    DataModel dataModel;
    Integer max, exchange, withdrawlimit;
    String merchantapi;
    Boolean manualpay;

    EditText MaxLimit, ExchangeRate, WithdrawLimit, MerchantAPI;
    Switch switchManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        MaxLimit = findViewById(R.id.maxLimit);
        ExchangeRate = findViewById(R.id.exchangeRate);
        WithdrawLimit = findViewById(R.id.withdrawLimit);
        MerchantAPI = findViewById(R.id.merchantAPI);
        switchManual = findViewById(R.id.switchManual);

        fetchData();
    }

    private void fetchData() {
        DatabaseReference reference = Constants.databaseReference().child("configData");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    dataModel = dataSnapshot.getValue(DataModel.class);
                    if (dataModel != null) {
                        max = dataModel.getMaxAvail();
                        exchange = dataModel.getExchangeRate();
                        withdrawlimit = dataModel.getWithdrawLimit();
                        merchantapi = dataModel.getMerchantAPI();
                        manualpay = dataModel.getManualVisible();

                        // Set the EditText fields and radio buttons here
                        MaxLimit.setText(String.valueOf(max));
                        ExchangeRate.setText(String.valueOf(exchange));
                        WithdrawLimit.setText(String.valueOf(withdrawlimit));

                        byte[] byteData = Base64.decode(merchantapi, Base64.DEFAULT);
                        String decodedAPI = new String(byteData);
                        MerchantAPI.setText(decodedAPI);

                        if (manualpay) {
                            switchManual.setChecked(true);
                        } else {
                            switchManual.setChecked(false);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle the error if needed
            }
        });
    }

    public void submitBtnClick(View view) {
        String max = MaxLimit.getText().toString().trim();
        String exchange = ExchangeRate.getText().toString().trim();
        String withdrawLimit = WithdrawLimit.getText().toString().trim();
        String merchantapi = MerchantAPI.getText().toString().trim();

        if (TextUtils.isEmpty(max) || TextUtils.isEmpty(exchange) || TextUtils.isEmpty(withdrawLimit) || TextUtils.isEmpty(merchantapi)) {
            Toast.makeText(EditActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Get a reference to the main node where you want to update the data
            DatabaseReference reference = Constants.databaseReference();

            // Create a new child node called "configData"
            DatabaseReference configDataRef = reference.child("configData");

            // Update the fields under "configData"
            configDataRef.child("currentAvail").setValue(Integer.valueOf(max));
            configDataRef.child("exchangeRate").setValue(Integer.valueOf(exchange));
            configDataRef.child("withdrawLimit").setValue(Integer.valueOf(withdrawLimit));

            String data = merchantapi;
            byte[] byteData = data.getBytes();
            String base64EncodedData = Base64.encodeToString(byteData, Base64.DEFAULT);
            configDataRef.child("merchantAPI").setValue(base64EncodedData);

            boolean isSwitchOn = switchManual.isChecked();

            configDataRef.child("manualVisible").setValue(isSwitchOn);

            Toast.makeText(EditActivity.this, "Changes have been made to the database", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
