/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.LivroServicos;
import services.ServicosFactory;
import Model.Livro;
import Model.Editora;
import javafx.beans.property.IntegerProperty;
import services.EditoraServicos;

/**
 *
 * @author 182120001
 */
public class jfLivro extends javax.swing.JFrame {

    /**
     * Creates new form jfLivro
     */
    public jfLivro() {
        initComponents();
        addRowToTable();
        jbDeletar.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    
    public boolean validaInputs() {
        if (jtfTitulo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher Titulo!");
            jtfTitulo.requestFocus();
            return false;
        } else if (jtfISBN.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher ISBN!");
            jtfISBN.requestFocus();
            return false;
        } else if (jtfAssunto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher Assunto!");
            jtfAssunto.requestFocus();
            return false;
        } else if (jtfAutor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher Autor!");
            jtfAutor.requestFocus();
            return false;
        } else if (jtfEditora.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher Editora!");
            jtfEditora.requestFocus();
            return false;
        } else if (jtfEstoque.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher Estoque!");
            jtfEstoque.requestFocus();
            return false;
        } else if (jtfPreco.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher Preço!");
            jtfPreco.requestFocus();
            return false;
        }
        return true;
    }
    
    public void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) jtLivro.getModel();
        model.getDataVector().removeAllElements();//remove todas linhas
        model.fireTableDataChanged();
        Object rowData[] = new Object[4];
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        for (Livro l : livroS.getLivros()) {
            rowData[0] = l.getIsbn();
            rowData[1] = l.getNomeLivro();
            rowData[2] = l.getAssunto();
            rowData[3] = l.getIdEditora().getnomeEditora();
            model.addRow(rowData);
        }
    }
    
    public void somenteNum(java.awt.event.KeyEvent evt) {
        String number = "0123456789";
        if (jtfISBN.getText().length() < 14) {
            if (!number.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfISBN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfAutor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfAssunto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfEstoque = new javax.swing.JTextField();
        jtfPreco = new javax.swing.JTextField();
        jtfEditora = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Kaufmann BT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerência Livro");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("* Titulo:");

        jtfTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTituloKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("* ISBN:");

        jtfISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfISBNKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("* Autor:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("* Assunto:");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("* Estoque:");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("* Preço:");

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("* Editora:");

        jtfEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEstoqueActionPerformed(evt);
            }
        });
        jtfEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEstoqueKeyTyped(evt);
            }
        });

        jtfEditora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEditoraFocusLost(evt);
            }
        });

        jbSalvar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jbSalvar.setForeground(new java.awt.Color(0, 0, 0));
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbDeletar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jbDeletar.setForeground(new java.awt.Color(0, 0, 0));
        jbDeletar.setText("Deletar");
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbFechar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jbFechar.setForeground(new java.awt.Color(0, 0, 0));
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jbLimpar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jbLimpar.setForeground(new java.awt.Color(0, 0, 0));
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbEditar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(0, 0, 0));
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jtLivro.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jtLivro.setForeground(new java.awt.Color(0, 0, 0));
        jtLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Titulo", "Assunto", "Editora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLivro);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jbSalvar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jbEditar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addGap(12, 12, 12)
                                        .addComponent(jtfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbFechar)
                                        .addGap(32, 32, 32)
                                        .addComponent(jbLimpar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jbDeletar)
                                        .addGap(19, 19, 19))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfAssunto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jtfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbEditar)
                    .addComponent(jbFechar)
                    .addComponent(jbLimpar)
                    .addComponent(jbDeletar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        if (validaInputs()) {
            //pega dados da tela para cadastrar
            int idLivro = 0;
            String nomeLivro = jtfTitulo.getText().toUpperCase();
            String isbn = jtfISBN.getText();
            String assunto = jtfAssunto.getText();
            String autor = jtfAutor.getText().toUpperCase();
            int estoque = Integer.parseInt(jtfEstoque.getText());
            float preco = Float.parseFloat(jtfPreco.getText());
            EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
            Editora ed = editoraS.buscarEditorabyCNPJ(jtfEditora.getText());
            LivroServicos livroS = ServicosFactory.getLivroServicos();
            Livro l = new Livro(idLivro, nomeLivro, autor, assunto, isbn, estoque, preco, ed);
            if (jbSalvar.getText().equals("Salvar")) {
                livroS.cadLivro(l);
            } else {
                livroS.atualizarLivro(l);
                jbLimpar.doClick();
            }
            limparCampos();
            addRowToTable();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
        int linha;
        String isbn;
        linha = jtLivro.getSelectedRow();
        isbn = (String) jtLivro.getValueAt(linha, 0);
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        Object[] resp = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this, "Deseja realmente deletar este Livro?", "Deletar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
        if (resposta == 0) {
            livroS.deletarLivro(isbn);
            addRowToTable();
            JOptionPane.showMessageDialog(this, "Livro deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Ok, entendo sua decisão!");
        }
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        if (jbLimpar.getText().equals("Limpar")) {
            limparCampos();
        } else {
            limparCampos();
            jbLimpar.setText("Limpar");
            jbEditar.setEnabled(false);
            jtfISBN.setEnabled(true);
            jbSalvar.setText("Salvar");
        }
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        jbSalvar.setText("Confirmar");
        jtfISBN.setEnabled(false);
        jbLimpar.setText("Cancelar");
        jbDeletar.setVisible(false);
        //pegando dados da tabela e add em variaveis locais
        int linha;
        linha = jtLivro.getSelectedRow();
        String isbn = (String) jtLivro.getValueAt(linha, 0);
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        Livro li = livroS.buscarLivrobyCNPJ(isbn);
        //carregar dados no form
        jtfISBN.setText(li.getIsbn());
        jtfTitulo.setText(li.getNomeLivro());
        jtfAssunto.setText(li.getAssunto());
        jtfEditora.setText(li.getIdEditora().getcnpj());
        jtfAutor.setText(li.getAutor());
        jtfEstoque.setText(String.valueOf(li.getEstoque()));
        jtfPreco.setText(String.valueOf(li.getPreco()));
        jtfTitulo.requestFocus();
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jtfTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTituloKeyTyped
        // TODO add your handling code here:
        String nletras = "0123456789<>:?/~^}][{´`=+-_!|'\'@#$%¨&*()²³£¢¬§º°ª";
        if (nletras.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTituloKeyTyped

    private void jtLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLivroMouseClicked
        // TODO add your handling code here:
        jbEditar.setEnabled(true);
        jbDeletar.setVisible(true);
    }//GEN-LAST:event_jtLivroMouseClicked

    private void jtfEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEstoqueActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtfEstoqueActionPerformed

    private void jtfEstoqueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstoqueKeyTyped
        // TODO add your handling code h
        somenteNum(evt);
    }//GEN-LAST:event_jtfEstoqueKeyTyped

    private void jtfISBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfISBNKeyTyped
        // TODO add your handling code here:
        somenteNum(evt);
    }//GEN-LAST:event_jtfISBNKeyTyped

    private void jtfEditoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEditoraFocusLost
        // TODO add your handling code here:
        EditoraServicos edS = ServicosFactory.getEditoraServicos();
        Editora ed = edS.buscarEditorabyCNPJ(jtfEditora.getText());
        if (ed.getnomeEditora() == null) {
            JOptionPane.showMessageDialog(this, "Editora não cadastrada!",
                    "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Object[] resp = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(this, "Editora " + ed.getnomeEditora() + " está correta?", "Pesquisa", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
            if (resposta == 1) {
                jtfEditora.setText("");
                jtfEditora.requestFocus();
            }
        }
    }//GEN-LAST:event_jtfEditoraFocusLost
    
    private void limparCampos() {
        jtfISBN.setText("");
        jtfAssunto.setText("");
        jtfAutor.setText("");
        jtfEditora.setText("");
        jtfTitulo.setText("");
        jtfPreco.setText("");
        jtfEstoque.setText("");
        jtfTitulo.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTable jtLivro;
    private javax.swing.JTextField jtfAssunto;
    private javax.swing.JTextField jtfAutor;
    private javax.swing.JTextField jtfEditora;
    private javax.swing.JTextField jtfEstoque;
    private javax.swing.JTextField jtfISBN;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}
