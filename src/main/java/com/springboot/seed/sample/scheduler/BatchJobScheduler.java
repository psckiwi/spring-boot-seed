package com.springboot.seed.sample.scheduler;

import com.springboot.seed.sample.scheduler.batchjob.SampleBatch01Job;
import com.springboot.seed.sample.scheduler.batchjob.SampleBatch02Job;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Profile({"batch"})
@Component
public class BatchJobScheduler {
    private final Logger log = LogManager.getLogger(BatchJobScheduler.class);

    @Autowired
    private SampleBatch01Job sampleBatch01Job;

    @Autowired
    private SampleBatch02Job sampleBatch02Job;

    // *****************************************************************************************************************
    // @Scheduled(initialDelay = 1000, fixedDelay = 300000)
    @Scheduled(fixedRate = 5000)
    public void sampleBatch01Job() {
        sampleBatch01Job.exec();
    }

    // *****************************************************************************************************************
    @Scheduled(cron = "0 * * * * *")
    public void sampleBatch02Job() {
        sampleBatch02Job.exec();
    }
}

