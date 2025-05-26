package com.bappi.supershopmanagementsystemspringboot.entity;

import com.bappi.supershopmanagementsystemspringboot.enums.ApprovalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String username;

    private String password;

    private String role;

    @Builder.Default
    private LocalDateTime registrationTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;

}
