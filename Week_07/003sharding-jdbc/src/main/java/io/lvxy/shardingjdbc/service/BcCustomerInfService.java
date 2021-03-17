package io.lvxy.shardingjdbc.service;


import io.lvxy.shardingjdbc.pojo.BcCustomerInf;

import java.util.List;

public interface BcCustomerInfService {
    int deleteByPrimaryKey(Long customerInfId);

    int insert(BcCustomerInf record);

    BcCustomerInf selectByPrimaryKey(Long customerInfId);

    List<BcCustomerInf> selectAll();

    int updateByPrimaryKey(BcCustomerInf record);

    int save (BcCustomerInf bcCustomerInf);
}