package com.atguigu.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.pojo.User;
import com.atguigu.springmvc.pojo.UserVO;

@Controller
@RequestMapping("hello2")
public class Hello2Contronller {

	@RequestMapping(value = "show1.do")
	public ModelAndView test1() {
		ModelAndView mView = new ModelAndView();		
		mView.setViewName("hello");
		mView.addObject("msg","hellow this is spring slelteon");
		return mView;
		
	}
	
	@RequestMapping("aa?/show2")
	public ModelAndView test2() {
		ModelAndView mView = new ModelAndView();		
		mView.setViewName("hello");
		mView.addObject("msg","ANT风格的映射？？？？");
		
		
		return mView;
	}
	@RequestMapping("*/show3")
	public ModelAndView test3() {
		ModelAndView mView = new ModelAndView();		
		mView.setViewName("hello");
		mView.addObject("msg","***风格的映射***");
		
		
		return mView;
	}
	@RequestMapping("show5/{name}/{id}")
	public ModelAndView test(@PathVariable("name")String name,@PathVariable("id")Long id) {
		ModelAndView mView = new ModelAndView();		
		mView.setViewName("hello");
		mView.addObject("msg","Restfull      name="+name+",  id="+id);
		
		
		return mView;
	}
	
	@RequestMapping(value="show6",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView test5() {
		ModelAndView mView = new ModelAndView("hello");
		mView.addObject("msg","限定请求方法");
		
		
		return mView;
	}
	
	@RequestMapping(value = "show8", params = "id")
    public ModelAndView test8() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "springmvc的映射之限定请求参数，id");
        return mv;
    }

    @RequestMapping(value = "show9", params = "!id")
    public ModelAndView test9() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "springmvc的映射之限定请求参数，!id");
        return mv;
    }

    @RequestMapping(value = "show10", params = "id=1")
    public ModelAndView test10() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "springmvc的映射之限定请求参数，id=1");
        return mv;
    }

    @RequestMapping(value = "show11", params = "id!=1")
    public ModelAndView test11() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "springmvc的映射之限定请求参数，id!=1");
        return mv;
    }

    @RequestMapping(value = "show12", params = { "id", "name" })
    public ModelAndView test12() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "springmvc的映射之限定请求参数，id,name");
        return mv;
    }

    
    /**
     * 1.请求头信息必须包含User-Agent
     * 2.User-Agent头参数的值必须为Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
     *   即：限定浏览器必须是谷歌浏览器，而且版本还是Chrome/69.0.3497.100
     * @return
     */
    @RequestMapping(value = "show13", headers = "User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36")
    public ModelAndView test13() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "限定请求头信息");
        return mv;
    }

//    GetMapping：相当于RequestMapping（method = RequestMethod.GET）
//    		PostMapping：相当于RequestMapping（method = RequestMethod.POST）
//    		PutMapping：相当于RequestMapping（method = RequestMethod.PUT）
//    		DeleteMapping：相当于RequestMapping（method = RequestMethod.DELETE）

    
    @GetMapping(value = "show14")
    public ModelAndView test14() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "GetMapping");
        return mv;
    }

    @PostMapping(value = "show15")
    public ModelAndView test15() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "PostMapping");
        return mv;
    }

    @PutMapping(value = "show16")
    public ModelAndView test16() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "PutMapping");
        return mv;
    }

    @DeleteMapping(value = "show17")
    public ModelAndView test17() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "DeleteMapping");
        return mv;
    }

	
    
    @RequestMapping("show18")
    public ModelAndView test18(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView("hello");
        StringBuffer sb = new StringBuffer();
        sb.append("request: " + request.toString() + "<br />");
        sb.append("response: " + response.toString() + "<br />");
        sb.append("session: " + session.toString() + "<br />");
        mv.addObject("msg", sb.toString());
        return mv;
    }

    @RequestMapping("show19")
    public String test19(Model model, ModelMap modelMap, Map<String, Object> map){
        // model.addAttribute("msg", "Model数据模型");
        // modelMap.addAttribute("msg", "ModelMap数据模型");
        map.put("msg", "Map数据模型");
        return "hello";
    }

    @RequestMapping("show20/{name}/{id}")
    public String test20(@PathVariable("name")String name,@PathVariable("id")Long id, Model model){
        model.addAttribute("msg", "获取占位符参数：name=" + name+",  id="+id);
        return "hello";
    }

    
    @RequestMapping("show21")
    public String test21(@RequestParam("name")String name,@RequestParam("id")Long id, Model model){
        model.addAttribute("msg", "获取普通参数：name=" + name+",  id="+id);
        return "hello";
    }
    
    @RequestMapping("show22")
    public String test22(@RequestParam(value = "name", required = false)String name, Model model){
        model.addAttribute("msg", "获取普通参数：" + name);
        return "hello";
    }
    
    @RequestMapping("show23")
    public String test23(@RequestParam(value = "name", defaultValue = "lisi")String name, Model model){
        model.addAttribute("msg", "获取普通参数：" + name);
        return "hello";
    }

    
    @RequestMapping("show24")
    public String test24(@RequestHeader("User-Agent")String userAgent,@RequestHeader("Cache-Control")String CacheControl, Model model){
        model.addAttribute("msg", "获取请求头信息参数：userAgent=" + userAgent+"</br> header  :  "+CacheControl);
        return "hello";
    }

    
    @RequestMapping("show25")
    public String test25(@CookieValue(value = "JSESSIONID",defaultValue = "null")String sessionId, Model model){
        model.addAttribute("msg", "获取cookie中的参数：" + sessionId);
        return "hello";
    }

    
    /**
     * 方法的返回值为void时，处理完业务逻辑后
     * 可以通过@ResponseStatus注解设置响应状态码
     * 告诉浏览器已经处理成功
     * @param name
     * @param age
     * @param isMarry
     * @param income
     * @param interests
     */
    @RequestMapping("show26")
    @ResponseStatus(value = HttpStatus.OK)
    public void test26(
    		Model model,
    		@RequestParam("userName") String username, 
    		@RequestParam("age") Integer age,
            @RequestParam("isMarry") Boolean isMarry, 
            @RequestParam("salary") Double salary,
            @RequestParam("interests") String[] interests
            ) {
		        StringBuffer sb = new StringBuffer();
		        sb.append("username: " + username + "\n");
		        sb.append("age: " + age + "\n");
		        sb.append("isMarry: " + isMarry + "\n");
		        sb.append("salary: " + salary + "\n");
		        sb.append("interests: [");
		        for (String interest : interests) {sb.append(interest + " ");}
		        sb.append("]");
	        System.out.println(sb.toString());
    }

    @RequestMapping("show27")
    @ResponseStatus(value = HttpStatus.OK)
    public void test27(User user) {
	        System.out.println(user.toString());
    }
    
    
    
