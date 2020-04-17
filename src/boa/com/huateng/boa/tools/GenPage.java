package com.huateng.boa.tools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GenPage {

    private JFrame frame;
    private JTextField textField;
    private ArrayList<String> addTableList = new ArrayList<String>();
    String[] columnNames = {"表名", "列名", "列描述", "查询条件", "条件类型", "结果列表", "明细页面", "edittype", "datatype", "length",
            "translated", "isKey"};
    String[] editTypes = {"text", "textarea", "select", "checkbox", "radio", "date", "datalabel", "process"};
    String[] dataTypes = {"string", "int", "double", "float", "date", "predate", "postdate", "time", "timestamp",
            "currency", "time14"};
    DefaultListModel tableList = new DefaultListModel();
    DefaultTableModel tableTable = new DefaultTableModel() {
        @Override
        public java.lang.Class<?> getColumnClass(int paramInt) {
            if (paramInt == 3 || paramInt == 5 || paramInt == 6 || paramInt == 11) {
                return Boolean.class;
            } else if (paramInt == 4) {
                return JComboBox.class;
            } else {
                return String.class;
            }
        }

        ;

        @Override
        public boolean isCellEditable(int paramInt1, int paramInt2) {
            if (paramInt2 > 1) {
                return true;
            } else {
                return false;
            }
        }

        ;
    };

    JList list = new JList();
    private JTextField textField_1;
    private JTable table;
    private JTextField textField_2;
    private JTextField textField_3;
    JCheckBox chckbxNewCheckBox = new JCheckBox("是否生成明细页面");
    JComboBox comboBox = new JComboBox();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ParseSQL.loadAll();
                    GenPage window = new GenPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GenPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(true);
        frame.setBounds(0, 0, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("表名");
        label.setBounds(53, 23, 61, 16);
        frame.getContentPane().add(label);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                try {

                    if (addTableList.contains(textField.getText().toUpperCase())) {
                        JOptionPane.showMessageDialog(frame, "table exists.", "parse error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (ParseSQL.tableInfo.containsKey(textField.getText().toUpperCase())) {
                        tableList.addElement(textField.getText().toUpperCase());
                        addTableList.add(textField.getText().toUpperCase());
                        for (ColumnItem item : ParseSQL.hibernateMap.get(textField.getText().toUpperCase())) {
                            FieldModel field = new FieldModel();
                            field.setTableName(textField.getText().toUpperCase());
                            field.setColumnName(item.getName().toUpperCase());
                            field.setColumnDesc(item.getName().toUpperCase());
                            field.setInWhere(false);
                            field.setWhereType("=");
                            field.setInResult(false);
                            field.setInDetail(true);
                            field.setDropType("");
                            field.setLen(item.getLen());
                            field.setKey(false);
                            if (item.getName().toUpperCase().endsWith("DATE")
                                    || item.getName().toUpperCase().endsWith("TM")
                                    || item.getName().toUpperCase().endsWith("TIME")) {
                                field.setEditType("date");
                                if (item.getLen() == 14) {
                                    field.setDataType("time14");
                                } else if (item.getLen() == 19) {
                                    field.setDataType("timestamp");
                                } else {
                                    field.setDataType("date");
                                }
                            } else {
                                field.setEditType("text");
                                field.setDataType("string");
                            }

                            tableTable.addRow(field.toArray());
                        }
                        textField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "no hbm file found ", "parse error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnAdd.setBounds(401, 18, 117, 29);
        frame.getContentPane().add(btnAdd);

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                if (list.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(frame, "please select item.", "parse error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String tableName = list.getSelectedValue().toString();
                if (addTableList.contains(tableName) == false) {
                    JOptionPane.showMessageDialog(frame, "table not exists.", "parse error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    addTableList.remove(tableName);
                    tableList.removeElement(tableName);
                    int rows = tableTable.getRowCount();
                    for (int i = (rows - 1); i >= 0; i--) {
                        String rowValue = tableTable.getValueAt(i, 0).toString();
                        if (tableName.equals(rowValue)) {
                            tableTable.removeRow(i);
                        }
                    }
                }
            }
        });
        btnRemove.setBounds(401, 59, 117, 29);
        frame.getContentPane().add(btnRemove);

        textField = new JTextField();
        textField.setBounds(126, 18, 263, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(53, 51, 336, 102);
        frame.getContentPane().add(scrollPane);

        list.setModel(tableList);
        scrollPane.setViewportView(list);

        JLabel lblSql = new JLabel("基础关联");
        lblSql.setBounds(53, 165, 61, 16);
        frame.getContentPane().add(lblSql);

        textField_1 = new JTextField();
        textField_1.setBounds(53, 184, 702, 26);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel label_1 = new JLabel("字段");
        label_1.setBounds(53, 236, 61, 16);
        frame.getContentPane().add(label_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(53, 264, 1060, 378);
        frame.getContentPane().add(scrollPane_1);

        tableTable.setColumnIdentifiers(columnNames);
        table = new JTable(tableTable);
        JComboBox c = new JComboBox();
        c.addItem("=");
        c.addItem("between");
        c.addItem("like");

        JComboBox editTypesBox = new JComboBox();
        for (String str : editTypes) {
            editTypesBox.addItem(str);
        }

        JComboBox dataTypesBox = new JComboBox();
        for (String str : dataTypes) {
            dataTypesBox.addItem(str);
        }

        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(5);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.getColumnModel().getColumn(6).setPreferredWidth(10);
        table.getColumnModel().getColumn(7).setPreferredWidth(10);
        table.getColumnModel().getColumn(8).setPreferredWidth(10);
        table.getColumnModel().getColumn(9).setPreferredWidth(10);
        table.getColumnModel().getColumn(10).setPreferredWidth(500);
        table.getColumnModel().getColumn(11).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(c));
        table.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(editTypesBox));
        table.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(dataTypesBox));
        // JCheckBox jc1 = new JCheckBox();
        // table.getColumnModel().getColumn(2).setCellEditor(new
        // DefaultCellEditor(jc1));

        scrollPane_1.setViewportView(table);

        JButton btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                String title = textField_2.getText().trim();
                String module = textField_3.getText().trim();
                String baseWhere = textField_1.getText().trim();

                if (addTableList == null || addTableList.size() == 0) {
                    JOptionPane.showMessageDialog(frame, "no table", "parse error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    String pageType = comboBox.getSelectedItem().toString();
                    if (addTableList.size() == 1) {
                        GenFrontPageForSingleTable.genFrontPage(title, module, tableTable, addTableList.get(0),
                                baseWhere, chckbxNewCheckBox.isSelected(), pageType);
                        if (chckbxNewCheckBox.isSelected()) {
                            GenDetailFrontPageForSingleTable.genFrontPage(title, module, tableTable, addTableList.get(0), baseWhere, pageType);
                        }
                    } else {
                        GenFrontPage.genFrontPage(title, module, tableTable, addTableList, baseWhere, chckbxNewCheckBox.isSelected());
                        if (chckbxNewCheckBox.isSelected()) {
                            GenDetailFrontPage.genFrontPage(title, module, tableTable, addTableList, baseWhere);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(frame, e.getMessage(), "parse error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnGenerate.setBounds(401, frame.getHeight() - 40, 117, 20);
        frame.getContentPane().add(btnGenerate);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(53, 211, 61, 16);
        frame.getContentPane().add(lblTitle);

        textField_2 = new JTextField();
        textField_2.setBounds(126, 206, 263, 26);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblModule = new JLabel("Module");
        lblModule.setBounds(419, 211, 61, 16);
        frame.getContentPane().add(lblModule);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(492, 206, 263, 26);
        frame.getContentPane().add(textField_3);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                tableTable.removeRow(table.getSelectedRow());
            }
        });
        btnDelete.setBounds(1110, 260, 84, 29);
        frame.getContentPane().add(btnDelete);
        chckbxNewCheckBox.setBounds(126, 232, 263, 23);
        frame.getContentPane().add(chckbxNewCheckBox);

        comboBox.setBounds(492, 232, 263, 27);
        frame.getContentPane().add(comboBox);

        comboBox.addItem("Query");
        comboBox.addItem("Maker");
        comboBox.addItem("Checker");
        JLabel lblType = new JLabel("Type");
        lblType.setBounds(419, 236, 61, 16);
        frame.getContentPane().add(lblType);
    }
}
