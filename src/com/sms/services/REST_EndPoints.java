/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services;
import retrofit2.Call;
import retrofit2.http.*;
import com.sms.dtos.*;

/**
 *
 * @author jilanis
 */
public interface REST_EndPoints {
    @Headers({"Content-Type: application/json"})
	@POST("login/")
	Call<LoginRespDTO> login(@Body LoginDTO loginReq);
        
}
