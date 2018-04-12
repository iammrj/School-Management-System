/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.utils;

import com.google.gson.Gson;
import com.sms.dtos.NewFrameDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jilanis
 */
public class ReadFromJSON {

    String filepath = new Utilities().getTempPath() + "\\.TempAdmsn.json";
    Gson gson = new Gson();
    NewFrameDTO dataObj;

    public NewFrameDTO readFromFile() {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filepath));
            dataObj = gson.fromJson(bReader, NewFrameDTO.class);
            bReader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFromJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return dataObj;
    }
}
