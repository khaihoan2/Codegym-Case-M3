package com.codegym.model;

import java.sql.Date;

public class Order {
    private int id;

    private int userId;

    private String userName;

    private int paymentId;

    private String paymentName;

    private int shipmentId;

    private String shipmentName;

    private int statusId;

    private String statusName;

    private Date createAt;

    private Date lastModifiedAt;

    private Date deleteAt;

    public Order() {
    }

    public Order(int userId, int paymentId, int shipmentId) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.shipmentId = shipmentId;
    }

    public Order(int id, int userId, int paymentId, int shipmentId, int statusId, Date createAt, Date lastModifiedAt, Date deleteAt) {
        this.id = id;
        this.userId = userId;
        this.paymentId = paymentId;
        this.shipmentId = shipmentId;
        this.statusId = statusId;
        this.createAt = createAt;
        this.lastModifiedAt = lastModifiedAt;
        this.deleteAt = deleteAt;
    }

    public Order(int id, int userId, String userName, int paymentId, String paymentName, int shipmentId, String shipmentName, int statusId, String statusName, Date createAt, Date lastModifiedAt, Date deleteAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.paymentId = paymentId;
        this.paymentName = paymentName;
        this.shipmentId = shipmentId;
        this.shipmentName = shipmentName;
        this.statusId = statusId;
        this.statusName = statusName;
        this.createAt = createAt;
        this.lastModifiedAt = lastModifiedAt;
        this.deleteAt = deleteAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentName() {
        return shipmentName;
    }

    public void setShipmentName(String shipmentName) {
        this.shipmentName = shipmentName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }
}
