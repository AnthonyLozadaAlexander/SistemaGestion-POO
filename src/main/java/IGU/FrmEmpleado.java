/*
 * Created by JFormDesigner on Fri Nov 07 08:06:37 ECT 2025
 */

package IGU;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;

import Clases.Empleado;
import Clases.EmpleadoTiempoCompleto;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author zDefcon
 */


public class FrmEmpleado extends JFrame {
    private ArrayList<Empleado> listEmpleados = new ArrayList<>();
    private DefaultTableModel modelo;
    public FrmEmpleado() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        String[] column = {"Nombre", "Edad", "Salario", "Bono", "Salario Mensual", "Salario Anual"};
        modelo = new DefaultTableModel(column, 0){
            @Override
            public boolean isCellEditable(int row, int column){ // Evitar Edicion Directa
                return false;
            }
        };
        tabla.setModel(modelo);
    }

    private int Int(String txt){
        return Integer.parseInt(txt.trim());
    }

    private boolean vacios(){
        if(txtNombre.getText().isEmpty() || txtEdad.getText().isEmpty() || txtSalario.getText().isEmpty() || txtBono.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Porfavor, Debe Ingresar Los Campos Requeridos", "Campos Vacios",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private void modificar(){
        int fila = -1;
        boolean indiceE = false;
        boolean filaE = false;
        int indice = -1;
        int opcion = JOptionPane.showConfirmDialog(null, "Desea Modificar Empleado?", "Modificar Empleado",
                JOptionPane.YES_NO_OPTION);

        if(opcion == JOptionPane.NO_OPTION){
            return;
        }

        String elegir = JOptionPane.showInputDialog(this, "Ingrese 1 para modificar por Indice o 2 para modificar por Nombre: ");

        switch(elegir){
            case "1" -> {
                String indiceBuscar = JOptionPane.showInputDialog(this, "Ingrese el indice del empleado a modificar: ");
                indice = Int(indiceBuscar);
                indiceE = true;
            }

            case "2" -> { fila = tabla.getSelectedRow();
                if(fila == -1){
                    JOptionPane.showMessageDialog(this, "No Ha Seleccionado Ningun Empleado en la Tabla", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                filaE = true;

            }

        }

        if(indice < 0 || indice >= listEmpleados.size()){
            JOptionPane.showMessageDialog(this, "Indice invalido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = txtNombre.getText();
        int edad = Int(txtEdad.getText());
        double salario = Double.parseDouble(txtSalario.getText().trim());
        double bono = Double.parseDouble(txtBono.getText().trim());

        if(indiceE){
            listEmpleados.set(indice, new EmpleadoTiempoCompleto(nombre, edad, bono, salario));
        }

        if(filaE){
            listEmpleados.set(fila, new EmpleadoTiempoCompleto(nombre, edad, bono, salario));
        }

    }

    private void limpiar(){
        txtNombre.setText("");
        txtEdad.setText("");
        txtSalario.setText("");
        txtBono.setText("");
        txtIndice.setText("");
    }

    private void agregar(){
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText().trim());
        double salario = Double.parseDouble(txtSalario.getText().trim());
        double bono = Double.parseDouble(txtBono.getText().trim());
        listEmpleados.add(new EmpleadoTiempoCompleto(nombre, edad, salario, bono));
        txtArea.append("Empleado agregado: " + nombre + "\n");
        txtArea.append("Total empleados: " + listEmpleados.size() + "\n");

    }

    private void mostrar(){
         txtArea.append("Lista de Empleados: ["+listEmpleados.size()+"]\n");
        for (int i = 0; i < listEmpleados.size(); i++) {
            txtArea.append("[" + i + "]: " + listEmpleados.get(i).mostrarInfo() + "\n");
        }
    }
    

    private void btnAgregar(ActionEvent e) {
        if(vacios()){
            return;
        }
        agregar();
        mostrar();
    }

    private void btnModificar(ActionEvent e) {
        modificar();
        mostrar();

    }

    private void Eliminar(){
        int index = Integer.parseInt(txtIndice.getText().trim());
        String nom = listEmpleados.get(index).toString();
        listEmpleados.remove(index);
        txtArea.append("Empleado eliminado: " + nom + "\n");
        txtArea.append("Total empleados: " + listEmpleados.size() + "\n");
    }

    private void btnEliminar(ActionEvent e) {
        Eliminar();
        mostrar();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        txtNombre = new JTextField();
        txtEdad = new JTextField();
        txtSalario = new JTextField();
        txtBono = new JTextField();
        txtIndice = new JTextField();
        scrollPane1 = new JScrollPane();
        txtArea = new JTextArea();
        btnAgregar = new JButton();
        btnModificar = new JButton();
        btnEliminar = new JButton();
        separator1 = new JSeparator();
        btnBuscar = new JButton();
        label6 = new JLabel();
        scrollPane2 = new JScrollPane();
        tabla = new JTable();

        //======== this ========
        setName("this");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Nombre:");
        label1.setFont(new Font("CaskaydiaMono NF SemiBold", Font.BOLD, 16));
        label1.setName("label1");

        //---- label2 ----
        label2.setText("Edad:");
        label2.setFont(new Font("CaskaydiaMono NF SemiBold", Font.BOLD, 16));
        label2.setName("label2");

        //---- label3 ----
        label3.setText("Salario:");
        label3.setFont(new Font("CaskaydiaMono NF SemiBold", Font.BOLD, 16));
        label3.setName("label3");

        //---- label4 ----
        label4.setText("Bono:");
        label4.setFont(new Font("CaskaydiaMono NF SemiBold", Font.BOLD, 16));
        label4.setName("label4");

        //---- label5 ----
        label5.setText("Indice:");
        label5.setFont(new Font("CaskaydiaMono NF SemiBold", Font.BOLD, 16));
        label5.setName("label5");

        //---- txtNombre ----
        txtNombre.setName("txtNombre");

        //---- txtEdad ----
        txtEdad.setName("txtEdad");

        //---- txtSalario ----
        txtSalario.setName("txtSalario");

        //---- txtBono ----
        txtBono.setName("txtBono");

        //---- txtIndice ----
        txtIndice.setName("txtIndice");

        //======== scrollPane1 ========
        {
            scrollPane1.setName("scrollPane1");

            //---- txtArea ----
            txtArea.setName("txtArea");
            scrollPane1.setViewportView(txtArea);
        }

        //---- btnAgregar ----
        btnAgregar.setText("Agregar");
        btnAgregar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
        btnAgregar.setName("btnAgregar");
        btnAgregar.addActionListener(e -> btnAgregar(e));

        //---- btnModificar ----
        btnModificar.setText("Modificar");
        btnModificar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
        btnModificar.setName("btnModificar");
        btnModificar.addActionListener(e -> btnModificar(e));

        //---- btnEliminar ----
        btnEliminar.setText("Eliminar");
        btnEliminar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
        btnEliminar.setName("btnEliminar");
        btnEliminar.addActionListener(e -> btnEliminar(e));

        //---- separator1 ----
        separator1.setForeground(Color.black);
        separator1.setName("separator1");

        //---- btnBuscar ----
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 18));
        btnBuscar.setName("btnBuscar");

        //---- label6 ----
        label6.setText("Gestor Empleados");
        label6.setFont(new Font("CaskaydiaMono NF SemiBold", Font.BOLD, 36));
        label6.setName("label6");

        //======== scrollPane2 ========
        {
            scrollPane2.setName("scrollPane2");

            //---- tabla ----
            tabla.setModel(new DefaultTableModel());
            tabla.setName("tabla");
            scrollPane2.setViewportView(tabla);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2, GroupLayout.Alignment.TRAILING)
                                .addComponent(label1, GroupLayout.Alignment.TRAILING)
                                .addComponent(label4, GroupLayout.Alignment.TRAILING)
                                .addComponent(label5, GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIndice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(btnAgregar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
                    .addGap(57, 57, 57)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(separator1, GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 356, Short.MAX_VALUE)
                    .addComponent(label6)
                    .addGap(319, 319, 319))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(label6)
                    .addGap(26, 26, 26)
                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(txtBono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtIndice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5)))
                                .addComponent(label4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addComponent(btnAgregar)
                            .addGap(18, 18, 18)
                            .addComponent(btnModificar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminar)
                            .addContainerGap(17, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(17, Short.MAX_VALUE))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Daniel Sanchez (Anthony Lozada)
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtSalario;
    private JTextField txtBono;
    private JTextField txtIndice;
    private JScrollPane scrollPane1;
    private JTextArea txtArea;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JSeparator separator1;
    private JButton btnBuscar;
    private JLabel label6;
    private JScrollPane scrollPane2;
    private JTable tabla;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
