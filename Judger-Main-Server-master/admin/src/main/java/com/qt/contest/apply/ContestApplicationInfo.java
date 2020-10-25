package com.qt.contest.apply;

import com.qt.domain.contest.dto.ContestInfo;
import com.qt.domain.user.dto.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class ContestApplicationInfo {

    @NotNull
    private Long id;

    @NotNull
    private ContestInfo contestInfo;

    @NotNull
    private UserInfo userInfo;

    @NotNull
    private Boolean isApproved;

    @Builder
    public ContestApplicationInfo(@NotNull Long id, @NotNull ContestInfo contestInfo, @NotNull UserInfo userInfo, @NotNull Boolean isApproved) {
        this.id = id;
        this.contestInfo = contestInfo;
        this.userInfo = userInfo;
        this.isApproved = isApproved;
    }
}
