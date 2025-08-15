package pablo.tzeliks.view.helpers;

import pablo.tzeliks.dto.EquipamentoDTO;
import pablo.tzeliks.model.enums.TipoEquipamento;

import java.util.List;
import java.util.Locale;

public final class EquipamentoPrinter {

    private EquipamentoPrinter() {}

    public static void imprimirLista(List<EquipamentoDTO> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum equipamento encontrado.");
            return;
        }
        System.out.println();
        System.out.println("---- Equipamentos ----");
        for (EquipamentoDTO dto : lista) {
            imprimirEquipamento(dto);
            System.out.println("----------------------");
        }
    }

    public static void imprimirEquipamento(EquipamentoDTO dto) {
        if (dto == null) {
            System.out.println("Equipamento nulo.");
            return;
        }

        String preco = String.format(Locale.ENGLISH, "%.2f", dto.preco());

        System.out.println("ID: " + dto.id());
        System.out.println("Nome: " + safeString(dto.nome()));
        System.out.println("Código: " + safeString(dto.codigo()));
        System.out.println("Tipo: " + (dto.tipoEquipamento() != null ? dto.tipoEquipamento().name() : "N/A"));
        System.out.println("Quantidade: " + dto.quantidade());
        System.out.println("Preço: R$ " + preco);

        TipoEquipamento tipo = dto.tipoEquipamento();
        if (tipo == TipoEquipamento.MOTOR_ELETRICO) {
            System.out.println("Potência (kW): " + String.format(Locale.ENGLISH, "%.2f", dto.potencia()));
        } else if (tipo == TipoEquipamento.PAINEL_CONTROLE) {
            System.out.println("Tensão (V): " + dto.tensao());
        }
    }

    private static String safeString(Object o) {
        return o == null ? "-" : o.toString();
    }
}