package com.blog.website.common;

import java.util.List;

/**
 * @author jiangzehao
 * @date 2019/3/4 16:21
 */
public class PageView {
    private List records;
    private long pageCount;
    private int pageSize = 10;
    private int pageNow = 1;
    private long rowCount;
    private int startPage;
    private int pagecode = 10;

    public PageView() {
    }

    public int getFirstResult() {
        return (this.pageNow - 1) * this.pageSize;
    }

    public int getPagecode() {
        return this.pagecode;
    }

    public void setPagecode(int pagecode) {
        this.pagecode = pagecode;
    }

    public PageView(int pageSize, int pageNow) {
        this.pageSize = pageSize;
        this.pageNow = pageNow;
    }

    public PageView(int pageNow) {
        this.pageNow = pageNow;
        this.startPage = (this.pageNow - 1) * this.pageSize;
    }

    public void setQueryResult(long rowCount, List records) {
        this.setRowCount(rowCount);
        this.setRecords(records);
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
        this.setPageCount(this.rowCount % (long)this.pageSize == 0L?this.rowCount / (long)this.pageSize:this.rowCount / (long)this.pageSize + 1L);
    }

    public List getRecords() {
        return this.records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPageNow() {
        return this.pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public long getPageCount() {
        return this.pageCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return this.rowCount;
    }

    public int getStartPage() {
        return this.startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }
}
