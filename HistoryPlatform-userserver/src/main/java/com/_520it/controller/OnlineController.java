package com._520it.controller;

import com._520it.pojo.Illness;
import com._520it.pojo.KindsUser;
import com._520it.pojo.PageResult;
import com._520it.pojo.User;
import com._520it.service.OnlineService;
import com._520it.service.impl.OnlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 超哥 on 2019/4/25.
 */
@Controller
@RequestMapping("/online")
public class OnlineController {

    @Autowired
    private OnlineServiceImpl onlineService;

    @RequestMapping("/queryOnlineDoctors")
    public String queryOnlineDoctors( Model model){
        List<KindsUser> list = onlineService.queryOnlineDoctors();
        model.addAttribute("result",list);
       return "online";
    }
    @RequestMapping("/joinOnlineChat")
    public String joinOnlineChat(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        if(user==null){
            return "login";
        }
        return "onlineChat";
    }
}
