/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author Avell
 */
public class TaskTableModel extends AbstractTableModel {

    //Colunas que ir�o aparecer na table
    String[] columns = {"Nome", "Descri��o", "Prazo", "Tarefa conclu�da", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        //Quantidade de tarefas define a quantidade de linhas na table
        return tasks.size(); 
    }
    
    @Override
    public boolean isCellEditable (int rowIndex, int columnIndex) {
        
        //Se o retorno (indice da coluna) for igual a tr�s, retorna true, � edit�vel
        return columnIndex == 3;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //Qual a classe do componente que est� em determinada coluna, caso n�o seja implementado tudo � String
        if (tasks.isEmpty()) return Object.class;
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public int getColumnCount() {
        //Quantidade de colunar usando como refer�ncia o vetor criado acima
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return switch (columnIndex) {
            case 0 -> tasks.get(rowIndex).getName();
            case 1 -> tasks.get(rowIndex).getDescription();
            case 2 -> sdf.format(tasks.get(rowIndex).getDeadLine());
            case 3 -> tasks.get(rowIndex).isIsComplete();
            case 4 -> "";
            case 5 -> "";
            default -> "Dados n�o encontrados";
        };
    }
    
    @Override
    public void setValueAt (Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setIsComplete((boolean) aValue);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
}
