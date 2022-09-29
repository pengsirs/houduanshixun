package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.SmbmsBill;
import com.qf.pojo.SmbmsProvider;
import com.qf.pojo.SmbmsUser;

import java.util.HashMap;


public interface SmbmsService {
    //登录（查询用户）
    public boolean login(String userName,String userPassword);
    //用户查询列表
    public PageInfo<SmbmsUser> showList(Integer pageNum, HashMap<Object,Object>map);

    //根据用户id查询信息
    public SmbmsUser selectUserById(int id);
    //添加用户
    public boolean addUser(SmbmsUser smbmsUser);
    //删除用户
    public int deleteUser(int id);

    public PageInfo<SmbmsBill> billList(Integer pageNum, HashMap<Object,Object>map);

    public SmbmsBill selectBillById(int id);

    public PageInfo<SmbmsProvider> providerList(Integer pageNum, HashMap<Object, Object> map);
}
