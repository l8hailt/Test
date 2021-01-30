package com.example.test.upload_file_android_q;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ITSOL JAPAN
 * Created on 01/26/2021.
 * Copyright © 2020 YSL Solution Co., Ltd. All rights reserved.
 *
 * <p>
 **/
public class RetroClient {

    private static RetroService instance;

    public static RetroService getInstance() {

        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.116:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            instance = retrofit.create(RetroService.class);
        }
        return instance;
    }

}
