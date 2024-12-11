package com.example.retrofit2_android_java_demo.api;

import com.example.retrofit2_android_java_demo.api.model.LoginRequest;
import com.example.retrofit2_android_java_demo.api.model.LoginResponse;
import com.example.retrofit2_android_java_demo.api.model.UserInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthApi {
  /**
   * 認証したアカウントの名前と権限を取得
   * 
   * @return Call&lt;UserInfoResponse&gt;
   */
  @GET("api/auth/userinfo")
  Call<UserInfoResponse> fetchUserInfo();
    

  /**
   * 登録した学生、先生、管理者のログインAPI
   * 
   * @param loginRequest  (required)
   * @return Call&lt;LoginResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/auth/login")
  Call<LoginResponse> login(
    @retrofit2.http.Body LoginRequest loginRequest
  );

}
