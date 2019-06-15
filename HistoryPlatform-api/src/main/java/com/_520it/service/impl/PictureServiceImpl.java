package com._520it.service.impl;

import com._520it.mapper.PictureMapper;
import com._520it.pojo.Picture;
import com._520it.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/22.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;
    public void savePicture(Picture picture) {
        pictureMapper.savePicture(picture );
    }

    public int queryPicture(Picture picture) {
        return pictureMapper.queryPicture(picture);
    }

    public void updatePicture(Picture picture) {
        pictureMapper.updatePicture(picture);
    }

    public int countTotal(Picture picture) {
        return pictureMapper.countTotal(picture);
    }

    public List<Picture> queryPictures(Picture picture, int startIndex, int endIndex) {
        return pictureMapper.queryPictures(picture,  startIndex,  endIndex);
    }

    public void removePicture(String id) {
       pictureMapper.removePicture(id);
    }
}
