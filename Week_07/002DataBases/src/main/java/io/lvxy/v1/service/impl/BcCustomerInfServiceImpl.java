package io.lvxy.v1.service.impl;

import io.lvxy.v1.config.database.Master;
import io.lvxy.v1.mapper.BcCustomerInfMapper;
import io.lvxy.v1.pojo.BcCustomerInf;
import io.lvxy.v1.service.BcCustomerInfService;
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
    public int deleteByPrimaryKey(Integer customerInfId) {
        return bcCustomerInfMapper.deleteByPrimaryKey(customerInfId);
    }

    @Transactional
    @Override
    public int insert(BcCustomerInf bcCustomerInf) {
        return bcCustomerInfMapper.insert(bcCustomerInf);
    }

    @Override
    public BcCustomerInf selectByPrimaryKey(Integer customerInfId) {
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

    @Master
    @Override
    public int save(BcCustomerInf bcCustomerInf) {
        return bcCustomerInfMapper.insert(bcCustomerInf);
    }
}
