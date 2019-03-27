package com.city.management.collection.mapper.base;

import com.city.management.collection.model.base.SummaryType;
import com.city.management.collection.model.base.SummaryTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummaryTypeMapper {
    long countByExample(SummaryTypeExample example);

    int deleteByExample(SummaryTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SummaryType record);

    int insertSelective(SummaryType record);

    List<SummaryType> selectByExample(SummaryTypeExample example);

    SummaryType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SummaryType record, @Param("example") SummaryTypeExample example);

    int updateByExample(@Param("record") SummaryType record, @Param("example") SummaryTypeExample example);

    int updateByPrimaryKeySelective(SummaryType record);

    int updateByPrimaryKey(SummaryType record);
}