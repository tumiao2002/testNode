package com.example.needone1.SqlUtils;

import org.springframework.stereotype.Component;

@Component
public class ProjectSql
{
    public String selectProjects(String type,String msg)
    {
        String sql = "SELECT pid,name,updateTime from projects";
        if (msg!=null)
            return sql += " where name like \"msg\"";
        if (type.equals("all"))//查询所有项目
        {
            sql += "  where deleteTime = null";
        }
        else if (type.equals("on"))//查询所有正在运行的项目
        {
            sql += " where generateTime = null and deleteTime = null";
        }
        else if (type.equals("gui"))//查询所有已归档的项目
        {
            sql += " where generateTime != null and deleteTime = null";
        }

        return sql;
    }
}
