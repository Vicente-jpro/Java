   private List<Produto> getNumberItemTable() {

        String sql = "SELECT id_produto FROM produto_tb ORDER BY nome_produto ";

        List lista = new ArrayList<Produto>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            produto = null;
            while (rs.next()) {

                produto = new Produto(rs.getInt("id_produto"));

                lista.add(produto);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do produto\n"
                    + "O correu um erro ao ler todos os IDs",
                    "LEITURA DO PRODUTO SALVAR", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return lista;

    } 


/**
     * @return Actualiza o número de ordem na lista de PRODUTO para ser
     * impresso.
     *
     * A contagem de número de ordem começa apartir de 1 até n.
     * @param produto
     */
    protected void updateSequenceNumber() {

        String sql = "UPDATE public.produto_tb "
                + "	SET contador = ? "
                + "	WHERE  id_produto = ? ";

        List<Produto> lista = getNumberItemTable();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);

            int contador = 1;
            for (Produto produt : lista) {

                stmt.setInt(1, contador);
                stmt.setInt(2, produt.getIdProduto());
                contador++;

                stmt.executeUpdate();

            }
//
//            JOptionPane.showMessageDialog(null, "Produto actualizado com sucesso\n",
//                    "ACTUALIZAÇÃO DE PRODUTO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o número de sequência\n" ,
//                    "ACTUALIZAÇÃO DO NÚMERO DE SEQUÊNCIA", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

