package com.knf.dev.demo.springbootdatablepagination.controller;

import com.knf.dev.demo.springbootdatablepagination.vo.Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @GetMapping({"/", "/view"})
    public String view() {
        return "index";
    }

    @GetMapping({"/getcall"})
    public ResponseEntity<Vo> listAllUsers() {

        // Dummy list of values
        List<String[]> obj = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            String uname = "username-";
            String lname = "lastname-";
            String Id = "Id-";
            String email = "sibinknf@gmail.com-";
            String pin = "pin-";
            String mStringArray[] = {uname + i, lname + i, Id + i, 
                                        email + i, pin + i};
            obj.add(mStringArray);

        }
        Vo vo = new Vo();
        vo.setData(obj);
        return new ResponseEntity<>(vo, HttpStatus.OK);

    }
} 
