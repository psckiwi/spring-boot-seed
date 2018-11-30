package com.springboot.seed.sample.jpa.dto;

import com.springboot.seed.sample.jpa.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto {
    private Long id;
    private String teamName;
    private Collection<Member> members;
}
