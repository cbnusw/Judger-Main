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
    private LocalDateTime startTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endTime;


    @Builder
    public ContestInfo(@NotNull String name, String description,@NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime ) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Contest toEntity() {
        return new Contest(name, description, startTime, endTime);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime;
    }
}
