//   -----------------------------------------------------------------------------
//    Copyright 2010 Ferran Caellas Puig

//    This file is part of Learn Music Notes.
//
//    Learn Music Notes is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.

//    Learn Music Notes is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.

//    You should have received a copy of the GNU General Public License
//    along with Learn Music Notes.  If not, see <http://www.gnu.org/licenses/>.
//   -----------------------------------------------------------------------------


package net.fercanet.LNM;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import net.fercanet.*;


public class Settings extends Activity {
	
	String hofentries;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        Button endgame = (Button) findViewById(R.id.endgame);
        endgame.setOnClickListener(ClickListener);
        
        
        
       // Spinner spinner = (Spinner) findViewById(R.id.sphofentries);
        
        CustomSpinner spinner = new CustomSpinner(this);
        
        spinner = (CustomSpinner) findViewById(R.id.sphofentries);
        
     //   Spinner spinner = new Spinner(this);
        
     //   spinner = (Spinner) findViewById(R.id.sphofentries);
        
           
        
        ArrayAdapter adapter = ArrayAdapter.createFromResource( this, R.array.hofentries_array , android.R.layout.simple_spinner_dropdown_item); adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
     //   spinner.setOnItemSelectedListener(ItemSelectedListener);
     //   spinner.setSelectionByItemId(spinner, 3);
        



        
        
    }
    
    
    // Click listener for exit button
    OnClickListener ClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			
			SharedPreferences settings = getPreferences(0);
		    SharedPreferences.Editor editor = settings.edit();
		    
		    Spinner spinner = (Spinner) findViewById(R.id.sphofentries);
		    spinner.getItemAtPosition(1);
		    editor.putString("hofentries", hofentries);
			
		    moveTaskToBack(true);
		}
    };
    
    
    // OnItemSelectedListener for sphofentries (spinner with the number of hall of fame entries)
    OnItemSelectedListener ItemSelectedListener = new OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			hofentries = parent.getItemAtPosition(pos).toString();	
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
		
    }; 
    
    
   
	
}






