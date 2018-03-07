package com.dabai.ascll;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class strToasc extends Activity
{
	EditText ed1,ed2;
	StringBuffer te;
	StringBuffer te1;
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.str);
		setTitle("String To Ascii");
		
		ed1 = (EditText)findViewById(R.id.strEditText1);
		ed2 = (EditText)findViewById(R.id.strEditText2);
		
		te = new StringBuffer();
		te1 = new StringBuffer();
	}
	
	//菜单 
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.str, menu);
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
        }
        return super.onOptionsItemSelected(item);
    }

	
	
	public void sta(View view){
		str1();
	}
	
	public void ats(View view){
		asc1();
	}
	
	
	//分割字符串然后循环遍历
	public void str1(){
		if(!ed1.getText().toString().equals("")){
		
			new Thread() {
				@Override
				public void run() {
					super.run();
					//新线程操作
					char []a=ed1.getText().toString().toCharArray();
					for(int i=0;i<a.length;i++){
						int b = (int)a[i];
						te.append(b+" ");
					}
					runOnUiThread(new Runnable(){
							@Override
							public void run() {
								//更新UI操作
								ed2.setText((te.toString()));
								te.delete(0,te.length());
							}
						});
				}
			}.start();
				
		}
		else{
			toast("你没有输入任何字符串");
		}	
	}
	
	
	//ascii码回转
	public void asc1(){
		if(!ed2.getText().toString().equals("")){
			
			new Thread() {
				@Override
				public void run() {
					super.run();
					//新线程操作
					String a= ed2.getText().toString();		
					String[] b =a.split(" ");
					for(int i=0;i<b.length;i++){
						te1.append((char)Integer.parseInt(b[i]));
					}
					runOnUiThread(new Runnable(){
							@Override
							public void run() {
								//更新UI
								ed1.setText(te1.toString());
								te1.delete(0,te1.length());
							}
						});
				}
			}.start();	
			}
			else
			{
				toast("你没有输入任何ascii码");
			}
	} 
	
	
	
	
	
	public void toast(String a){
		Toast.makeText(getApplicationContext(),a,Toast.LENGTH_SHORT).show();
	}	
	
	}
