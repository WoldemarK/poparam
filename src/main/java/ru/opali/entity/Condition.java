package ru.opali.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Condition {
    private String sex;
    private Long ageFrom;
    private Long ageTo;
    private Long distance;
    private boolean isOns;
    private boolean isFwb;
    private boolean isStp;
    private boolean isLtp;
    private boolean isDontKnow;

}
