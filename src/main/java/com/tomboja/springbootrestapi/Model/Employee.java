package com.tomboja.springbootrestapi.Model;

import lombok.*;

import javax.persistence.*;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 11/28/21
 */

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email")
    private String email;

}
