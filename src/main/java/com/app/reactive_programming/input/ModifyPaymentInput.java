package com.app.reactive_programming.input;

import com.app.reactive_programming.enums.PaymentStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModifyPaymentInput {

    private PaymentStatus status;

}
