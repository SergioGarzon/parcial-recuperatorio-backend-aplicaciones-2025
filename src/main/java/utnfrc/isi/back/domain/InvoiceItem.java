package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InvoiceItem {
    
    /*
    INVOICE_LINE_ID INTEGER        NOT NULL DEFAULT NEXT VALUE FOR SEQ_INVOICE_LINE_ID,
    INVOICE_ID      INTEGER        NOT NULL,
    TRACK_ID        INTEGER        NOT NULL,
    UNIT_PRICE      NUMERIC(10, 2) NOT NULL,
    QUANTITY        INTEGER        NOT NULL,
     */

    private Integer idInvoiceLine;
    private Integer idInvoice;
    private Integer idTrack;
    private Float unitPrice;
    private Integer quantity;

}
