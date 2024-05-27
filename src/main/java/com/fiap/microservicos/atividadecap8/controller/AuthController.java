package com.fiap.microservicos.atividadecap8.controller;

import com.fiap.microservicos.atividadecap8.dto.TokenDto;
import com.fiap.microservicos.atividadecap8.model.User;
import com.fiap.microservicos.atividadecap8.service.TokenService;
import com.fiap.microservicos.atividadecap8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authentication;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity logar(@RequestBody User usuario){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuario.getUsername(), usuario.getPassword()
                );

        Authentication auth = authentication.authenticate(usernamePassword);

        String token = tokenService.gerarToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDto(token));
    }

    @RequestMapping("/users")
    public ResponseEntity cadastrar(@RequestBody User usuario){
    User userNovo = userService.gravar(usuario);
    return ResponseEntity.ok(userNovo);
    }
}
