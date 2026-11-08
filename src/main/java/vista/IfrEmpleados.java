/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Geovanny_Callizo
 */
public class IfrEmpleados extends javax.swing.JInternalFrame {
private int idEmpleadoSeleccionado = -1;
    /**
     * Creates new form IfrEmpleados
     */
    public IfrEmpleados() {
        initComponents();
        cargarTablaEmpleados();
    }
private void cargarTablaEmpleados() {
    javax.swing.table.DefaultTableModel modeloTabla =
        (javax.swing.table.DefaultTableModel)
        tblEmpleados.getModel();

    modeloTabla.setRowCount(0);

    try {
        servicio.EmpleadoServicio empleadoServicio =
        new servicio.EmpleadoServicio();

       for (modelo.Empleado empleado : empleadoServicio.listarOrdenados()) {
            modeloTabla.addRow(new Object[]{
                empleado.getCodigo(),
                empleado.getIdentidad(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getPuesto(),
                empleado.getSalario(),
                empleado.getFechaIngreso()
            });
        }

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Error al cargar empleados: " + e.getMessage()
        );
    }
}
    /**
     
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cmbPuesto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtIdentidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        cmbFiltroPuesto = new javax.swing.JComboBox<>();

        setTitle("Gestion de Empleados");

        jLabel1.setText("Codigo de empleado :");

        jLabel2.setText("Puesto :");

        jLabel3.setText("Salario :");

        txtSalario.addActionListener(this::txtSalarioActionPerformed);

        jLabel4.setText("Fecha de Ingreso :");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un puesto", "Gerente", "Supervisor", "Operador", "Auxiliar", "Tecnico" }));

        jLabel5.setText("Nombre :");

        jLabel6.setText("Apellido :");

        jLabel7.setText("Telefono :");

        jLabel8.setText("Correo :");

        jLabel9.setText("Fecha de Nacimiento :");

        jLabel10.setText("Identidad :");

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Identidad", "Nombre", "Apellido", "Puesto", "Salario", "Fecha Ingreso"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        cmbFiltroPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Gerente", "Supervisor", "Operador", "Auxiliar", "Tecnico" }));
        cmbFiltroPuesto.addActionListener(this::cmbFiltroPuestoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtCorreo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTelefono)
                            .addComponent(txtApellido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSalario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPuesto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFechaIngreso)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(170, 170, 170)
                                .addComponent(txtIdentidad))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnActualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar))
                                    .addComponent(cmbFiltroPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(24, 24, 24)
                .addComponent(cmbFiltroPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
      
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtCodigo.setText("");
cmbPuesto.setSelectedIndex(0);
txtSalario.setText("");
txtFechaIngreso.setText("");
txtIdentidad.setText("");
txtNombre.setText("");
txtApellido.setText("");
txtTelefono.setText("");
txtCorreo.setText("");
txtFechaNacimiento.setText("");
txtCodigo.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       String codigo = txtCodigo.getText().trim();
String puesto = cmbPuesto.getSelectedItem().toString();
String salarioTexto = txtSalario.getText().trim();
String fechaIngreso = txtFechaIngreso.getText().trim();
String identidad = txtIdentidad.getText().trim();
String nombre = txtNombre.getText().trim();
String apellido = txtApellido.getText().trim();
String telefono = txtTelefono.getText().trim();
String correo = txtCorreo.getText().trim();
String fechaNacimiento = txtFechaNacimiento.getText().trim();
if (codigo.isEmpty()
        || cmbPuesto.getSelectedIndex() == 0
        || salarioTexto.isEmpty()
        || fechaIngreso.isEmpty()
        || identidad.isEmpty()
        || nombre.isEmpty()
        || apellido.isEmpty()) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Debe completar los campos obligatorios"
    );
    return;
}
double salario;

try {
    salario = Double.parseDouble(salarioTexto);

    if (salario <= 0) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "El salario debe ser mayor que cero"
        );
        return;
    }

} catch (NumberFormatException e) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Ingrese un salario numérico válido"
    );
    return;
}try {
    modelo.Empleado empleado = new modelo.Empleado(
        0,
        identidad,
        nombre,
        apellido,
        telefono,
        correo,
        fechaNacimiento,
        codigo,
        puesto,
        salario,
        fechaIngreso
    );

    servicio.EmpleadoServicio empleadoServicio =
        new servicio.EmpleadoServicio();

empleadoServicio.guardar(empleado);

    javax.swing.JOptionPane.showMessageDialog(
        this, "Empleado guardado correctamente"
    );
cargarTablaEmpleados ();
    btnNuevo.doClick();

} catch (IllegalArgumentException e) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Datos inválidos: " + e.getMessage()
    );

} catch (java.sql.SQLException e) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Error al guardar: " + e.getMessage()
    );
}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String identidad = txtIdentidad.getText().trim();

if (!identidad.matches("[0-9]{13}")) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Ingrese una identidad de 13 dígitos"
    );
    return;
}

try {
    servicio.EmpleadoServicio empleadoServicio =
        new servicio.EmpleadoServicio();

java.util.Optional<modelo.Empleado> resultado =
        empleadoServicio.buscarPorIdentidad(identidad);
    if (resultado.isPresent()) {

        modelo.Empleado empleado = resultado.get();
        idEmpleadoSeleccionado = empleado.getId();
                
        txtCodigo.setText(empleado.getCodigo());
        cmbPuesto.setSelectedItem(empleado.getPuesto());
        txtSalario.setText(String.valueOf(empleado.getSalario()));
        txtFechaIngreso.setText(empleado.getFechaIngreso());

        txtIdentidad.setText(empleado.getIdentidad());
        txtNombre.setText(empleado.getNombre());
        txtApellido.setText(empleado.getApellido());
        txtTelefono.setText(empleado.getTelefono());
        txtCorreo.setText(empleado.getCorreo());
        txtFechaNacimiento.setText(empleado.getFechaNacimiento());

        javax.swing.JOptionPane.showMessageDialog(
            this, "Empleado encontrado correctamente"
        );

    } else {
        javax.swing.JOptionPane.showMessageDialog(
            this, "No se encontró el empleado"
        );
    }

} catch (java.sql.SQLException e) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Error al buscar: " + e.getMessage()
    );
}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       if (idEmpleadoSeleccionado == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Primero debe buscar y seleccionar un empleado"
    );
    return;
}String codigo = txtCodigo.getText().trim();
String puesto = cmbPuesto.getSelectedItem().toString();
String salarioTexto = txtSalario.getText().trim();
String fechaIngreso = txtFechaIngreso.getText().trim();

String identidad = txtIdentidad.getText().trim();
String nombre = txtNombre.getText().trim();
String apellido = txtApellido.getText().trim();
String telefono = txtTelefono.getText().trim();
String correo = txtCorreo.getText().trim();
String fechaNacimiento = txtFechaNacimiento.getText().trim();
if (codigo.isEmpty()
        || cmbPuesto.getSelectedIndex() == 0
        || salarioTexto.isEmpty()
        || fechaIngreso.isEmpty()
        || identidad.isEmpty()
        || nombre.isEmpty()
        || apellido.isEmpty()) {

    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Debe completar los campos obligatorios"
    );
    return;
}
double salario;

try {
    salario = Double.parseDouble(salarioTexto);

    if (salario <= 0) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "El salario debe ser mayor que cero"
        );
        return;
    }

} catch (NumberFormatException e) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Ingrese un salario numérico válido"
    );
    return;
}
modelo.Empleado empleado = new modelo.Empleado(
    idEmpleadoSeleccionado,
    identidad,
    nombre,
    apellido,
    telefono,
    correo,
    fechaNacimiento,
    codigo,
    puesto,
    salario,
    fechaIngreso
);
try {
    servicio.EmpleadoServicio empleadoServicio =
        new servicio.EmpleadoServicio();
System.out.println("ID seleccionado: " + idEmpleadoSeleccionado);
System.out.println("ID del objeto: " + empleado.getId());
    empleadoServicio.actualizar(empleado);
 cargarTablaEmpleados();
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Empleado actualizado correctamente"
    );

} catch (java.sql.SQLException e) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Error al actualizar: " + e.getMessage()
    );
}
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idEmpleadoSeleccionado == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Primero debe buscar y seleccionar un empleado"
    );
    return;
}
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
    this,
    "¿Está seguro de que desea eliminar este empleado?",
    "Confirmar eliminación",
    javax.swing.JOptionPane.YES_NO_OPTION,
    javax.swing.JOptionPane.WARNING_MESSAGE
);

if (confirmacion != javax.swing.JOptionPane.YES_OPTION) {
    return;
}
try {
    servicio.EmpleadoServicio empleadoServicio =
        new servicio.EmpleadoServicio();

empleadoServicio.eliminar(idEmpleadoSeleccionado);

    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Empleado eliminado correctamente"
    );

    idEmpleadoSeleccionado = -1;
    btnNuevo.doClick();
    cargarTablaEmpleados();

} catch (java.sql.SQLException e) {

    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Error al eliminar: " + e.getMessage()
    );
}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
      int fila = tblEmpleados.getSelectedRow();

if (fila == -1) {
    return;
}

int filaModelo = tblEmpleados.convertRowIndexToModel(fila);

javax.swing.table.TableModel modelo = tblEmpleados.getModel();

txtCodigo.setText(modelo.getValueAt(filaModelo, 0).toString());
txtIdentidad.setText(modelo.getValueAt(filaModelo, 1).toString());
txtNombre.setText(modelo.getValueAt(filaModelo, 2).toString());
txtApellido.setText(modelo.getValueAt(filaModelo, 3).toString());

cmbPuesto.setSelectedItem(modelo.getValueAt(filaModelo, 4).toString());
txtSalario.setText(modelo.getValueAt(filaModelo, 5).toString());
txtFechaIngreso.setText(modelo.getValueAt(filaModelo, 6).toString());
try {
    dao.EmpleadoDAOImpl empleadoDAO =
            new dao.EmpleadoDAOImpl();

    String identidad = txtIdentidad.getText().trim();

    java.util.Optional<modelo.Empleado> resultado =
            empleadoDAO.buscarPorIdentidad(identidad);

    if (resultado.isPresent()) {
        modelo.Empleado empleado = resultado.get();

        idEmpleadoSeleccionado = empleado.getId();

        txtTelefono.setText(empleado.getTelefono());
        txtCorreo.setText(empleado.getCorreo());
        txtFechaNacimiento.setText(
                empleado.getFechaNacimiento());

    } else {
        idEmpleadoSeleccionado = -1;
        javax.swing.JOptionPane.showMessageDialog(
                this, "Empleado no encontrado");
    }

} catch (java.sql.SQLException e) {
    idEmpleadoSeleccionado = -1;
    javax.swing.JOptionPane.showMessageDialog(
            this, "Error al consultar: " + e.getMessage());
}
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void cmbFiltroPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroPuestoActionPerformed
      String puesto = cmbFiltroPuesto.getSelectedItem().toString();

javax.swing.table.TableRowSorter<
    javax.swing.table.TableModel> filtro =
    new javax.swing.table.TableRowSorter<>(
        tblEmpleados.getModel()
    );

tblEmpleados.setRowSorter(filtro);

if (!puesto.equals("Todos")) {
    filtro.setRowFilter(
        javax.swing.RowFilter.regexFilter(
            "(?i)^" + java.util.regex.Pattern.quote(puesto) + "$", 4
        )
    );
}
    }//GEN-LAST:event_cmbFiltroPuestoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbFiltroPuesto;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtIdentidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
