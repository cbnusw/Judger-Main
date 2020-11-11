package com.qt.domain.start;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ContestStartInfo {
    boolean isPossilbe; //시험이 가능한지
    long remainingTime; //남은시간
}
