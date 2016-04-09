package com.bearbao.makeupdictionary;

/**
 * Created by Diego on 4/7/16.
 */
public class FaceCategoryItem {
    private String category;
    private int category_pic_id;

    public FaceCategoryItem(String category, int category_pic_id) {
        this.category = category;
        this.category_pic_id = category_pic_id;
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


}
