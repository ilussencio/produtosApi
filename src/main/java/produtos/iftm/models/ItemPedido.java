package produtos.iftm.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedido {
    @Id
    @Column(name = "COD_ITEM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "QTD_ITEM")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "COD_PEDIDO")
    private Produto produto;
}
