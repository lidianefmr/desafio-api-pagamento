package br.com.tools.pagamento.controller;

import br.com.tools.pagamento.model.Pagamento;
import br.com.tools.pagamento.model.dto.request.DescricaoRequestDTO;
import br.com.tools.pagamento.model.dto.request.FormaPagamentoRequestDTO;
import br.com.tools.pagamento.model.dto.request.PagamentoRequestDTO;
import br.com.tools.pagamento.model.dto.request.TransacaoRequestDTO;
import br.com.tools.pagamento.model.dto.response.PagamentoResponseDTO;
import br.com.tools.pagamento.model.enums.TipoPagamentoEnum;
import br.com.tools.pagamento.service.PagamentoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

public class PagamentoControllerTest {
    @Mock
    PagamentoService pagamentoService;
    @InjectMocks
    PagamentoController pagamentoController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveWithConflict() throws Exception {
        when(pagamentoService.existsPagamentoById(anyLong())).thenReturn(true);
        when(pagamentoService.save(any())).thenReturn(new PagamentoResponseDTO(null));

        ResponseEntity<Object> result = pagamentoController.save(new PagamentoRequestDTO(new TransacaoRequestDTO("cartao", Long.valueOf(1), new DescricaoRequestDTO(Double.valueOf(0), new GregorianCalendar(2023, Calendar.MAY, 24, 9, 14).getTime(), "estabelecimento"), new FormaPagamentoRequestDTO(TipoPagamentoEnum.AVISTA, Integer.valueOf(0)))));
        Assert.assertEquals(HttpStatus.CONFLICT, result.getStatusCode());
    }

    @Test
    public void testSaveWithSucess() throws Exception {
        when(pagamentoService.existsPagamentoById(anyLong())).thenReturn(false);
        when(pagamentoService.save(any())).thenReturn(new PagamentoResponseDTO(null));

        ResponseEntity<Object> result = pagamentoController.save(new PagamentoRequestDTO(new TransacaoRequestDTO("cartao", Long.valueOf(1), new DescricaoRequestDTO(Double.valueOf(0), new GregorianCalendar(2023, Calendar.MAY, 24, 9, 14).getTime(), "estabelecimento"), new FormaPagamentoRequestDTO(TipoPagamentoEnum.AVISTA, Integer.valueOf(0)))));
        Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    public void testFindById() throws Exception {
        when(pagamentoService.findById(anyLong())).thenReturn(null);

        ResponseEntity<Object> result = pagamentoController.findById(Long.valueOf(1));
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testFindAll() throws Exception {
        when(pagamentoService.findAll(any())).thenReturn(null);

        ResponseEntity<Page<Pagamento>> result = pagamentoController.findAll(null);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testFindEstornoById() throws Exception {
        when(pagamentoService.existsEstornoById(anyLong())).thenReturn(true);
        when(pagamentoService.findEstornoById(anyLong())).thenReturn(null);

        ResponseEntity<Object> result = pagamentoController.findEstornoById(Long.valueOf(1));
        Assert.assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

}