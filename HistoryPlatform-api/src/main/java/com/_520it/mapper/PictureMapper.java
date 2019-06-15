package com._520it.mapper;

import com._520it.pojo.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/22.
 */
public interface PictureMapper {
    /**
     * 保存图片
     * @param picture
     */
    void savePicture(Picture picture);

    /**
     * 查询图片
     * @param picture
     * @return
     */
    int queryPicture(Picture picture);

    /**
     * 更新
     * @param picture
     */
    void updatePicture(Picture picture);

    /**
     * 统计图片数量
     * @param picture
     * @return
     */
    int countTotal(Picture picture);

    /**
     * 查询图片
     * @param picture
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<Picture> queryPictures(@Param("picture") Picture picture, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    /**
     * 删除
     * @param id
     */
    void removePicture(String id);
}
