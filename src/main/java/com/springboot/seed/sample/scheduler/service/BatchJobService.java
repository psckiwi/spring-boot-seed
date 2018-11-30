package com.springboot.seed.sample.scheduler.service;

import com.springboot.seed.sample.scheduler.BatchJobConstants;
import com.springboot.seed.sample.scheduler.domain.BatchJob;
import com.springboot.seed.sample.scheduler.meta.BatchJobDv;
import com.springboot.seed.sample.scheduler.meta.BatchJobName;
import com.springboot.seed.sample.scheduler.repository.BatchJobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BatchJobService {
    private final Logger log = LoggerFactory.getLogger(BatchJobService.class);

    @Autowired
    private BatchJobRepository batchJobRepository;

    public BatchJob startJob(BatchJobDv jobDv, BatchJobName jobName, String jobArgs) {
        BatchJob job = BatchJob.builder()
            .jobDv(jobDv)
            .jobName(jobName)
            .jobArgs(jobArgs)
            .jobExecYn(BatchJobConstants.JOB_EXEC_YN_NO)
            .crtUserId(BatchJobConstants.BATCH_USER)
            .build();

        return batchJobRepository.save(job);
    }


    public BatchJob finishJob(Long id, String jobExecYn, String jobResult, String remark) {
        BatchJob job = batchJobRepository.findById(id).orElse(null);

        if (job != null) {
            job.setJobExecYn(jobExecYn);
            job.setJobResult(jobResult);
            job.setRemark(remark);
            job.setModUserId(BatchJobConstants.BATCH_USER);
        }

        return job;
    }

    public Boolean isExecJob(BatchJobDv jobDv, BatchJobName jobName) {
        List<BatchJob> execJobs = batchJobRepository.findByJobDvAndJobNameAndJobExecYn(jobDv, jobName, BatchJobConstants.JOB_EXEC_YN_NO);

        if (execJobs != null && execJobs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<BatchJob> findAll() {
        return batchJobRepository.findAll();
    }
}
