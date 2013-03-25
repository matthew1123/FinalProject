package com.example.tabs;
 
import android.app.ListActivity;
import android.os.Bundle;
 
public class OutboxActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outbox);
    }
}