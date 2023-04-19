package com.example.needone1.server.Impl;

import com.example.needone1.dao.ProjectDao;
import com.example.needone1.entity.Project;
import com.example.needone1.entity.demo.UpdateInfo;
import com.example.needone1.server.ProjectService;

import com.example.needone1.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao;

    @Override
    public boolean createProj(Project project)
    {
        Date date = DateUtil.getNowDate();
        projectDao.createProj(project.getName(), project.getPath(), date,date,project.getPassword());
        return true;
    }
    @Override
    public List<Project> getProjects(String type,String msg)
    {
        return projectDao.getProjects(type,msg);
    }

    @Override
    public void updatePoint(UpdateInfo updateInfo) throws Exception {
        Date updateTime = DateUtil.getNowDate();
        try {
            projectDao.updatePoint(updateInfo.getName(), updateInfo.getPath(), updateInfo.getPassword(), updateTime, updateInfo.getPid());
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deletePoint(String pid) throws Exception {
        try {
            projectDao.tryDeletePoint(pid,DateUtil.getNowDate());
        }catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void guiPoint(String pid) throws Exception {
        try {
            projectDao.guiPoint(pid,DateUtil.getNowDate());
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }


    @Override//模糊查询
    public List<Project> getLike(String type,String msg) {
        return projectDao.getProjects(type,msg);
    }

    @Override
    public Project getPoint(String pid) {
        return projectDao.getSetPoint(pid);
    }

    @Override
    public List<Project> testGetProjects() {
        return projectDao.testGetAllProjects();
    }
}
