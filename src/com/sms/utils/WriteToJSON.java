/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.utils;

import com.google.gson.Gson;
import com.sms.dtos.NewFrameDTO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jilanis
 */
public class WriteToJSON {
    String filepath = new Utilities().getTempPath()+ "\\.TempAdmsn.json";
    Gson gson = new Gson();
    public void writeToFile(NewFrameDTO dataObj){
        try {
            String jsoString = gson.toJson(dataObj);
            FileWriter fileWriter = new FileWriter(filepath);
            fileWriter.write(jsoString);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteToJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
