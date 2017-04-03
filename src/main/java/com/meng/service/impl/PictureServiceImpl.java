package com.meng.service.impl;

import com.meng.dao.PictureDao;
import com.meng.domain.Picture;
import com.meng.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    public List<Picture> getAllPicture() {
        return pictureDao.getAllPictures();
    }
    public int InsertPicture(String picName, String content) {
        return pictureDao.InsertPicture(picName,content);
    }
}
