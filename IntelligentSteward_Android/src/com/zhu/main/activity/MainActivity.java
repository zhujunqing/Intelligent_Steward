package com.zhu.main.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements android.widget.RadioGroup.OnCheckedChangeListener{

	private TabHost tabhost;//页签
	private RadioGroup mainTab;//单选组
	public RadioGroup getMainTab() {
		return mainTab;
	}
	public void setMainTab(RadioGroup mainTab) {
		this.mainTab = mainTab;
	}
	RadioButton keepAccounts;//记账
	RadioButton totalAccounts;//总额(流水)
	RadioButton account;//账户
	
	private Intent keepAccountsIntent;//记账页面
	private Intent totalAccountsIntent;//总额(流水)页面
	private Intent accountIntent;//账户页面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainTab = (RadioGroup)findViewById(R.id.main_tab1);
		int w = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		mainTab.measure(w, h);
		int height = mainTab.getMeasuredHeight();
		int width = mainTab.getMeasuredWidth();
		
		tabhost = getTabHost();
		keepAccounts = (RadioButton)findViewById(R.id.keep_accounts_id);
		totalAccounts = (RadioButton)findViewById(R.id.total_accounts_id);
		account = (RadioButton)findViewById(R.id.account_id);
		mainTab.setOnCheckedChangeListener(this);
		
		keepAccountsIntent = new Intent(this,KeepAccountsActivity.class);//记账页面
		tabhost.addTab(tabhost.newTabSpec("tab1").setIndicator("tab11", null).setContent(keepAccountsIntent));
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.keep_accounts_id:
			tabhost.setCurrentTab(0);
			break;
		case R.id.total_accounts_id:
			tabhost.setCurrentTab(1);
			break;
		case R.id.account_id:
			tabhost.setCurrentTab(2);
			break;
		}
	}

}
