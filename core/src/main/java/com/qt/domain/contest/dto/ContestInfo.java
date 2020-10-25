package com.qt.domain.contest.dto;

import com.qt.domain.contest.Contest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class ContestInfo {

    @NotNull
    private String name;

    private String description;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime activeTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime inActiveTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime freezeTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime unFreezeTime;

    @Builder
    public ContestInfo(@NotNull String name, String description, @NotNull LocalDateTime activeTime, @NotNull LocalDateTime inActiveTime, @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime, @NotNull LocalDateTime freezeTime, @NotNull LocalDateTime unFreezeTime) {
        this.name = name;
        this.description = description;
        this.activeTime = activeTime;
        this.inActiveTime = inActiveTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.freezeTime = freezeTime;
        this.unFreezeTime = unFreezeTime;
    }

    public Contest toEntity() {
        return new Contest(name, description, activeTime, inActiveTime, startTime, endTime, freezeTime, unFreezeTime);
    }


    //수정 필요???
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", activeTime=" + activeTime +
                ", inActiveTime=" + inActiveTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", freezeTime=" + freezeTime +
                ", unFreezeTime=" + unFreezeTime;
    }
}
