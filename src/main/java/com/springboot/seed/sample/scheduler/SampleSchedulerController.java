package com.springboot.seed.sample.scheduler;

import com.springboot.seed.sample.scheduler.batchjob.SampleBatch01Job;
import com.springboot.seed.sample.scheduler.batchjob.SampleBatch02Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleSchedulerController {

    @Autowired
    private SampleBatch01Job sampleBatch01Job;

    @Autowired
    private SampleBatch02Job sampleBatch02Job;

    @PostMapping("/batch/sample01")
    public void sampleBatch01Job() {
        sampleBatch01Job.exec();
    }

    @PostMapping("/batch/sample02")
    public void sampleBatch02Job() {
        sampleBatch02Job.exec();
    }
}
