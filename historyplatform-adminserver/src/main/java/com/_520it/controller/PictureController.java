package com._520it.controller;

import com._520it.pojo.Illness;
import com._520it.pojo.PageResult;
import com._520it.pojo.Picture;
import com._520it.service.impl.PictureServiceImpl;
import com._520it.utils.PictureUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 超哥 on 2019/4/22.
 */
@Controller
@RequestMapping("/admin/picture")
public class PictureController {

    @Autowired
    private PictureServiceImpl pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public JSONObject upload(Picture picture, HttpServletRequest request) throws IOException {
        String src = PictureUtils.uploadPicture(picture.getFile(), picture.getType(), request);
        picture.setSrc(src);
        int count=pictureService.queryPicture(picture);
        if(count<=0){
            pictureService.savePicture(picture);
        }else{
            pictureService.updatePicture(picture);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","ok");
        return  jsonObject;
    }

    @RequestMapping("/download/img/upload/{imageName}")
    @ResponseBody
    public String download(@PathVariable("imageName") String imageName, HttpServletRequest request, HttpServletResponse response) throws IOException {
       PictureUtils.downloadImage(imageName,request,response);
        return  null ;
    }

    @RequestMapping(value = "/queryPictures",method = RequestMethod.POST)
    public String  queryIllness(Picture picture, Model model){
        PageResult result = new PageResult();
        String startPage = picture.getStartPage();
        if(startPage==null || startPage.trim()==""){
            result.setStartPage(1);
        }else {
            result.setStartPage(Integer.parseInt(picture.getStartPage()));
        }
        //统计总记录数
        int totalRecords=pictureService.countTotal(picture);
        if(totalRecords==0){
            result=null;
        }else{
            result.setTotalRecords(totalRecords);
            result.setPageNum(10);
            result.init();
            //查询医院
            List<Picture> list = pictureService.queryPictures(picture,result.getStartIndex(),result.getEndIndex());
            result.setList(list);
        }
        model.addAttribute("result",result);
        model.addAttribute("picture",picture);
        return "adManage";
    }
    @RequestMapping(value = "/removePicture/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String  removePicture(@PathVariable("id") String id){
        pictureService.removePicture(id);
        return "ok";
    }
}
