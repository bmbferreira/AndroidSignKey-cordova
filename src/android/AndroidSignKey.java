/*
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 * Copyright (c) 2005-2010, Nitobi Software Inc.
 * Copyright (c) 2011, IBM Corporation
 */

package com.phonegap.plugins.androidsignkey;

import java.io.IOException;
import java.net.URLConnection;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.Signature;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import org.apache.cordova.CordovaPlugin;

public class AndroidSignKey extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			 if (action.equals("getSignatureHashCode")) {
				Signature [] sigs = this.cordova.getActivity().getApplicationContext().getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_SIGNATURES).signatures;
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