//    @RequestMapping("show100")
//    public String test28(Model model, UserVO userVO) {
//        model.addAttribute("msg", userVO.getUsers().toString());
//        return "hello";
//        
//    }

    @RequestMapping("show28")
    public String test28(Model model,@RequestParam("ids")List<Long> ids){
        model.addAttribute("msg", ids.toString());
        return "hello";
    }
    
    /**
     * 测试转发
     * 并传递参数：id、key
     * @return
     */
    @RequestMapping("show29")
    public String test29() {
        
        return "forward:show31.do?id=111&key=forward";
    }
    
    /**
     * 测试重定向
     * 并传递参数：id、key
     * @return
     */
    @RequestMapping("show30")
    public String test30() {
        
        return "redirect:show31.do?id=222&key=redirect";
    }
    
    @RequestMapping("show31")
    public String test31(Model model, @RequestParam("id")Long id, @RequestParam("key")String key) {
        model.addAttribute("msg", "forward?redirect: id=" + id + ", key=" + key);
        return "hello";
    }

    
    //原生的转发以及重定向
    @RequestMapping("show32")
    public void test32(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/hello2/show30.do?id=111&key=forward").forward(request, response);;//转发
    }
    @RequestMapping("show33")
    public void test33(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.sendRedirect("/springmvc/hello2/show30.do?id=222&key=redirect");//重定向
    }
    
    
    

   
    
    @RequestMapping("show34")
    public String test20(Model model){
        
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("马云" + i);
            user.setAge(20 + i);
            user.setSalary(1000.00+i);
            user.setIsMarry(false);
            user.setInterests(new String[]{"market","data"});
            users.add(user);
        }
        model.addAttribute("users1", users);
        
        return "users";
    }
    
    
    
    
    
    //这里是通过表格去提交数据视图控制
    @RequestMapping("user")
    public String toUser(Model model){
        model.addAttribute("user", new User());
        return "user";
    }
    //这里是数据接收之后进行打印在后台
    @RequestMapping("save")
    @ResponseStatus(value=HttpStatus.OK)
    public void save(User user){
        System.out.println(user.toString());
    }
    
    
    /**
     * 需要把什么序列化为json，就返回什么值
     * 1.方法上添加该注解，代表该方法要返回其他视图
     * 2.把方法的返回序列化为json
     * @return
     */
    @RequestMapping("show35")
    @ResponseBody
    public List<User> test35(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("高晓松" + i);
            user.setAge(20 + i);
            user.setIsMarry(false);
            user.setSalary(1000.51);
            user.setInterests(new String[] {"football","basketball"});
            user.setBirthday(new Date());
            user.setPassword("12345678-ii"+i);
            users.add(user);
        }
        return users;
    }
    
    @RequestMapping("show36")
    @ResponseBody
    public String test36(){
        return "hello world!";
    }
    
    
    
    @RequestMapping("show37")
    public String test37(@RequestBody User user, Model model){
        
        model.addAttribute("msg", user);
        return "hello";
    }
    
    /**
     * 文件上传的主要细节问题
     * 上传之前需要包  commons-fileupload-1.3.3.jar ，    commons-io-2.6.jar
     * 2， 配置文件上传解析器  url spring-web 包 CommonsMutipartResolver
     * 3.编写controller，文件的接受跟普通参数差不多MutilpartFile file.TransferTo(new File("路径"))
     * 文件大小超出范围就会抛出异常 出来给MyHandlerExceptionResolver 类去处理异常问题
     * @param file
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
  @RequestMapping("show38")
  public String test38(@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {
	  file.transferTo(new File("D:\\"+file.getOriginalFilename()));
	return "redirect:/success.html";
  	
  }
  
    
  
  //拦截器的使用检车
  @RequestMapping("show39")
  public ModelAndView test39() throws RuntimeException{
	  ModelAndView mView = new ModelAndView();
	  System.out.println("Handler 方法正在执行");
	  mView.setViewName("hello");
	  mView.addObject("msg", "this is springmvc");
	  return mView;
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    
    
}























