package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    /*    
    EMPLOYEE_ID  INTEGER       ,
    LAST_NAME    VARCHAR(20)   ,
    FIRST_NAME   VARCHAR(20)  ,
    TITLE        VARCHAR(30),
    REPORTS_TO   INTEGER,
    BIRTH_DATE   DATE,
    HIRE_DATE    DATE,
    ADDRESS      VARCHAR(70),
    CITY         VARCHAR(40),
    STATE        VARCHAR(40),
    COUNTRY      VARCHAR(40),
    POSTAL_CODE  VARCHAR(10),
    PHONE        VARCHAR(24),
    FAX          VARCHAR(24),
    EMAIL        VARCHAR(60),
    */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "SEQ_EMPLOYEE_ID", allocationSize = 1)
    @Column(name = "EMPLOYEE_ID")
    private Integer idEmployee;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "REPORTS_TO")
    private Integer reportsTo;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "HIRE_DATE")
    private LocalDate hireDate;

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
}
