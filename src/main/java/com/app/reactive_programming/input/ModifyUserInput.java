package com.app.reactive_programming.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModifyUserInput {

    private String name;

    private String email;

    private String phone;

    private String password;

}
