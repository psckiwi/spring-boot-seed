package com.springboot.seed.sample.scheduler.repository;

import com.springboot.seed.sample.scheduler.domain.BatchJob;
import com.springboot.seed.sample.scheduler.meta.BatchJobDv;
import com.springboot.seed.sample.scheduler.meta.BatchJobName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchJobRepository extends JpaRepository<BatchJob, Long> {

    List<BatchJob> findByJobDvAndJobNameAndJobExecYn(BatchJobDv jobDv, BatchJobName jobName, String jobExecYn);
}
