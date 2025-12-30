package com.yudorm.app.data.remote;

import com.yudorm.app.data.models.IssueResponse;
import com.yudorm.app.data.models.RegisterRequest;
import com.yudorm.app.data.models.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface YudormApiService {

    @POST("api/auth/register")
    Call<UserResponse> register(@Body RegisterRequest request);

    // Backend'de RequestParam kullandığımız için @Query kullanıyoruz
    @POST("api/auth/login")
    Call<UserResponse> login(
            @Query("studentNo") String studentNo,
            @Query("password") String password
    );

    @GET("api/issues/all")
    Call<List<IssueResponse>> getAllIssues();
    // YudormApiService üzerinden isteği oluşturuyoruz

}
