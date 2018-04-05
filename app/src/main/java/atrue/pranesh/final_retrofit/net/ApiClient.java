package atrue.pranesh.final_retrofit.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public static String base_Url = "http://api.stackexchange.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder request = chain.request().newBuilder().addHeader("Authkey", "8WAtp8nUEOrzSu67t9tGITEzIdgr6huIpXqo");
                    return chain.proceed(request.build());
                }
            });
            OkHttpClient okHttpClient = builder.build();

            retrofit=new Retrofit.Builder()
                    .baseUrl(base_Url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
