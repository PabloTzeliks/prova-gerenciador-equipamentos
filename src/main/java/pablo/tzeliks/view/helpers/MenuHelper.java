package pablo.tzeliks.view.helpers;

public class MenuHelper {

    public static void imprimirMenuPrincipal() {
        System.out.println("===============================");
        System.out.println("  Sistema de Controle WEG 2.0  ");
        System.out.println("===============================");
        System.out.println("1 - Cadastrar Equipamento");
        System.out.println("2 - Listar Equipamentos");
        System.out.println("3 - Pesquisar Equipamento por Código");
        System.out.println("4 - Remover Equipamento por Código");
        System.out.println("5 - Movimentar Estoque (Adicionar/Retirar Quantidade)");
        System.out.println("6 - Relatórios de Estoque");
        System.out.println("7 - Busca Avançada por Nome");
        System.out.println("8 - Busca Avançada por Preço");
        System.out.println("0 - Sair");
        System.out.println();
    }

    public static void imprimirMenuCadastro() {
        System.out.println("===============================");
        System.out.println("    CADASTRO DE EQUIPAMENTO    ");
        System.out.println("===============================");
        System.out.println();
    }

    public static void imprimirMenuListagem() {
        System.out.println("===============================");
        System.out.println("    LISTAGEM DE EQUIPAMENTO    ");
        System.out.println("===============================");
        System.out.println("1 - Listar todos os equipamentos");
        System.out.println("2 - Listar equipamentos por tipo");
        System.out.println("0 - Voltar");
        System.out.println();
    }

    public static void imprimirMenuPesquisar() {
        System.out.println("===============================");
        System.out.println("    PESQUISA DE EQUIPAMENTO    ");
        System.out.println("===============================");
        System.out.println();
    }
}