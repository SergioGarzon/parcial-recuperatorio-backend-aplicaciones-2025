package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    
    /*
    
    CUSTOMER_ID    INTEGER
    FIRST_NAME     VARCHAR(40)  
    LAST_NAME      VARCHAR(20)  
    COMPANY        VARCHAR(80),
    ADDRESS        VARCHAR(70),
    CITY           VARCHAR(40),
    STATE          VARCHAR(40),
    COUNTRY        VARCHAR(40),
    POSTAL_CODE    VARCHAR(10),
    PHONE          VARCHAR(24),
    FAX            VARCHAR(24),
    EMAIL          VARCHAR(60)  
    SUPPORT_REP_ID INTEGER,
    */

    @Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(optional = true)
    @Column(name = "SUPPORT_REP_ID")
    private Integer supportRepId;
}
