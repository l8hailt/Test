package com.example.test.upload_file_android_q;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * @author ITSOL JAPAN
 * Created on 01/26/2021.
 * Copyright © 2020 YSL Solution Co., Ltd. All rights reserved.
 *
 * <p>
 **/
public interface RetroService {

    @Multipart
    @POST("tea")
    Call<String> uploadImage(@Part MultipartBody.Part image);

}
