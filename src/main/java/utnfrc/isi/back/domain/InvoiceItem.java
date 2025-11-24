package utnfrc.isi.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {
    
    /*
    INVOICE_LINE_ID INTEGER        NOT NULL DEFAULT NEXT VALUE FOR SEQ_INVOICE_LINE_ID,
    INVOICE_ID      INTEGER        NOT NULL,
    TRACK_ID        INTEGER        NOT NULL,
    UNIT_PRICE      NUMERIC(10, 2) NOT NULL,
    QUANTITY        INTEGER        NOT NULL,
     */

    private int idInvoiceLine;
    private int idInvoice;
    private int idTrack;
    private float unitPrice;
    private int quantity;

}
