/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dtos;

import java.sql.Timestamp;

/**
 *
 * @author jilanis
 */
public class LoginRespDTO {

    public String user;
    public String token;
    public Timestamp lastAccessDate;

    public Timestamp getlastAccess() {
        return lastAccessDate;
    }

    public void setlastAccess(Timestamp lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
