package com.moutamid.spintowinadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {
    List<MyData> dataList = new ArrayList<>();
    private static final String TAG = "RequestActivity"; // Add this line

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        DatabaseReference reference = Constants.databaseReference();
        DatabaseReference withdrawRequestData = reference.child("WithdrawRequests");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(dataList); // Replace with your data
        recyclerView.setAdapter(adapter);

        withdrawRequestData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataList.clear(); // Clear the list to avoid duplicating data

                for (DataSnapshot idSnapshot : dataSnapshot.getChildren()) {
                    // Get the unique ID
                    String uniqueId = idSnapshot.getKey();

                    // Retrieve "mobileNumber" and "withdrawalAmount" from the child node with the unique ID
                    String Number = idSnapshot.child("mobileNumber").getValue(String.class);
                    Integer Amount = idSnapshot.child("withdrawalAmount").getValue(Integer.class);


                    if (Number != null && Amount != null) {
                        MyData item = new MyData(uniqueId, Number, Amount);
                        dataList.add(item);
                    }
                }

                if (dataList.size() > 0) {
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle the case where no data was found
                    Log.d(TAG, "No data found in Firebase.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database read errors if needed.
                Log.e(TAG, "Firebase database error: " + databaseError.getMessage());
            }
        });
    }
}
