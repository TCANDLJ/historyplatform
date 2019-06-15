package com._520it.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 超哥 on 2019/4/22.
 */
public class Picture {

    private String id;//图片id
    private String type;//图片类型
    private String historyVal;//医院名称
    private String kinds;//科室
    private String doctorName;//医生名字
    private String doctorJob;//医生工作
    private String src;//图片路径
    private MultipartFile file;//上传文件
    private String createTime;//上传时间
    private String startPage;//开始页
    private String startDate;//开始时间
    private String endDate;//结束时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHistoryVal() {
        return historyVal;
    }

    public void setHistoryVal(String historyVal) {
        this.historyVal = historyVal;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorJob() {
        return doctorJob;
    }

    public void setDoctorJob(String doctorJob) {
        this.doctorJob = doctorJob;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
