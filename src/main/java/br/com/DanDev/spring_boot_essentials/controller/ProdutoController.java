package br.com.DanDev.spring_boot_essentials.controller;

import br.com.DanDev.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.DanDev.spring_boot_essentials.dto.ProdutoDto;
import br.com.DanDev.spring_boot_essentials.exception.NotFoundException;
import br.com.DanDev.spring_boot_essentials.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;




    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll(){

        return produtoService.findall();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity creatProduct(@RequestBody ProdutoDto produtoDto){
        return produtoService.creatProduct(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity updateProduct(@PathVariable Integer id,
                                       @RequestBody ProdutoDto produtoDto) throws NotFoundException {
        return produtoService.atualizarProduto(produtoDto, id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteproduct(@PathVariable Integer id){
        produtoService.removerProduto(id);
    }
}
