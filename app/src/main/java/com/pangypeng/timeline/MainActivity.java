package com.pangypeng.timeline;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.pangypeng.timeline.adapter.StatusExpandAdapter;
import com.pangypeng.timeline.entity.ChildStatusEntity;
import com.pangypeng.timeline.entity.GroupStatusEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandlist;
    private StatusExpandAdapter statusExpandAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews() {
        expandlist = (ExpandableListView) findViewById(R.id.expandlist);
        statusExpandAdapter = new StatusExpandAdapter(this,getDataList());
        expandlist.setAdapter(statusExpandAdapter);
        expandlist.setGroupIndicator(null);
        expandlist.setSelection(0);// 默认选择项
        // 默认全部展开
        int groupConut = expandlist.getCount();
        for(int i =0;i<groupConut;i++){
            expandlist.expandGroup(i);
        }
        expandlist.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if(expandlist.isGroupExpanded(groupPosition)){
                    expandlist.collapseGroup(groupPosition);
                }else{
                    expandlist.expandGroup(groupPosition);
                }
                return true;
            }
        });
        expandlist.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this,"["+groupPosition+","+childPosition+"]",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private List<GroupStatusEntity> getDataList() {
        List<GroupStatusEntity> groupList;
        String[] strArray = new String[]{"3月4日","3月5日","3月6日"};
        String[][] childTimeArray = new String[][]{
                {"吃饭","睡觉","吃饭","睡觉"},
                {"吃饭","上课","睡觉"},
                {"上课","吃饭"}
        };
        groupList = new ArrayList<>();
        for (int i=0;i<strArray.length;i++){
            GroupStatusEntity group = new GroupStatusEntity();
            group.setGroupName(strArray[i]);
            List<ChildStatusEntity> childList = new ArrayList<>();
            for(int j=0;j<childTimeArray[i].length;j++){
                ChildStatusEntity child = new ChildStatusEntity();
                child.setContent(childTimeArray[i][j]);
                child.setInfinished(true);
                childList.add(child);
            }
            group.setChildList(childList);
            groupList.add(group);
        }
        return groupList;
    }



}
