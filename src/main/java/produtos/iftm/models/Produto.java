package produtos.iftm.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name  = "TB_PRODUTO")
public class Produto {
    @Id
    @Column(name = "COD_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DES_PRODUTO")
    private String descricao;

    @Column(name = "VLR_PRODUTO")
    private float valor;

    @Column(name = "QTD_ESTOQUE")
    private Integer quantidade;

    @Column(name = "COD_VRS")
    private Integer version;
}
