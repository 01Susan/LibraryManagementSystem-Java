/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.personal.BookManagementSystem.GUI;

import com.personal.BookManagementSystem.model.Books;
import com.personal.BookManagementSystem.dao.BooksDao;
import com.personal.BookManagementSystem.dao.impl.BooksDaoimpl;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class BooksUI extends javax.swing.JFrame {

    private final BooksDao booksDao = new BooksDaoimpl();
    private final String[] columns = new String[]{"Id", "book_name", "publication", "category", "date"};
    private final DefaultTableModel model = new DefaultTableModel();

    private void save() throws Exception {
        try {
            Books book = getValueFromTextField();
            int rowCount = booksDao.save(book);
            if (rowCount >= 1) {
                showMessageDialog("Book sucessfuly saved");
                resetForm();
                findAll();
            } else {
                showMessageDialog("Something went wrong");
            }

        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private Books getValueFromTextField() {
        String BookName = BookInputFiled.getText();
        String Publication = PublicationInput.getText();
        String Category = (String) CategoryChooes.getSelectedItem();
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        String Date = ymd.format(jDateChooser2.getDate());
        Books book = new Books(BookName, Publication, Category, Date);
        return book;
    }

    private void update() throws NumberFormatException, ParseException {
        try {
            int selectRow = Table.getSelectedRow();
            int Id = (int) Table.getValueAt(selectRow, 0);
            Books book = booksDao.findOne(Id);
            if (editUpdatebtn.getText().equals("Edit")) {
                editUpdatebtn.setText("Update");
                BookInputFiled.setText(book.getBookName());
                PublicationInput.setText(book.getPublication());
                SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
                Date setterdate = ymd.parse(book.getDate());
                jDateChooser2.setDate(setterdate);
                CategoryChooes.setSelectedItem(book.getCategory());
            } else if (editUpdatebtn.getText().equals("Update")) {
                book.setBookName(BookInputFiled.getText());
                book.setPublication(PublicationInput.getText());
                SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
                String Dateer = ymd.format(jDateChooser2.getDate());
                book.setDate(Dateer);
                String Category = (String) CategoryChooes.getSelectedItem();
                book.setCategory(Category);
                int rowCount = booksDao.update(book, Id);
                if (rowCount >= 1) {
                    showMessageDialog("Book Sucessfully update");
                    resetForm();
                    findAll();
                    editUpdatebtn.setText("Edit");
                } else {
                    showMessageDialog("Someting went wrong");
                }

            }

        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());

        }
    }

    private void remove() {
        int selectedRow = Table.getSelectedRow();
        int Id = (int) Table.getValueAt(selectedRow, 0);
        try {
            Books book = booksDao.findOne(Id);
            if (book != null) {
                int rowCount = booksDao.remove(Id);
                if (rowCount >= 1) {
                    showMessageDialog("Book Sucessfully Deleted");
                    findAll();
                }

            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }

    }

    private void resetForm() {
        BookInputFiled.setText("");
        PublicationInput.setText("");
        CategoryChooes.setSelectedItem("");
    }

    private void setUpTableModel() {
        Table.setModel(model);
        model.setColumnIdentifiers(columns);
    }
    //Find All code

    private void search() throws SQLException {
        String query = SearchFiled.getText();
        if (query.length() == 0) {
            findAll();
        } else {
            model.setRowCount(0);
            try {
                List<Books> books = booksDao.search(SearchFiled.getText());
                for (Books book : books) {
                    Object[] row = {book.getId(), book.getBookName(), book.getPublication(), book.getDate(), book.getDate()};
                    model.addRow(row);
                }
            } catch (SQLException ex) {
                showMessageDialog(ex.getMessage());
            }
        }
    }

    public BooksUI() {
        initComponents();
        setUpTableModel();
        findAll();
    }

// Code for Ui Design part   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MainPanel = new javax.swing.JPanel();
        HeaderPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        UserPanel = new javax.swing.JPanel();
        PublicationPanel = new javax.swing.JPanel();
        Publication = new javax.swing.JLabel();
        PublicationInput = new javax.swing.JTextField();
        CategoryPanel = new javax.swing.JPanel();
        CategoryLabel = new javax.swing.JLabel();
        CategoryChooes = new javax.swing.JComboBox<>();
        Date = new javax.swing.JPanel();
        DateLabel = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        BooknamePanel = new javax.swing.JPanel();
        BookNameLabel = new javax.swing.JLabel();
        BookInputFiled = new javax.swing.JTextField();
        btnPannel = new javax.swing.JPanel();
        savebtn = new javax.swing.JButton();
        editUpdatebtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        loginPanel = new javax.swing.JPanel();
        Logoutbtn = new javax.swing.JButton();
        RightMainpannel = new javax.swing.JPanel();
        TablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        SearchPanel = new javax.swing.JPanel();
        SearchFiled = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        HeaderPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/personal/BookManagementSystem/GUI/booklogo2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(13, 58, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Book Management System");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        UserPanel.setBackground(new java.awt.Color(13, 59, 102));

        PublicationPanel.setBackground(new java.awt.Color(13, 58, 102));

        Publication.setBackground(new java.awt.Color(255, 255, 255));
        Publication.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Publication.setForeground(new java.awt.Color(255, 255, 255));
        Publication.setText("Publication");

        PublicationInput.setBackground(new java.awt.Color(13, 58, 102));
        PublicationInput.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        PublicationInput.setForeground(new java.awt.Color(255, 255, 255));
        PublicationInput.setText("Enter Publication Name");
        PublicationInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        PublicationInput.setCaretColor(new java.awt.Color(255, 255, 255));
        PublicationInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PublicationInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PublicationInputFocusLost(evt);
            }
        });

        javax.swing.GroupLayout PublicationPanelLayout = new javax.swing.GroupLayout(PublicationPanel);
        PublicationPanel.setLayout(PublicationPanelLayout);
        PublicationPanelLayout.setHorizontalGroup(
            PublicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PublicationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Publication)
                .addGap(18, 18, 18)
                .addComponent(PublicationInput, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PublicationPanelLayout.setVerticalGroup(
            PublicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PublicationPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PublicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PublicationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Publication))
                .addContainerGap())
        );

        CategoryPanel.setBackground(new java.awt.Color(13, 58, 102));

        CategoryLabel.setBackground(new java.awt.Color(255, 255, 255));
        CategoryLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CategoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        CategoryLabel.setText("Category");

        CategoryChooes.setForeground(new java.awt.Color(13, 58, 102));
        CategoryChooes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spritual", "Comics", "Novel", "Business", "Technology", " " }));

        Date.setBackground(new java.awt.Color(13, 58, 102));

        DateLabel.setBackground(new java.awt.Color(255, 255, 255));
        DateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(255, 255, 255));
        DateLabel.setText("Date");

        jDateChooser2.setNextFocusableComponent(jDateChooser2);

        javax.swing.GroupLayout DateLayout = new javax.swing.GroupLayout(Date);
        Date.setLayout(DateLayout);
        DateLayout.setHorizontalGroup(
            DateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DateLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(DateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        DateLayout.setVerticalGroup(
            DateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateLabel))
                .addGap(125, 125, 125))
        );

        javax.swing.GroupLayout CategoryPanelLayout = new javax.swing.GroupLayout(CategoryPanel);
        CategoryPanel.setLayout(CategoryPanelLayout);
        CategoryPanelLayout.setHorizontalGroup(
            CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryPanelLayout.createSequentialGroup()
                .addComponent(CategoryLabel)
                .addGap(31, 31, 31)
                .addComponent(CategoryChooes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CategoryPanelLayout.setVerticalGroup(
            CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryLabel)
                    .addComponent(CategoryChooes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        BooknamePanel.setBackground(new java.awt.Color(13, 58, 102));

        BookNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        BookNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BookNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        BookNameLabel.setText("BookName");

        BookInputFiled.setBackground(new java.awt.Color(13, 58, 102));
        BookInputFiled.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        BookInputFiled.setForeground(new java.awt.Color(255, 255, 255));
        BookInputFiled.setText("Enter Book Name");
        BookInputFiled.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        BookInputFiled.setCaretColor(new java.awt.Color(255, 255, 255));
        BookInputFiled.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BookInputFiledFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BookInputFiledFocusLost(evt);
            }
        });
        BookInputFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookInputFiledActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BooknamePanelLayout = new javax.swing.GroupLayout(BooknamePanel);
        BooknamePanel.setLayout(BooknamePanelLayout);
        BooknamePanelLayout.setHorizontalGroup(
            BooknamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BooknamePanelLayout.createSequentialGroup()
                .addComponent(BookNameLabel)
                .addGap(18, 18, 18)
                .addComponent(BookInputFiled))
        );
        BooknamePanelLayout.setVerticalGroup(
            BooknamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BooknamePanelLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(BooknamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookInputFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookNameLabel))
                .addContainerGap())
        );

        btnPannel.setBackground(new java.awt.Color(13, 59, 102));

        savebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savebtn.setForeground(new java.awt.Color(13, 59, 102));
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        editUpdatebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editUpdatebtn.setForeground(new java.awt.Color(13, 59, 102));
        editUpdatebtn.setText("Edit");
        editUpdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUpdatebtnActionPerformed(evt);
            }
        });

        Deletebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Deletebtn.setForeground(new java.awt.Color(13, 59, 102));
        Deletebtn.setText("Delete");
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });

        ClearBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(13, 59, 102));
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPannelLayout = new javax.swing.GroupLayout(btnPannel);
        btnPannel.setLayout(btnPannelLayout);
        btnPannelLayout.setHorizontalGroup(
            btnPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPannelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(btnPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(savebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(Deletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editUpdatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        btnPannelLayout.setVerticalGroup(
            btnPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPannelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(btnPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(savebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(editUpdatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(btnPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Deletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        loginPanel.setBackground(new java.awt.Color(13, 58, 102));

        Logoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Logoutbtn.setForeground(new java.awt.Color(13, 58, 102));
        Logoutbtn.setText("Logout");
        Logoutbtn.setHideActionText(true);
        Logoutbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PublicationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BooknamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CategoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(BooknamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PublicationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        RightMainpannel.setBackground(new java.awt.Color(255, 255, 255));

        TablePanel.setBackground(new java.awt.Color(255, 255, 255));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "BookName", "Publication", "Category", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table);

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        SearchPanel.setBackground(new java.awt.Color(255, 255, 255));

        SearchFiled.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        SearchFiled.setForeground(new java.awt.Color(13, 59, 102));
        SearchFiled.setText("Search");
        SearchFiled.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(13, 59, 102)));
        SearchFiled.setCaretColor(new java.awt.Color(13, 59, 102));
        SearchFiled.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchFiledFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchFiledFocusLost(evt);
            }
        });
        SearchFiled.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFiledKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchFiled))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchFiled, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout RightMainpannelLayout = new javax.swing.GroupLayout(RightMainpannel);
        RightMainpannel.setLayout(RightMainpannelLayout);
        RightMainpannelLayout.setHorizontalGroup(
            RightMainpannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RightMainpannelLayout.setVerticalGroup(
            RightMainpannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightMainpannelLayout.createSequentialGroup()
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(UserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(RightMainpannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RightMainpannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(MainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        try {
            // TODO add your handling code here:
            save();
        } catch (Exception ex) {
            showMessageDialog(ex.getMessage());
        }
    }//GEN-LAST:event_savebtnActionPerformed

    private void BookInputFiledFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BookInputFiledFocusGained
//         TODO add your handling code here:
        if (BookInputFiled.getText().equals("Enter Book Name")) {
            BookInputFiled.setText("");
        }

    }//GEN-LAST:event_BookInputFiledFocusGained

    private void BookInputFiledFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BookInputFiledFocusLost
//         TODO add your handling code here:
        if (BookInputFiled.getText().equals("")) {
            BookInputFiled.setText("Enter Book Name");
        }

    }//GEN-LAST:event_BookInputFiledFocusLost

    private void PublicationInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PublicationInputFocusGained
//         TODO add your handling code here:
        if (PublicationInput.getText().equals("Enter Publication Name")) {
            PublicationInput.setText("");
        }
    }//GEN-LAST:event_PublicationInputFocusGained

    private void PublicationInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PublicationInputFocusLost
        // TODO add your handling code here:
        if (PublicationInput.getText().equals("")) {
            PublicationInput.setText("Enter Publication Name");
        }
    }//GEN-LAST:event_PublicationInputFocusLost

    private void SearchFiledFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFiledFocusGained
        // TODO add your handling code here:
        if (SearchFiled.getText().equals("Search")) {
            SearchFiled.setText("");
        }
    }//GEN-LAST:event_SearchFiledFocusGained

    private void SearchFiledFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFiledFocusLost
        // TODO add your handling code here:
        if (SearchFiled.getText().equals("")) {
            SearchFiled.setText("Search");
        }
    }//GEN-LAST:event_SearchFiledFocusLost

    private void BookInputFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookInputFiledActionPerformed


    }//GEN-LAST:event_BookInputFiledActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void editUpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUpdatebtnActionPerformed
        try {
            // TODO add your handling code here:
            update();
        } catch (NumberFormatException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_editUpdatebtnActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(Deletebtn, "Are you sure want to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            remove();
        }
    }//GEN-LAST:event_DeletebtnActionPerformed

    private void LogoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutbtnActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(Logoutbtn, "Are you sure?");
        if (a == JOptionPane.YES_OPTION) {
            dispose();
            LoginForm obj = new LoginForm();
            obj.setTitle("Login Form");
            obj.setVisible(true);
        }
    }//GEN-LAST:event_LogoutbtnActionPerformed

    private void SearchFiledKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFiledKeyReleased
        try {
            // TODO add your handling code here:
            search();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_SearchFiledKeyReleased

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
            java.util.logging.Logger.getLogger(BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BooksUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookInputFiled;
    private javax.swing.JLabel BookNameLabel;
    private javax.swing.JPanel BooknamePanel;
    private javax.swing.JComboBox<String> CategoryChooes;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JPanel CategoryPanel;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JPanel Date;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JButton Logoutbtn;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel Publication;
    private javax.swing.JTextField PublicationInput;
    private javax.swing.JPanel PublicationPanel;
    private javax.swing.JPanel RightMainpannel;
    private javax.swing.JTextField SearchFiled;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JTable Table;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JPanel btnPannel;
    private javax.swing.JButton editUpdatebtn;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JButton savebtn;
    // End of variables declaration//GEN-END:variables

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void findAll() {

        model.setRowCount(0);
        try {
            List<Books> books = booksDao.findAll();
            for (Books book : books) {
                Object[] row = {book.getId(), book.getBookName(), book.getPublication(), book.getCategory(), book.getDate()};
                model.addRow(row);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }

    }
}
