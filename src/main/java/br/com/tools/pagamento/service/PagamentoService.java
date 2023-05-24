package br.com.tools.pagamento.service;

import br.com.tools.pagamento.model.Descricao;
import br.com.tools.pagamento.model.FormaPagamento;
import br.com.tools.pagamento.model.Pagamento;
import br.com.tools.pagamento.model.dto.request.PagamentoRequestDTO;
import br.com.tools.pagamento.model.dto.response.DescricaoResponseDTO;
import br.com.tools.pagamento.model.dto.response.FormaPagamentoResponseDTO;
import br.com.tools.pagamento.model.dto.response.PagamentoResponseDTO;
import br.com.tools.pagamento.model.dto.response.TransacaoResponseDTO;
import br.com.tools.pagamento.model.enums.StatusEnum;
import br.com.tools.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public boolean existsPagamentoById(Long id) {
        return pagamentoRepository.existsById(id);
    }

    public PagamentoResponseDTO save(PagamentoRequestDTO pagamentoDTO) {
        Pagamento pagamentoSalvo = pagamentoRepository.save(DTOtoEntity(pagamentoDTO));
        return entityToDTO(pagamentoSalvo);
    }

    public Optional<Pagamento> findById(Long id) {
        return pagamentoRepository.findById(id);
    }

    public Page<Pagamento> findAll(Pageable pageable) {
        return pagamentoRepository.findAll(pageable);
    }

    public boolean existsEstornoById(Long id) {
        return pagamentoRepository.existsEstornoById(id);
    }

    public Optional<Pagamento> findEstornoById(Long id) {
        return pagamentoRepository.findById(id);
    }

    private Pagamento DTOtoEntity(PagamentoRequestDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setCartao(pagamentoDTO.getTransacao().getCartao());
        pagamento.setId(pagamentoDTO.getTransacao().getId());

        Descricao descricao = new Descricao();
        descricao.setNsu(1234567L);
        descricao.setEstabelecimento(pagamentoDTO.getTransacao().getDescricao().getEstabelecimento());
        descricao.setValor(pagamentoDTO.getTransacao().getDescricao().getValor());
        descricao.setDataHora(pagamentoDTO.getTransacao().getDescricao().getDataHora());
        descricao.setCodigoAutorizacao(1234567L);
        descricao.setStatus(StatusEnum.AUTORIZADO);
        pagamento.setDescricao(descricao);

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipo(pagamentoDTO.getTransacao().getFormaPagamento().getTipo());
        formaPagamento.setParcelas(pagamentoDTO.getTransacao().getFormaPagamento().getParcelas());
        pagamento.setFormaPagamento(formaPagamento);
        return pagamento;
    }

    private PagamentoResponseDTO entityToDTO(Pagamento pagamentoSalvo) {
        PagamentoResponseDTO pagamentoResponseDTO = new PagamentoResponseDTO();

        TransacaoResponseDTO transacaoResponseDTO = new TransacaoResponseDTO();
        transacaoResponseDTO.setCartao(pagamentoSalvo.getCartao());
        transacaoResponseDTO.setId(pagamentoSalvo.getId());
        pagamentoResponseDTO.setTransacao(transacaoResponseDTO);

        DescricaoResponseDTO descricaoResponseDTO = new DescricaoResponseDTO();
        descricaoResponseDTO.setStatus(pagamentoSalvo.getDescricao().getStatus());
        descricaoResponseDTO.setValor(pagamentoSalvo.getDescricao().getValor());
        descricaoResponseDTO.setNsu(pagamentoSalvo.getDescricao().getNsu());
        descricaoResponseDTO.setEstabelecimento(pagamentoSalvo.getDescricao().getEstabelecimento());
        descricaoResponseDTO.setCodigoAutorizacao(pagamentoSalvo.getDescricao().getCodigoAutorizacao());
        descricaoResponseDTO.setDataHora(pagamentoSalvo.getDescricao().getDataHora());
        pagamentoResponseDTO.getTransacao().setDescricao(descricaoResponseDTO);

        FormaPagamentoResponseDTO formaPagamentoResponseDTO = new FormaPagamentoResponseDTO();
        formaPagamentoResponseDTO.setParcelas(pagamentoSalvo.getFormaPagamento().getParcelas());
        formaPagamentoResponseDTO.setTipo(pagamentoSalvo.getFormaPagamento().getTipo());
        pagamentoResponseDTO.getTransacao().setFormaPagamento(formaPagamentoResponseDTO);
        return pagamentoResponseDTO;
    }

}
