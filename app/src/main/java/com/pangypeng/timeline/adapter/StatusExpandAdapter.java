package com.pangypeng.timeline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.pangypeng.timeline.R;
import com.pangypeng.timeline.entity.ChildStatusEntity;
import com.pangypeng.timeline.entity.GroupStatusEntity;

import java.util.List;

/**
 * 作者 pang
 * 时间 2016/3/9 0009 9:17
 * 文件 TimeLine
 * 描述
 */
public class StatusExpandAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private LayoutInflater inflater = null;
    private List<GroupStatusEntity> groupList;

    public StatusExpandAdapter(Context context, List<GroupStatusEntity> group_list){
        groupList = group_list;
        mContext = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 返回一级Item总数
     * @return
     */
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    /**
     * 返回一级item下二级item的总数
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        if(groupList.get(groupPosition).getChildList() == null){
            return 0;
        }else{
            return groupList.get(groupPosition).getChildList().size();
        }

    }

    /**
     * 返回一级item对象
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    /**
     * 返回二级item对象
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getChildList().get(childPosition);
    }

    /**
     * 返回一级item的显示位置信息
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 返回二级item的位置信息
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    class GroupViewHolder{
        TextView groupName;
    }
    /**
     *
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       GroupViewHolder holder = null;
        if(convertView == null){
            holder = new GroupViewHolder();
            convertView = inflater.inflate(R.layout.group_status_item,null);

            holder.groupName = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (GroupViewHolder) convertView.getTag();
        }
        holder.groupName.setText(groupList.get(groupPosition).getGroupName());
        return convertView;
    }

    class ChildViewHolder{
        TextView child_content;
    }
    /**
     *
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        ChildStatusEntity child = (ChildStatusEntity) getChild(groupPosition,childPosition);
        if (convertView == null){
            holder = new ChildViewHolder();
            convertView = inflater.inflate(R.layout.child_status_item,null);
            holder.child_content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
            holder = (ChildViewHolder) convertView.getTag();
        }
        holder.child_content.setText(child.getContent());
        return convertView;
    }

    /**
     * 二级item是否可以被选择
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
