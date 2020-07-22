package com.text_project.bean;

import lombok.Getter;

/**
 * 本bean用于分页显示的相关信息的计算与获取
 * @author peng
 * @version 1.0
 */
@Getter
public class PageInfo {

    private int start;

    private int rows;

    /**
     * 通过page以及rows计算当前子集在结果集的起始位置
     * @param page 当前的页数
     * @param rows 每页的记录数
     */
    public PageInfo(int page, int rows) {
        this.start = rows*(page-1);
        this.rows = rows;
    }
}
