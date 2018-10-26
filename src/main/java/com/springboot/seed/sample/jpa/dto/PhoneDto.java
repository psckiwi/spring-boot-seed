package com.springboot.seed.sample.jpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhoneDto {
    private Long id;
    private Long memberId;
    private String number;
}
