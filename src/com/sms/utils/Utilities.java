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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jilanis
 */
public class Utilities {

    String homeDir = System.getProperty("user.home");
    String filepath = homeDir + File.separator + ".usl.RAJ";
    String JSONfilepath = getTempPath() + "\\.TempAdmsn.json";
    Gson gson = new Gson();
    NewFrameDTO dataObj;
    File file = new File(filepath);
    java.util.Properties properties = System.getProperties();

    public void writeToFile(NewFrameDTO dataObj) {
        try {
            String jsoString = gson.toJson(dataObj);
            FileWriter fileWriter = new FileWriter(JSONfilepath);
            fileWriter.write(jsoString);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NewFrameDTO readFromFile() {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filepath));
            dataObj = gson.fromJson(bReader, NewFrameDTO.class);
            bReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataObj;
    }

    public String getUserToken() throws IOException {

        StringBuilder fileContents = new StringBuilder((int) file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");
        try {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine()).append(lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }

    public void setUserToken(String token) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        PrintWriter writer;
        try {
            writer = new PrintWriter(filepath, "UTF-8");
            writer.println(token);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logoutUser() {
        setUserToken("");
    }

    public String getTempPath() {
        System.out.println(properties.getProperty("java.io.tmpdir"));
        return properties.getProperty("java.io.tmpdir");
    }
}
