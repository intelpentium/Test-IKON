package tech.project.ikon.transfer.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tech.project.ikon.common.constant.ConstantCommon;
import tech.project.ikon.transfer.model.NasabahPotensial;
import tech.project.ikon.transfer.model.RequestNasabahPotensial;

public interface INasabahRest {

//    @GET(ConstantCommon.NP_LIST_PATH)
//    Call<NasabahPotensial> nasabahPotensial(
//        @Query("officerCode") String officerCode
//    );

    @POST(ConstantCommon.NP_LIST_PATH)
    Call<NasabahPotensial> nasabahPotensial(
            @Body RequestNasabahPotensial requestNasabahPotensial
    );
}
