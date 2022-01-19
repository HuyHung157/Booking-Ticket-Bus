/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhung.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TIM
 */
@Entity
@Table(name = "order_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderTicket.findAll", query = "SELECT o FROM OrderTicket o"),
    @NamedQuery(name = "OrderTicket.findById", query = "SELECT o FROM OrderTicket o WHERE o.id = :id"),
    @NamedQuery(name = "OrderTicket.findByAmount", query = "SELECT o FROM OrderTicket o WHERE o.amount = :amount"),
    @NamedQuery(name = "OrderTicket.findByCreatedDate", query = "SELECT o FROM OrderTicket o WHERE o.createdDate = :createdDate"),
    @NamedQuery(name = "OrderTicket.findByDescription", query = "SELECT o FROM OrderTicket o WHERE o.description = :description"),
    @NamedQuery(name = "OrderTicket.findByIsActive", query = "SELECT o FROM OrderTicket o WHERE o.isActive = :isActive"),
    @NamedQuery(name = "OrderTicket.findByIsArchive", query = "SELECT o FROM OrderTicket o WHERE o.isArchive = :isArchive")})
public class OrderTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderTicket")
    private Set<OrderDetail> orderDetailSet;

    {
        isActive = true;
        isArchive = false;
    }

    public OrderTicket() {
    }

    public OrderTicket(Integer id) {
        this.id = id;
    }

    public OrderTicket(Integer id, Date createdDate, boolean isActive, boolean isArchive) {
        this.id = id;
        this.createdDate = createdDate;
        this.isActive = isActive;
        this.isArchive = isArchive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
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
        if (!(object instanceof OrderTicket)) {
            return false;
        }
        OrderTicket other = (OrderTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.huyhung.pojo.OrderTicket[ id=" + id + " ]";
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
