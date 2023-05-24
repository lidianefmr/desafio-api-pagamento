package br.com.tools.pagamento.service;

import br.com.tools.pagamento.model.Pagamento;
import br.com.tools.pagamento.repository.PagamentoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class PagamentoServiceTest {
    @Mock
    PagamentoRepository pagamentoRepository;

    @InjectMocks
    PagamentoService pagamentoService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExistsPagamentoById() throws Exception {
        when(pagamentoRepository.existsById(anyLong())).thenReturn(true);

        boolean result = pagamentoService.existsPagamentoById(Long.valueOf(1));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFindById() throws Exception {
        Optional<Pagamento> result = pagamentoService.findById(Long.valueOf(1));
        Assert.assertEquals(Optional.empty(), result);
    }

    @Test
    public void testFindAll() throws Exception {
        Page<Pagamento> result = pagamentoService.findAll(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testExistsEstornoById() throws Exception {
        when(pagamentoRepository.existsEstornoById(anyLong())).thenReturn(true);

        boolean result = pagamentoService.existsEstornoById(Long.valueOf(1));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFindEstornoById() throws Exception {
        Optional<Pagamento> result = pagamentoService.findEstornoById(Long.valueOf(1));
        Assert.assertEquals(Optional.empty(), result);
    }

}