package utnfrc.isi.back.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="invoice_seq")
    @SequenceGenerator(name = "invoice_seq", sequenceName = "SEQ_INVOICE_ID", allocationSize = 1)
    @Column(name = "INVOICE_ID")
    private Integer idInvoice;

    @ManyToOne(optional = false)
    @Column(name = "CUSTOMER_ID")
    private Integer idCustomer;

    @Column(name = "INVOICE_DATE")
    private LocalDate invoiceDate;

    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;

    @Column(name = "BILLING_CITY")
    private String billingCity;

    @Column(name = "BILLING_STATE")
    private String billingState;

    @Column(name = "BILLING_COUNTRY")
    private String billingCountry;

    @Column(name = "BILLING_POSTAL_CODE")
    private String billingPostalCode;

    @Column(name = "TOTAL")
    private Float total;
}
