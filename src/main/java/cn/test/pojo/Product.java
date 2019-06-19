package cn.test.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Long id;

    private Long productNum;

    private String productName;

    private BigDecimal productPrice;

    private Date gmtCreat;

    private Date gmtModifiled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductNum() {
        return productNum;
    }

    public void setProductNum(Long productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Date getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(Date gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    public Date getGmtModifiled() {
        return gmtModifiled;
    }

    public void setGmtModifiled(Date gmtModifiled) {
        this.gmtModifiled = gmtModifiled;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productNum=" + productNum +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", gmtCreat=" + gmtCreat +
                ", gmtModifiled=" + gmtModifiled +
                '}';
    }
}