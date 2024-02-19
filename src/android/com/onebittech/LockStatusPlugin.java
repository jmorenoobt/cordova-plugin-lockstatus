package com.onebittech.LockStatusPlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.KeyguardManager;

public class LockStatusPlugin extends CordovaPlugin {

    /*
     * (non-Javadoc)
     *
     * @see org.apache.cordova.api.Plugin#execute(java.lang.String,
     * org.json.JSONArray, java.lang.String)
     */
    @Override
    public boolean execute(String action, JSONArray args,
            CallbackContext callbackContext) {

        if (action.equals("isDeviceLocked")) {

            Boolean isLocked = this.isDeviceLocked();

            if (isLocked != null) {
                JSONObject JSONresult = new JSONObject();
                try {
                    JSONresult.put("is_device_locked", isLocked);
                    PluginResult r = new PluginResult(PluginResult.Status.OK,
                            JSONresult);
                    callbackContext.success(isLocked);
                    r.setKeepCallback(true);
                    callbackContext.sendPluginResult(r);
                    return true;
                } catch (JSONException jsonEx) {
                    PluginResult r = new PluginResult(
                            PluginResult.Status.JSON_EXCEPTION);
                    callbackContext.error("error");
                    r.setKeepCallback(true);
                    callbackContext.sendPluginResult(r);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets the mac address.
     *
     * @return the mac address
     */
    private Boolean isDeviceLocked() {
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Activity.KEYGUARD_SERVICE);
        return keyguardManager.isDeviceLocked();
    }
}
