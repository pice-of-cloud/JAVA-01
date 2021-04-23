package io.lvxy.service;

import io.lvxy.mapper.BoOrderMapper;
import io.lvxy.pojo.BoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoOrderServiceImpl implements BoOrderService {

    @Autowired
    private BoOrderMapper boOrderMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long id) {
        return boOrderMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void insert(BoOrder boOrder) {
        boOrderMapper.insert(boOrder);
    }


    @Override
    public BoOrder selectByPrimaryKey(Long id) {
        return boOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BoOrder> selectAll() {
        return boOrderMapper.selectAll();
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(BoOrder boOrder) {
        return boOrderMapper.updateByPrimaryKey(boOrder);
    }

    @Override
    public BoOrder selectByCustomerId(Long customerId) {
        return boOrderMapper.selectByCustomerId(customerId);
    }
}
