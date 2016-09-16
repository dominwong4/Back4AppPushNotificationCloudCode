package dominwong4.scm.back4apppushnotificationcloudcode;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonghoyin on 15/9/2016.
 */

public class MainApplication extends Application {
    private static MainApplication instance = new MainApplication();
    public static final String APPLICATION_ID = "msQU7s4NATNB8Hkx2l2mVJlui1GbXQzt7Mp5ZIcP";
    public static final String CLIENT_KEY = "0qEjd7ei4To77jZxJG6QJ8lBipPBYqZp9bsHodZg";
    public static final String BACK4PAPP_API = "https://parseapi.back4app.com/";

    public MainApplication(){
        instance = this;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server(BACK4PAPP_API).build());

        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
        Log.d("Parse","Initialized");
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("GCMSenderId", "966437188652");
        installation.saveInBackground();

        ParsePush.subscribeInBackground("test_channel", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                Log.d("Parse","Success");
                else
                    Log.d("Parse","Failed");
            }
        });
    }
}
