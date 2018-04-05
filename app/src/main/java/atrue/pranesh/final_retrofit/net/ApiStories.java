package atrue.pranesh.final_retrofit.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiStories {

    @GET("api.php?mod=posts&method=getEvents&format=json")
    Call<ResponseBody> getAllEvents();

    @GET("{id}/questions?order=desc&sort=activity&tagged=ipv4&site=stackoverflow&filter=!BHMIbze0EPheMk572h0kxuj.q(NQC*")
    Call<ResponseBody> getStack(@Path("id") double id);
}
