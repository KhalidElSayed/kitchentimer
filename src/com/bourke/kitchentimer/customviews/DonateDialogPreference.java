/**
 *  Kitchen Timer
 *  Copyright (C) 2010 Roberto Leinardi
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */

package com.bourke.kitchentimer.customviews;

import com.bourke.kitchentimer.R;
import com.bourke.kitchentimer.ui.ConfigActivity;
import com.bourke.kitchentimer.ui.PresetsActivity;
import com.bourke.kitchentimer.utils.Utils;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;

public class DonateDialogPreference extends DialogPreference {
	Context mContext;
	String fileName;

	public DonateDialogPreference(Context context, AttributeSet attrs) {
		super(context, attrs);

		mContext= context;
		TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.MyDialogPreference);
		fileName = a.getString(R.styleable.MyDialogPreference_fileName);
	}

//	protected void onPrepareDialogBuilder(Builder builder) {
//		builder.setView(Utils.dialogWebView(mContext, fileName));
//	}

	@Override
	protected void onDialogClosed(boolean positiveResult) {
		super.onDialogClosed(positiveResult);
		if (positiveResult) {
			Utils.donate(mContext);
		}
	}
}
