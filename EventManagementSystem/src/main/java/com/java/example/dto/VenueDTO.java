package com.java.example.dto;

import lombok.Data;

@Data
public class VenueDTO {
    private Long id;
    private String name;
    private String location;
    private int capacity;
}
