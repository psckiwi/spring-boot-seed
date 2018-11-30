package com.springboot.seed.sample.jpa.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "tb_member")
public class Member extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "member_name", length = 100, nullable = false)
    private String memberName;

    @NotNull
    @Column(name = "team_id")
    private Long teamId;

    @Builder
    private Member(String memberName, Long teamId) {
        this.memberName = memberName;
        this.teamId = teamId;
    }

}
