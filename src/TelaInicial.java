
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TelaInicial extends JFrame implements ActionListener
{
    
    private ArrayList<JButton> flavours = new ArrayList<JButton>();
    
    private String[] saboresComuns = {"Tangerina", "Tapioca", "Maracujá", "Graviola"};
    private String[] saboresEspeciais = {"Ceu Azul", "Meia-noite", "Choque de Alegria", "Capa vermelha"};
    
    
    // --- BOTOES PRINCIPAIS
    JButton casquinha;
    JButton copo;
    JButton water;
    // -- BOTOES SECUNDARIOS
    JButton plusWater;
    
    ArrayList <JButton> saboresComunsButtons = new ArrayList<JButton>();
    ArrayList <JButton> saboresSecundariosButtons = new ArrayList<JButton>();
    // -- CHECKBOXES
    JRadioButton tamanhoAguaPequeno;
    JRadioButton tamanhoAguaGrande;
    JRadioButton semGas;
    JRadioButton comGas;
    
    
    //-- PANELS
    JPanel mainPanel;
    JPanel waterPanel;
    JPanel commonPanel;
    JPanel secondPanel;
    
    //Boxes
    Box mainBox;
   
    //-- GROUPS
    ButtonGroup typeWaterGroup;
    ButtonGroup typeGasGroup;
    
    static Produto produtoAtual; 
    
    public TelaInicial(){
        super("Tela Inicial - Seja Bem vindo!");        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setPreferredSize(new Dimension(640, 480));
        mainBox = Box.createVerticalBox();
        AddButtons();
        AddWaterCheckboxes();
        AddWaterPlus();
        AddFlavours();
        this.add(mainBox);
        this.pack();
        this.setVisible(true);
    }
    
    
    private void AddButtons(){
    	if(mainPanel == null) {
    		mainPanel = new JPanel();
    	}
       casquinha = new JButton("Casquinha");
       casquinha.setSize(250, 100);
       casquinha.addActionListener(this);
       casquinha.setActionCommand("Casquinha");
       mainPanel.add(casquinha);
       copo = new JButton("Copo");
       copo.setSize(250, 100);
       copo.addActionListener(this);
       copo.setActionCommand("Copo");
       mainPanel.add(copo);
       water = new JButton("Agua");
       water.setSize(250, 100);
       water.addActionListener(this);
       water.setActionCommand("Water");
       mainPanel.add(water);
       mainBox.add(mainPanel);
       
       
    }
    
    private void AddWaterCheckboxes(){
    	if(waterPanel == null) {
    		waterPanel = new JPanel();
    	}
    	if(typeWaterGroup == null) {
    		typeWaterGroup = new ButtonGroup();
    	}
    	if(tamanhoAguaPequeno == null) {
    		tamanhoAguaPequeno = new JRadioButton("Pequeno");
        	tamanhoAguaPequeno.setVisible(false);
        	waterPanel.add(tamanhoAguaPequeno);
        	typeWaterGroup.add(tamanhoAguaPequeno);
    	}
    	if(tamanhoAguaGrande == null) {
    		tamanhoAguaGrande = new JRadioButton("Grande");
        	tamanhoAguaGrande.setVisible(false);
        	waterPanel.add(tamanhoAguaGrande);
        	typeWaterGroup.add(tamanhoAguaGrande);
    	}
    	
    	if(typeGasGroup == null) {
    		typeGasGroup = new ButtonGroup();
    	}
    	if(semGas == null) {
    		semGas = new JRadioButton("S/Gás");
    		semGas.setVisible(false);
    		waterPanel.add(semGas);
    		typeGasGroup.add(semGas);
    	}
    	if(comGas == null) {
    		comGas = new JRadioButton("C/Gás");
    		comGas.setVisible(false);
    		waterPanel.add(comGas);
    		typeGasGroup.add(comGas);
    	}
    	
    	mainBox.add(waterPanel);
    }
    
    
    private void AddFlavours(){
    	if(commonPanel == null) {
    		commonPanel = new JPanel();
    	}
    	if(secondPanel == null) {
    		secondPanel = new JPanel();
    	}
    	for(String saborComum : saboresComuns) {
    		JButton comum = new JButton(saborComum);
    		//comum.addActionListener();
    		saboresComunsButtons.add(comum);
    		commonPanel.add(comum);
    		comum.setVisible(false);
    	}
    	for(String saborEspecial : saboresEspeciais) {
    		JButton especial = new JButton(saborEspecial);
    		//comum.addActionListener();
    		saboresSecundariosButtons.add(especial);
    		secondPanel.add(especial);
    		especial.setVisible(false);
    	}
    	
    	mainBox.add(commonPanel);
    	mainBox.add(secondPanel);
    }
    
    private void AddWaterPlus() {
    	plusWater = new JButton("+");
    	plusWater.addActionListener(new PlusAction());
    	plusWater.setActionCommand("addWater");
    	waterPanel.add(plusWater);
    	plusWater.setVisible(false);
    }
    
    private void ActivateWaterCommands() {
    	tamanhoAguaPequeno.setVisible(true);
    	tamanhoAguaGrande.setVisible(true);
    	semGas.setVisible(true);
    	comGas.setVisible(true);
    	plusWater.setVisible(true);
    }
    private void DisableWaterCommands() {
    	tamanhoAguaPequeno.setVisible(false);
    	tamanhoAguaGrande.setVisible(false);
    	semGas.setVisible(false);
    	comGas.setVisible(false);
    	plusWater.setVisible(false);
    }
    
    private void ActivateFlavours() {
    	for(JButton flavour : saboresComunsButtons) {
    		flavour.setVisible(true);
    	}
    	for(JButton flavour : saboresSecundariosButtons) {
    		flavour.setVisible(true);
    	}
    }
    private void DisableFlavours() {
    	for(JButton flavour : saboresComunsButtons) {
    		flavour.setVisible(false);
    	}
    	for(JButton flavour : saboresSecundariosButtons) {
    		flavour.setVisible(false);
    	}
    }
    
    public void actionPerformed(ActionEvent ae){
        String action = ae.getActionCommand();
        DisableWaterCommands();
        DisableFlavours();
        if(Pedido.getPedidoAtual() == null){
           new Pedido();
        }
        if(action.equals("Water")){
        	produtoAtual = new Agua();
        	tamanhoAguaPequeno.setSelected(true);
        	semGas.setSelected(true);
            ActivateWaterCommands();
        }
        else if(action.equals("Casquinha")) {
        	ActivateFlavours();
        }
    }
    
    //-------------------------------------Classes de ação-------------------------------
    
    private class PlusAction implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		switch(e.getActionCommand()) {
    			case "addWater":
    				Agua aguaAtual = (Agua)produtoAtual;
    				aguaAtual.SetAgua(tamanhoAguaGrande.isSelected() ? TamanhoAgua.GRANDE : TamanhoAgua.PEQUENO,
    				semGas.isSelected() ? TipoAgua.CONVENCIONAL : TipoAgua.GAS);
    				Pedido.getPedidoAtual().addProduto(aguaAtual);
    				produtoAtual = null;
    				DisableWaterCommands();
    			break;
    		}
    	}
    }
}
