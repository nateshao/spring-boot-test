package com.nateshao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
/**
 * @date Created by 邵桐杰 on 2020/11/6 10:12
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendEmailServiceTest {
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleMailTest() {
        String to="1210331079@qq.com";
        String subject="【纯文本邮件】标题";
        String text="Spring Boot纯文本邮件发送内容测试.....";
        // 发送简单邮件
        sendEmailService.sendSimpleEmail(to,subject,text);
    }

    @Test
    public void sendComplexEmailTest() {
        String to="2127269781@qq.com";
        String subject="【复杂邮件】标题";
        // 定义邮件内容
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head>");
        text.append("<body><h1>祝大家元旦快乐！</h1>");
        // cid为固定写法，rscId指定一个唯一标识
        String rscId = "img001";
        text.append("<img src='cid:" +rscId+"'/></body>");
        text.append("</html>");
        // 指定静态资源文件和附件路径
        String rscPath="F:\\email\\newyear.jpg";
        String filePath="F:\\email\\元旦放假注意事项.docx";
        // 发送复杂邮件
        sendEmailService.sendComplexEmail(to,subject,text.toString(),filePath,rscId,rscPath);
    }


    @Test
    public void sendTemplateEmailTest() {
        String to="2127269781@qq.com";
        String subject="【模板邮件】标题";
        // 使用模板邮件定制邮件正文内容
        Context context = new Context();
        context.setVariable("username", "石头");
        context.setVariable("code", "456123");
        // 使用TemplateEngine设置要处理的模板页面
        String emailContent = templateEngine.process("emailTemplate_vercode", context);
        // 发送模板邮件
        sendEmailService.sendTemplateEmail(to,subject,emailContent);
    }


}