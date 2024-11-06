package tech.project.ikon.transfer.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.project.ikon.common.constant.ConstantCommon;
import tech.project.ikon.transfer.rest.IArtikelRest;
import tech.project.ikon.transfer.rest.INasabahRest;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Provides
    @Singleton
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(ConstantCommon.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public static INasabahRest iNasabahRest(Retrofit retrofit) {
        return retrofit.create(INasabahRest.class);
    }

    @Provides
    @Singleton
    public static IArtikelRest iArtikelRest(Retrofit retrofit) {
        return retrofit.create(IArtikelRest.class);
    }
}
