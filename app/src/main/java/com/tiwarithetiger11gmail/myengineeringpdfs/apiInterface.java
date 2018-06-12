package com.tiwarithetiger11gmail.myengineeringpdfs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by MURARI TIWARI on 11/1/2017.
 */

public interface apiInterface {

    @POST("/android")
    Call<List<modal>> getmodal(@Body ReaquestBody body);

}
