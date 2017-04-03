package com.meng.service;

import java.util.List;

import com.meng.domain.Picture;


public interface PictureService {
    /**
     * 查询所有照片
     * @return 所有照片
     */
    List<Picture> getAllPicture();

    /**
     * 这个服务就是PictureDao中的InsertP
     * @param picName
     * @param content
     * @return 数据库成功返回1，失败返回0
     */
    int InsertPicture(String picName, String content);
}
