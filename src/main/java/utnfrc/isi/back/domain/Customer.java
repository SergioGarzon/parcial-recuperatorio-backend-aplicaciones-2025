package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
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

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
    private Integer supportRepId;
}
