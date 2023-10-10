package produtos.iftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import produtos.iftm.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
