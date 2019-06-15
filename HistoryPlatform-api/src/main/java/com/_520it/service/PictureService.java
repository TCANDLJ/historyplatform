package com._520it.service;

import com._520it.pojo.Picture;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/22.
 */
public interface PictureService {
    void savePicture(Picture picture);

    int queryPicture(Picture picture);

    void updatePicture(Picture picture);

    int countTotal(Picture picture);

    List<Picture> queryPictures(Picture picture, int startIndex, int endIndex);

    void removePicture(String id);
}
