package com.nateshao.web.scheduleTask;

import com.nateshao.dao.StatisticMapper;
import com.nateshao.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @date Created by 邵桐杰 on 2020/11/10 10:35
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Component
public class ScheduleTask {
    @Autowired
    private StatisticMapper statisticMapper;
    @Autowired
    private MailUtils mailUtils;
    @Value("${spring.mail.username}")
    private String mailto;

    /**
     * 定时邮件发送任务，每月1日中午12点整发送邮件
     */
    @Scheduled(cron = "0 0 12 1 * ?")
//    @Scheduled(cron = "0 */3 * * * ? ")
    public void sendEmail() {
        //  定制邮件内容
        long totalvisit = statisticMapper.getTotalVisit();
        long totalComment = statisticMapper.getTotalComment();
        StringBuffer content = new StringBuffer();
        content.append("博客系统总访问量为：" + totalvisit + "人次").append("\n");
        content.append("博客系统总评论量为：" + totalComment + "人次").append("\n");
        mailUtils.sendSimpleEmail(mailto, "个人博客系统流量统计情况", content.toString());
    }
}