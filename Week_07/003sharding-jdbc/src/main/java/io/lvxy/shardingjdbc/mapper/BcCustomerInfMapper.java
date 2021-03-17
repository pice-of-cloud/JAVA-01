package io.lvxy.shardingjdbc.mapper;


import io.lvxy.shardingjdbc.pojo.BcCustomerInf;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BcCustomerInfMapper {
    int deleteByPrimaryKey(Long customerInfId);

    int insert(BcCustomerInf record);

    BcCustomerInf selectByPrimaryKey(Long customerInfId);

    List<BcCustomerInf> selectAll();

    int updateByPrimaryKey(BcCustomerInf record);
}