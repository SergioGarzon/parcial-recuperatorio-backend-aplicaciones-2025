package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="invoice_line_seq")
    @SequenceGenerator(name = "invoice_line_seq", sequenceName = "SEQ_INVOICE_LINE_ID", allocationSize = 1)
    @Column(name = "INVOICE_LINE_ID")
    private Integer idInvoiceLine;

    @ManyToOne(optional = false)
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice idInvoice;

    @Column(name = "TRACK_ID")
    private Integer idTrack;

    @Column(name = "UNIT_PRICE")
    private Float unitPrice;

    @Column(name = "QUANTITY")
    private Integer quantity;

}
