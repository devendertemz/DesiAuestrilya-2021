package com.thetemz.desiaustralia.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class GetingDeviceToken3 extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String refreshtoken= FirebaseInstanceId.getInstance().getToken();
        Log.d("myfriebaseid",refreshtoken);
       // storeToken(refreshtoken);

    }

}