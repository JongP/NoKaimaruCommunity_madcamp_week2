package com.example.madcamp_week2.frag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.madcamp_week2.MainActivity;
import com.example.madcamp_week2.model.Dictionary;
import com.example.madcamp_week2.adapter.DictionaryAdapter;
import com.example.madcamp_week2.model.Item;
import com.example.madcamp_week2.R;
import com.example.madcamp_week2.server.RestResult;
import com.example.madcamp_week2.server.RetrofitInterface;
import com.example.madcamp_week2.user.UserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class Fragment1 extends Fragment {

    ArrayList<Item> mArrayList = new ArrayList<Item>();
    private DictionaryAdapter mAdapter;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.249.18.117:80";
    RecyclerView mRecyclerView;
    private static int flag = 0;
    int[] numEachCategory = new int[5];

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_id);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        //handleServer();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        handleServer();
    }

    private void handleServer() {

        Call<List<RestResult>> call = retrofitInterface.executeGetAllRest();

        call.enqueue(new Callback<List<RestResult>>() {
            @Override
            public void onResponse(Call<List<RestResult>> call, Response<List<RestResult>> response) {
                if(response.code()==200){

                    List<RestResult> list = response.body();

                    parsingRestResult(list);

                    mAdapter = new DictionaryAdapter(mArrayList);

                    mAdapter.setOnItemClickListener(new DictionaryAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            String restId = mArrayList.get(position).getId();
                            MainActivity activity = (MainActivity)getActivity();
                            if (activity != null)
                                activity.switchToRestPage(restId);
                        }
                    });

                    mRecyclerView.setAdapter(mAdapter);

                }else if(response.code()==400){
                    Log.d("evening", "onClick: test response fail");
                }
                Log.d("evening", "response end");
            }
            @Override
            public void onFailure(Call<List<RestResult>> call, Throwable t) {
                Log.d("serverError",t.getMessage());
                Toast.makeText(getContext(), "Server is closed.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void parsingRestResult(List<RestResult> list) {
        Dictionary dict;
        int index;

        for(RestResult restaurant : list){

            boolean dup = false;

            for (Item i : mArrayList) {
                if (i.getType() == 1 && i.getId().equals(restaurant.getId())) {
                    dup = true;
                    break;
                }
                if (i.getType() == 0 && i.getInvisibleChildren() != null) {
                    for (Item j : i.getInvisibleChildren()) {
                        if (j.getId().equals(restaurant.getId())) {
                            dup = true;
                            break;
                        }
                    }
                    if (dup) break;
                }

            }
            if (dup) continue;;

            String name = restaurant.getName();
            String id = restaurant.getId();
            String contact = restaurant.getContact();
            double rate = restaurant.getRate();

            switch (restaurant.getCategory()) {
                case "한식":
                    if (numEachCategory[0] == 0) {
                        index = 0;
                        if (mArrayList.size() > index)
                            mArrayList.add(index, new Item("한식"));
                        else
                            mArrayList.add(new Item("한식"));

                        Log.d("evening", "한식 header index : " + index);
                    }
                    numEachCategory[0]++;
                    index = numEachCategory[0];

                    dict = new Dictionary(name, contact);

                    if (mArrayList.size() > index)
                        mArrayList.add(index, new Item("한식", id, dict));
                    else
                        mArrayList.add(new Item("한식", id, dict));
                    mArrayList.get(index).setRate(Math.round(rate * 10) / 10.0);

                    //Log.d("evening", "한식 Item : " + mArrayList.get(index).dict.getName());

                    break;

                case "일식":
                    if (numEachCategory[1] == 0) {
                        index = numEachCategory[0] + 1;
                        if (mArrayList.size() > index)
                            mArrayList.add(index, new Item("일식"));
                        else
                            mArrayList.add(new Item("일식"));
                    }
                    numEachCategory[1]++;
                    index = numEachCategory[0] + 1 + numEachCategory[1];

                    dict = new Dictionary(name, contact);

                    if (mArrayList.size() > index)
                        mArrayList.add(index, new Item("일식", id, dict));
                    else
                        mArrayList.add(new Item("일식", id, dict));
                    mArrayList.get(index).setRate(Math.round(rate * 10) / 10.0);
                    break;

                case "양식":
                    if (numEachCategory[2] == 0) {
                        index = numEachCategory[0] + 1 + numEachCategory[1] + 1;

                        if (mArrayList.size() > index)
                            mArrayList.add(index, new Item("양식"));
                        else
                            mArrayList.add(new Item("양식"));
                    }
                    numEachCategory[2]++;
                    index = numEachCategory[0] + 1
                            + numEachCategory[1] + 1
                            + numEachCategory[2];

                    dict = new Dictionary(name, contact);

                    if (mArrayList.size() > index)
                        mArrayList.add(index, new Item("양식", id, dict));
                    else
                        mArrayList.add(new Item("양식", id, dict));
                    mArrayList.get(index).setRate(Math.round(rate * 10) / 10.0);
                    break;

                case "Pub & Bar":
                    if (numEachCategory[4] == 0) {
                        index = numEachCategory[0] + 1
                                + numEachCategory[1] + 1
                                + numEachCategory[2] + 1
                                + numEachCategory[3] + 1;
                        if (mArrayList.size() > index)
                            mArrayList.add(index, new Item("Pub & Bar"));
                        else
                            mArrayList.add(new Item("Pub & Bar"));
                    }
                    numEachCategory[4]++;
                    index = numEachCategory[0] + 1
                            + numEachCategory[1] + 1
                            + numEachCategory[2] + 1
                            + numEachCategory[3] + 1
                            + numEachCategory[4];

                    dict = new Dictionary(name, contact);

                    if (mArrayList.size() > index)
                        mArrayList.add(index, new Item("Pub & Bar", id, dict));
                    else
                        mArrayList.add(new Item("Pub & Bar", id, dict));
                    mArrayList.get(index).setRate(Math.round(rate * 10) / 10.0);
                    break;

                default:
                    if (numEachCategory[3] == 0) {
                        index = numEachCategory[0] + 1
                                + numEachCategory[1] + 1
                                + numEachCategory[2] + 1;
                        if (mArrayList.size() > index)
                            mArrayList.add(index, new Item("기타 외국 음식"));
                        else
                            mArrayList.add(new Item("기타 외국 음식"));
                    }
                    numEachCategory[3]++;
                    index = numEachCategory[0] + 1
                            + numEachCategory[1] + 1
                            + numEachCategory[2] + 1
                            + numEachCategory[3];

                    dict = new Dictionary(name, contact);
                    if (mArrayList.size() > index)
                        mArrayList.add(index, new Item("기타 외국 음식", id, dict));
                    else
                        mArrayList.add(new Item("기타 외국 음식", id, dict));
                    mArrayList.get(index).setRate(Math.round(rate * 10) / 10.0);
                    break;
            }
        }
    }

}