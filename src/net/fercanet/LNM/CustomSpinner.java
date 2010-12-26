package net.fercanet.LNM;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.Spinner;

public class CustomSpinner extends Spinner {
	
	public CustomSpinner(Context context, AttributeSet attrs) {
	    super(context, attrs);
	}   
	
	public CustomSpinner(Context context) {
	    super(context);
	}

	public void setSelectionByItemId(AdapterView<?> parent, long id){
		for (int i = 0; i < parent.getCount(); i++) {              
	          long itemIdAtPosition = parent.getItemIdAtPosition(i);
	          if (itemIdAtPosition == id) {
	        	  parent.setSelection(i);
	        	  break;
	          }
		}
	}
	
	
}