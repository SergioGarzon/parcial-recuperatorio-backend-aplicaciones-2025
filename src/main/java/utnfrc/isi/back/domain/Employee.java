package utnfrc.isi.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    private int idEmployee;
    private String lastName;
    private String firstName;
    private String title;
    private int reportsTo;
    private String birthDate;
    private String hireDate;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
}
