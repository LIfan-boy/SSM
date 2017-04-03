package com.meng.web.controller;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.meng.domain.Picture;
import com.meng.domain.User;
import com.meng.service.PictureService;
import com.meng.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Elric on 2017/3/24.
 */
@Controller
public class MainController {

	@Autowired
	private PictureService pictureService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Picture> pictures = pictureService.getAllPicture();
		model.addAttribute("pictures", pictures);
		return "index";
	}

	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "single")
	public String single() {
		return "single";
	}
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "checkandRedict")
	public String checkAndRedict(@Param("username") String username, @Param("password") String password, 
			HttpServletRequest request) {
		//获取参数
		String userName = request.getParameter("username");
		String pass = request.getParameter("password");
		
		User user = userService.CheckUser(username, password);
		if (user != null && username.equals(user.getUsername()) && pass.equals(user.getPassword())) {
			return "upload";
		} else {
			return "index";
		}
	}
	
	/**
	 * 上传
	 * @param file
	 * @param content
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, @Param("content") String content,
			HttpServletRequest request, Model model) throws IOException {
	
		// 获取项目的根路径，将上传图片的路径与我们的资源路径在一起，才能显示
		HttpSession session = request.getSession();
		String path = session.getServletContext().getRealPath("/");
		System.out.println("getRealPath('/'):" + path);
		
		String picName = new Date().getTime() + ".jpg";
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path + "upload/", new Date().getTime() + ".jpg"));
		} else if (content == null) {
			// 如果输入为null数据库不允许插入
			content = "";
		}
		// 图片类的名字保存为路径+名字方便后期前端提取
		// 将图片名字用时间戳保存，解决上传图片为中文乱码等问题
		String uploadPath = request.getContextPath();
		int code = pictureService.InsertPicture(uploadPath + "/upload/" + picName, content);
		if (code == 1) {
			List<Picture> pictures = pictureService.getAllPicture();
			model.addAttribute("pictures", pictures);
			return "index";
		} else
			return "index";
	}
}
