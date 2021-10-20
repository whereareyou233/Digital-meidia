package com.example.redxiaoxiang;

import java.io.Serializable;

public class Book implements Serializable {
    public int imgPath;//图片地址
    public String Name;//货物名称



    public Book(int imgPath, String goodsName) {
        this.imgPath = imgPath;
        this.Name = goodsName;

    }

    public int getImgPath() {
        return imgPath;
    }

    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String goodsName) {
        this.Name = goodsName;
    }


}