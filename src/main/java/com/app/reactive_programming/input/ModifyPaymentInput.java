package com.app.reactive_programming.input;

import com.app.reactive_programming.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModifyPaymentInput {

    private PaymentStatus status;

}
