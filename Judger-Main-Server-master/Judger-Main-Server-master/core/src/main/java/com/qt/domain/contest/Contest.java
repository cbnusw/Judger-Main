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
    private LocalDateTime activeTime;

    @NotNull
    private LocalDateTime inActiveTime;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @NotNull
    private LocalDateTime freezeTime;

    @NotNull
    private LocalDateTime unFreezeTime;

    public Contest(@NotNull String name, String description, @NotNull LocalDateTime activeTime, @NotNull LocalDateTime inActiveTime, @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime, @NotNull LocalDateTime freezeTime, @NotNull LocalDateTime unFreezeTime) {
        this.name = name;
        this.description = description;
        this.activeTime = activeTime;
        this.inActiveTime = inActiveTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.freezeTime = freezeTime;
        this.unFreezeTime = unFreezeTime;
    }

    public Long updateTo(ContestInfo contestInfo) {
        this.name = contestInfo.getName();
        this.description = contestInfo.getDescription();
        this.activeTime = contestInfo.getActiveTime();
        this.inActiveTime = contestInfo.getInActiveTime();
        this.startTime = contestInfo.getStartTime();
        this.endTime = contestInfo.getEndTime();
        this.freezeTime = contestInfo.getFreezeTime();
        this.unFreezeTime = contestInfo.getUnFreezeTime();
        return id;
    }
}
