package com.example.finalproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.data.api.ApiManager;
import com.example.finalproject.data.api.ProductListener;
import com.example.finalproject.data.model.CartResponse;

import com.example.finalproject.data.model.product.ProductResponse;
import com.example.finalproject.data.model.product.Product;
import com.example.finalproject.helper.TokenManager;
import com.example.finalproject.ui.adapter.ProductAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements ProductListener  {


    public HomeFragment() {
        // Required empty public constructor
    }



    RecyclerView recyclerView;
    ProductAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    protected void initialize(View view)
    {

        recyclerView=view.findViewById(R.id.product_recycler_id);
        adapter=new ProductAdapter(getContext(),this);
        layoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);


        navController=Navigation.findNavController(view);
       ApiManager.getProductService().getProduct().enqueue(new Callback<ProductResponse>() {
           @Override
           public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
               if(response.isSuccessful())
               {

                   adapter.setProduct_Item_list(response.body().getProducts());
               }
               else
               {
                 Log.d("dddddddddddd", "onResponse: "+response.code());

               }
           }

           @Override
           public void onFailure(Call<ProductResponse> call, Throwable t) {
             Log.d("ddddddddd", "onFailure: "+t.getLocalizedMessage());
           }
       });
    }



    @Override
    public void showProductDetails(Product productItem) {
        Bundle bundle=new Bundle();
        bundle.putSerializable("Product", productItem);
        navController.navigate(R.id.action_home_fragment_to_productDetailsFragment,bundle);
    }

    @Override
    public void addToCart(Product productItem) {

        TokenManager token=new TokenManager(getContext());
        String tokenid=token.getToken();

        ApiManager.getProductService().addToCart(productItem.getId(),"Bearer "+tokenid,1 ).enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                if(response.isSuccessful())
                {
                    Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {

            }
        });
    }
}