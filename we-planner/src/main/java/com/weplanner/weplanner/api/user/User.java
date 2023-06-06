package com.weplanner.weplanner.api.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "brithdate")
    private LocalDate brithdate;

    @Column(name = "gender", length = 2)
    @ColumnDefault("'U'")
    private String gender;

    @Column(name = "with_type", length = 5)
    private String withType;

    @Column(name = "user_role", nullable = false)
    @ColumnDefault("1")
    private Long userRole;

    @Column(name = "isReceive", nullable = false)
    private boolean isReceive;

    @Column(name = "created_at")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
