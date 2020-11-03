package com.example.demo.controller;
import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log
@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping("")
    public ResponseEntity<List<Menu>> list(Menu menu) throws Exception {

        return new ResponseEntity<>(service.list(menu), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(HttpServletRequest request, String id) throws Exception {
        log.info("Controller Menu Create File");

        MultipartHttpServletRequest mult = null;
        return null;
    }

    @PostMapping("/fileremove")
    public ResponseEntity file() throws Exception {
        return null;
    }
}
