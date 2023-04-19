package com.example.needone1.server;

import com.example.needone1.entity.Project;
import com.example.needone1.entity.demo.UpdateInfo;
import com.example.needone1.utils.R;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目管理页面
 */
@Service
public interface ProjectService {

    boolean createProj(Project project);

    List<Project> getProjects(String type,String msg);

    void deletePoint(String pid) throws Exception;

    void guiPoint(String pid) throws Exception;

    void updatePoint(UpdateInfo updateInfo) throws Exception;

    List<Project> getLike(String type,String msg);

    Project getPoint(String pid);

    List<Project> testGetProjects();
}
