package com._520it.controller;

import com._520it.pojo.ArticleQuery;
import com._520it.pojo.History;
import com._520it.pojo.PageResult;
import com._520it.service.impl.HistoryServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/20.
 */
@Controller
@RequestMapping("/admin/history")
public class HistoryController {

    @Autowired
    private HistoryServerImpl historyServer;

    @RequestMapping(value = "/savaHistory",method = RequestMethod.POST)
    @ResponseBody
    public String  saveHistory(History history,Model model){
        if(history.getId()==null || history.getId().trim()=="") {
            historyServer.saveHistory(history);
        }else {
            historyServer.updateHistory(history);
        }
        model.addAttribute("history",null);
        return "ok";
    }
    @RequestMapping(value = "/queryHistorys",method = RequestMethod.POST)
    public String  queryHistorys(History history, Model  model){
        if(history.getName().trim()==""){
            history.setName(null);
        }
        PageResult result = new PageResult();
        String startPage = history.getStartPage();
        if(startPage==null || startPage.trim()==""){
            result.setStartPage(1);
        }else {
            result.setStartPage(Integer.parseInt(history.getStartPage()));
        }
        //统计总记录数
        int totalRecords=historyServer.countTotal(history);
        if(totalRecords==0){
            result=null;
        }else{
            result.setTotalRecords(totalRecords);
            result.setPageNum(10);
            result.init();
            //查询医院
            List<History> list = historyServer.queryHistorys(history,result.getStartIndex(),result.getEndIndex());
            result.setList(list);
        }
        model.addAttribute("result",result);
        model.addAttribute("history",history);
        return "historyList";
    }
    @RequestMapping(value = "/removeHistory/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String  removeHistory(@PathVariable("id") String id){
        historyServer.removeHistory(id);
        return "ok";
    }
    @RequestMapping(value = "/editHistory/{id}")
    public String  editHistory(@PathVariable("id") String id,Model model){
        History history=historyServer.editHistory(id);
        model.addAttribute("history",history);
        return "history";
    }
}
