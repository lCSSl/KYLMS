package com.kaiyu56.job.util;

import org.quartz.JobExecutionContext;

import com.kaiyu56.job.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 *
 * @author css
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
