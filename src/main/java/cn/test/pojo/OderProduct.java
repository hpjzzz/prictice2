package cn.test.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OderProduct {
    private Long id;

    private Long tProductNum;

    private Long tOrderNum;

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

    public Long gettProductNum() {
        return tProductNum;
    }

    public void settProductNum(Long tProductNum) {
        this.tProductNum = tProductNum;
    }

    public Long gettOrderNum() {
        return tOrderNum;
    }

    public void settOrderNum(Long tOrderNum) {
        this.tOrderNum = tOrderNum;
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

    @Override
    public String toString() {
        return "OderProduct{" +
                "id=" + id +
                ", tProductNum=" + tProductNum +
                ", tOrderNum=" + tOrderNum +
                ", totalNum=" + totalNum +
                ", totalPrice=" + totalPrice +
                ", gmtCreat=" + gmtCreat +
                ", gmtModified=" + gmtModified +
                '}';
    }
}