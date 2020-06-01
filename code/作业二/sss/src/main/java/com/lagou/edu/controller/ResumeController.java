package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    /**
     * Spring容器和SpringMVC容器是有层次的（父子容器）
     * Spring容器：service对象+dao对象
     * SpringMVC容器：controller对象，，，，可以引用到Spring容器中的对象
     */


    @Autowired
    private ResumeService accountService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Resume> findAll() throws Exception {
        return accountService.findAll();
    }

    @RequestMapping(value = "/deleteById",method = {RequestMethod.POST})
    @ResponseBody
    public void deleteById(@RequestBody Resume resume) {
        accountService.deleteById(resume.getId());
    }

    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    @ResponseBody
    public void edit(@RequestBody Resume resume) {
        accountService.save(resume);
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public String add(String address,String name,String phone) {
        Resume resume = new Resume();
        resume.setAddress(address);
        resume.setName(name);
        resume.setPhone(phone);
        accountService.save(resume);
        return "resume";
    }

}
