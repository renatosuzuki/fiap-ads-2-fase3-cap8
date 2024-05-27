package com.fiap.microservicos.atividadecap8.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fiap.microservicos.atividadecap8.model.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    Algorithm algo = Algorithm.HMAC256("fiap-secreto");

    public String gerarToken(User usuario) {
        String token = JWT
                .create()
                .withIssuer("fiap")
                .withSubject(usuario.getUsername())
                .withExpiresAt(gerarDataExpiracao())
                .sign(algo);

        return token;
    }

    public String validarToken(String token) {
        try {
            return JWT
                    .require(algo)
                    .withIssuer("fiap")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant gerarDataExpiracao() {
        return LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
