package com.nateshao.activiti;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.apache.catalina.security.SecurityUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class NateshaoBoot19ActivitiApplicationTests {

    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private SecurityUtil securityUtil;

//    @Test
//    public void contextLoads() {
//        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(SpringDataWebProperties.Pageable.of(0, 10));
//        processDefinitionPage.getContent().forEach(System.out::println);
//    }

}
