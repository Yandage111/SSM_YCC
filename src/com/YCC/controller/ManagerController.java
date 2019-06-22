package com.YCC.controller;

//这是测试 冲突03
import com.YCC.entity.commodity;
import com.YCC.entity.customer;
import com.YCC.entity.manager;
import com.YCC.service.CommodityService;
import com.YCC.service.CustomerService;
import com.YCC.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/headler")
public class ManagerController {

    @Autowired
    private ManagerService service;
    @Autowired
    private CommodityService commservice;
    @Autowired
    private CustomerService cusservice;

//1234
//1234
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/login")
    public String login(String UserName, String password, Model model, HttpSession session, HttpServletRequest request){
        boolean flag = service.login(UserName, password);
        boolean flag1= cusservice.login(UserName, password);
        model.addAttribute("username",UserName);
        session.setAttribute("username",UserName);
        String code=request.getParameter("code");
        String randStr=(String)session.getAttribute("randStr");
        boolean flag2=code.equals(randStr);

        String yonghu=request.getParameter("yonghu");
        if(yonghu.equals("管理员"))
        {
            if(flag&&flag2){
                session.setAttribute("login", "login");
                session.setAttribute("prices", 0);
                return "forward:/headler/showAll";
            }else if(!flag){
                model.addAttribute("loginMessage", "您输入的用户名或密码错误!");
                return "login";
            }else{
                model.addAttribute("codeMessage", "您输入的验证码错误!");
                return "login";
            }
        }
        else{
            if(flag1&&flag2){
                session.setAttribute("login", "login");
                customer cuser=cusservice.queryusername(UserName);
                int prices=cuser.getPrices();
                session.setAttribute("prices", 0);
                session.setAttribute("pricess", prices);
                return "forward:/headler/customerproductlist";
            }else if(!flag1){
                model.addAttribute("loginMessage", "您输入的用户名或密码错误!");
                return "login";
            }else{
                model.addAttribute("codeMessage", "您输入的验证码错误!");
                return "login";
            }

        }


    }


    @RequestMapping("/regist")
    public String regist(Model model, manager user){


        String registmessage=service.regist(user);

        if(registmessage==null)
        {
            return "login";
        }
        else{
            model.addAttribute("registMessage",registmessage);
            return "regist";
        }



    }


    @RequestMapping("/showAll")
    public String showAll(Model model){

        List<commodity> commoditys = commservice.queryAll();

        model.addAttribute("commoditys", commoditys);

        return "productlist";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){

        commservice.deletecommodity(id);;

        return "redirect:/headler/showAll";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,HttpServletRequest request){
        commodity user = commservice.queryCommodityById(id);
        request.setAttribute("user", user);
        return "update";
    }

    @RequestMapping("/update")
    public String update(commodity user){

        commservice.updatecommodity(user);

        return "redirect:/headler/showAll";

    }
    @RequestMapping("/addcommodity")
    public String addcommodity(commodity user,Model model){

        String aaa=commservice.addcommodity(user);

        if(aaa==null){
            return "redirect:/headler/showAll";
        }
        else{
            model.addAttribute("bbb", aaa);
            return "add";
        }
    }


    @RequestMapping("/likecommodity")
    public String likecommodity(HttpServletRequest request,Model model,HttpSession session){


        String name=request.getParameter("like");
        String lowprice=request.getParameter("lowprice");
        String highprice=request.getParameter("highprice");




        List<commodity> commoditys=null;

        if(name!=null&&!lowprice.equals("")&&!highprice.equals("")){
            int lowprice1=Integer.valueOf(lowprice).intValue();
            int highprice1=Integer.valueOf(highprice).intValue();
            commoditys = commservice.findcommodityname(name,lowprice1,highprice1);
        }else if(lowprice.equals("")&& !highprice.equals("")){
            int highprice1=Integer.valueOf(highprice).intValue();
            commoditys = commservice.findcommodityname(name,0,highprice1);
        }else if(highprice.equals("")&& !lowprice.equals("")){
            int lowprice1=Integer.valueOf(lowprice).intValue();
            commoditys = commservice.findcommodityname(name,lowprice1,0);
        }else{
            commoditys = commservice.findcommodityname(name,0,0);
        }


        model.addAttribute("commoditys", commoditys);

        return "customerproductlist";

    }



    @RequestMapping("/customerproductlist")
    public String customerproductlist(Model model)
    {
        List<commodity> commoditys = commservice.queryAll();

        model.addAttribute("commoditys", commoditys);

        return "customerproductlist";
    }

    @RequestMapping("/xiaofei")
    public String xiaofei(Integer id,Model model,HttpServletRequest request,HttpSession session)
    {
        commodity user = commservice.queryCommodityById(id);

        int price=user.getPrice()+(int)session.getAttribute("prices");

        session.setAttribute("prices", price);



        return "forward:/headler/customerproductlist";
    }

    @RequestMapping("/anquantuichu")
    public String anquantuichu(HttpSession session)
    {
        session.removeAttribute("login");
        session.removeAttribute("prices");

        return "login";
    }

    @RequestMapping("/xiadangoumai")
    public String xiadangoumai(String username,Model model,HttpSession session)
    {
        if(username!=null)
        {
            customer cuser=cusservice.queryusername(username);
            int prices=cuser.getPrices()-(int)session.getAttribute("prices");

            cusservice.updatecustomer(username, prices);

            session.setAttribute("prices", 0);

            session.setAttribute("pricess", prices);

            return "forward:/headler/customerproductlist";
        }else{
            customer cuser=cusservice.queryusername(username);
            int prices=cuser.getPrices();
            session.setAttribute("prices", 0);
            session.setAttribute("pricess", prices);
            return "forward:/headler/customerproductlist";
        }

    }

    @RequestMapping("/qingkong")
    public String qingkong(HttpSession session)
    {
        session.setAttribute("prices", 0);

        return "forward:/headler/customerproductlist";
    }
    @RequestMapping("/yonghucaozuo")
    public  String yonghucaozuo(Model model,HttpSession session)
    {

        List<customer> customers = cusservice.qurryall();

        model.addAttribute("customers", customers);

        return "yonghucaozuo";
    }

    @RequestMapping("/zhuceyonghu")
    public String zhuceyonghu(customer user,Model model){

        String aaa=cusservice.regist(user);

        if(aaa==null){
            return "redirect:/headler/yonghucaozuo";
        }
        else{
            model.addAttribute("bbb", aaa);
            return "zhuceyonghu";
        }
    }

    @RequestMapping("/shanchuyonghu")
    public String shanchuyonghu(Integer id)
    {

        cusservice.shanchuyonghu(id);

        return "redirect:/headler/yonghucaozuo";
    }

    @RequestMapping("/xiugai")
    public String xiugai(Integer id, HttpServletRequest request){

        customer user = cusservice.queryCustomerById(id);
        request.setAttribute("", user);
        return "updateyonghu";


    }

    @RequestMapping("/xiugaiyonghu")
    public String xiugaiyonghu(customer user)
    {
        cusservice.updateyonghu(user);

        return "redirect:/headler/yonghucaozuo";
    }

}
