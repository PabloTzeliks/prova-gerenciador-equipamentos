package pablo.tzeliks.service;

import pablo.tzeliks.model.Equipamento;
import pablo.tzeliks.model.PainelControle;
import pablo.tzeliks.dto.EquipamentoDTO;
import pablo.tzeliks.model.enums.TipoEquipamento;

public class EquipamentoFactory {

    public static Equipamento instanceOf(TipoEquipamento tipoEquipamento) {

        try {

            switch (tipoEquipamento) {

                case MOTOR_ELETRICO -> {

                }

                case PAINEL_CONTROLE -> {

                }

                default -> {

                }

            }

        } catch (Exception e) {
            System.out.println("Erro! Houve um erro ao Criar o Equipamento. Observe: " + e.getMessage());
        }

        return null;
    }
}
