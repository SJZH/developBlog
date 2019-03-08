package com.common.common;

import com.github.pagehelper.PageInfo;

/**
 * @author jiangzehao
 * @date 2019/3/4 16:11
 */
public class APIResultWithPageView extends APIResult {
    private PageView pageView;

    public APIResultWithPageView(){
    }

    public APIResultWithPageView(int code, String msg, PageView pageView) {
        super(code, msg);
        this.pageView = pageView;
    }

    public APIResultWithPageView(PageView pageView) {
        this.pageView = pageView;
    }

    public PageView getPageView() {
        return pageView;
    }

    public void setPageView(PageView pageView) {
        this.pageView = pageView;
    }

    public void setPageView(PageInfo<?> pageInfo) {
        PageView pageView = new PageView();
        pageView.setRecords(pageInfo.getList());
        pageView.setPageNow(pageInfo.getPageNum());
        pageView.setRowCount(pageInfo.getTotal());
        pageView.setPageSize(pageInfo.getPageSize());
        pageView.setStartPage(pageInfo.getStartRow());
        pageView.setPageCount((long)pageInfo.getPages());
        this.pageView = pageView;
    }
}
