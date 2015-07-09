package com.epam.edu.student.tasklet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.epam.edu.student.job.writer.ExampleItemWriter;

public class FirstTasklet implements Tasklet, InitializingBean {
	private static final Log log = LogFactory.getLog(FirstTasklet.class);

	private String testParameter;

	private FirstTasklet() {

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(testParameter, "testParameter must be set");
	}

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		if (testParameter == null) {
			throw new UnexpectedJobExecutionException(
					"testParameter must be set");
		} else {
			log.info("FINISHED");
		}
		return RepeatStatus.FINISHED;
	}

	public String getTestParameter() {
		return testParameter;
	}

	public void setTestParameter(String testParameter) {
		this.testParameter = testParameter;
	}

}
