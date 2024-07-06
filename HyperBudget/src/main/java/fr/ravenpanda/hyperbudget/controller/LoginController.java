package fr.ravenpanda.hyperbudget.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("login page");
    }
}
