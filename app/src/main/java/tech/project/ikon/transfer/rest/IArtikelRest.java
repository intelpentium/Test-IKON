package tech.project.ikon.transfer.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import tech.project.ikon.common.constant.ConstantCommon;
import tech.project.ikon.transfer.model.Artikel;

public interface IArtikelRest {

    @GET(ConstantCommon.ARTIKEL)
    Call<Artikel> artikel();
}
