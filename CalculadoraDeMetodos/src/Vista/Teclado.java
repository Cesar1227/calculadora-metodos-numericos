/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Tecla.TeclaFuncion;
import Visor.Visor;

/**
 *
 * @author cesit
 */
public class Teclado extends javax.swing.JPanel {

    /**
     * Creates new form Teclado
     */
    TeclaFuncion[] lteclas; //teclas
    TeclaFuncion tecla;
    private final int nTeclas = 26;
    Visor visor;
    String[] texto;
    TeclaFuncion[] funcion; //funcion escrita
    int cont;
    public final int tam = 30;
    private int pos = 0;

    public Teclado() {
        initComponents();
        TeclaFuncion tf = new TeclaFuncion();
        tf.setSize(100, 100);
        this.add(tf).setLocation(100, 100);
        this.tecladoInit();
    }

    //Establecer parametros para inicializar el teclado
    public void tecladoInit() {
        cont = 0;
        texto = new String[tam];
        funcion = new TeclaFuncion[tam];
        //this.generarTeclado();
    }

    private void digitar(TeclaFuncion tf) {
        if (tf.getTipo().equals("N")) {
            if (this.digitNum(tf)) {
                this.visualizar();
            }
        } else if (tf.getTipo().equals("O")) {
            if (this.digitOper(tf)) {
                this.visualizar();
            }
        } else if (tf.getTipo().equals("C")) {
            if (this.digitConstante(tf)) {
                this.visualizar();
            }
        } else if (tf.getTipo().equals("I")) {
            if (this.digitIncognita(tf)) {
                this.visualizar();
            }
        } else if (tf.getTipo().equals("P")) {
            if (this.digitParentesis(tf)) {
                this.visualizar();
            }
        }
    }

    private boolean digitNum(TeclaFuncion tf) {
        TeclaFuncion tfAux = new TeclaFuncion();
        tfAux.setTipo("N");
        if (cont > 0) {
            if (funcion[cont - 1].getTipo().equals("N")) {
                tfAux.setText(funcion[cont - 1].getText() + tf.getText());
                funcion[cont - 1] = tfAux;
                texto[cont - 1] = tfAux.getText();
                return true;
            } else {
                funcion[cont] = tf;
                texto[cont] = tf.getText();
                cont++;
                return true;
            }
        } else {
            funcion[cont] = tf;
            texto[cont] = tf.getText();
            System.out.println(tf.getText());
            cont++;
            return true;
        }
    }

    private boolean digitConstante(TeclaFuncion tf) {
        if (cont > 0) {
            if (funcion[cont - 1].getTipo().equals("O")) {
                funcion[cont] = tf;
                texto[cont] = tf.getText();
                cont++;
                return true;
            } else {
                return false;
            }
        } else {
            funcion[cont] = tf;
            texto[cont] = tf.getText();
            cont++;
            return true;
        }
    }

    private boolean digitOper(TeclaFuncion tf) {
        if (cont > 0) {
            if (funcion[cont - 1].getTipo().equals("O")) {
                return false;
            } else {
                funcion[cont] = tf;
                texto[cont] = tf.getText();
                cont++;
                return true;
            }
        } else {
            return false;
        }
    }

    private boolean digitParentesis(TeclaFuncion tf) {
        if (cont > 0) {
            if (funcion[cont - 1].getTipo().equals("O") || funcion[cont - 1].getTipo().equals("P")) {
                funcion[cont] = tf;
                texto[cont] = tf.getText();
                cont++;
                return true;
            } else {
                return false;
            }
        } else {
            funcion[cont] = tf;
            texto[cont] = tf.getText();
            cont++;
            return true;
        }
    }

    private boolean digitIncognita(TeclaFuncion tf) {
        if (cont > 0) {
            if (funcion[cont - 1].getTipo().equals("O")) {
                funcion[cont] = tf;
                texto[cont] = tf.getText();
                cont++;
                return true;
            } else {
                return false;
            }
        } else {
            funcion[cont] = tf;
            texto[cont] = tf.getText();
            cont++;
            return true;
        }
    }

    private void visualizar() {
        visor.ingresar(texto, cont);
    }

    private void clear() {
        int i = 0;
        while (i <= cont) {
            funcion[i] = null;
            texto[i] = null;
            i++;
        }
        cont = 0;
        visor.ingresar(texto, -1);
    }

    private void borrar() {

        if (cont > 0) {
            funcion[cont - 1] = null;
            texto[cont - 1] = null;
            cont--;
            this.visualizar();
        }
    }

    public Visor getVisor() {
        return visor;
    }

