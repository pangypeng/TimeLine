package com.pangypeng.timeline.entity;

import java.util.List;

/**
 * 作者 pang
 * 时间 2016/3/9 0009 9:12
 * 文件 TimeLine
 * 描述
 */
public class GroupStatusEntity {
    private String groupName; // 一级 item 数据名称

    private List<ChildStatusEntity> childList;// 二级item数据列表

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ChildStatusEntity> getChildList() {
        return childList;
    }

    public void setChildList(List<ChildStatusEntity> childList) {
        this.childList = childList;
    }
}
