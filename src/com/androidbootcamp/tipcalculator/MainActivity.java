package com.androidbootcamp.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnTenPercent = (Button) findViewById(R.id.btnTenPercent);
		btnTenPercent.setOnClickListener(new View.OnClickListener() {
		    
			@Override
		    public void onClick(View v) {
		    	Integer tipPercentage = 10;
		    	calculateTip(tipPercentage);
		    }
		});
		
		Button btnFifteenPercent = (Button) findViewById(R.id.btnFifteenPercent);
		btnFifteenPercent.setOnClickListener(new View.OnClickListener() {
		    
			@Override
		    public void onClick(View v) {
		    	Integer tipPercentage = 15;
		    	calculateTip(tipPercentage);
		    }
		});
		
		Button btnTwentyPercent = (Button) findViewById(R.id.btnTwentyPercent);
		btnTwentyPercent.setOnClickListener(new View.OnClickListener() {
		    
			@Override
		    public void onClick(View v) {
		    	Integer tipPercentage = 20;
		    	calculateTip(tipPercentage);
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void calculateTip(int tipPercentage) {
		EditText etTotal = (EditText) findViewById(R.id.etTotal);
		double tipMultiplier = tipPercentage / 100.0;
		double total = Double.valueOf(etTotal.getText().toString());
		double tip = Math.round((total * tipMultiplier) * 100.0) / 100.0;
		DecimalFormat decFormat = new DecimalFormat("$###,##0.00");
		String tipString = decFormat.format(tip);
		TextView tvTip = (TextView) findViewById(R.id.tvTipAmount);
		tvTip.setText(tipString);
	}

	
}
