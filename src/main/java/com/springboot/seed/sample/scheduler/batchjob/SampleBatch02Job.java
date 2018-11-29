package com.springboot.seed.sample.scheduler.batchjob;

import com.springboot.seed.sample.scheduler.BatchJobConstants;
import com.springboot.seed.sample.scheduler.domain.BatchJob;
import com.springboot.seed.sample.scheduler.meta.BatchJobDv;
import com.springboot.seed.sample.scheduler.meta.BatchJobName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SampleBatch02Job extends CommonBatchJob {

    private final Logger log = LoggerFactory.getLogger(SampleBatch02Job.class);

    private final BatchJobDv jobDv = BatchJobDv.SAMPLE;
    private final BatchJobName jobName = BatchJobName.SAMPLE02;

    public void exec() {
        if (isExecJob(jobDv, jobName)) {
            return;
        }

        String jobExecYn = BatchJobConstants.JOB_EXEC_YN_YES;
        String jobResult = "";

        BatchJob job = startJob(jobDv, jobName, "");

        try {
            // TODO - write business logic
            int number = (int) (Math.random() * 100);
            jobResult = String.valueOf(number) + " % 3 = " + String.valueOf(number % 3);
        } catch (Exception e) {
            log.error(e.getMessage());
            jobExecYn = BatchJobConstants.JOB_EXEC_YN_ERROR;
            jobResult = e.getMessage();
        } finally {
            finishJob(job.getId(), jobExecYn, jobResult, "");
        }
    }
}
