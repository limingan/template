package com.city.management.collection.mapper.base;

import com.city.management.collection.model.base.NoticeRead;
import com.city.management.collection.model.base.NoticeReadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeReadMapper {
    long countByExample(NoticeReadExample example);

    int deleteByExample(NoticeReadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeRead record);

    int insertSelective(NoticeRead record);

    List<NoticeRead> selectByExample(NoticeReadExample example);

    NoticeRead selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeRead record, @Param("example") NoticeReadExample example);

    int updateByExample(@Param("record") NoticeRead record, @Param("example") NoticeReadExample example);

    int updateByPrimaryKeySelective(NoticeRead record);

    int updateByPrimaryKey(NoticeRead record);
}