package com.qf.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.mapper.SmbmsMapper;
import com.qf.pojo.SmbmsBill;
import com.qf.pojo.SmbmsUser;
import com.qf.service.SmbmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SmbmsServiceimpl implements SmbmsService {

    @Autowired
    public SmbmsMapper smbmsMapper;
    @Override
    public boolean login(String userName, String userPassword) {

        SmbmsUser smbmsUser = smbmsMapper.selectUserByUserName(userName);
        if(smbmsUser==null){
            return false;
        }else {
            if(userPassword.equals(smbmsUser.getUserPassword())){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public PageInfo<SmbmsUser> showList(Integer pageNum, HashMap<Object, Object> map) {
        //设置分页内容
        PageHelper.startPage(pageNum,5);

        List<SmbmsUser> smbmsUsers = smbmsMapper.showList(map);

        PageInfo<SmbmsUser> smbmsUserPageInfo = new PageInfo<>(smbmsUsers);

        return smbmsUserPageInfo;
    }

    @Override
    public SmbmsUser selectUserById(int id) {

        return smbmsMapper.SelectUserById(id);
    }


    @Override
    public boolean addUser(SmbmsUser smbmsUser) {

        int i = smbmsMapper.addUser(smbmsUser);

        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    //删除用户
    @Override
    public int deleteUser(int id){
        return smbmsMapper.deleteUser(id);
    }

    @Override
    public PageInfo<SmbmsBill> billList(Integer pageNum, HashMap<Object, Object> map) {
        //设置分页内容
        PageHelper.startPage(pageNum,5);

        List<SmbmsBill> smbmsBill = smbmsMapper.smbmsBill(map);

        PageInfo<SmbmsBill> smbmsBillPageInfo = new PageInfo<>(smbmsBill);
        return smbmsBillPageInfo;
    }

}

