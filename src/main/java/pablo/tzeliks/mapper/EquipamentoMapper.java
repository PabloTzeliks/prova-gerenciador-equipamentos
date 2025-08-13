package pablo.tzeliks.mapper;

import pablo.tzeliks.dto.EquipamentoDTO;
import pablo.tzeliks.model.Equipamento;
import pablo.tzeliks.model.MotorEletrico;
import pablo.tzeliks.service.EquipamentoFactory;

public class EquipamentoMapper {
    public static Equipamento toEntity(EquipamentoDTO dto) {

        Equipamento entity = EquipamentoFactory.createFromDTO(dto);

        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity.setCodigo(dto.codigo());
        entity.setQuantidade(dto.quantidade());
        entity.setPreco(dto.preco());
        entity.setTipoEquipamento(dto.tipoEquipamento());

        return entity;
    }

    public static EquipamentoDTO toDTO(Equipamento entity) {

        return new EquipamentoDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCodigo(),
                entity.getQuantidade(),
                entity.getPreco(),
                entity.getTipoEquipamento()
        );
    }

    public static MotorEletrico toEntity(MotorEletricoDTO dto) {

        MotorEletrico entity = (MotorEletrico) EquipamentoFactory.createFromDTO(dto);

        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity.setCodigo(dto.codigo());
        entity.setQuantidade(dto.quantidade());
        entity.setPreco(dto.preco());
        entity.setTipoEquipamento(dto.tipoEquipamento());

        entity.setPotencia(dto.potencia());

        return entity;
    }
}
