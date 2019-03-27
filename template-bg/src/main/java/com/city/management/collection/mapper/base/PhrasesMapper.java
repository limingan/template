package com.city.management.collection.mapper.base;

import com.city.management.collection.model.base.Phrases;
import com.city.management.collection.model.base.PhrasesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhrasesMapper {
    long countByExample(PhrasesExample example);

    int deleteByExample(PhrasesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Phrases record);

    int insertSelective(Phrases record);

    List<Phrases> selectByExample(PhrasesExample example);

    Phrases selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Phrases record, @Param("example") PhrasesExample example);

    int updateByExample(@Param("record") Phrases record, @Param("example") PhrasesExample example);

    int updateByPrimaryKeySelective(Phrases record);

    int updateByPrimaryKey(Phrases record);
}