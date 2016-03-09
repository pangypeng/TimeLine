package com.pangypeng.timeline.entity;

/**
 * 作者 pang
 * 时间 2016/3/9 0009 9:13
 * 文件 TimeLine
 * 描述
 */
public class ChildStatusEntity {
    private String content; // 内容
    private boolean infinished;// 是否已完成

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isInfinished() {
        return infinished;
    }

    public void setInfinished(boolean infinished) {
        this.infinished = infinished;
    }
}
