package com.meng.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.meng.domain.Picture;
import com.meng.service.impl.PictureServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class) // spring的单元测试
@ContextConfiguration({ "classpath:spring/spring-*.xml" }) // 上下文配置
public class PictureServiceTest {
	
	@Autowired
	private PictureServiceImpl pictureService;
	
	@Test
	public void getAllPictureTest() {
		
		List<Picture> result = new ArrayList<>();
		try {
			result = pictureService.getAllPicture();
			for(Picture picture : result) {
				System.out.println(picture);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查找用户失败！");
		}
		if (result != null) {
			System.err.println("查找用户成功！");
		}
		
	}
	
	@Test
	public void InsertPicture() {
		
	}
}
