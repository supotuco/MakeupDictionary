package com.bearbao.makeupdictionary;

/**
 * Created by Diego on 4/7/16.
 */
public class FaceCategoryItem {
    private String category;
    private int category_pic_id;
    private int category_position;

    public FaceCategoryItem(String category, int category_pic_id, int category_position) {
        this.category = category;
        this.category_pic_id = category_pic_id;
        this.category_position = category_position;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategory_pic_id() {
        return category_pic_id;
    }

    public void setCategory_pic_id(int category_pic_id) {
        this.category_pic_id = category_pic_id;
    }

    public int getCategory_position() {
        return category_position;
    }

    public void setCategory_position(int category_position) {
        this.category_position = category_position;
    }
}
