package com._520it.controller;

import com._520it.pojo.History;
import com._520it.pojo.Illness;
import com._520it.pojo.PageResult;
import com._520it.service.IllnessServer;
import com._520it.service.impl.IllnessServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/21.
 */
@Controller
@RequestMapping("/admin/illness")
public class IllnessController {

    @Autowired
    private IllnessServer illnessServer;

    @RequestMapping(value = "/saveIllness",method = RequestMethod.POST)
    @ResponseBody
    public String saveIllness(Illness illness,Model model){
        if(illness.getId()==null || illness.getId().trim()=="") {
            illnessServer.saveIllness(illness);
        }else {
            illnessServer.updateIllness(illness);
        }
        model.addAttribute("history",null);
        return "ok";
    }

    @RequestMapping(value = "/queryIllness",method = RequestMethod.POST)
    public String  queryIllness(Illness illness, Model  model){
        if(illness.getName().trim()==""){
            illness.setName(null);
        }
        PageResult result = new PageResult();
        String startPage = illness.getStartPage();
        if(startPage==null || startPage.trim()==""){
            result.setStartPage(1);
        }else {
            result.setStartPage(Integer.parseInt(illness.getStartPage()));
        }
        //统计总记录数
        int totalRecords=illnessServer.countTotal(illness);
        if(totalRecords==0){
            result=null;
        }else{
            result.setTotalRecords(totalRecords);
            result.setPageNum(10);
            result.init();
            //查询医院
            List<Illness> list = illnessServer.queryIllness(illness,result.getStartIndex(),result.getEndIndex());
            result.setList(list);
        }
        model.addAttribute("result",result);
        model.addAttribute("illness",illness);
        return "illnessList";
    }
    @RequestMapping(value = "/removeIllness/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String  removeIllness(@PathVariable("id") String id){
        illnessServer.removeIllness(id);
        return "ok";
    }
    @RequestMapping(value = "/editIllness/{id}")
    public String  editIllness(@PathVariable("id") String id,Model model){
        Illness illness=illnessServer.editIllness(id);
        model.addAttribute("illness",illness);
        return "illness";
    }

}
