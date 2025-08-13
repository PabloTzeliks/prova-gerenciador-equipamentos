package pablo.tzeliks.dto;

import pablo.tzeliks.model.domain.Codigo;
import pablo.tzeliks.model.enums.TipoEquipamento;

public record EquipamentoDTO(
        int id,
        String nome,
        Codigo codigo,
        int quantidade,
        double preco,
        TipoEquipamento tipoEquipamento,
        double potencia,
        double tensao
) {

    public EquipamentoDTO(int id, String nome, Codigo codigo, int quantidade, double preco, TipoEquipamento tipoEquipamento, double potencia) {
        this(id, nome, codigo, quantidade, preco, tipoEquipamento, potencia, -1);
    }

    public EquipamentoDTO(int id, double tensao, Codigo codigo, int quantidade, double preco, TipoEquipamento tipoEquipamento, String nome) {
        this(id, nome, codigo, quantidade, preco, tipoEquipamento, -1, tensao);
    }
}
