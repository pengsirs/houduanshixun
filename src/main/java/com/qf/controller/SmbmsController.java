package com.qf.controller;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.SmbmsBill;
import com.qf.pojo.SmbmsProvider;
import com.qf.pojo.SmbmsUser;
import com.qf.service.SmbmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class SmbmsController {

    @Autowired
    public SmbmsService smbmsService;

    //这个地方的作用就是启动默认进入登录页面
    @RequestMapping("/")
    public String login(){
        return "login";

    }
    //登录方法
    @RequestMapping("/login")
    public String loginSmbmsUser(Model model, String userName, String userPassword){
        boolean login = smbmsService.login(userName,userPassword);
        System.out.println(login);

        if (login){
            model.addAttribute("userName",userName);
            return "welcome";
        }else {
            return "login";
        }

    }

    @RequestMapping("/userList")
    public String UserList(Model model, @RequestParam(defaultValue = "1") Integer PageNum,String name){
        HashMap<Object,Object> map = new HashMap<>();
        map.put("name",name);
        model.addAttribute("name",name);
        PageInfo<SmbmsUser> smbmsUserPageInfo = smbmsService.showList(PageNum,map);
        model.addAttribute("PageInfo",smbmsUserPageInfo);
        return "userList";
    }

    @RequestMapping("/billList")
    public String BillList(Model model,@RequestParam(defaultValue = "1") Integer PageNum,String name){
        HashMap<Object,Object> map = new HashMap<>();
        map.put("name",name);
        model.addAttribute("name",name);
        PageInfo<SmbmsBill> smbmsBillPageInfo = smbmsService.billList(PageNum,map);
        model.addAttribute("PageInfoBill",smbmsBillPageInfo);
        return "billList";
    }

    @RequestMapping("/providerList")
    public String PreviderList(Model model,@RequestParam(defaultValue = "1") Integer PageNum,String name){
        HashMap<Object,Object> map = new HashMap<>();
        map.put("name",name);
        model.addAttribute("name",name);
        PageInfo<SmbmsProvider> smbmsProviderPageInfo = smbmsService.providerList(PageNum,map);
        model.addAttribute("PageInfoProvider",smbmsProviderPageInfo);
        return "providerList";
    }

    @RequestMapping("/userView")
    public String SelectUser(Model model,int id) {//传入Model的原因是查询的数据需要传输给前端 通过Model
        SmbmsUser smbmsUser = smbmsService.selectUserById(id);
        if (smbmsUser == null) {
            System.out.println("查询失败");
            return "eror";
        } else {
            model.addAttribute("user",smbmsUser);
            return "userView";
        }
    }
    @RequestMapping("/billView")
    public String SelectBill(Model model,int id) {
        SmbmsBill smbmsBill = smbmsService.selectBillById(id);
        if (smbmsBill == null) {
            System.out.println("查询失败");
            return "error";
        } else {
            model.addAttribute("bill",smbmsBill);
            System.out.println(smbmsBill+"?????????");
            return "billView";
        }
    }
    @RequestMapping("/providerView")
    public String SelectProvider(Model model,int id) {
        SmbmsProvider smbmsProvider = smbmsService.selectProviderById(id);
        if (smbmsProvider == null) {
            System.out.println("查询失败");
            return "error";
        } else {
            model.addAttribute("provider",smbmsProvider);
            System.out.println(smbmsProvider+"?????????");
            return "providerView";
        }
    }
    @RequestMapping("/password")
    public String PassWord(){
        return "password";
    }
    @RequestMapping("/userAdd")
    public String Usadd(){
        return "userAdd";
    }
    @RequestMapping("/add")
    public String addUser(Model model,String userName,String userPassword,int gender,String birthday,String phone,String address,int userRole) throws ParseException {
        SmbmsUser User = new SmbmsUser();
        User.setUserName(userName);
        User.setUserPassword(userPassword);
        User.setGender(gender);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(birthday);
        User.setBirthday(parse);
        User.setPhone(phone);
        User.setAddress(address);
        User.setUserRole(userRole);

        boolean b = smbmsService.addUser(User);
        if (b){
            System.out.println("添加成功");
            return "redirect:/userList";
        }else{
                return "eror";
            }
    }

    @RequestMapping("/providerAdd")
    public String ProviderAdd(){
        return "providerAdd";
    }
    @RequestMapping("/billAdd")
    public String BillAdd(){
        return "billAdd";
    }
    @RequestMapping("/providerUpdata")
    public String ProviderUpdata(){
        return "providerUpdata";
    }
    @RequestMapping("/billUpdata")
    public String BillUpdata(){
        return "billUpdata";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser (Model model,int id){
        int i = smbmsService.deleteUser(id);
        if(i>0){
            System.out.println(i);
            return "redirect:/userList";
        }else{
            return "error";
        }
    }
    @RequestMapping("/deleteProvider")
    public String deleteProvider(Model model,int id){
        int i = smbmsService.deleteProvider(id);
        if(i>0){
            System.out.println(i);
            return "redirect:/providerList";
        }else{
            return "error";
        }
    }
    @RequestMapping("/deleteBill")
    public String deleteBill(Model model,int id){
        int i = smbmsService.deleteBill(id);
        if(i>0){
            System.out.println(i);
            return "redirect:/billList";
        }else{
            return "error";
        }
    }
}
