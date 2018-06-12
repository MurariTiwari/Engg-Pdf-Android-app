package com.tiwarithetiger11gmail.myengineeringpdfs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MURARI TIWARI on 11/1/2017.
 */

public class ApiClient {
    public static final String BASE_URl="http://10.0.2.2:3000";
    public static Retrofit retrofit=null;

    public static  Retrofit getApiClient()
    {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
