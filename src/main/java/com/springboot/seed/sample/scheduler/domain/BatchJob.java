package com.springboot.seed.sample.scheduler.domain;


import com.springboot.seed.sample.scheduler.meta.BatchJobDv;
import com.springboot.seed.sample.scheduler.meta.BatchJobName;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "tb_batch_job")
public class BatchJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "job_dv", length = 255, nullable = false)
    @Enumerated(EnumType.STRING)
    private BatchJobDv jobDv;

    @NotNull
    @Column(name = "job_name", length = 255, nullable = false)
    @Enumerated(EnumType.STRING)
    private BatchJobName jobName;

    @Size(max = 255)
    @Column(name = "job_args", length = 255)
    private String jobArgs;

    @NotNull
    @Size(max = 1)
    @Column(name = "job_exec_yn", length = 1, nullable = false)
    private String jobExecYn;

    @Size(max = 255)
    @Column(name = "job_result", length = 255)
    private String jobResult;

    @Size(max = 255)
    @Column(name = "remark", length = 255)
    private String remark;

    @NotNull
    @Size(max = 100)
    @Column(name = "reg_user_id", length = 100, nullable = false)
    private String regUserId;

    @Column(name = "reg_dttm")
    private ZonedDateTime regDttm;

    @Size(max = 100)
    @Column(name = "modf_user_id", length = 100)
    private String modfUserId;

    @Column(name = "modf_dttm")
    private ZonedDateTime modfDttm;

    @Builder
    private BatchJob(BatchJobDv jobDv, BatchJobName jobName, String jobArgs, String jobExecYn, String jobResult, String remark, String regUserId, ZonedDateTime regDttm, String modfUserId, ZonedDateTime modfDttm)
    {
        this.jobDv = jobDv;
        this.jobName = jobName;
        this.jobArgs = jobArgs;
        this.jobExecYn = jobExecYn;
        this.jobResult = jobResult;
        this.remark = remark;
        this.regUserId = regUserId;
        this.regDttm = regDttm;
        this.modfUserId = modfUserId;
        this.modfDttm = modfDttm;
    }
}
