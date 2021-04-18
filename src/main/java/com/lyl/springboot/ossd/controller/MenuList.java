package com.lyl.springboot.ossd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// 给前端发送菜单的数据
//@RestController
//@RequestMapping("/getMenu")
public class MenuList {
    //@RequestMapping(value = "/Teacher", method = RequestMethod.GET)
    public Object getTeacherMenuList(){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        // 一级菜单：信息管理 课程管理 试题管理 消息回复
        /* 二级菜单：
            信息管理：展示个人信息 修改个人信息 修改个人头像 修改密码
            课程管理：查看个人全部课程 创建课程 上传课程文件 创建考试
            试题管理：创建试卷 创建试题
            消息管理：查看消息
         */
        try{
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("信息管理","课程管理","试题管理","消息回复"));
            ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(101,102,103,104,105,106));
            // 二级菜单
            ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("展示个人信息","修改个人信息","修改个人头像","修改密码"));
            ArrayList<String> stringArrayList2 = new ArrayList<>(Arrays.asList("查看个人全部课程","创建课程","上传课程文件","创建考试"));
            ArrayList<String> stringArrayList3 = new ArrayList<>(Arrays.asList("创建试卷","创建试题"));
            ArrayList<String> stringArrayList4 = new ArrayList<>(Arrays.asList("查看消息"));
            ArrayList<ArrayList<String>> arrayList2 = new ArrayList<>(Arrays.asList(stringArrayList,stringArrayList2,stringArrayList3,stringArrayList4));
            for (int i = 0; i < arrayList.size(); i++) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("id",arrayList1.get(i));
                jsonObject1.put("authName",arrayList.get(i));
                jsonObject1.put("path",null);
                jsonObject.put(Integer.toString(i),jsonObject1);
                for (int j = 0; j < arrayList2.get(i).size(); j++) {
                    JSONObject jsonObject3 = new JSONObject();
                    jsonObject3.put("id",arrayList1.get(i));
                    jsonObject3.put("authName",arrayList2.get(i).get(j));
                    jsonObject3.put("path",null);
                }
            }
            // status
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("msg","获取教师菜单列表成功");
            jsonObject1.put("status",200);
            // 封装到一个json
            jsonObject2.put("data",jsonObject);
            jsonObject2.put("meta",jsonObject1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject2;
    }
}
