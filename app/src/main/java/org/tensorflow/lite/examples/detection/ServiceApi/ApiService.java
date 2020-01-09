package org.tensorflow.lite.examples.detection.ServiceApi;


import org.tensorflow.lite.examples.detection.model.AddUserResponse;
import org.tensorflow.lite.examples.detection.model.FaceSearch;
import org.tensorflow.lite.examples.detection.model.LoginApi.Login;
import org.tensorflow.lite.examples.detection.model.LoginHeader;
import org.tensorflow.lite.examples.detection.model.ManualAddUser;
import org.tensorflow.lite.examples.detection.model.SearchHeaderr;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {


    @POST("auth/searchWithEncodedImage")
    Call<FaceSearch> getresult(@Body SearchHeaderr searchHeader);


    @Multipart
    @POST("images/singleImage/")
    Call<AddUserResponse> saveNewUser(@Part MultipartBody.Part file,
                                      @Part("name") RequestBody name,
                                      @Part("user_id") RequestBody user_id);


    @Multipart
    @POST("images/singleImageForApproval")
    Call<ManualAddUser> addNewUser(@Part MultipartBody.Part file,
                                   @Part("user_id") RequestBody userId);

}
