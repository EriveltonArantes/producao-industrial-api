package com.producaoindustrialapi.controller;

import com.producaoindustrialapi.model.LinhaProd;
import com.producaoindustrialapi.model.ProdutoIndustrial;
import com.producaoindustrialapi.model.OrdemProducao;
import com.producaoindustrialapi.model.RegistroProducao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.producaoindustrialapi.repository.LinhaProdRepository linhaProdRepository;

    @Autowired
    private com.producaoindustrialapi.repository.ProdutoIndustrialRepository produtoIndustrialRepository;

    @Autowired
    private com.producaoindustrialapi.repository.OrdemProducaoRepository ordemProducaoRepository;

    @Autowired
    private com.producaoindustrialapi.repository.RegistroProducaoRepository registroProducaoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalLinhaProd", linhaProdRepository.count());
        resumo.put("somaCapacidadeDiariaLinhaProd", linhaProdRepository.findAll().stream().filter(e -> e.getCapacidadeDiaria() != null).mapToInt(e -> e.getCapacidadeDiaria()).sum());
        resumo.put("graficoLinhaProd", linhaProdRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalProdutoIndustrial", produtoIndustrialRepository.count());
        resumo.put("somaTempoProducaoMinProdutoIndustrial", produtoIndustrialRepository.findAll().stream().filter(e -> e.getTempoProducaoMin() != null).mapToInt(e -> e.getTempoProducaoMin()).sum());
        resumo.put("graficoProdutoIndustrial", produtoIndustrialRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalOrdemProducao", ordemProducaoRepository.count());
        resumo.put("somaQuantidadeOrdemProducao", ordemProducaoRepository.findAll().stream().filter(e -> e.getQuantidade() != null).mapToLong(e -> e.getQuantidade()).sum());
        resumo.put("graficoOrdemProducao", ordemProducaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalRegistroProducao", registroProducaoRepository.count());
        resumo.put("somaQuantidadeProduzidaRegistroProducao", registroProducaoRepository.findAll().stream().filter(e -> e.getQuantidadeProduzida() != null).mapToInt(e -> e.getQuantidadeProduzida()).sum());
        return resumo;
    }
}
