package com.app.reactive_programming.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterInput {

    private String name;

    private String email;

    private String phone;

    private String password;

}
