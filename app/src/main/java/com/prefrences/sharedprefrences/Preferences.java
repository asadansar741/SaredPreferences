package com.prefrences.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private  final String MY_GLOBAL_PREERENCES="myGlobalPrefrences";
    public static final String MY_EDIT_TEXT="myEditText";
    public static final String USER_OBJ="USER_OBJ";

    Preferences(Context context){
        this.context=context;
        editor=context.getSharedPreferences(MY_GLOBAL_PREERENCES,Context.MODE_PRIVATE).edit();
        sharedPreferences=context.getSharedPreferences(MY_GLOBAL_PREERENCES,Context.MODE_PRIVATE);
    }

    public void saveStringInPrefrence(String key,String value){
        editor.putString(key,value);
    }

    public void commitPrefrence(){
        editor.apply();
    }

    public String getStringFromPrefrences(String key,String defaultValue){
        return sharedPreferences.getString(key,defaultValue);
    }

    public SharedPreferences getSharedPrefObj(){
        return sharedPreferences;
    }



}
