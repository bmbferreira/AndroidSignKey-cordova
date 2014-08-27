/*
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 * Copyright (c) 2005-2010, Nitobi Software Inc.
 * Copyright (c) 2011, IBM Corporation
 */

package com.phonegap.plugins.androidsignkey;


import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.Signature;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Context;

import org.apache.cordova.CordovaPlugin;

public class AndroidSignKey extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	try {
		if (action.equals("getSignatureHashCode")) {
			Context ctx = this.cordova.getActivity().getApplicationContext();
			Signature [] sigs = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), PackageManager.GET_SIGNATURES).signatures;
			for (int i = 0; i < sigs.length; i++) {
			   callbackContext.success(sigs[0].hashCode());
			   return true;
			}
		}
        } catch (NameNotFoundException e) {
            e.printStackTrace();
	    callbackContext.error(e.getMessage());
        } 
        return false;
    }

}
