package com.qf.mapper;

import com.qf.pojo.SmbmsBill;
import com.qf.pojo.SmbmsProvider;
import com.qf.pojo.SmbmsUser;

import java.util.HashMap;
import java.util.List;

public interface SmbmsMapper {

    //查询用户根据UserName属性
    public SmbmsUser selectUserByUserName(String userName);

    //查询用户列表
    public List<SmbmsUser> showList(HashMap<Object,Object>map);

    //通过id查询用户信息
    public SmbmsUser SelectUserById(int id);
    //增加用户
    public int addUser(SmbmsUser smbmsUser);
    //删除用户
    public int deleteUser(int id);

    public List<SmbmsBill> smbmsBill(HashMap<Object,Object>map);

    public SmbmsBill SelectBillById(int id);

    public List<SmbmsProvider> smbmsProvider(HashMap<Object, Object> map);

    public SmbmsProvider SelectProviderById(int id);

    public int deleteProvider(int id);

    public int deleteBill(int id);
}
