package com.weplanner.weplanner.api.plan;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.weplanner.weplanner.api.plan.Enum.AuthType;

@Entity
@Table(name = "plan_edit_auth")
public class PlanEditAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "plan_id", nullable = false)
    private Long planId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_writer", nullable = false)
	public AuthType isWriter;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}

