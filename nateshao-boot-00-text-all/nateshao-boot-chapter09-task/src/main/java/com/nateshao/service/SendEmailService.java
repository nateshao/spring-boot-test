package com.nateshao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @date Created by 邵桐杰 on 2020/11/6 10:01
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Service
public class SendEmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送纯文本邮件
     * @param to       收件人地址
     * @param subject  邮件标题
     * @param text     邮件内容
     */
    public void sendSimpleEmail(String to,String subject,String text){
        // 定制纯文本邮件信息SimpleMailMessage
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            // 发送邮件
            mailSender.send(message);
            System.out.println("纯文本邮件发送成功");
        } catch (MailException e) {
            System.out.println("纯文本邮件发送失败 "+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送复杂邮件（包括静态资源和附件）
     * @param to           收件人地址
     * @param subject      邮件标题
     * @param text         邮件内容
     * @param filePath     附件地址
     * @param rscId        静态资源唯一标识
     * @param rscPath      静态资源地址
     */
    public void sendComplexEmail(String to,String subject,String text,String filePath,String rscId,String rscPath){
        // 定制复杂邮件信息MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // 使用MimeMessageHelper帮助类，并设置multipart多部件使用为true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            // 设置邮件静态资源
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            // 设置邮件附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            // 发送邮件
            mailSender.send(message);
            System.out.println("复杂邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("复杂邮件发送失败 "+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送模板邮件
     * @param to       收件人地址
     * @param subject  邮件标题
     * @param content  邮件内容
     */
    public void sendTemplateEmail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // 使用MimeMessageHelper帮助类，并设置multipart多部件使用为true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            // 发送邮件
            mailSender.send(message);
            System.out.println("模板邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("模板邮件发送失败 "+e.getMessage());
            e.printStackTrace();
        }
    }

}