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

import org.hibernate.annotations.ColumnDefault;

import com.weplanner.weplanner.api.plan.Enum.CompanionType;
import com.weplanner.weplanner.api.plan.Enum.PlaceType;
import com.weplanner.weplanner.api.plan.Enum.ThemeType;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "place", nullable = false)
    private PlaceType place;
    
    @Column(name = "companion_type", nullable = false)
    private CompanionType companionType;

    @Column(name = "theme_type", nullable = false)
    private ThemeType themeType;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "thumbnail", length = 100, nullable = true)
    private String thumbnail;

    @ColumnDefault("0")
    @Column(name = "view_cnt", nullable = false)
    private Long viewCnt;

    @Column(name = "is_private", nullable = false )
    private boolean isPrivate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;
}
