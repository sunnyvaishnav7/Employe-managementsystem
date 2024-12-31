package com.example.em_project;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // this use for comented name , phone number.
@NoArgsConstructor
@AllArgsConstructor


public class Employee {
    @Id
    private Long id;

    private String name;
    private String phone;
    private String email;
    
}
