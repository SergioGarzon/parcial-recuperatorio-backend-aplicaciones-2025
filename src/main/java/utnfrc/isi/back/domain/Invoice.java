package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVOICES")
public class Invoice {
    /*
    INVOICE_ID          INTEGER        NOT NULL DEFAULT NEXT VALUE FOR SEQ_INVOICE_ID,
    CUSTOMER_ID         INTEGER        NOT NULL,
    INVOICE_DATE        DATE           NOT NULL,
    BILLING_ADDRESS     VARCHAR(70),
    BILLING_CITY        VARCHAR(40),
    BILLING_STATE       VARCHAR(40),
    BILLING_COUNTRY     VARCHAR(40),
    BILLING_POSTAL_CODE VARCHAR(10),
    TOTAL               NUMERIC(10, 2) NOT NULL,
     */

    private Integer idInvoice;
    private Integer idCustomer;
    private String invoiceDate;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private Float total;
}
