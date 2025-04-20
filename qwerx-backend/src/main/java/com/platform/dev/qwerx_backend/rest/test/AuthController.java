package com.platform.dev.qwerx_backend.rest.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Authentication", description = "Operations related to authentication")
public class AuthController {

    @PostMapping("/authenticate")
    @Operation(
            summary = "Authenticate user",
            description = "Validates username and password and returns a token (dummy implementation)",
            responses = {
                @ApiResponse(responseCode = "200", description = "Authenticated successfully"),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                @ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
            }
        )
        public String authenticate(@RequestBody AuthRequest request) {
            if ("admin".equals(request.getUsername()) && "admin".equals(request.getPassword())) {
                return "dummy-jwt-token";
            } else {
                throw new RuntimeException("Unauthorized");
            }
        }

        // DTO interno o separato
        public static class AuthRequest {
            private String username;
            private String password;

            // Getters e setters
            public String getUsername() { return username; }
            public void setUsername(String username) { this.username = username; }

            public String getPassword() { return password; }
            public void setPassword(String password) { this.password = password; }
        }
    }
