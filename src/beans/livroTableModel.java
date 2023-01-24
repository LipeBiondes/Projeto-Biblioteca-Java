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
 * @author Thiag
 */
public class livroTableModel extends AbstractTableModel{
    private List<LivroBeans> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Titulo", "Autor", "Genero", "Quantidade"};
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    public int getRowCont(){
        return dados.size();
    }
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    public Object getValueat(int linha, int coluna){
        switch (coluna){
            case 0: 
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getTitulo();
            case 2:
                return dados.get(linha).getAutor();
            case 3:
                return dados.get(linha).getGenero();
            case 4:
                return dados.get(linha).getQtd();
        }
        return null;
    }
    
    public void addRow(LivroBeans e){
        this.dados.remove(e);
        this.fireTableDataChanged();
    }
    public void removedRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
