package io.lvxy.shardingjdbc.service.impl;


import io.lvxy.shardingjdbc.mapper.BcCustomerInfMapper;
import io.lvxy.shardingjdbc.pojo.BcCustomerInf;
import io.lvxy.shardingjdbc.service.BcCustomerInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BcCustomerInfServiceImpl implements BcCustomerInfService {

    @Autowired
    BcCustomerInfMapper bcCustomerInfMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long customerInfId) {
        return bcCustomerInfMapper.deleteByPrimaryKey(customerInfId);
    }

    @Transactional
    @Override
    public int insert(BcCustomerInf bcCustomerInf) {
        return bcCustomerInfMapper.insert(bcCustomerInf);
    }

    @Override
    public BcCustomerInf selectByPrimaryKey(Long customerInfId) {
        return bcCustomerInfMapper.selectByPrimaryKey(customerInfId);
    }

    @Override
    public List<BcCustomerInf> selectAll() {
        return bcCustomerInfMapper.selectAll();
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(BcCustomerInf bcCustomerInf) {
        return bcCustomerInfMapper.updateByPrimaryKey(bcCustomerInf);
    }


    @Override
    public int save(BcCustomerInf bcCustomerInf) {
        return bcCustomerInfMapper.insert(bcCustomerInf);
    }
}
