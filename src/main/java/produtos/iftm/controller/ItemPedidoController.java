package produtos.iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import produtos.iftm.models.ItemPedido;
import produtos.iftm.repository.ItemPedidoRepository;
import produtos.iftm.service.ItemPedidoService;

import java.util.List;

@RestController
@RequestMapping("/item-pedidos")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll() {
        return ResponseEntity.ok(itemPedidoRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(itemPedidoRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<ItemPedido> save(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.save(itemPedido);
    }
}
