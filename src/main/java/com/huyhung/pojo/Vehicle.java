/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TIM
 */
@Entity
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicle.findByLicensePlates", query = "SELECT v FROM Vehicle v WHERE v.licensePlates = :licensePlates"),
    @NamedQuery(name = "Vehicle.findByVehicleNumber", query = "SELECT v FROM Vehicle v WHERE v.vehicleNumber = :vehicleNumber"),
    @NamedQuery(name = "Vehicle.findByTotalSeat", query = "SELECT v FROM Vehicle v WHERE v.totalSeat = :totalSeat"),
    @NamedQuery(name = "Vehicle.findByTotalSeatUpper", query = "SELECT v FROM Vehicle v WHERE v.totalSeatUpper = :totalSeatUpper"),
    @NamedQuery(name = "Vehicle.findByTotalSeatLower", query = "SELECT v FROM Vehicle v WHERE v.totalSeatLower = :totalSeatLower"),
    @NamedQuery(name = "Vehicle.findByStatus", query = "SELECT v FROM Vehicle v WHERE v.status = :status"),
    @NamedQuery(name = "Vehicle.findByDescription", query = "SELECT v FROM Vehicle v WHERE v.description = :description"),
    @NamedQuery(name = "Vehicle.findByIsActive", query = "SELECT v FROM Vehicle v WHERE v.isActive = :isActive"),
    @NamedQuery(name = "Vehicle.findByIsArchive", query = "SELECT v FROM Vehicle v WHERE v.isArchive = :isArchive")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "license_plates")
    private String licensePlates;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_seat")
    private int totalSeat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_seat_upper")
    private int totalSeatUpper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_seat_lower")
    private int totalSeatLower;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_archive")
    private boolean isArchive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Set<TripDetail> tripDetailSet;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Vehicle(Integer id, String licensePlates, String vehicleNumber, int totalSeat, int totalSeatUpper, int totalSeatLower, String status, boolean isActive, boolean isArchive) {
        this.id = id;
        this.licensePlates = licensePlates;
        this.vehicleNumber = vehicleNumber;
        this.totalSeat = totalSeat;
        this.totalSeatUpper = totalSeatUpper;
        this.totalSeatLower = totalSeatLower;
        this.status = status;
        this.isActive = isActive;
        this.isArchive = isArchive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getTotalSeatUpper() {
        return totalSeatUpper;
    }

    public void setTotalSeatUpper(int totalSeatUpper) {
        this.totalSeatUpper = totalSeatUpper;
    }

    public int getTotalSeatLower() {
        return totalSeatLower;
    }

    public void setTotalSeatLower(int totalSeatLower) {
        this.totalSeatLower = totalSeatLower;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(boolean isArchive) {
        this.isArchive = isArchive;
    }

    @XmlTransient
    public Set<TripDetail> getTripDetailSet() {
        return tripDetailSet;
    }

    public void setTripDetailSet(Set<TripDetail> tripDetailSet) {
        this.tripDetailSet = tripDetailSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.huyhung.pojo.Vehicle[ id=" + id + " ]";
    }
    
}
