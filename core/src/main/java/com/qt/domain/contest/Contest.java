package com.qt.domain.contest;

import com.qt.domain.contest.dto.ContestInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Contest {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Lob
    private String description;


    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;


    public Contest(@NotNull String name, String description, @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public Long updateTo(ContestInfo contestInfo) {
        this.name = contestInfo.getName();
        this.description = contestInfo.getDescription();
        this.startTime = contestInfo.getStartTime();
        this.endTime = contestInfo.getEndTime();
        return id;
    }
}