    public void setVisor(Visor visor) {
        this.visor = visor;
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
        pnlNumerico = new javax.swing.JPanel();
        tecla9 = new Tecla.TeclaFuncion();
        tecla8 = new Tecla.TeclaFuncion();
        tecla7 = new Tecla.TeclaFuncion();
        tecla6 = new Tecla.TeclaFuncion();
        tecla5 = new Tecla.TeclaFuncion();
        tecla4 = new Tecla.TeclaFuncion();
        tecla3 = new Tecla.TeclaFuncion();
        tecla2 = new Tecla.TeclaFuncion();
        tecla1 = new Tecla.TeclaFuncion();
        tecla0 = new Tecla.TeclaFuncion();
        teclaPunto = new Tecla.TeclaFuncion();
        teclaBorrar = new Tecla.TeclaFuncion();
        pnlFunciones = new javax.swing.JPanel();
        teclaRaiz = new Tecla.TeclaFuncion();
        teclaLog10 = new Tecla.TeclaFuncion();
        teclaLNatural = new Tecla.TeclaFuncion();
        teclaEuler = new Tecla.TeclaFuncion();
        teclaAbrirP = new Tecla.TeclaFuncion();
        teclaCerrarP = new Tecla.TeclaFuncion();
        teclaPotencia = new Tecla.TeclaFuncion();
        teclaDivision = new Tecla.TeclaFuncion();
        teclaProducto = new Tecla.TeclaFuncion();
        teclaSuma = new Tecla.TeclaFuncion();
        teclaResta = new Tecla.TeclaFuncion();
        teclaX = new Tecla.TeclaFuncion();
        teclaA = new Tecla.TeclaFuncion();
        teclaB = new Tecla.TeclaFuncion();
        teclaC = new Tecla.TeclaFuncion();
        teclaClear = new Tecla.TeclaFuncion();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(102, 102, 102));
        setOpaque(false);

        pnlNumerico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlNumerico.setLayout(new java.awt.GridLayout(3, 5, 1, 1));

