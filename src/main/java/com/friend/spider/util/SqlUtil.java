package com.friend.spider.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SqlUtil {

    private static String INSERT_INTO = " insert into ";

    private static String UPDATE = " update ";

    private static String SET = " set ";

    private static String WHERE = " where ";

    public static String getInsertSql(String tableName,Map<String,Object> keyValue){
        if(keyValue == null || StringUtils.isEmpty(tableName)){
            return "";
        }
        if(keyValue.size() <= 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        StringBuffer keyBuf = new StringBuffer();
        StringBuffer valueBuf = new StringBuffer();
        for(Map.Entry<String,Object> entry : keyValue.entrySet()){
            keyBuf.append(entry.getKey()).append(",");
            valueBuf.append(entry.getValue()).append(",");
        }
        result.append(INSERT_INTO).append(tableName)
                .append("(").append(keyBuf.substring(0,keyBuf.lastIndexOf(","))).append(")")
                .append(" values ")
                .append("(").append(valueBuf.substring(0,valueBuf.lastIndexOf(","))).append(")");
        return result.toString();
    }

    public static String getUpdateSqlById(String tableName,Map<String,Object> keyValue,long id){
        if(keyValue == null || StringUtils.isEmpty(tableName) || id <= 0){
            return "";
        }
        if(keyValue.size() <= 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        StringBuffer setBuf = new StringBuffer();
        for(Map.Entry<String,Object> entry : keyValue.entrySet()){
            setBuf.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" ").append(", ");
        }
        result.append(UPDATE).append(tableName)
                .append(SET)
                .append(setBuf.substring(0,setBuf.lastIndexOf(","))).append(" ")
                .append(WHERE)
                .append(" id ").append(" = ").append(id);
        return result.toString();
    }

    public static String getUpdateSqlByWhereMap(String tableName,Map<String,Object> keyValue,Map<String,Object> whereMap){
        if(keyValue == null || StringUtils.isEmpty(tableName) || whereMap == null){
            return "";
        }
        if(keyValue.size() <= 0 || whereMap.size() <= 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        StringBuffer setBuf = new StringBuffer();
        StringBuffer whereBuf = new StringBuffer();
        for(Map.Entry<String,Object> entry : keyValue.entrySet()){
            setBuf.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" ").append(", ");
        }
        for(Map.Entry<String,Object> entry : whereMap.entrySet()){
            whereBuf.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" ").append("and ");
        }
        result.append(UPDATE).append(tableName)
                .append(SET)
                .append(setBuf.substring(0,setBuf.lastIndexOf(","))).append(" ")
                .append(WHERE)
                .append(setBuf.substring(0,whereBuf.lastIndexOf("and"))).append(" ");
        return result.toString();
    }

    public static void main(String[] args){
        Map<String,Object> map = new HashMap<>();
        map.put("name","fyc");
        map.put("age",34);
        //String sql = getInsertSql("user",map);
        String sql = getUpdateSqlByWhereMap("user",map,map);
        System.out.println(sql);
    }

}
