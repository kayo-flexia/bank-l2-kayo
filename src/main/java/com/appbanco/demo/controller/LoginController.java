package com.appbanco.demo.controller;

import com.appbanco.demo.dto.LoginRequestDTO;
import com.appbanco.demo.dto.LoginResponseDTO;
import com.appbanco.demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping //marca el método login como el manejador para las solicitudes HTTP de tipo POST
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        //ResponseEntity controla las respuestas HTTP, que seran del tipo LoginResponseDTO. @RequestBody aguarda por los datos de la solicitud (usuario y clave)
        LoginResponseDTO response = loginService.login(loginRequest);
        return ResponseEntity.ok(response); //Entregamos la respuesta
    }
}
