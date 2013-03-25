package com.example.tabs;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Attributes.Name;
 
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
public class InboxActivity extends Activity {
 
    // List view
    private ListView lv;
 
    // Listview Adapter
    ArrayAdapter<String> adapter;
 
    // Search EditText
    EditText inputSearch;
 
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    
    
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
 
        // Listview Data
        String products[] = {"Matthew" , "Embong" , "Pudge" , "Jun" , "Teng" , "King"};
 
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        
 
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_view, R.id.product_name, products);
        lv.setAdapter(adapter);  
       
        inputSearch.addTextChangedListener(new TextWatcher() {
        	 
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                InboxActivity.this.adapter.getFilter().filter(cs);
            }
         
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
         
            }
         
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        }
        );
        
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), lv.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
				
			}
        	
        	
		});
 
    }
 
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }
 
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
 
        switch (item.getItemId())
        {

 
        case R.id.menu_favorite:
            Toast.makeText(InboxActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_search:
            Toast.makeText(InboxActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_cancel:
            Toast.makeText(InboxActivity.this, "Share is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_delete:
            Toast.makeText(InboxActivity.this, "Delete is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }

		
	    
 
}