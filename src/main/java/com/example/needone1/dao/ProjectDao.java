package com.example.needone1.dao;

import com.example.needone1.SqlUtils.ProjectSql;
import com.example.needone1.entity.Project;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;


@Mapper
//@Component
public interface ProjectDao
{
    @Insert("insert INTO projects(NAME,path,createTime,updateTime,password) VALUES(#{name},#{path},#{createTime},#{updateTime},#{password});")
    int createProj(String name, String path, Date createTime, Date updateTime,String password);
    @Update("update projects set name = #{name},path = #{path},password = #{password},updateTime = #{updateTime} where pid = #{pid}")
    void updatePoint(String name, String path, String password, Date updateTime, String pid);

    @Update("update projects set deleteTime = #{deleteTime} where pid = #{pid}")
    void tryDeletePoint(String pid, Date deleteTime);
    @Update("update projects set generateTime = #{generateTime} where pid = #{pid}")
    void guiPoint(String pid, Date generateTime);

    @SelectProvider(type = ProjectSql.class,method = "selectProjects")
    List<Project> getProjects(String type,String msg);

    @Select("select pid,name,path,password,createTime from projects where pid = #{pid}")
    Project getSetPoint(String pid);

    @Select("select * from projects")
    List<Project> testGetAllProjects();
}
