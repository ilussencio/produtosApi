package produtos.iftm.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import produtos.iftm.models.ItemPedido;
import produtos.iftm.models.Produto;
import produtos.iftm.repository.ItemPedidoRepository;
import produtos.iftm.repository.ProdutoRepository;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ResponseEntity<ItemPedido> save(ItemPedido itemPedido) {
        var produto = produtoRepository.findById(itemPedido.getProduto().getId());
        if(produto.isEmpty())
            return ResponseEntity.badRequest().build();

        if(produto.get().getQuantidade() < itemPedido.getQuantidade())
            return ResponseEntity.badRequest().build();

        produto.get().setQuantidade(produto.get().getQuantidade() - itemPedido.getQuantidade());
        produtoRepository.save(produto.get());

        itemPedido.setProduto(produto.get());
        return ResponseEntity.ok(itemPedidoRepository.save(itemPedido));
    }
}
