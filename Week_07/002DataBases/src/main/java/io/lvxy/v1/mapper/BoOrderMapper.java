package io.lvxy.v1.mapper;

import io.lvxy.v1.pojo.BoOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BoOrder record);

    BoOrder selectByPrimaryKey(Long id);

    List<BoOrder> selectAll();

    int updateByPrimaryKey(BoOrder record);
}
