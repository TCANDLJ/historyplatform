package com._520it.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * Created by 超哥 on 2019/4/22.
 */
public class PictureUtils {

    public static String uploadPicture(MultipartFile file, String type, HttpServletRequest request) throws IOException {
            String filepath = "";//文件路径
            if (file != null) {
                String oldFileName = file.getOriginalFilename();//获取源文件的名称
                //获取后缀
                String prefix = oldFileName.substring(oldFileName.lastIndexOf(".") + 1);

                //获取跟目录
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                String genPath = path.getAbsolutePath()+"/static/img/upload";

                if (type.equals("1") || type.equals("2")) {
                    filepath =  "/ad" + type + "." + prefix;
                }else {
                  filepath="/"+UUID.randomUUID().toString()+"."+prefix;
                }
                //新建文件
                File files = new File(genPath,filepath);
                // 检测是否存在目录
               /* if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }*/
                //将文件写入
                file.transferTo(files);
            }
               return "/img/upload"+filepath;
    }

    public static void downloadImage(String imageName, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        String genPath = path.getAbsolutePath()+"/static/img/upload/";
        String fileUrl = genPath+imageName;
       // String imageName=imageSrc.substring(imageSrc.lastIndexOf("/")+1);
        if (fileUrl != null) {
            File file = new File(fileUrl);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + imageName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
