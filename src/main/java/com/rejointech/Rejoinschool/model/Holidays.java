package com.rejointech.Rejoinschool.model;

import lombok.Data;

@Data
public class Holidays {
    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FESTIVAL,FEDERAL
    }
}
