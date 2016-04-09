package com.bearbao.makeupdictionary;

/**
 * Created by Diego on 4/8/16.
 */
public class ProductItem {
    private String product;
    private int product_pic_id;

    public ProductItem(String product, int product_pic_id) {
        this.product = product;
        this.product_pic_id = product_pic_id;
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getProduct_pic_id() {
        return product_pic_id;
    }

    public void setProduct_pic_id(int product_pic_id) {
        this.product_pic_id = product_pic_id;
    }


}
