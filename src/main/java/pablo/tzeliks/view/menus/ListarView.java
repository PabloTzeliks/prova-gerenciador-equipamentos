package pablo.tzeliks.view.menus;

import pablo.tzeliks.dto.EquipamentoDTO;
import pablo.tzeliks.model.enums.TipoEquipamento;
import pablo.tzeliks.service.EstoqueService;
import pablo.tzeliks.view.InputHelper;
import pablo.tzeliks.view.MenuHelper;
import pablo.tzeliks.view.MessageHelper;

import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class ListarView {

    public static void executar(Scanner scanner, EstoqueService service) {
        while (true) {

            MenuHelper.imprimirMenuListagem();

            int opcao = InputHelper.lerInteiro(scanner, "Escolha uma opção: ");

            switch (opcao) {
                case 0:
                    return;
                case 1:
                    listarTodos(service);
                    break;
                case 2:
                    listarPorTipo(scanner, service);
                    break;
                default:
                    MessageHelper.erro("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void listarTodos(EstoqueService service) {
        try {
            List<EquipamentoDTO> lista = service.listarTodos();
            imprimirLista(lista);
        } catch (Exception e) {
            MessageHelper.erro("Não foi possível listar equipamentos: " + e.getMessage());
        }
    }

    public static void listarPorTipo(Scanner scanner, EstoqueService service) {
        TipoEquipamento tipo = InputHelper.escolherEnum(scanner, "Escolha o tipo do equipamento:");
        if (tipo == null) {
            MessageHelper.info("O tipo do equipamento deve ser informado.");
            return;
        }

        try {
            List<EquipamentoDTO> lista = service.listarPorTipo(tipo);
            imprimirLista(lista);
        } catch (Exception e) {
            MessageHelper.erro("Não foi possível listar equipamentos por tipo: " + e.getMessage());
        }
    }

    private static void imprimirLista(List<EquipamentoDTO> lista) {
        if (lista == null || lista.isEmpty()) {
            MessageHelper.info("Nenhum equipamento encontrado.");
            return;
        }

        System.out.println();
        System.out.println("---- Equipamentos ----");
        // Exibição detalhada
        for (EquipamentoDTO dto : lista) {
            imprimirEquipamento(dto);
            System.out.println("----------------------");
        }
    }

    private static void imprimirEquipamento(EquipamentoDTO dto) {
        if (dto == null) return;

        // Formatar preço com 2 casas
        String preco = String.format(Locale.ENGLISH, "%.2f", dto.preco());

        System.out.println("ID: " + dto.id());
        System.out.println("Nome: " + safeString(dto.nome()));
        System.out.println("Código: " + safeString(dto.codigo()));
        System.out.println("Tipo: " + (dto.tipoEquipamento() != null ? dto.tipoEquipamento().name() : "N/A"));
        System.out.println("Quantidade: " + dto.quantidade());
        System.out.println("Preço: R$ " + preco);

        // Exibir atributos específicos conforme o tipo
        TipoEquipamento tipo = dto.tipoEquipamento();
        if (tipo == TipoEquipamento.MOTOR_ELETRICO) {

            System.out.println("Potência (kW): " + String.format(Locale.ENGLISH, "%.2f", dto.potencia()));
        } else if (tipo == TipoEquipamento.PAINEL_CONTROLE) {
            System.out.println("Tensão (V): " + String.format(Locale.ENGLISH, "%.0f", dto.tensao()));
        }
    }

    private static String safeString(Object o) {
        return o == null ? "-" : o.toString();
    }
}