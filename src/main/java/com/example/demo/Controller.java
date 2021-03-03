package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@RestController
public class Controller {
    @PostMapping("/addUser")
    public void addUser() {

    }

    @GetMapping("/home")
    public ArrayList<String> getHome() {
        ArrayList<String> al = new ArrayList<>();
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mingle?useSSL=false", "root", null);
            System.out.println("Executed API call");
            PreparedStatement s = c.prepareStatement("select friendEmail_A from friend ");
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                al.add(rs.getString("friendEmail_A"));
            }
            return al;
        } catch (Exception ex) {
            al.add(ex.getMessage());
            return al;
        }
    }
}