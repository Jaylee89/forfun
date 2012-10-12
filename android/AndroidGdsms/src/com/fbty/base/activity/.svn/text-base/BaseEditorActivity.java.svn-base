/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.base.activity;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author libing create 2011-4-10
 * @version 0.1
 *
 */
import android.view.View;
import android.widget.Button;

public abstract class BaseEditorActivity extends BaseActivity {
	protected Button deleteButton;
	protected Button resetButton;
	protected Button saveButton;

	protected void fillForm() {
	}

	protected void findViews() {
		saveButton = (Button) findViewById(2131230736);
		resetButton = (Button) findViewById(2131230737);
		deleteButton = (Button) findViewById(2131230738);
	}

	protected void init() {
	}

	protected void onClickDeleteButton() {
	}

	protected void onClickResetButton() {
		showViews();
	}

	protected void onClickSaveButton() {
	}

	protected void setListensers(){
    super.setListensers();
    if (deleteButton != null){
        deleteButton.setOnClickListener(new View.OnClickListener() {
		
        	@Override
        	public void onClick(View v) {
        	    onClickDeleteButton();
        	    toListActivity();
        	}
        });
    }
    if (resetButton != null){
    	resetButton.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			onClickResetButton();
    		}
    	});
    }
    if (saveButton != null){
    	saveButton.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			onClickSaveButton();
    			toListActivity();
    		}
    	});
    }
  }

	protected boolean validate() {
		return true;
	}
}