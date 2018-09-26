package com.friend.spider.dao;

import com.friend.spider.common.DatabaseEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * fyc
 */
@Repository
public class BaseDao {

    @Autowired
    @Qualifier("aJdbcTemplate")
    private JdbcTemplate aJdbcTemplate;

    @Autowired
    @Qualifier("bJdbcTemplate")
    private JdbcTemplate bJdbcTemplate;

    public List<Map<String, Object>> selectListByStartIdAndEndId(String databaseName, String tableName, String fieldNames, String key, Long startId, Long endId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(databaseName).append(".").append(tableName)
                .append(" where ").append(key).append(" >=  ").append(startId).append(" and ")
                .append(key).append(" <= ").append(endId);
        return getJdbcTemplate(databaseName).queryForList(sql.toString());
    }

    public List<Map<String, Object>> selectListBykeys(String databaseName, String tableName, String fieldNames, String key, Set<Long> valueList){
        if(valueList == null || valueList.size() < 1){
            return null;
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(databaseName).append(".").append(tableName)
                .append(" where ").append(key).append(" in ( ").append(StringUtils.join(valueList.iterator(),",")).append(" )");

        return getJdbcTemplate(databaseName).queryForList(sql.toString());
    }

    public List<Map<String, Object>> selectListBykeys(String databaseName,String tableName,String fieldNames, String key, List<Long> valueList){
        if(valueList == null || valueList.size() < 1){
            return null;
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(databaseName).append(".").append(tableName)
                .append(" where ").append(key).append(" in ( ").append(StringUtils.join(valueList.iterator(),",")).append(" )");
        return getJdbcTemplate(databaseName).queryForList(sql.toString());
    }

    public Long selectMaxKey(String databaseName,String tableName,String key){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( key ).append(" from ").append(databaseName).append(".").append(tableName)
                .append(" order by ").append(key).append(" desc limit 1 ");
        return getJdbcTemplate(databaseName).queryForObject(sql.toString(),Long.class);
    }

    public Long selectMinKey(String databaseName,String tableName,String key){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( key ).append(" from ").append(databaseName).append(".").append(tableName)
                .append(" order by ").append(key).append(" limit 1 ");
        return getJdbcTemplate(databaseName).queryForObject(sql.toString(),Long.class);
    }

    public Long getCountByKey(String databaseName,String tableName,String key,String value){
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) from ").append(databaseName).append(".").append(tableName)
                .append(" where ").append(key).append(" = ").append(value );
        return getJdbcTemplate(databaseName).queryForObject(sql.toString(),Long.class);
    }

    public <T> List<T> selectListByStartIdAndEndId(String databaseName,String tableName,String fieldNames, String key,Long startId,Long endId, Class<T> clazz){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(tableName)
                .append(" where ").append(key).append(" >=  ").append(startId).append(" and ")
                .append(key).append(" <= ").append(endId);
        return getJdbcTemplate(databaseName).query(sql.toString(),new BeanPropertyRowMapper<T>(clazz));
    }

    public <T> List<T> selectIdsByStartIdAndEndId(String databaseName,String tableName,String fieldNames, String key,Long startId,Long endId, Class<T> clazz){
        StringBuffer sql = new StringBuffer();
        sql.append(" select id from ").append(tableName)
                .append(" where ").append(key).append(" >=  ").append(startId).append(" and ")
                .append(key).append(" <= ").append(endId);
        return getJdbcTemplate(databaseName).query(sql.toString(),new BeanPropertyRowMapper<T>(clazz));
    }

    public <T> List<T> selectListBykeys(String databaseName,String tableName,String fieldNames, String key, Set<Long> valueList, Class<T> clazz){
        if(valueList == null || valueList.size() < 1){
            return null;
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(tableName)
                .append(" where ").append(key).append(" in ( ").append(StringUtils.join(valueList.iterator(),",")).append(" )");

        return getJdbcTemplate(databaseName).query(sql.toString(),new BeanPropertyRowMapper<T>(clazz));
    }

    public <T> List<T> selectListBykeys(String databaseName,String tableName,String fieldNames, String key, List<Long> valueList, Class<T> clazz){
        if(valueList == null || valueList.size() < 1){
            return null;
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(tableName)
                .append(" where ").append(key).append(" in ( ").append(StringUtils.join(valueList.iterator(),",")).append(" )");
        System.out.println(sql.toString());
        return getJdbcTemplate(databaseName).query(sql.toString(),new BeanPropertyRowMapper<T>(clazz));
    }

    public Map<String, Object> getObjectByKey(String databaseName,String tableName,String fieldNames, String key, String value){
        Map<String, Object> result = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" select ").append( fieldNames).append(" from ").append(databaseName).append(".").append(tableName)
                    .append(" where ").append(key).append(" = ").append(value ).append(" ");
            System.out.println(sql.toString());
            result = getJdbcTemplate(databaseName).queryForMap(sql.toString());
        }catch (EmptyResultDataAccessException e){
            result = new HashMap<>();
        }
        return result;
    }

    public List<Map<String, Object>> getListByKey(String databaseName,String tableName,String fieldNames, String key, String value){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(databaseName).append(".").append(tableName)
                .append(" where ").append(key).append(" = ").append(value ).append(" ");
        return getJdbcTemplate(databaseName).queryForList(sql.toString());
    }

    public List<Map<String, Object>> getListByKVS(String databaseName, String tableName, String fieldNames, Map<String,Object> whereMap) {
        if (whereMap==null||whereMap.size()==0)return null;
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(databaseName).append(".").append(tableName);

        Object[] args = new Object[whereMap.size()];
        StringBuffer whereBuf = new StringBuffer();
        int count = 0;  //临时变量
        for(Map.Entry<String,Object> entry : whereMap.entrySet()){
            whereBuf.append(entry.getKey()).append(" = ").append("?").append(" ").append("and ");
            args[count] = entry.getValue();
            count++;
        }
        sql.append(" where ").append(whereBuf.substring(0,whereBuf.lastIndexOf("and"))).append(" ");
        return  getJdbcTemplate(databaseName).queryForList(sql.toString());
    }

    public List<Map<String, Object>> getListByKey(String databaseName,String tableName,String fieldNames, String key, String value,long from,long to){
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( fieldNames).append(" from ").append(databaseName).append(".").append(tableName)
                .append(" where ").append(key).append(" = ").append(value )
                .append(" limit ").append(from ).append(" , ").append(to).append(" ");
        return getJdbcTemplate(databaseName).queryForList(sql.toString());
    }

    public void deleteObjectByKey(String databaseName,String tableName,String key, String value){
        StringBuffer sql = new StringBuffer();
        sql.append(" delete from ").append(databaseName).append(".").append(tableName)
                .append(" where ").append(key).append(" = ").append(value );
        getJdbcTemplate(databaseName).execute(sql.toString());
    }

    public void insert(String databaseName, String table, Map<String, Object> keyValue) {
        if(keyValue == null || StringUtils.isEmpty(table)){
            return;
        }
        if(keyValue.size() <= 0){
            return;
        }
        Object[] args = new Object[keyValue.size()];
        StringBuffer sql = new StringBuffer();
        StringBuffer keyBuf = new StringBuffer();
        StringBuffer valueBuf = new StringBuffer();
        int count = 0;  //临时变量
        for(Map.Entry<String,Object> entry : keyValue.entrySet()){
            keyBuf.append(entry.getKey()).append(",");
            valueBuf.append("?").append(",");
            args[count] = entry.getValue();
            count++;
        }
        sql.append(" insert into ").append(table)
                .append("(").append(keyBuf.substring(0,keyBuf.lastIndexOf(","))).append(")")
                .append(" values ")
                .append("(").append(valueBuf.substring(0,valueBuf.lastIndexOf(","))).append(")");
        getJdbcTemplate(databaseName).update(sql.toString(),args);
    }

    public void update(String database, String table, Map<String, Object> setMap, Map<String, Object> whereMap) {
        if(setMap == null || StringUtils.isEmpty(table) || whereMap == null){
            return;
        }
        if(setMap.size() <= 0 || whereMap.size() <= 0){
            return;
        }
        Object[] args = new Object[setMap.size() + whereMap.size()];
        StringBuffer sql = new StringBuffer();
        StringBuffer setBuf = new StringBuffer();
        StringBuffer whereBuf = new StringBuffer();
        int count = 0;  //临时变量
        for(Map.Entry<String,Object> entry : setMap.entrySet()){
            setBuf.append(entry.getKey()).append(" = ").append("?").append(" ").append(", ");
            args[count] = entry.getValue();
            count++;
        }
        for(Map.Entry<String,Object> entry : whereMap.entrySet()){
            whereBuf.append(entry.getKey()).append(" = ").append("?").append(" ").append("and ");
            args[count] = entry.getValue();
            count++;
        }
        sql.append(" update ").append(table)
                .append(" set ")
                .append(setBuf.substring(0,setBuf.lastIndexOf(","))).append(" ")
                .append(" where ")
                .append(whereBuf.substring(0,whereBuf.lastIndexOf("and"))).append(" ");
        getJdbcTemplate(database).update(sql.toString(),args);
    }

    public boolean exist(String database, String table, String key, String value) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select ").append( " id ").append(" from ").append(database).append(".").append(table)
                .append(" where ").append(key).append(" = ").append(value ).append(" ");
        return getJdbcTemplate(database).queryForList(sql.toString()).size() > 0;
    }

    private JdbcTemplate getJdbcTemplate(String database){
        JdbcTemplate jdbcTemplate = null;
        if(DatabaseEnum.b.name().equals(database.toLowerCase())){
             jdbcTemplate = bJdbcTemplate;
        }else {
             jdbcTemplate = aJdbcTemplate;
        }
        return jdbcTemplate;
    }

}
