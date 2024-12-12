package com.example.retrofit2_android_java_demo.api;

import com.example.retrofit2_android_java_demo.api.model.JoinLectureRequest;
import com.example.retrofit2_android_java_demo.api.model.JoinStatusResponse;
import com.example.retrofit2_android_java_demo.api.model.RegisterStudentAccountRequest;
import com.example.retrofit2_android_java_demo.api.model.StudentAccountResponse;
import com.example.retrofit2_android_java_demo.api.model.StudentClassResponse;
import com.example.retrofit2_android_java_demo.api.model.SubjectReportResponse;
import com.example.retrofit2_android_java_demo.api.model.SubjectsResponse;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface StudentApi {
  /**
   * クラス一覧
   * 学生登録時に必要なクラス一覧を無権限で取得
   * @return Call&lt;List&lt;StudentClassResponse&gt;&gt;
   */
  @GET("api/student/classes")
  Call<List<StudentClassResponse>> fetchAllStudentClasses();
    

  /**
   * 学生が参加している授業の一覧
   * 
   * @return Call&lt;List&lt;SubjectsResponse&gt;&gt;
   */
  @GET("api/student/subjects")
  Call<List<SubjectsResponse>> fetchAllSubjects();
    

  /**
   * 学生が参加している指定したID授業の情報
   *
   * @param token  (required)
   * @param subjectId  (required)
   * @return Call&lt;SubjectReportResponse&gt;
   */
  @GET("api/student/subjects/{subjectId}")
  Call<SubjectReportResponse> fetchSubjectReport(
          @retrofit2.http.Header("X-Auth-Token") String token,
          @retrofit2.http.Path("subjectId") Long subjectId
  );

  /**
   * 学生が講義に参加
   * 学生が読み取った授業ID、講義IDとjoinCodeを利用して講義に参加します。
   * @param token  (required)
   * @param joinLectureRequest  (required)
   * @return Call&lt;JoinStatusResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/student/join")
  Call<JoinStatusResponse> joinLecture(
          @retrofit2.http.Header("X-Auth-Token") String token,
          @retrofit2.http.Body JoinLectureRequest joinLectureRequest
  );

  /**
   * 学生登録
   * 学生が新規登録画面からIDとパスワード、名前、クラスを選択して登録
   * @param registerStudentAccountRequest  (required)
   * @return Call&lt;StudentAccountResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/student/register")
  Call<StudentAccountResponse> registerStudentAccount(
    @retrofit2.http.Body RegisterStudentAccountRequest registerStudentAccountRequest
  );

}
