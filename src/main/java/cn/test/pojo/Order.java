package cn.test.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long id;

    private Long orderNum;

    private Date deliveryDate;

    private String consignorNum;

    private String consignorName;

    private String providerNum;

    private String providerName;

    private Long totalNum;

    private BigDecimal totalPrice;

    private Date gmtCreat;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getConsignorNum() {
        return consignorNum;
    }

    public void setConsignorNum(String consignorNum) {
        this.consignorNum = consignorNum == null ? null : consignorNum.trim();
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName == null ? null : consignorName.trim();
    }

    public String getProviderNum() {
        return providerNum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum=" + orderNum +
                ", deliveryDate=" + deliveryDate +
                ", consignorNum='" + consignorNum + '\'' +
                ", consignorName='" + consignorName + '\'' +
                ", providerNum='" + providerNum + '\'' +
                ", providerName='" + providerName + '\'' +
                ", totalNum=" + totalNum +
                ", totalPrice=" + totalPrice +
                ", gmtCreat=" + gmtCreat +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public void setProviderNum(String providerNum) {
        this.providerNum = providerNum == null ? null : providerNum.trim();
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(Date gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}