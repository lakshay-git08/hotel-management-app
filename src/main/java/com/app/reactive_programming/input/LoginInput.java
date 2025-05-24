package com.app.reactive_programming.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginInput {

    private String email;

    private String password;
}
