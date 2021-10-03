package com.codegym.model;

import java.time.LocalDate;

public class Order {
    private int id;

    private int userId;

    private int paymentId;

    private int shipmentId;

    private int statusId;

    private LocalDate createAt;

    private LocalDate lastModifiedAt;

    private LocalDate deleteAt;

    public Order() {
    }

    public Order(int id, int userId, int paymentId, int shipmentId, int statusId, LocalDate createAt, LocalDate lastModifiedAt, LocalDate deleteAt) {
        this.id = id;
        this.userId = userId;
        this.paymentId = paymentId;
        this.shipmentId = shipmentId;
        this.statusId = statusId;
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

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDate lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public LocalDate getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDate deleteAt) {
        this.deleteAt = deleteAt;
    }
}
