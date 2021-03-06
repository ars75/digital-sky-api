package com.ispirit.digitalsky.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ispirit.digitalsky.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ds_drone_device")
public class DroneDevice implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "DRONE_TYPE_ID")
    private long droneTypeId;

    @JsonIgnore
    @Column(name = "CREATED_DATE")
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @JsonDeserialize(using = CustomLocalDateDeSerializer.class)
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate createdDate;

    @JsonIgnore
    @Column(name = "LAST_MODIFIED_DATE")
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @JsonDeserialize(using = CustomLocalDateDeSerializer.class)
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate lastModifiedDate;

    @JsonIgnore
    @Column(name = "MANUFACTURER_BUSINESS_IDENTIFIER", nullable = false)
    @Size(max = 36)
    private String manufacturerBusinessIdentifier;

    @JsonIgnore
    @Column(name = "REGISTRATION_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneDeviceRegistrationStatus registrationStatus  = DroneDeviceRegistrationStatus.NOT_REGISTERED;

    @Column(name = "VERSION")
    @NotNull
    @Size(max = 20)
    private String version;

    @Column(name = "TXN")
    @NotNull
    @Size(max = 50)
    private String txn;

    @Column(name = "UNIQUE_DEVICE_ID")
    @NotNull
    @Size(max = 50)
    private String deviceId;

    @Column(name = "DEVICE_MODEL_ID")
    @NotNull
    @Size(max = 50)
    private String deviceModelId;

    @Column(name = "OPERATOR_BUSINESS_IDENTIFIER")
    @Size(max = 36)
    private String operatorBusinessIdentifier;

    @Column(name = "ID_HASH")
    private String idHash;

    public DroneDevice() {

    }

    public DroneDevice(String deviceId, String deviceModelId, String version, String txn, String idHash, String operatorBusinessIdentifier, long droneTypeId ) {
        this.deviceId = deviceId;
        this.deviceModelId = deviceModelId;
        this.version = version;
        this.txn = txn;
        this.idHash = idHash;
        this.operatorBusinessIdentifier = operatorBusinessIdentifier;
        this.droneTypeId = droneTypeId;
    }

    public DroneDevice(String deviceId, String deviceModelId, String version, String txn, String idHash ) {
        this.deviceId = deviceId;
        this.deviceModelId = deviceModelId;
        this.version = version;
        this.txn = txn;
        this.idHash = idHash;
    }


    public long getDroneTypeId() {
        return droneTypeId;
    }

    public void setDroneTypeId(long droneTypeId) {
        this.droneTypeId = droneTypeId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTxn() {
        return txn;
    }

    public void setTxn(String txn) {
        this.txn = txn;
    }

    public String getDeviceId() { return deviceId; }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(String deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public String getOperatorBusinessIdentifier() { return operatorBusinessIdentifier; }

    public void setOperatorBusinessIdentifier(String operatorBusinessIdentifier) { this.operatorBusinessIdentifier = operatorBusinessIdentifier; }

    public String getManufacturerBusinessIdentifier() { return manufacturerBusinessIdentifier; }

    public void setManufacturerBusinessIdentifier(String manufacturerBusinessIdentifier) { this.manufacturerBusinessIdentifier = manufacturerBusinessIdentifier; }

    public String getIdHash() {
        return idHash;
    }

    public void setIdHash(String idHash) { this.idHash = idHash; }

    public DroneDeviceRegistrationStatus getRegistrationStatus() { return registrationStatus; }

    public void setRegistrationStatus(DroneDeviceRegistrationStatus registrationStatus) { this.registrationStatus = registrationStatus; }
}
