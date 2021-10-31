package com.knf.springboot.keycloak.controller;

import com.knf.springboot.keycloak.keycloakservice.KeycloakService;
import com.knf.springboot.keycloak.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/employees")
@RestController
public class EmployeeController {

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createEmployee
            (@RequestBody EmployeeVO employeeVo) {
        return ResponseEntity.ok(keycloakService.
                createEmployee(employeeVo));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login
            (@RequestBody EmployeeVO employeeVo) {
        return ResponseEntity.ok(keycloakService.
                login(employeeVo));
    }

    @GetMapping(value = "/unprotected")
    public String getUnProtectedData() {
        return "This api is not protected.";
    }

    @GetMapping(value = "/protected")
    public String getProtectedData() {
        return "This api is protected.";
    }
}