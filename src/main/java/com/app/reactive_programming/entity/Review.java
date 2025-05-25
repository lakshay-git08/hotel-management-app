package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {

    @Id
    private String id;

    private String userId;

    private String hotelId;

    private Float rating;

    private String comment;

    private Date createdAt;

    private Date updatedAt;

}
