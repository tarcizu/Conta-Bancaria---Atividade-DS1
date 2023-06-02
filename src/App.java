import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entidades.ContaEspecial;
import Entidades.ContaPoupanca;

public class App {
    private static List<ContaPoupanca> contasPoupancas = new ArrayList<>();
    private static List<ContaEspecial> contasEspeciais = new ArrayList<>();
    private static int idAtual = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            limparTela();
            System.out.println("\t\t\t\tJavaBank\n");
            System.out.print(
                    "\t\t\t\t  MENU\n\n\t1 - Cadastrar Conta\n\t2 - Listar Contas\n\n\tDigite a opção desejada: ");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    listarContas();
                    break;

                default:
                    System.out.println("\n\tOpção Invalida!");
                    sc.nextLine();
                    sc.nextLine();

                    continue;
            }

        }

        // sc.close();
    }

    public static void criarConta() {
        while (true) {

            limparTela();
            System.out.println("\t\t\t\tJavaBank\n");
            System.out.print(
                    "\t\t\t      CADASTRAR CONTA\n\n\t1 - Conta Poupança\n\t2 - Conta Especial\n\n\tDigite a opção desejada: ");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("\n\tDigite o nome do titular da conta: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.print("\n\tDigite o saldo inicial da conta: ");
                    double saldo = sc.nextDouble();
                    contasPoupancas.add(new ContaPoupanca(nome, ++idAtual, saldo));
                    gerenciarConta(1, contasPoupancas.size() - 1);

                    break;
                case 2:
                    System.out.print("\n\tDigite o nome do titular da conta: ");
                    sc.nextLine();
                    nome = sc.nextLine();
                    System.out.print("\n\tDigite o saldo inicial da conta: ");
                    saldo = sc.nextDouble();
                    System.out.print("\n\tDigite o limite inicial da conta: ");
                    double limite = sc.nextDouble();
                    contasEspeciais.add(new ContaEspecial(nome, ++idAtual, saldo, limite));
                    gerenciarConta(2, contasEspeciais.size() - 1);
                    break;

                default:
                    break;
            }
            break;

        }

    }

    public static void listarContas() {
        while (true) {

            limparTela();
            System.out.println("\t\t\t\tJavaBank\n");
            System.out.print(
                    "\t\t\t      LISTA CONTAS\n\n\t1 - Conta Poupança\n\t2 - Conta Especial\n\n\tDigite a opção desejada: ");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    int indexLista = 0;
                    if (contasPoupancas.size() == 0) {
                        System.out.println("Não existe Contas Poupança cadastradas!");
                        sc.nextLine();
                        sc.nextLine();
                        break;

                    }
                    for (ContaPoupanca conta : contasPoupancas) {
                        System.out.printf("Opção: %d\nConta: %d | Titular: %s | Saldo: R$%.2f\n",
                                ++indexLista,
                                conta.getNum_conta(),
                                conta.getNome(),
                                conta.getSaldo());

                    }
                    System.out.print("Selecione a opção desejada: ");
                    int contaEscolhida = sc.nextInt();
                    gerenciarConta(1, contaEscolhida - 1);

                    break;
                case 2:
                    indexLista = 0;
                    if (contasEspeciais.size() == 0) {
                        System.out.println("Não existe Contas Especiais cadastradas!");
                        sc.nextLine();
                        sc.nextLine();
                        break;

                    }
                    for (ContaEspecial conta : contasEspeciais) {
                        System.out.printf("Opção: %d\nConta: %d | Titular: %s | Saldo: R$%.2f | Limite: R$%.2f\n",
                                ++indexLista,
                                conta.getNum_conta(),
                                conta.getNome(),
                                conta.getSaldo(),
                                conta.getLimite());

                    }
                    System.out.print("Selecione a opção desejada: ");
                    contaEscolhida = sc.nextInt();
                    gerenciarConta(2, contaEscolhida - 1);

                    break;
            }
            break;
        }

    }

    public static void gerenciarConta(int tipo, int numero) {

        if (tipo == 1) {
            if (numero < contasPoupancas.size()) {
                while (true) {
                    limparTela();
                    System.out.println("\t\t\t\tJavaBank\n");
                    System.out.print("\t\t\t      CONTA POUPANÇA");
                    System.out.printf(
                            "\n\t\t\tNumero: %d\n\t\t\tTitular: %s\n\t\t\tSaldo: R$%.2f\n\n",
                            contasPoupancas.get(numero).getNum_conta(), contasPoupancas.get(numero).getNome(),
                            contasPoupancas.get(numero).getSaldo());
                    System.out.print(
                            "\t\t\t\t  MENU\n\n\t\t1 - Sacar\n\t\t2 - Depositar\n\t\t3 - Encerrar Conta\n\t\t4 - Voltar\n\n\t\tDigite a opção desejada: ");

                    int escolha = sc.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.print("\n\t\t\t\tSACAR");
                            System.out.print("\n\t\tValor: ");
                            double valor = sc.nextDouble();
                            contasPoupancas.get(numero).sacar(valor);
                            sc.nextLine();
                            sc.nextLine();
                            continue;
                        case 2:
                            System.out.print("\n\t\t\t\tDEPOSITAR");
                            System.out.print("\n\t\tValor: ");
                            valor = sc.nextDouble();
                            contasPoupancas.get(numero).depositar(valor);
                            sc.nextLine();
                            sc.nextLine();
                            continue;
                        case 3:
                            if (contasPoupancas.get(numero).deletar() == 1) {
                                contasPoupancas.remove(numero);
                                sc.nextLine();
                                sc.nextLine();
                                break;
                            } else {
                                sc.nextLine();
                                sc.nextLine();
                                continue;
                            }
                        case 4:
                            break;
                        default:
                            System.out.println("\n\tOpção Invalida!");
                            sc.nextLine();
                            sc.nextLine();
                            continue;
                    }
                    break;
                }
            } else {
                System.out.println("A conta selecionada não existe");
                sc.nextLine();
                sc.nextLine();

            }
        }
        if (tipo == 2) {
            if (numero < contasEspeciais.size()) {
                while (true) {
                    limparTela();
                    System.out.println("\t\t\t\tJavaBank\n");
                    System.out.print("\t\t\t      CONTA ESPECIAL");
                    System.out.printf(
                            "\n\t\t\tNumero: %d\n\t\t\tTitular: %s\n\t\t\tSaldo: R$%.2f\n\t\t\tLimite: R$%.2f\n\n",
                            contasEspeciais.get(numero).getNum_conta(), contasEspeciais.get(numero).getNome(),
                            contasEspeciais.get(numero).getSaldo(),
                            contasEspeciais.get(numero).getLimite());
                    System.out.print(
                            "\t\t\t\t  MENU\n\n\t\t1 - Sacar\n\t\t2 - Depositar\n\t\t3 - Encerrar Conta\n\t\t4 - Voltar\n\n\t\tDigite a opção desejada: ");

                    int escolha = sc.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.print("\n\t\t\t\tSACAR");
                            System.out.print("\n\t\tValor: ");
                            double valor = sc.nextDouble();
                            contasEspeciais.get(numero).sacar(valor);
                            sc.nextLine();
                            sc.nextLine();
                            continue;
                        case 2:
                            System.out.print("\n\t\t\t\tDEPOSITAR");
                            System.out.print("\n\t\tValor: ");
                            valor = sc.nextDouble();
                            contasEspeciais.get(numero).depositar(valor);
                            sc.nextLine();
                            sc.nextLine();
                            continue;
                        case 3:
                            if (contasEspeciais.get(numero).deletar() == 1) {
                                contasEspeciais.remove(numero);
                                sc.nextLine();
                                sc.nextLine();
                                break;
                            } else {
                                sc.nextLine();
                                sc.nextLine();
                                continue;
                            }
                        case 4:
                            break;
                        default:
                            System.out.println("\n\tOpção Invalida!");
                            sc.nextLine();
                            sc.nextLine();
                            continue;
                    }
                    break;
                }
            } else {
                System.out.println("A conta selecionada não existe");
                sc.nextLine();
                sc.nextLine();

            }
        }

    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
    }

}
