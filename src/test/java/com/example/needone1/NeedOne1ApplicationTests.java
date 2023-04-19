package com.example.needone1;

import com.example.needone1.entity.Project;
import com.example.needone1.server.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class NeedOne1ApplicationTests {

    @Test
    void contextLoads() {

    }
    @Test
    public  void getNowDate()
    {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.format(date);
        System.out.println(dateFormat);
    }
    @Autowired
    ProjectService projectService;
    @Test
    public void testMysql()
    {
        List<Project> projects = projectService.testGetProjects();
        System.out.println(projects);
    }
}
