package pablo.tzeliks.view;

import pablo.tzeliks.model.enums.TipoEquipamento;

import java.util.Scanner;

public class InputHelper {

    public static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                MessageHelper.erro("Valor inválido, tente novamente.");
            }
        }
    }

    public static double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                MessageHelper.erro("Valor inválido, tente novamente.");
            }
        }
    }

    public static String lerString(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    public static TipoEquipamento escolherEnum(Scanner scanner,  String mensagem) {
        while (true) {

            System.out.println(mensagem);
            System.out.println();

            System.out.println("Tipos de Equipamento:\n" +
                    "\n1- Motor Elétrico" +
                    "\n2- Painel Controle\n");

            String input = scanner.nextLine();

            try {
                if (input.equals("1")) {
                    TipoEquipamento tipo = TipoEquipamento.MOTOR_ELETRICO;

                    return tipo;
                } else if (input.equals("2")) {
                    TipoEquipamento tipo = TipoEquipamento.PAINEL_CONTROLE;

                    return tipo;
                } else {
                    return null;
                }
            } catch (NumberFormatException e) {
                MessageHelper.erro("Valor inválido, tente novamente.");
            }
        }
    }
}