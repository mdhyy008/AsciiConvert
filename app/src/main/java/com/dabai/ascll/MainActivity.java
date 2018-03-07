package com.dabai.ascll;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import com.dabai.ascll.strToasc;

public class MainActivity extends Activity 
{
	
	EditText ed1,ed2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		setTitle("Char To Ascii");
		ed1 =(EditText)findViewById(R.id.mainEditText1);
		ed2 =(EditText)findViewById(R.id.mainEditText2);
		
   
		}
	
	
	//菜单 
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.del:
				ed1.setText("");
				ed2.setText("");
				break;
				case R.id.asc:
				Intent a = new Intent(MainActivity.this,strToasc.class);
				startActivity(a);
				break;
        }
        return super.onOptionsItemSelected(item);
    }
	
	
	
	
	
	
	
	public void cta(View view){
		if(!ed1.getText().toString().equals("")){
		ed2.setText(charToAscII()+"");
		}
		else{
			toast("你没有输入任何字符");
		}
		
	}
	public void atc(View view){
		if(!ed2.getText().toString().equals("")){
		ed1.setText(asciiTochar()+"");
		}
		else{
			toast("你没有输入任何ascii码");
		}
	}
	
		
	public void toast(String a){
		Toast.makeText(getApplicationContext(),a,Toast.LENGTH_SHORT).show();
	}	
		
	
	//c
	public int charToAscII(){
		String a = ed1.getText().toString();
		int b = (int)a.charAt(0);
		return b;
	}
	//a
	
	
	public char asciiTochar(){
		String a=ed2.getText().toString();
		char b = (char)Integer.parseInt(a);
		return b;
	}
	
}
