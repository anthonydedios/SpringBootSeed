package com.telstra.wifidisconnectdb.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "WIFI_DISCONNECT")
public class WifiDisconnect {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    @Column(name = "CREATED_DATE", nullable = true)
    private Date createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    @Column(name = "SCHEDULED_DATE")
    private String scheduledDate;

    @Column(name = "CUSTOMER_ACCOUNT_CODE")
    private String customerAccountCode;

    @Column(name = "BILLING_ACCOUNT_CODE")
    private String billingAccountCode;

    @Column(name = "SERVICE_ID")
    private String serviceId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "SWB_VERSION")
    private String swbVersion;

    @Column(name = "CREDIT_CODE")
    private String creditCode;

    @Column(name = "DNUMBER")
    private String dnumber;

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSwbVersion() {
        return swbVersion;
    }

    public void setSwbVersion(String swbVersion) {
        this.swbVersion = swbVersion;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getDnumber() {
        return dnumber;
    }

    public void setDnumber(String dnumber) {
        this.dnumber = dnumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBillingAccountCode() {
        return billingAccountCode;
    }

    public void setBillingAccountCode(String billingAccountCode) {
        this.billingAccountCode = billingAccountCode;
    }

    public String getCustomerAccountCode() {
        return customerAccountCode;
    }

    public void setCustomerAccountCode(String customerAccountCode) {
        this.customerAccountCode = customerAccountCode;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public WifiDisconnect() {
    }

    public WifiDisconnect(String customerAccountCode, String billingAccountCode, String serviceId, String status, String swbVersion, String creditCode, String dnumber, String scheduledDate, Date createdDate) {
        this.customerAccountCode = customerAccountCode;
        this.billingAccountCode = billingAccountCode;
        this.serviceId = serviceId;
        this.status = status;
        this.swbVersion = swbVersion;
        this.creditCode = creditCode;
        this.dnumber = dnumber;
        this.scheduledDate = scheduledDate;
        this.createdDate = createdDate;
    }
}
