package com._520it.controller;

import com._520it.pojo.Illness;
import com._520it.service.impl.IllnessServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/23.
 */
@Controller
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    private IllnessServerImpl illnessServer;

    @RequestMapping("/queryIllness")
    public String queryIllness(Illness illness, Model model){
        List<Illness> result=illnessServer.queryIllness(illness);
        model.addAttribute("result",result);
        return "detail";
    }
    @RequestMapping("/query/{name}")
    public String query(@PathVariable("name") String name, Model model){
        Illness illness = new Illness();
        illness.setName(name);
        List<Illness> result=illnessServer.queryIllness(illness);
        model.addAttribute("result",result);
        return "detail";
    }

}
