package io.lvxy.shardingjdbc.mapper;

import io.lvxy.shardingjdbc.pojo.BoOrder;
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