        tecla9.setBackground(new java.awt.Color(240, 240, 240));
        tecla9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla9.setForeground(new java.awt.Color(0, 0, 0));
        tecla9.setText("9");
        tecla9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla9.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla9.setTipo("N");
        tecla9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla9MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla9);

        tecla8.setBackground(new java.awt.Color(240, 240, 240));
        tecla8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla8.setForeground(new java.awt.Color(0, 0, 0));
        tecla8.setText("8");
        tecla8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla8.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla8.setTipo("N");
        tecla8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla8MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla8);

        tecla7.setBackground(new java.awt.Color(240, 240, 240));
        tecla7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla7.setForeground(new java.awt.Color(0, 0, 0));
        tecla7.setText("7");
        tecla7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla7.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla7.setTipo("N");
        tecla7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla7MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla7);

        tecla6.setBackground(new java.awt.Color(240, 240, 240));
        tecla6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla6.setForeground(new java.awt.Color(0, 0, 0));
        tecla6.setText("6");
        tecla6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla6.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla6.setTipo("N");
        tecla6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla6MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla6);

        tecla5.setBackground(new java.awt.Color(240, 240, 240));
        tecla5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla5.setForeground(new java.awt.Color(0, 0, 0));
        tecla5.setText("5");
        tecla5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla5.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla5.setTipo("N");
        tecla5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla5MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla5);

        tecla4.setBackground(new java.awt.Color(240, 240, 240));
        tecla4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla4.setForeground(new java.awt.Color(0, 0, 0));
        tecla4.setText("4");
        tecla4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla4.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla4.setTipo("N");
        tecla4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla4MouseClicked(evt);
            }
        });
        tecla4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecla4ActionPerformed(evt);
            }
        });
        pnlNumerico.add(tecla4);

        tecla3.setBackground(new java.awt.Color(240, 240, 240));
        tecla3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla3.setForeground(new java.awt.Color(0, 0, 0));
        tecla3.setText("3");
        tecla3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla3.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla3.setTipo("N");
        tecla3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla3MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla3);

        tecla2.setBackground(new java.awt.Color(240, 240, 240));
        tecla2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla2.setForeground(new java.awt.Color(0, 0, 0));
        tecla2.setText("2");
        tecla2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla2.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla2.setTipo("N");
        tecla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla2MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla2);

        tecla1.setBackground(new java.awt.Color(240, 240, 240));
        tecla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla1.setForeground(new java.awt.Color(0, 0, 0));
        tecla1.setText("1");
        tecla1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla1.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla1.setTipo("N");
        tecla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla1MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla1);

        tecla0.setBackground(new java.awt.Color(240, 240, 240));
        tecla0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        tecla0.setForeground(new java.awt.Color(0, 0, 0));
        tecla0.setText("0");
        tecla0.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        tecla0.setPreferredSize(new java.awt.Dimension(50, 50));
        tecla0.setTipo("N");
        tecla0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecla0MouseClicked(evt);
            }
        });
        pnlNumerico.add(tecla0);

        teclaPunto.setBackground(new java.awt.Color(240, 240, 240));
        teclaPunto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaPunto.setForeground(new java.awt.Color(0, 0, 0));
        teclaPunto.setText(".");
        teclaPunto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        teclaPunto.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaPunto.setTipo("P");
        teclaPunto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaPuntoMouseClicked(evt);
            }
        });
        pnlNumerico.add(teclaPunto);

        teclaBorrar.setBackground(new java.awt.Color(240, 240, 240));
        teclaBorrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        teclaBorrar.setForeground(new java.awt.Color(0, 0, 0));
        teclaBorrar.setText("<--");
        teclaBorrar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        teclaBorrar.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaBorrarMouseClicked(evt);
            }
        });
        pnlNumerico.add(teclaBorrar);

        pnlFunciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFunciones.setLayout(new java.awt.GridLayout(4, 5, 1, 1));

        teclaRaiz.setBackground(new java.awt.Color(240, 240, 240));
        teclaRaiz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaRaiz.setForeground(new java.awt.Color(5, 5, 5));
        teclaRaiz.setText("raizCuadra(x)");
        teclaRaiz.setPreferredSize(new java.awt.Dimension(50, 50));
        pnlFunciones.add(teclaRaiz);

        teclaLog10.setBackground(new java.awt.Color(240, 240, 240));
        teclaLog10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaLog10.setForeground(new java.awt.Color(5, 5, 5));
        teclaLog10.setText("log10(x)");
        teclaLog10.setPreferredSize(new java.awt.Dimension(50, 50));
        pnlFunciones.add(teclaLog10);

        teclaLNatural.setBackground(new java.awt.Color(240, 240, 240));
        teclaLNatural.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaLNatural.setForeground(new java.awt.Color(5, 5, 5));
        teclaLNatural.setText("Ln(x)");
        teclaLNatural.setPreferredSize(new java.awt.Dimension(50, 50));
        pnlFunciones.add(teclaLNatural);

        teclaEuler.setBackground(new java.awt.Color(240, 240, 240));
        teclaEuler.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaEuler.setForeground(new java.awt.Color(5, 5, 5));
        teclaEuler.setText("e");
        teclaEuler.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaEuler.setTipo("C");
        teclaEuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaEulerMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaEuler);

        teclaAbrirP.setBackground(new java.awt.Color(240, 240, 240));
        teclaAbrirP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaAbrirP.setForeground(new java.awt.Color(5, 5, 5));
        teclaAbrirP.setText("(");
        teclaAbrirP.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaAbrirP.setTipo("P");
        teclaAbrirP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaAbrirPMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaAbrirP);

        teclaCerrarP.setBackground(new java.awt.Color(240, 240, 240));
        teclaCerrarP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaCerrarP.setForeground(new java.awt.Color(5, 5, 5));
        teclaCerrarP.setText(")");
        teclaCerrarP.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaCerrarP.setTipo("P");
        teclaCerrarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaCerrarPMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaCerrarP);

        teclaPotencia.setBackground(new java.awt.Color(240, 240, 240));
        teclaPotencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaPotencia.setForeground(new java.awt.Color(5, 5, 5));
        teclaPotencia.setText("^");
        teclaPotencia.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaPotencia.setTipo("O");
        teclaPotencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaPotenciaMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaPotencia);

        teclaDivision.setBackground(new java.awt.Color(240, 240, 240));
        teclaDivision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaDivision.setForeground(new java.awt.Color(5, 5, 5));
        teclaDivision.setText("/");
        teclaDivision.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaDivision.setTipo("O");
        teclaDivision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaDivisionMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaDivision);

        teclaProducto.setBackground(new java.awt.Color(240, 240, 240));
        teclaProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaProducto.setForeground(new java.awt.Color(5, 5, 5));
        teclaProducto.setText("*");
        teclaProducto.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaProducto.setTipo("O");
        teclaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaProductoMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaProducto);

        teclaSuma.setBackground(new java.awt.Color(240, 240, 240));
        teclaSuma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaSuma.setForeground(new java.awt.Color(5, 5, 5));
        teclaSuma.setText("+");
        teclaSuma.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaSuma.setTipo("O");
        teclaSuma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaSumaMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaSuma);

        teclaResta.setBackground(new java.awt.Color(240, 240, 240));
        teclaResta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaResta.setForeground(new java.awt.Color(5, 5, 5));
        teclaResta.setText("-");
        teclaResta.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaResta.setTipo("O");
        teclaResta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaRestaMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaResta);

        teclaX.setBackground(new java.awt.Color(240, 240, 240));
        teclaX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaX.setForeground(new java.awt.Color(5, 5, 5));
        teclaX.setText("X");
        teclaX.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaX.setTipo("I");
        teclaX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaXMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaX);

        teclaA.setBackground(new java.awt.Color(240, 240, 240));
        teclaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaA.setForeground(new java.awt.Color(5, 5, 5));
        teclaA.setText("A");
        teclaA.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaA.setTipo("I");
        pnlFunciones.add(teclaA);

        teclaB.setBackground(new java.awt.Color(240, 240, 240));
        teclaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaB.setForeground(new java.awt.Color(5, 5, 5));
        teclaB.setText("B");
        teclaB.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaB.setTipo("I");
        pnlFunciones.add(teclaB);

        teclaC.setBackground(new java.awt.Color(240, 240, 240));
        teclaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 86)));
        teclaC.setForeground(new java.awt.Color(5, 5, 5));
        teclaC.setText("C");
        teclaC.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaC.setTipo("I");
        pnlFunciones.add(teclaC);

        teclaClear.setBackground(new java.awt.Color(240, 240, 240));
        teclaClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 86, 68)));
        teclaClear.setForeground(new java.awt.Color(0, 0, 0));
        teclaClear.setText("CLEAR");
        teclaClear.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        teclaClear.setPreferredSize(new java.awt.Dimension(50, 50));
        teclaClear.setTipo("");
        teclaClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teclaClearMouseClicked(evt);
            }
        });
        pnlFunciones.add(teclaClear);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNumerico, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(pnlNumerico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tecla4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tecla4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tecla4ActionPerformed

    private void tecla0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla0MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla0MouseClicked

    private void tecla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla1MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla1MouseClicked

    private void tecla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla2MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla2MouseClicked

    private void tecla3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla3MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla3MouseClicked

    private void tecla4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla4MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla4MouseClicked

    private void tecla5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla5MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla5MouseClicked

    private void tecla6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla6MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla6MouseClicked

    private void tecla7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla7MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla7MouseClicked

    private void tecla8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla8MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla8MouseClicked

    private void tecla9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tecla9MouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_tecla9MouseClicked

    private void teclaRestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaRestaMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaRestaMouseClicked

    private void teclaSumaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaSumaMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaSumaMouseClicked

    private void teclaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaProductoMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaProductoMouseClicked

    private void teclaDivisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaDivisionMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaDivisionMouseClicked

    private void teclaClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaClearMouseClicked
        this.clear();
    }//GEN-LAST:event_teclaClearMouseClicked

    private void teclaBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaBorrarMouseClicked
        this.borrar();
    }//GEN-LAST:event_teclaBorrarMouseClicked

    private void teclaPuntoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaPuntoMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaPuntoMouseClicked

    private void teclaPotenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaPotenciaMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaPotenciaMouseClicked

    private void teclaAbrirPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaAbrirPMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaAbrirPMouseClicked

    private void teclaCerrarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaCerrarPMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaCerrarPMouseClicked

    private void teclaEulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaEulerMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaEulerMouseClicked

    private void teclaXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teclaXMouseClicked
        this.digitar((TeclaFuncion) evt.getComponent());
    }//GEN-LAST:event_teclaXMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlFunciones;
    private javax.swing.JPanel pnlNumerico;
    private Tecla.TeclaFuncion tecla0;
    private Tecla.TeclaFuncion tecla1;
    private Tecla.TeclaFuncion tecla2;
    private Tecla.TeclaFuncion tecla3;
    private Tecla.TeclaFuncion tecla4;
    private Tecla.TeclaFuncion tecla5;
    private Tecla.TeclaFuncion tecla6;
    private Tecla.TeclaFuncion tecla7;
    private Tecla.TeclaFuncion tecla8;
    private Tecla.TeclaFuncion tecla9;
    private Tecla.TeclaFuncion teclaA;
    private Tecla.TeclaFuncion teclaAbrirP;
    private Tecla.TeclaFuncion teclaB;
    private Tecla.TeclaFuncion teclaBorrar;
    private Tecla.TeclaFuncion teclaC;
    private Tecla.TeclaFuncion teclaCerrarP;
    private Tecla.TeclaFuncion teclaClear;
    private Tecla.TeclaFuncion teclaDivision;
    private Tecla.TeclaFuncion teclaEuler;
    private Tecla.TeclaFuncion teclaLNatural;
    private Tecla.TeclaFuncion teclaLog10;
    private Tecla.TeclaFuncion teclaPotencia;
    private Tecla.TeclaFuncion teclaProducto;
    private Tecla.TeclaFuncion teclaPunto;
    private Tecla.TeclaFuncion teclaRaiz;
    private Tecla.TeclaFuncion teclaResta;
    private Tecla.TeclaFuncion teclaSuma;
    private Tecla.TeclaFuncion teclaX;
    // End of variables declaration//GEN-END:variables
}
