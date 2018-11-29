package com.springboot.seed.sample.scheduler.batchjob;

import com.springboot.seed.sample.scheduler.domain.BatchJob;
import com.springboot.seed.sample.scheduler.meta.BatchJobDv;
import com.springboot.seed.sample.scheduler.meta.BatchJobName;
import com.springboot.seed.sample.scheduler.service.BatchJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonBatchJob {

    private final Logger log = LoggerFactory.getLogger(CommonBatchJob.class);

    @Autowired
    BatchJobService batchJobService;

    protected Boolean isExecJob(BatchJobDv jobDv, BatchJobName jobName) {
        return batchJobService.isExecJob(jobDv, jobName);
    }

    protected BatchJob startJob(BatchJobDv jobDv, BatchJobName jobName, String jobArgs) {
        log.info("##### BatchJob started... [jobDv] : {} / [jobName] : {} (args : {})", jobDv, jobName, jobArgs);
        return batchJobService.startJob(jobDv, jobName, jobArgs);
    }

    protected BatchJob finishJob(Long id, String jobExecYn, String jobResult, String remark) {
        log.info("##### BatchJob finished... [id] : {} / [jobExecYn] : {} / [jobResult] : {} / [remark] : {}", id, jobExecYn, jobResult, remark);
        return batchJobService.finishJob(id, jobExecYn, jobResult, remark);
    }
}
