package br.com.tools.pagamento.controller;

import br.com.tools.pagamento.model.Pagamento;
import br.com.tools.pagamento.model.dto.request.PagamentoRequestDTO;
import br.com.tools.pagamento.service.PagamentoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @ApiOperation(value = "Solicitação de pagamento")
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PagamentoRequestDTO pagamentoDTO) {
        if (pagamentoService.existsPagamentoById(pagamentoDTO.getTransacao().getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um pagamento com esse ID");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.save(pagamentoDTO));
    }

    @ApiOperation(value = "Consulta pagamento por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.findById(id));
    }

    @ApiOperation(value = "Consulta todos os pagamentos")
    @GetMapping
    public ResponseEntity<Page<Pagamento>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.findAll(pageable));
    }

    @ApiOperation(value = "Consulta estorno por ID")
    @GetMapping("/{id}/estorno")
    public ResponseEntity<Object> findEstornoById(@PathVariable Long id) {
        if (pagamentoService.existsEstornoById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado estorno com esse ID");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.findEstornoById(id));
    }

}
