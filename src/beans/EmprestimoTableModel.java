/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ismael
 */
public class EmprestimoTableModel extends AbstractTableModel {

    private List<EmprestimoBeans> dados = new ArrayList<>();
    private String[] colunas = {"Emprestimo", "Aluno", "Titulo", "Data Inicio", "Data Fim"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getId_aluno();
            case 2:
                return dados.get(linha).getId_livro();
            case 3:
                return dados.get(linha).getDataP();
            case 4:
                return dados.get(linha).getDataD();
        }
        return null;
    }

    public void atualizarRow(EmprestimoBeans e) {
        
        this.fireTableDataChanged();

    }
    
    public void removedRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

}
