package com.example.retrofit2_android_java_demo;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // RetrofitでＡＰＩにアクセスするための初期設定
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper().registerModule(new JavaTimeModule())))
                .baseUrl("http://localhost:8080")
                .build();

        // 作成したRetrofitから、APIを利用するためのサービスの生成
        TeacherApiService teacherApiService = retrofit.create(TeacherApiService.class);

        // Tokenはログイン時に取得したトークンを保存しそれを取得して利用するようにする
        String token = "723f5296-4c51-4e82-83da-7d300537271e";

        // Subjectのリストを表示するためのListViewを取得する
        ListView subjectListView = (ListView) findViewById(R.id.subject_list_view);

        // TeacherApiServiceに定義されているメソッドを実行する。
        // .enqueueは必須、new Callbackの後の<>の中は、呼び出したメソッドによって異なる
        teacherApiService.fetchSubjects(token).enqueue(new Callback<List<TeacherSubject>>() {
            @Override
            // 正常にAPIが呼び出された際に実行される、（HTTPのレスポンスが返った場合のこと）
            // レスポンスステータス (200 Ok, 400 Bad Request, 403 Forbidden)によって処理を分岐させる場合は、
            // onResponse内でresponse.code()を呼び出して処理を変更する必要がある。
            public void onResponse(Call<List<TeacherSubject>> call, Response<List<TeacherSubject>> response) {
                System.err.println("response api");

                if (!response.isSuccessful()) {
                    System.err.println(response.toString());
                    return;
                }
                System.err.println("scussess full api");

                List<TeacherSubject> subjects = response.body();

                subjectListView.setAdapter(new TeacherSubjectsAdapter(getApplicationContext(), R.layout.subject_list_item, subjects));
            }

            @Override
            public void onFailure(Call<List<TeacherSubject>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}