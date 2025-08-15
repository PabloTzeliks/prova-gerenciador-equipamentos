package pablo.tzeliks.mapper;

import org.mapstruct.Mapper;
import pablo.tzeliks.model.MotorEletrico;
import pablo.tzeliks.model.PainelControle;
import pablo.tzeliks.view.EquipamentoDTO;

@Mapper
public interface EquipamentoMapper {

    MotorEletrico toMotorEletrico(EquipamentoDTO dto);
    EquipamentoDTO toDTO(MotorEletrico entity);

    PainelControle toPainelControle(EquipamentoDTO dto);
    EquipamentoDTO toDTO(PainelControle entity);
}