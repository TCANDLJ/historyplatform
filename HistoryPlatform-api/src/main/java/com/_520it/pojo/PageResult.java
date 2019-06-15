package com._520it.pojo;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/12.
 */
public class PageResult {
    private int startPage;//开始页
    private int startIndex;//开始索引
    private int endIndex;//结束索引
    private int totalPage;//总页数
    private int totalRecords;//总记录数
    private int pageNum;//显示数
    private int currentPage;//当前页
    private List list;//数据
    private boolean page;//是否支持分页，默认支持

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public boolean isPage() {
        return page;
    }

    public void setPage(boolean page) {
        this.page = page;
    }

    public void init(){
        //支持分页
        this.setPage(true);
        this.setStartIndex((this.getStartPage()-1)*this.getPageNum());
        this.setEndIndex(this.getPageNum());
        this.setTotalPage((this.getTotalRecords()+this.getPageNum()-1)/this.getPageNum());
    }
}
