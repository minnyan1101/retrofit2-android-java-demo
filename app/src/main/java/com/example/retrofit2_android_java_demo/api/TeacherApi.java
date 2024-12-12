package com.example.retrofit2_android_java_demo.api;


import com.example.retrofit2_android_java_demo.api.model.CreateClassRequest;
import com.example.retrofit2_android_java_demo.api.model.CreateSubjectLectureRequest;
import com.example.retrofit2_android_java_demo.api.model.CreateSubjectRequest;
import com.example.retrofit2_android_java_demo.api.model.EditAttendanceRequest;
import com.example.retrofit2_android_java_demo.api.model.EditClassRequest;
import com.example.retrofit2_android_java_demo.api.model.EditSubjectLectureRequest;
import com.example.retrofit2_android_java_demo.api.model.EditSubjectRequest;
import com.example.retrofit2_android_java_demo.api.model.StudentClassResponse;
import com.example.retrofit2_android_java_demo.api.model.StudentLectureAttendanceResponse;
import com.example.retrofit2_android_java_demo.api.model.StudentRequest;
import com.example.retrofit2_android_java_demo.api.model.StudentStatusResponse;
import com.example.retrofit2_android_java_demo.api.model.SubjectLectureResponse;
import com.example.retrofit2_android_java_demo.api.model.SubjectResponse;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TeacherApi {
  /**
   * 新しい講義の追加
   * 
   * @param subjectId  (required)
   * @param createSubjectLectureRequest  (required)
   * @return Call&lt;List&lt;SubjectLectureResponse&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/subjects/{subjectId}/lectures")
  Call<List<SubjectLectureResponse>> addLecture(
    @retrofit2.http.Path("subjectId") Long subjectId,
    @retrofit2.http.Body List<CreateSubjectLectureRequest> createSubjectLectureRequest
  );

  /**
   * 指定した学生の情報の編集
   * 
   * @param studentId  (required)
   * @param studentRequest  (required)
   * @return Call&lt;StudentStatusResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/students/{studentId}")
  Call<StudentStatusResponse> changeStudentStatus(
    @retrofit2.http.Path("studentId") String studentId,
    @retrofit2.http.Body StudentRequest studentRequest
  );

  /**
   * 新しいクラスの作成
   * 
   * @param createClassRequest  (required)
   * @return Call&lt;StudentClassResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/classes")
  Call<StudentClassResponse> createClass(
    @retrofit2.http.Body CreateClassRequest createClassRequest
  );

  /**
   * 新しい授業の作成
   * 
   * @param createSubjectRequest  (required)
   * @return Call&lt;SubjectResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/subjects")
  Call<SubjectResponse> createSubject(
    @retrofit2.http.Body CreateSubjectRequest createSubjectRequest
  );

  /**
   * 特定の講義を受講している特定学生の出席状況の変更
   * 
   * @param subjectId  (required)
   * @param lectureId  (required)
   * @param studentId  (required)
   * @param editAttendanceRequest  (required)
   * @return Call&lt;StudentLectureAttendanceResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/subjects/{subjectId}/lectures/{lectureId}/students/{studentId}")
  Call<StudentLectureAttendanceResponse> editAttendance(
    @retrofit2.http.Path("subjectId") Long subjectId,
    @retrofit2.http.Path("lectureId") Long lectureId,
    @retrofit2.http.Path("studentId") String studentId,
    @retrofit2.http.Body EditAttendanceRequest editAttendanceRequest
  );

  /**
   * 既存のクラスの編集
   * 
   * @param classId  (required)
   * @param editClassRequest  (required)
   * @return Call&lt;StudentClassResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/classes/{classId}")
  Call<StudentClassResponse> editClass(
    @retrofit2.http.Path("classId") Long classId,
    @retrofit2.http.Body EditClassRequest editClassRequest
  );

  /**
   * 特定の講義の編集
   *
   * @param subjectId  (required)
   * @param lectureId  (required)
   * @param editSubjectLectureRequest  (required)
   * @return Call&lt;SubjectLectureResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/subjects/{subjectId}/lectures/{lectureId}")
  Call<SubjectLectureResponse> editLecture(
    @retrofit2.http.Path("subjectId") Long subjectId,
    @retrofit2.http.Path("lectureId") Long lectureId,
    @retrofit2.http.Body EditSubjectLectureRequest editSubjectLectureRequest
  );

  /**
   * 指定した授業内容の編集
   * 
   * @param subjectId  (required)
   * @param editSubjectRequest  (required)
   * @return Call&lt;SubjectResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/teacher/subjects/{subjectId}")
  Call<SubjectResponse> editSubject(
    @retrofit2.http.Path("subjectId") Long subjectId,
    @retrofit2.http.Body EditSubjectRequest editSubjectRequest
  );

  /**
   * 特定の講義を受講している学生の出席状況一覧の取得
   * 
   * @param subjectId  (required)
   * @param lectureId  (required)
   * @return Call&lt;List&lt;StudentLectureAttendanceResponse&gt;&gt;
   */
  @GET("api/teacher/subjects/{subjectId}/lectures/{lectureId}/students")
  Call<List<StudentLectureAttendanceResponse>> fetchAllAttendance(
    @retrofit2.http.Path("subjectId") Long subjectId, @retrofit2.http.Path("lectureId") Long lectureId
  );

  /**
   * すべてのクラスの一覧
   * 
   * @return Call&lt;List&lt;StudentClassResponse&gt;&gt;
   */
  @GET("api/teacher/classes")
  Call<List<StudentClassResponse>> fetchAllClass();
    

  /**
   * 特定の授業の講義の一覧の取得
   * 
   * @param subjectId  (required)
   * @return Call&lt;List&lt;SubjectLectureResponse&gt;&gt;
   */
  @GET("api/teacher/subjects/{subjectId}/lectures")
  Call<List<SubjectLectureResponse>> fetchAllLecture(
    @retrofit2.http.Path("subjectId") Long subjectId
  );

  /**
   * すべての学生の一覧
   * 
   * @param classId  (optional)
   * @return Call&lt;List&lt;StudentStatusResponse&gt;&gt;
   */
  @GET("api/teacher/students")
  Call<List<StudentStatusResponse>> fetchAllStudents(
    @retrofit2.http.Query("classId") Long classId
  );

  /**
   * すべての授業の一覧
   * 
   * @return Call&lt;List&lt;SubjectResponse&gt;&gt;
   */
  @GET("api/teacher/subjects")
  Call<List<SubjectResponse>> fetchAllSubject();
    

  /**
   * 特定の講義の詳細を取得
   * 
   * @param subjectId  (required)
   * @param lectureId  (required)
   * @return Call&lt;SubjectLectureResponse&gt;
   */
  @GET("api/teacher/subjects/{subjectId}/lectures/{lectureId}")
  Call<SubjectLectureResponse> fetchLecture(
    @retrofit2.http.Path("subjectId") Long subjectId, @retrofit2.http.Path("lectureId") Long lectureId
  );

  /**
   * 指定した学生の情報
   * 
   * @param studentId  (required)
   * @return Call&lt;StudentStatusResponse&gt;
   */
  @GET("api/teacher/students/{studentId}")
  Call<StudentStatusResponse> fetchStudent(
    @retrofit2.http.Path("studentId") String studentId
  );

  /**
   * 指定した授業内容の取得
   * 
   * @param subjectId  (required)
   * @return Call&lt;SubjectResponse&gt;
   */
  @GET("api/teacher/subjects/{subjectId}")
  Call<SubjectResponse> fetchSubject(
    @retrofit2.http.Path("subjectId") Long subjectId
  );

}
