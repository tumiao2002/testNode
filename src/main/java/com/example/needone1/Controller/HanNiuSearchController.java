package com.example.needone1.Controller;

import com.example.needone1.entity.Project;
import com.example.needone1.entity.demo.UpdateInfo;
import com.example.needone1.server.ProjectService;
import com.example.needone1.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Test")
public class HanNiuSearchController {
    @Autowired
    ProjectService projectService;

    //1. 新建项目
    @PostMapping("/CreateProject")
    public R createProj(@RequestBody Project project) {
        if (project == null)
            return new R(null,"传入对象为空！",400);
        boolean proj = projectService.createProj(project);
        if (proj)
            return new R(null,"创建项目成功！",200);
        return new R(null,"创建项目失败！",400);
    }

    //2. 全部项目
    //2.1 查看全部项目
    @GetMapping("/All/GetProjects")
    public R getAllProjects()
    {
        List<Project> allProjects = projectService.getProjects("all",null);
        return new R(allProjects,"数据查询成功！",200);
    }
    //2.2 修改指定项目

    @PostMapping("/All/UpdatePoint")
    public R allUpdatePoint(@RequestBody UpdateInfo updateInfo) {
       if (updateInfo == null)
           return new R(null,"传入数据不能为空！",400);
//       if (updateInfo.getPid() == null)
//           return new R(null,"传入pid数据不能为空！",400);
//        if (updateInfo.getPath() == null)
//            return new R(null,"传入path数据不能为空！",400);
//        if (updateInfo.getName() == null)
//            return new R(null,"传入name数据不能为空！",400);
//        if (updateInfo.getCreateTime() == null)
//            return new R(null,"传入createTime数据不能为空！",400);
//        if (updateInfo.getPassword() == null)
//            return new R(null,"传入password数据不能为空！",400);
        try {
            projectService.updatePoint(updateInfo);
            return new R(null,"修改成功！",200);
        }catch (Exception e)
        {
            return new R(null,"修改失败！",500);
        }
    }

    //2.3 删除指定项目

    @PostMapping("/All/deletePoint")
    public R allDeletePoint(@RequestParam String pid)//得到可以确定唯一项目的数据
    {
        if (pid == null || pid.length() < 1)
            return new R(null, "pid为空！", 400);
        try {
            projectService.deletePoint(pid);
            return new R(null,"删除成功！",500);
        } catch (Exception e)
        {
            return new R(null,"删除失败！",500);
        }
    }

    //2.4 对指定项目进行归档
    @PostMapping("/All/GuiPoint")
    public R allGuiPoint(@RequestParam String pid)//得到可以确定唯一项目的数据
    {
        if (pid == null || pid.length() <1 )
            return new R(null,"pid为空！",400);
        try {
            projectService.guiPoint(pid);
            return new R(null,"归档成功！",200);
        }
        catch (Exception e)
        {
            return new R(null,"归档失败！",500);
        }
    }
    //3. 正在进行项目

    //3.1 查看正在进行的全部项目（返回所有正在进行的项目信息）
    @GetMapping("/On/AllProjects")
    public R onAllProjects()//返回正在进行的全部项目的信息
    {
        try {
            return new R(projectService.getProjects("on",null), "查询成功", 200);
        } catch (Exception e)
        {
            return new R(null,"归档失败！",500);
        }
    }

    //3.2 修改指定项目
    @PostMapping("/On/UpdatePoint")
    public R onUpdatePoint(@RequestBody UpdateInfo updateInfo)//唯一项目信息 + 修改信息
    {
        try {
            projectService.updatePoint(updateInfo);
            return new R(null,"修改成功！",200);
        }catch (Exception e)
        {
            return new R(null,"修改失败！",500);
        }
    }

    //3.3 删除指定项目
    @DeleteMapping("/On/DeletePoint")
    public R onDeletePoint(@RequestParam String pid)//确认删除项目信息//唯一项目信息
    {
        try {
            projectService.deletePoint(pid);
            return new R(null,"删除成功",200);
        }catch (Exception e)
        {
            return new R(null,"删除失败！",500);
        }
    }

    //3.4 对指定项目进行归档
    @PostMapping("/On/GuiPoint")
    public R onGuiPoint(@RequestParam String pid)//唯一项目信息
    {
        try {
            projectService.guiPoint(pid);
            return new R(null,"归档成功",200);
        }catch (Exception e)
        {
            return new R(null,"归档失败！",500);
        }
    }
    //4. 神已归档

    //4.1 查看全部已归档项目（返回所有已归档项目信息）
    @GetMapping("/Shen/AllProjects")
    public R shenAllProjects() {
        try {
            List<Project> projects = projectService.getProjects("gui",null);
            return new R(projects,"查询成功",200);
        }catch (Exception e)
        {
            return new R(null,"查询失败！",500);
        }
    }

    //4.2 修改指定项目
    @PostMapping("/Shen/UpdatePoint")
    public R shenUpdatePoint(@RequestBody UpdateInfo updateInfo) {
        try {
            projectService.updatePoint(updateInfo);
            return new R(null,"修改成功",200);
        }catch (Exception e)
        {
            return new R(null,"修改失败！",500);
        }
    }

    //4.3 删除指定项目
    @DeleteMapping("/Shen/DelPoint")
    public R shenDelPoint(@RequestParam String pid) {
        try {
            projectService.deletePoint(pid);
            return new R(null,"删除成功",200);
        }catch (Exception e)
        {
            return new R(null,"删除失败！",500);
        }
    }

    //4.4 对指定项目取消归档
    @PostMapping("/Shen/UnGui")
    public R shenUnGui(@RequestParam String pid) {
        try {
            projectService.guiPoint(pid);
            return new R(null,"删除成功",200);
        }catch (Exception e)
        {
            return new R(null,"删除失败！",500);
        }
    }

    //5. 项目搜素（输入关键字，根据项目名称搜索出项目）
    @GetMapping("/Search/SearchProjects")
    public R searchSearchProjects(@RequestParam String msg) {
        if (msg == null || msg.length() == 0)
            return new R(null,"输入数据不能为空！",400);
        try {
            List<Project> projects = projectService.getLike(null,msg);
            return new R(projects,"查询成功",200);
        }catch (Exception e)
        {
            return new R(null,"查询失败！",500);
        }
    }

    //6. 项目设置界面信息
    @GetMapping("/Set/GetInfos")
    public R SetGetInfos(@RequestParam String pid)
    {
        try {
            Project project = projectService.getPoint(pid);
            return new R(project,"查询成功",200);
        }catch (Exception e)
        {
            return new R(null,"查询失败！",500);
        }
    }
}
