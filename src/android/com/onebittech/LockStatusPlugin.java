package com.onebittech;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.content.Context;
import android.app.KeyguardManager;

public class LockStatusPlugin extends CordovaPlugin {

    private CordovaInterface cordova;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        this.cordova = cordova;
        super.initialize(cordova, webView);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.cordova.api.Plugin#execute(java.lang.String,
     * org.json.JSONArray, java.lang.String)
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isDeviceLocked")) {
            Boolean isLocked = this.isDeviceLocked();
            JSONObject output = new JSONObject();
            output.put("is_device_locked", isLocked);
            callbackContext.success(output);
            return true;
        }
        callbackContext.error("unknown action");
        return false;
    }

    /**
     * Gets the device's lock status.
     *
     * @return device locked true | false
     */
    private Boolean isDeviceLocked() {
        KeyguardManager keyguardManager = (KeyguardManager) (getContext().getSystemService(Context.KEYGUARD_SERVICE));
        return keyguardManager.isDeviceLocked();
    }

  private Context getContext() {
    return cordova.getActivity().getApplicationContext();
  }

}
