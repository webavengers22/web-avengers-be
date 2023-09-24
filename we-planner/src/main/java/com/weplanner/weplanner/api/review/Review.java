package com.weplanner.weplanner.api.review;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SQLDelete(sql= "UPDATE plan_review SET deleted_at = current_timestamp WHERE id = ?")
@Where(clause = "deleted_at is null")
@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@Table(name = "plan_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="plan_id", nullable = false)
    private Long planId;

    @Column(name ="description", columnDefinition = "LONGTEXT", nullable = false)
    private String description;

    @Column(name ="last_writer_id", nullable = false)
    private Long lastWriterId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;
}
