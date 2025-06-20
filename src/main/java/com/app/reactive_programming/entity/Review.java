package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private String id;

    private String userId;

    private String hotelId;

    private Float rating;

    private String comment;

    private Date createdAt;

    private Date updatedAt;

    private Boolean deleted;

    private Boolean active;

}
