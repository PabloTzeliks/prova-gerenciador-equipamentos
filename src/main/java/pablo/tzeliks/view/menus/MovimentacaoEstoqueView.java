package pablo.tzeliks.view.menus;

import pablo.tzeliks.dto.EquipamentoDTO;
import pablo.tzeliks.model.domain.Codigo;
import pablo.tzeliks.service.EstoqueService;
import pablo.tzeliks.view.helpers.EquipamentoPrinter;
import pablo.tzeliks.view.helpers.InputHelper;
import pablo.tzeliks.view.helpers.MenuHelper;
import pablo.tzeliks.view.helpers.MessageHelper;

import java.awt.*;
import java.util.Scanner;

public class MovimentacaoEstoqueView {

    public static void executar(Scanner scanner, EstoqueService service) {

        MenuHelper.imprimirMenuMovimentarEstoque();

        int escolhaTipoMovimentacaoEstoque = InputHelper.escolhaMovimentacaoEstoque(scanner);

        String codigoRaw = InputHelper.lerString(scanner, "Informe o código do equipamento (ex: AAA-0001): ");

        Codigo codigo;
        try {
            codigo = new Codigo(codigoRaw);
        } catch (Exception e) {
            MessageHelper.erro("Código inválido: " + e.getMessage());
            return;
        }

        int quantidade;

        while (true) {
            quantidade = InputHelper.lerInteiro(scanner, "Quantidade a movimentar (Valor positivo): ");
            if (quantidade == 0) {
                MessageHelper.erro("A quantidade deve ser diferente de zero.");
            } else {
                break;
            }
        }

        try {
            EquipamentoDTO dto = service.acharPorCodigo(codigo);
            if (dto == null) {
                MessageHelper.erro("Equipamento não encontrado.");
            } else {
                if (escolhaTipoMovimentacaoEstoque == 1) {
                    service.adicionarUnidadesEstoque(codigo, quantidade);
                    MessageHelper.info("Unidades adicionadas ao estoque com sucesso.");
                } else if (escolhaTipoMovimentacaoEstoque == 2) {
                    service.retirarUnidadesEstoque(codigo, quantidade);
                    MessageHelper.info("Unidades removidas do estoque com sucesso.");
                } else {
                    MessageHelper.erro("Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            // Service pode lançar uma exceção com mensagem clara (p.ex. "Equipamento não encontrado").
            MessageHelper.erro("Falha ao Movimentar Estoque do equipamento: " + e.getMessage());
        }
    }
}
