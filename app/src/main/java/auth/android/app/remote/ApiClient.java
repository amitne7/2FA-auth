package auth.android.app.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sudhirharit on 28/03/18.
 */

public class ApiClient {

    private static Retrofit retrofit = null;


    public static Retrofit getRetrofitClient(String base_url) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(60, TimeUnit.SECONDS);
        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.writeTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(logging);  // <-- this is the important line!


        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }

}
