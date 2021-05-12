/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.controller;



import co.admis.model.Customer;
import co.admis.model.Product;
import co.admis.model.ProductImage;
import co.admis.service.AdminService;
import co.admis.service.CustomerService;
import co.admis.service.ProductImageService;
import co.admis.service.ProductService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adeep My IT Solution Private Limited
 */
@Controller
public class Index {
    
    @Autowired
    AdminService adminService;
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    ProductImageService productImageService;
    
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }
    
    @RequestMapping(value = {"/signUp"}, method = RequestMethod.POST)
    public @ResponseBody 
        String signUp(HttpServletRequest request, HttpServletResponse response, Customer customer) {
        HttpSession session = request.getSession();
        System.out.println(session);
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("email"));
        String pswrd = request.getParameter("password");
        String pswrd2 = request.getParameter("confirmPassword");
        if(pswrd.equals(pswrd2))
        {
            Customer c = customerService.addCustomer(customer);
            if(c!=null){
            session.setAttribute("name",customer.getName()); 
            session.setAttribute("email", customer.getEmail());
            System.out.println("added");
            return "customer added";
            }
            return "Could'nt Add. Try again.";
            }
       else
        {
            return "paaswords do not match";
        }
    }
        
    @RequestMapping(value = {"/success"}, method = RequestMethod.GET)
    public ModelAndView success(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("success");
    }
    
    @RequestMapping(value = {"/failure"}, method = RequestMethod.GET)
    public ModelAndView failure(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("failure");
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = {"/signIn"}, method = RequestMethod.POST)
    public @ResponseBody 
        String signIn(HttpServletRequest request, HttpServletResponse response, Customer customer) {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pswrd = request.getParameter("password");
        Customer c = customerService.getCustomerByEmailAndPassword(email, pswrd);
        Customer c2 = customerService.getCustomerByEmail(email);
        if(c!=null){
          session.setAttribute("email", email);
          ModelAndView mav = new ModelAndView("dashboard-analytics");
          mav.addObject("customer",c2);
          return "loginSuccessful";
        }
        else if(c2!=null)
            return "incorrectEmail";
        else
            return "loginUnsuccessful";
    }
      
    @RequestMapping(value = {"/admin-add-product"}, method = RequestMethod.GET)
    public ModelAndView adminAddProduct(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(session);
        if(session!=null) 
        return new ModelAndView("admin-add-product");
        else 
            return new ModelAndView("login");
    }
    
    @RequestMapping(value = {"/addProduct"}, method = RequestMethod.POST)
    public @ResponseBody
        String addProduct(HttpServletRequest request, HttpServletResponse response, Product product, @RequestParam("file") MultipartFile multipartFile) throws IOException{
        System.out.println("hello");
            HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("app-ecommerce-details");
        ModelAndView mav2 = new ModelAndView("admin-add-product");
        if(session!=null)
        {
        System.out.println("hey"); 
  System.out.println(multipartFile.isEmpty());
        System.out.println(multipartFile.getSize());
        String key = "https://s3.ap-south-1.amazonaws.com/admin.add.product.images/Handbags/";
        String fileName = multipartFile.getOriginalFilename();
        System.out.println(fileName);
        String brand = request.getParameter("brand");
        productService.uploadS3Object("admin.add.product.images/Handbags", fileName, multipartFile.getInputStream());
        product.setImage(key+fileName);
        Product p = productService.addProduct(product); 
        ProductImage productImage = new ProductImage();
        productImage.setImage_name(multipartFile.getName());
        productImage.setImage_type(multipartFile.getContentType());
        productImage.setImage_url(key+fileName);
        productImage.setProduct(p);
        ProductImage pImage = productImageService.addProductImage(productImage);
        System.out.println(p.getBrand());
        Product productDetail = productService.getProductById(product.getIdproduct());
        System.out.println(productDetail);
        mav.addObject("productDetail",productDetail);
        return productDetail.getIdproduct()+"";
        }
        else 
            return "CannotAdd";
    }      
    
    @RequestMapping(value = {"/app-ecommerce-shop"}, method = RequestMethod.GET)
    public ModelAndView app_ecommerce_shop(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("app-ecommerce-shop");
        if(session!=null)  
        {
            String email = (String) session.getAttribute("email");
            System.out.println(email);
            Customer c = customerService.getCustomerByEmail(email);
            List<Product> p = productService.getProducts();
            p.size();
            if(c!=null)
            {
                mav.addObject("total", p.size());
                mav.addObject("products" , p);
                mav.addObject("customer",c);
                return mav;
            }
            else 
                return new ModelAndView("login");
        }
        return new ModelAndView("login");
    }
    
//    @RequestMapping(value = {"/app-ecommerce-details"}, method = RequestMethod.GET)
//    public ModelAndView app_ecommerce_details(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//        ModelAndView mav = new ModelAndView("app-ecommerce-details");
//        if(session!=null)  
//        {
//            String email = (String) session.getAttribute("email");
//            System.out.println(email);
//            Customer c = customerService.getCustomerByEmail(email);
//            if(c!=null)
//            {
//                mav.addObject("customer",c);
//                return mav;
//            }
//            else 
//                return new ModelAndView("login");
//        }
//        return new ModelAndView("login");
//    
//    }
//    
    @RequestMapping(value = {"/app-ecommerce-details"}, method = RequestMethod.GET)
    public ModelAndView app_ecommerce_details(HttpServletRequest request, HttpServletResponse response, @RequestParam("idproduct") int idproduct) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("app-ecommerce-details");
        if(session!=null)  
        {
            String email = (String) session.getAttribute("email");
            System.out.println(email);
            Customer c = customerService.getCustomerByEmail(email);
            Product p = productService.getProductById(idproduct);
            if(c!=null)
            {
                mav.addObject("customer",c);
                mav.addObject("productDetail",p);
                return mav;
            }
            else 
                return new ModelAndView("login");
        }
        return new ModelAndView("login");
    
    }
    
    
    @RequestMapping(value = {"/dashboard-analytics"}, method = RequestMethod.GET)
    public ModelAndView dashboard_analytics(HttpServletRequest request, HttpServletResponse response) {
       HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("dashboard-analytics");
        if(session!=null)  
        {
            String email = (String) session.getAttribute("email");
            System.out.println(email);
            Customer c = customerService.getCustomerByEmail(email);
            if(c!=null)
            {
                mav.addObject("customer",c);
                return mav;
            }
            else 
                return new ModelAndView("login");
        }
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = {"/dashboard-ecommerce"}, method = RequestMethod.GET)
    public ModelAndView dashboard_ecommerce(HttpServletRequest request, HttpServletResponse response) {
       HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("dashboard-ecommerce");
        if(session!=null)  
        {
            String email = (String) session.getAttribute("email");
            System.out.println(email);
            Customer c = customerService.getCustomerByEmail(email);
            if(c!=null)
            {
                mav.addObject("customer",c);
                return mav;
            }
            else 
                return new ModelAndView("login");
        }
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = {"/page-user-profile"}, method = RequestMethod.GET)
    public ModelAndView pageUserProfile(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("page-user-profile");
    }
    
}
