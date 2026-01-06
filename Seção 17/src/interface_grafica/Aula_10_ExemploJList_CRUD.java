package interface_grafica;

import javax.swing.*;
import javax.swing.event.DocumentEvent;      // Evento disparado quando o texto muda
import javax.swing.event.DocumentListener;   // Listener para mudanças no texto
import java.awt.*;
import java.awt.event.*;                     // Eventos de teclado e mouse
import java.util.ArrayList;
import java.util.List;

/*
 * Demonstra o uso de JList com operações de CRUD
 * (Create, Read, Update, Delete) e filtro de pesquisa
 */
public class Aula_10_ExemploJList_CRUD {

    /* Classe interna que representa um item da lista */
    static class Item {

        final int id;      // Identificador único
        String nome;       // Nome exibido na lista

        Item(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        // Define como o item será exibido no JList
        @Override
        public String toString() {
            return nome;
        }
    }

    // Lista principal de dados (fonte original)
    private final List<Item> dados = new ArrayList<>();

    // Controle de IDs automáticos
    private int proximoId = 1;

    // Componentes principais da interface
    private JFrame janela;
    private JList<Item> lista;
    private DefaultListModel<Item> modeloFiltrado;
    private JTextField campoNome;
    private JTextField campoPesquisa;
    private JLabel rotuloContagem;

    public static void main(String[] args) {

        // Garante que a interface gráfica rode na EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() ->
                new Aula_10_ExemploJList_CRUD().iniciar()
        );
    }

    /* Método responsável por montar toda a interface */
    private void iniciar() {

        janela = new JFrame("JList - CRUD + Pesquisa (Exemplo didático)");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 500);
        janela.setLocationRelativeTo(null);
        janela.setLayout(new BorderLayout(10, 10));

        // Itens iniciais da lista
        adicionarItemInicial("Maçã");
        adicionarItemInicial("Banana");
        adicionarItemInicial("Laranja");
        adicionarItemInicial("Uva");
        adicionarItemInicial("Pera");

        // Painel superior (pesquisa + contagem)
        JPanel painelTopo = new JPanel(new BorderLayout(8, 8));

        JPanel painelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        painelPesquisa.add(new JLabel("Pesquisar"));

        campoPesquisa = new JTextField(25);
        JButton botaoLimparPesquisa = new JButton("Limpar");

        painelPesquisa.add(campoPesquisa);
        painelPesquisa.add(botaoLimparPesquisa);

        rotuloContagem = new JLabel("Itens: 0");

        JPanel painelDireitaTopo = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        painelDireitaTopo.add(rotuloContagem);

        painelTopo.add(painelPesquisa, BorderLayout.WEST);
        painelTopo.add(painelDireitaTopo, BorderLayout.EAST);

        janela.add(painelTopo, BorderLayout.NORTH);

        // Modelo usado pelo JList (permite atualizar dinamicamente)
        modeloFiltrado = new DefaultListModel<>();
        lista = new JList<>(modeloFiltrado);

        // Configurações da lista
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setVisibleRowCount(12);
        lista.setFixedCellHeight(24);

        // Duplo clique carrega o item no campo de edição
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Item sel = lista.getSelectedValue();
                    if (sel != null) campoNome.setText(sel.nome);
                }
            }
        });

        // Tecla DELETE remove o item selecionado
        lista.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    excluirSelecionado();
                }
            }
        });

        janela.add(new JScrollPane(lista), BorderLayout.CENTER);

        // Painel inferior (cadastro)
        JPanel painelRodape = new JPanel(new GridLayout());
        painelRodape.setBorder(BorderFactory.createTitledBorder("Cadastro simples"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo nome
        gbc.gridx = 0; gbc.gridy = 0;
        painelRodape.add(new JLabel("Nome:"), gbc);

        campoNome = new JTextField(30);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        painelRodape.add(campoNome, gbc);

        // Botões CRUD
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        JButton btAdicionar = new JButton("Adicionar");
        JButton btAlterar = new JButton("Alterar");
        JButton btExcluir = new JButton("Excluir");
        JButton btLimpar = new JButton("Limpar");

        painelBotoes.add(btAdicionar);
        painelBotoes.add(btAlterar);
        painelBotoes.add(btExcluir);
        painelBotoes.add(btLimpar);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        painelRodape.add(painelBotoes, gbc);

        janela.add(painelRodape, BorderLayout.SOUTH);

        // Atualiza a lista conforme o texto digitado
        campoPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { aplicarFiltro(); }
            public void removeUpdate(DocumentEvent e) { aplicarFiltro(); }
            public void changedUpdate(DocumentEvent e) { aplicarFiltro(); }
        });

        // Limpa o campo de pesquisa
        botaoLimparPesquisa.addActionListener(e -> {
            campoPesquisa.setText("");
            aplicarFiltro();
        });

        // Ações dos botões
        btAdicionar.addActionListener(e -> adicionar());
        btAlterar.addActionListener(e -> alterarSelecionado());
        btExcluir.addActionListener(e -> excluirSelecionado());
        btLimpar.addActionListener(e -> campoNome.setText(""));

        aplicarFiltro();
        janela.setVisible(true);
    }

    // Adiciona itens iniciais
    public void adicionarItemInicial(String nome) {
        dados.add(new Item(proximoId++, nome));
    }

    // Aplica o filtro de pesquisa
    private void aplicarFiltro() {
        String termo = campoPesquisa.getText().trim().toLowerCase();
        modeloFiltrado.clear();

        for (Item it : dados) {
            if (termo.isEmpty() || it.nome.toLowerCase().contains(termo)) {
                modeloFiltrado.addElement(it);
            }
        }
        atualizarContagem();
    }

    // Atualiza o rótulo de contagem
    private void atualizarContagem() {
        rotuloContagem.setText(
            "Itens exibidos: " + modeloFiltrado.getSize() + " | Total: " + dados.size()
        );
    }

    // Altera o item selecionado
    private void alterarSelecionado() {
        Item sel = lista.getSelectedValue();

        if (sel == null) {
            JOptionPane.showMessageDialog(janela, "Selecione um item para alterar.");
            return;
        }

        String novoNome = campoNome.getText().trim();
        if (novoNome.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Digite o novo nome.");
            return;
        }

        sel.nome = novoNome;
        aplicarFiltro();
        JOptionPane.showMessageDialog(janela, "Item alterado com sucesso!");
    }

    // Exclui o item selecionado
    private void excluirSelecionado() {
        Item sel = lista.getSelectedValue();

        if (sel == null) {
            JOptionPane.showMessageDialog(janela, "Selecione um item para excluir.");
            return;
        }

        int op = JOptionPane.showConfirmDialog(
            janela,
            "Excluir \"" + sel.nome + "\"?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            dados.removeIf(i -> i.id == sel.id);
            aplicarFiltro();
            JOptionPane.showMessageDialog(janela, "Item excluído!");
        }
    }

    // Método auxiliar para adicionar itens via botão
    private void adicionar() {
        String nome = campoNome.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Digite um nome para adicionar");
            return;
        }

        dados.add(new Item(proximoId++, nome));
        campoNome.setText("");
        aplicarFiltro();
        JOptionPane.showMessageDialog(janela, "Item adicionado com sucesso!");
    }
}
