package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.app.reactive_programming.enums.HotelStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hotel {

    @Id
    private String id;

    private String userId;

    private String name;

    private String description;

    private HotelAddress address;

    private String[] amenities;

    private String[] images;

    private HotelStatus status;

    private Date createdAt;

}

// {
// "_id": "ObjectId",
// "ownerId": "ObjectId (ref to users)",
// "name": "string",
// "description": "string",
// "address": {
// "street": "string",
// "city": "string",
// "state": "string",
// "zipCode": "string",
// "location": {
// "type": "Point",
// "coordinates": [longitude, latitude]
// }
// },
// "amenities": ["WiFi", "TV", "AC", "Parking"],
// "images": ["url1", "url2"],
// "status": "PENDING | APPROVED | REJECTED",
// "createdAt": "Date"
// }