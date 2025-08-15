package pablo.tzeliks.service.contracts;

import pablo.tzeliks.exceptions.MovimentacaoEstoqueException;
import pablo.tzeliks.model.domain.Codigo;

public interface MovimentacaoEstoqueInterface {

    void adicionarUnidadesEstoque(Codigo codigo, int quantidade) throws MovimentacaoEstoqueException;
    void retirarUnidadesEstoque(Codigo codigo, int quantidade) throws MovimentacaoEstoqueException;

}