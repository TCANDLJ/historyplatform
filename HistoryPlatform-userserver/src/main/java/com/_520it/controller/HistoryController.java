package com._520it.controller;

import com._520it.pojo.History;
import com._520it.pojo.KindsUser;
import com._520it.pojo.PageResult;
import com._520it.service.impl.HistoryServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/24.
 */
@Controller
@RequestMapping("/history")
public class HistoryController  {

    @Autowired
    private HistoryServerImpl historyServer;

    @RequestMapping("/queryHistory")
    public String  queryHistory(History history, Model model){
        PageResult result = new PageResult();

        if(history.getName() ==null || history.getName().equals("")  ){
            history.setName("北京大学第三医院");
        }
        if(history.getKinds() ==null || history.getKinds().equals("")  ){
            history.setKinds("1");
        }
        if(history.getStartPage() ==null || history.getStartPage().equals("")){
            result.setStartPage(1);
        }else {
            result.setStartPage(Integer.parseInt(history.getStartPage()));
        }
        History his = historyServer.queryHistory(history);
        if(his !=null){
            history.setName(his.getName());
            his.setKinds(history.getKinds());
            model.addAttribute("history",his);
            //分页
            //统计总记录数
            int totalRecords = historyServer.countUserTotal(history);
            if (totalRecords == 0) {
                result = null;
            } else {
                result.setTotalRecords(totalRecords);
                result.setPageNum(3);
                result.init();
                //查询医院
                List<KindsUser> list = historyServer.queryKinds(history, result.getStartIndex(), result.getEndIndex());
                result.setList(list);
            }
            model.addAttribute("result",result);
        }else {
            model.addAttribute("history",null);
        }
        return "history";
    }
}
