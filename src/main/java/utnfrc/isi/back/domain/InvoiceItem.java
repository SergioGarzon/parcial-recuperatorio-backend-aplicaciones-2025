package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVOICE_ITEMS")
public class InvoiceItem {
    
    /*
    INVOICE_LINE_ID INTEGER        NOT NULL DEFAULT NEXT VALUE FOR SEQ_INVOICE_LINE_ID,
    INVOICE_ID      INTEGER        NOT NULL,
    TRACK_ID        INTEGER        NOT NULL,
    UNIT_PRICE      NUMERIC(10, 2) NOT NULL,
    QUANTITY        INTEGER        NOT NULL,
     */

    @Column(name = "INVOICE_LINE_ID")
    private Integer idInvoiceLine;

    @ManyToOne(optional = false)
    @Column(name = "INVOICE_ID")
    private Integer idInvoice;

    @Column(name = "TRACK_ID")
    private Integer idTrack;

    @Column(name = "UNIT_PRICE")
    private Float unitPrice;

    @Column(name = "QUANTITY")
    private Integer quantity;

}
