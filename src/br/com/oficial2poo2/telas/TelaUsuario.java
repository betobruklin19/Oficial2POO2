
package br.com.oficial2poo2.telas;

import java.sql.*;
import br.com.oficial2poo2.dal.ModuloConexao;
import javax.swing.JOptionPane;
public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void consultar (){
        String sql = "select * from usuarios where id_usuario=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtUsuarioId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtUsuarioNome.setText(rs.getString(2));
                txtUsuarioTelefone.setText(rs.getString(3));
                txtUsuarioLogin.setText(rs.getString(4));
                txtUsuarioSenha.setText(rs.getString(5));
                //combo box perfil
                comboUsuarioPerfil.setSelectedItem(rs.getString(6));
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                //limpar os campos de usuári, caso não tenha usuário cadastrado no banco
                txtUsuarioNome.setText(null);
                txtUsuarioTelefone.setText(null);
                txtUsuarioLogin.setText(null);
                txtUsuarioSenha.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //método de adicionar novo usuário
    private void adicionar(){
        String sql = "insert into usuarios(id_usuario, usuario, telefone, login, senha, perfil) values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuarioId.getText());
            pst.setString(2, txtUsuarioNome.getText());
            pst.setString(3, txtUsuarioTelefone.getText());
            pst.setString(4, txtUsuarioLogin.getText());
            pst.setString(5, txtUsuarioSenha.getText());
            pst.setString(6, comboUsuarioPerfil.getSelectedItem().toString());
            
            //validação dos campos obrigatórios
            if ((txtUsuarioId.getText().isEmpty()) || (txtUsuarioNome.getText().isEmpty()) || (txtUsuarioLogin.getText().isEmpty()) || (txtUsuarioSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!!!");
            } else {
            //a linha abaixo atualiza a tabela de usuário com os dados do formulário
            //a estrutura abaixo é usada para confirmar a inserção dos dados na tabela
                int adicionado = pst.executeUpdate();
                if (adicionado >0) {
                    JOptionPane.showMessageDialog(null, "Usuário " + "'" + txtUsuarioNome.getText()+ "'" + "adicionado com sucesso!");
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioTelefone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            }
               // pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //cria o método para alterar dados do usuário
    private void alterar(){
        String sql = "update usuarios set usuario=?,telefone=?,login=?,senha=?,perfil=? where id_usuario=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtUsuarioNome.getText());
            pst.setString(2,txtUsuarioTelefone.getText());
            pst.setString(3,txtUsuarioLogin.getText());
            pst.setString(4,txtUsuarioSenha.getText());
            pst.setString(5,comboUsuarioPerfil.getSelectedItem().toString());
            pst.setString(6,txtUsuarioId.getText());
            if ((txtUsuarioId.getText().isEmpty()) || (txtUsuarioNome.getText().isEmpty()) || (txtUsuarioLogin.getText().isEmpty()) || (txtUsuarioSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!!!");
            } else {
            //a linha abaixo atualiza a tabela de usuário com os dados do formulário
            //a estrutura abaixo é usada para confirmar a alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                if (adicionado >0) {
                    JOptionPane.showMessageDialog(null, "Dado(s) do usuário editado(s) com sucesso!");
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioTelefone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //estrutura abaixo confirma a exclusão do usuário
    public void remover(){
    int confirma=JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover este usuário???","Atenção",JOptionPane.YES_NO_OPTION);
        if (confirma==JOptionPane.YES_OPTION) {
            String sql="delete from usuarios where id_usuario=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1,txtUsuarioId.getText());
                //pst.executeUpdate();
                int apagado = pst.executeUpdate();
                if (apagado>0) {
                    JOptionPane.showMessageDialog(null, "Usuário " + "'" + txtUsuarioNome.getText()+ "'" + "removido com sucesso!");
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioTelefone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuarioId = new javax.swing.JTextField();
        txtUsuarioNome = new javax.swing.JTextField();
        txtUsuarioLogin = new javax.swing.JTextField();
        txtUsuarioSenha = new javax.swing.JTextField();
        comboUsuarioPerfil = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtUsuarioTelefone = new javax.swing.JTextField();
        btnUsuarioCreate = new javax.swing.JButton();
        btnUsuarioEdit = new javax.swing.JButton();
        btnUsuarioSearch = new javax.swing.JButton();
        btnUsuarioDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(640, 550));

        jLabel1.setText("* ID");

        jLabel2.setText("* Nome");

        jLabel3.setText("* Login");

        jLabel4.setText("* Senha");

        jLabel5.setText("* Perfil");

        txtUsuarioId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioIdActionPerformed(evt);
            }
        });

        txtUsuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioNomeActionPerformed(evt);
            }
        });

        comboUsuarioPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Usuário\t" }));
        comboUsuarioPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUsuarioPerfilActionPerformed(evt);
            }
        });

        jLabel6.setText("Telefone");

        btnUsuarioCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficial2poo2/icones/adduser.png"))); // NOI18N
        btnUsuarioCreate.setToolTipText("Adicionar Usuário");
        btnUsuarioCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioCreate.setPreferredSize(new java.awt.Dimension(60, 60));
        btnUsuarioCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioCreateActionPerformed(evt);
            }
        });

        btnUsuarioEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficial2poo2/icones/edituser.png"))); // NOI18N
        btnUsuarioEdit.setToolTipText("Editar Usuário");
        btnUsuarioEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioEdit.setPreferredSize(new java.awt.Dimension(60, 60));
        btnUsuarioEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioEditActionPerformed(evt);
            }
        });

        btnUsuarioSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficial2poo2/icones/searchuser.png"))); // NOI18N
        btnUsuarioSearch.setToolTipText("Buscar Usuário");
        btnUsuarioSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioSearch.setPreferredSize(new java.awt.Dimension(60, 60));
        btnUsuarioSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioSearchActionPerformed(evt);
            }
        });

        btnUsuarioDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficial2poo2/icones/deleteuser.png"))); // NOI18N
        btnUsuarioDelete.setToolTipText("Excluir Usuário");
        btnUsuarioDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioDelete.setPreferredSize(new java.awt.Dimension(60, 60));
        btnUsuarioDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("* Campos Obrigatótios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioTelefone)
                    .addComponent(txtUsuarioLogin)
                    .addComponent(comboUsuarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUsuarioSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuarioSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsuarioDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(btnUsuarioCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnUsuarioEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuarioTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboUsuarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsuarioCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarioEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarioSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarioDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        setBounds(0, 0, 642, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioIdActionPerformed

    private void txtUsuarioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioNomeActionPerformed

    private void btnUsuarioEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioEditActionPerformed
        // Chamando o método alterar dados do usuário
        alterar();
    }//GEN-LAST:event_btnUsuarioEditActionPerformed

    private void comboUsuarioPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUsuarioPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUsuarioPerfilActionPerformed

    private void btnUsuarioCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioCreateActionPerformed
        // chamando o método adicionar
        adicionar();
    }//GEN-LAST:event_btnUsuarioCreateActionPerformed

    private void btnUsuarioSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioSearchActionPerformed
        consultar();
    }//GEN-LAST:event_btnUsuarioSearchActionPerformed

    private void btnUsuarioDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioDeleteActionPerformed
        // chama o método de remover usuário
        remover();
    }//GEN-LAST:event_btnUsuarioDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuarioCreate;
    private javax.swing.JButton btnUsuarioDelete;
    private javax.swing.JButton btnUsuarioEdit;
    private javax.swing.JButton btnUsuarioSearch;
    private javax.swing.JComboBox comboUsuarioPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuarioId;
    private javax.swing.JTextField txtUsuarioLogin;
    private javax.swing.JTextField txtUsuarioNome;
    private javax.swing.JTextField txtUsuarioSenha;
    private javax.swing.JTextField txtUsuarioTelefone;
    // End of variables declaration//GEN-END:variables
}
