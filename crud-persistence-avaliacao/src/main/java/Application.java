import model.Cliente;
import model.Produto;
import repositories.ClienteDAO;
import repositories.ProdutoDAO;

import javax.swing.*;
import java.util.List;


/**
 * @author: Rodrigo Ramos
 * */
public class Application {
    public static void main(String[] args) {

        ClienteDAO cr = new ClienteDAO();
        ProdutoDAO pr = new ProdutoDAO();

        String opcao = "", opcao2 = "";

        String menuPrincipal =
                "1 - Manutencao dos Clientes \n"
                + "2 - Manutencao de Produtos \n"
                + "0 - Sair";

        while (!opcao.equals("0")) {
            opcao = JOptionPane.showInputDialog(menuPrincipal);
            switch (opcao) {
                case "1":
                    String menuCliente =
                            "1 - Adicionar Cliente  \n"
                                    + "2 - Buscar Cliente \n"
                                    + "3 - Atualizar Cliente \n"
                                    + "4 - Deletar Cliente \n"
                                    + "5 - Listar Clientes \n"
                                    + "0 - Sair";

                    while (!opcao2.equals("0")) {

                        opcao2 = JOptionPane.showInputDialog(menuCliente);

                        if (opcao2.equals("1")) {
                            Cliente cliente = new Cliente();
                            cliente.setNome(JOptionPane.showInputDialog("Nome do Cliente: "));
                            cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
                            cr.salvarCliente(cliente);
                            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
                        } else if (opcao2.equals("2")) {
                            String id = JOptionPane.showInputDialog("Insira o ID do Cliente: ");
                            int novoId = Integer.parseInt(id);
                            Cliente c = cr.consultarCliente(novoId);
                            JOptionPane.showMessageDialog(null," ID: " + c.getId()
                                    + " | Cliente: " + c.getNome() +
                                    " | CPF: " + c.getCpf());
                        }else if (opcao2.equals("3")) {
                            Cliente cliente = new Cliente();
                            cliente.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual ID deseja alterar: ")));
                            cliente.setNome(JOptionPane.showInputDialog("Nome do Cliente: "));
                            cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
                            cr.salvarCliente(cliente);
                            JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso!");
                        }else if (opcao2.equals("4")) {
                            String deleteId = JOptionPane.showInputDialog("Insira o ID do Cliente que deseja Deletar: ");
                            int idDelete = Integer.parseInt(deleteId);
                            Cliente clienteDelete = cr.deletarCliente(idDelete);
                            JOptionPane.showMessageDialog(null, "O cliente " + clienteDelete.getNome()
                                    + " foi Deletado.");
                        }else if (opcao2.equals("5")) {
                            List<Cliente> clientes = cr.listarClientes();
                            JOptionPane.showMessageDialog(null, clientes);
                        }
                    }
                    opcao = ""; opcao2 = "";
                    break;
                case "2":
                    String menuProduto =
                            "1 - Adicionar Produto  \n"
                                    + "2 - Buscar Produto \n"
                                    + "3 - Atualizar Produto \n"
                                    + "4 - Deletar Produto \n"
                                    + "5 - Listar Produtos \n"
                                    + "0 - Sair";

                    while (!opcao2.equals("0")) {

                        opcao2 = JOptionPane.showInputDialog(menuProduto);

                        if (opcao2.equals("1")) {
                            Produto produto = new Produto();
                            produto.setDescricao(JOptionPane.showInputDialog("Descricao do Produto: "));
                            produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preco: ")));
                            pr.salvarProduto(produto);
                            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
                        } else if (opcao2.equals("2")) {
                            String id = JOptionPane.showInputDialog("Insira o ID do Produto: ");
                            int novoId = Integer.parseInt(id);
                            Produto p = pr.consultarProduto(novoId);
                            JOptionPane.showMessageDialog(null," ID: " + p.getId()
                                    + " | Produto: " + p.getDescricao() +
                                    " | Preco: " + p.getPreco());
                        }else if (opcao2.equals("3")) {
                            Produto produto = new Produto();
                            produto.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual ID deseja alterar: ")));
                            produto.setDescricao(JOptionPane.showInputDialog("Descricao do Produto: "));
                            produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preço: ")));
                            pr.salvarProduto(produto);
                            JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso!");
                        }else if (opcao2.equals("4")) {
                            String deleteId = JOptionPane.showInputDialog("Insira o ID do Produto que deseja Deletar: ");
                            int idDelete = Integer.parseInt(deleteId);
                            Produto produtoDelete = pr.deletarProduto(idDelete);
                            JOptionPane.showMessageDialog(null, "O produto " + produtoDelete.getDescricao()
                                    + " foi Deletado.");
                        }else if (opcao2.equals("5")) {
                            List<Produto> produtos = pr.listarProdutos();
                            JOptionPane.showMessageDialog(null, produtos);
                        }
                    }
                    opcao = ""; opcao2 = "";
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "O sistema foi finalizado.");

                    break;

                default:
                    break;
            }
        }


    }
}
