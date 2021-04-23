package io.lvxy.v1.mapper;

import io.lvxy.v1.pojo.BcCustomerInf;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BcCustomerInfMapper {
    int deleteByPrimaryKey(Integer customerInfId);

    int insert(BcCustomerInf record);

    BcCustomerInf selectByPrimaryKey(Integer customerInfId);

    List<BcCustomerInf> selectAll();

    int updateByPrimaryKey(BcCustomerInf record);
}