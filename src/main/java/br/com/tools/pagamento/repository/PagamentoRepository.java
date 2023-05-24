package br.com.tools.pagamento.repository;

import br.com.tools.pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    boolean existsById(Long id);

    @Query(value = "SELECT * FROM tb_pagamento WHERE id = :id AND status = 'CANCELADO'", nativeQuery = true)
    boolean existsEstornoById(Long id);

}
