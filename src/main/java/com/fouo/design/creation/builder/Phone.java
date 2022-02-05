package com.fouo.design.creation.builder;

import lombok.*;

@Data
@Builder
public class Phone {
    private String cpu;
    private String mem;
    private String disk;
    private String cam;
}
