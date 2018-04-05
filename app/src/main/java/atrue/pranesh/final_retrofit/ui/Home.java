package atrue.pranesh.final_retrofit.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import atrue.pranesh.final_retrofit.R;
import atrue.pranesh.final_retrofit.busi.RecyAdap;
import atrue.pranesh.final_retrofit.model.Stack;
import atrue.pranesh.final_retrofit.model.User;
import atrue.pranesh.final_retrofit.net.ApiClient;
import atrue.pranesh.final_retrofit.net.ApiStories;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyAdap ad;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

      //  getUser();

        getRealUser();
    }
  /*  private void getList() {
        ApiStories apiStories= ApiClient.getClient().create(ApiStories.class);
        Call<List<Marvel>> listCall=apiStories.doGetListUsers();
        listCall.enqueue(new Callback<List<Marvel>>() {
            @Override
            public void onResponse(Call<List<Marvel>> call, Response<List<Marvel>> response) {
                usersList = response.body();
                setAdap();

            }

            @Override
            public void onFailure(Call<List<Marvel>> call, Throwable t) {

            }
        });

    }*/
    private void getRealUser() {
        ApiStories apiStories = ApiClient.getClient().create(ApiStories.class);
        Call<ResponseBody> responseBodyCall = apiStories.getStack(2.2);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                StringBuilder stringBuilder = new StringBuilder();
                InputStream inputStream = response.body().byteStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                try {
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String jsonArrayToString;

                try {
                    JSONObject jsonObject=new JSONObject(stringBuilder.toString());
                    if(jsonObject.has("items")){
                        jsonArrayToString=jsonObject.getJSONArray("items").toString();
                        Gson gson=new Gson();
                        List<Stack> stacks=gson.fromJson(jsonArrayToString,new TypeToken<List<Stack>>(){}.getType());
                        setAdapter(stacks);
                    }

                } catch (JSONException e) {

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
/*
    private void getUser() {
        ApiStories apiStories = ApiClient.getClient().create(ApiStories.class);
        Call<ResponseBody> responseBodyCall = apiStories.getAllEvents();
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                StringBuilder stringBuilder = new StringBuilder();

                InputStream inputStream = response.body().byteStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                try {
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String jsonArrayToString;
                try {
                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    if (jsonObject.has("sitter")) {
                        JSONObject jsonObject1 = jsonObject.getJSONObject("sitter");
                        if (jsonObject1.has("response")) {
                            JSONObject jsonObject2 = jsonObject1.getJSONObject("response");
                            if (jsonObject2.has("data")) {
                                jsonArrayToString = jsonObject2.getJSONArray("data").toString();
                                Gson gson = new Gson();
                                List<User> userList = gson.fromJson(jsonArrayToString, new TypeToken<List<User>>() {
                                }.getType());
                                setAdapter(userList);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }*/

    private void setAdapter(List<Stack> userList) {
        ad = new RecyAdap(userList, this);
        recyclerView.setAdapter(ad);
    }

    @Override
    public void onClick(View view) {

    }
}
