
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
    JButton concludedBuying;
    // -- BOTOES SECUNDARIOS
    JButton plusWater;
    JButton plusIcecream;
    JButton plusCup;
    JButton concludedIcecream;
    
    ArrayList <JButton> saboresComunsButtons = new ArrayList<JButton>();
    ArrayList <JButton> saboresSecundariosButtons = new ArrayList<JButton>();
    // -- CHECKBOXES
    JRadioButton tamanhoAguaPequeno;
    JRadioButton tamanhoAguaGrande;
    JRadioButton semGas;
    JRadioButton comGas;
    JRadioButton tamanhoSorvetePequeno;
    JRadioButton tamanhoSorveteGrande;
    
    
    //-- PANELS
    JPanel mainPanel;
    JPanel waterPanel;
    JPanel commonPanel;
    JPanel secondPanel;
    JPanel typeIcecreamPanel;
    JPanel concludedIcecreamPanel;
    JPanel concludedBuyingPanel;
    JPanel pricePanel;
    
    //Boxes
    Box mainBox;
   
    //-- GROUPS
    ButtonGroup typeWaterGroup;
    ButtonGroup typeGasGroup;
    ButtonGroup typeIcecreamGroup;
    
    //-- LABELS
    JLabel totalLabel;
    
    static Produto produtoAtual; 
    
    public TelaInicial(){
        super("Tela Inicial - Seja Bem vindo!");        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setPreferredSize(new Dimension(640, 480));
        mainBox = Box.createVerticalBox();
        AddButtons();
        AddWaterCheckboxes();
        AddWaterPlus();
        AddIcecreamCheckboxes();
        AddIcecreamPlus();
        AddFlavours();
        AddConcludedIcecreamPanel();
        addTotalLabel();
        AddConcludedButton();
        this.add(mainBox);
        this.pack();
        this.setVisible(true);
     
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	if(JOptionPane.showConfirmDialog(mainPanel,"Total de caixa apurado" + Pedido.FinalizarCaixa(), "Deseja sair? ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            		System.exit(0);
            	}
            }
        });
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
    
    private void AddConcludedButton() {
    	if(concludedBuyingPanel == null) {
    		concludedBuyingPanel = new JPanel();
    	}
    	if(concludedBuying == null) {
    		concludedBuying = new JButton("Pedido Concluido");
    		concludedBuying.addActionListener(this);
    		concludedBuying.setActionCommand("Concluded");
    	}
    	concludedBuyingPanel.add(concludedBuying);
    	mainBox.add(concludedBuyingPanel);
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
    
    private void AddIcecreamCheckboxes() {
    	if(typeIcecreamPanel == null) {
    		typeIcecreamPanel = new JPanel();
    	}
    	if(typeIcecreamGroup == null) {
    		typeIcecreamGroup = new ButtonGroup();
    	}
    	if( tamanhoSorvetePequeno == null) {
    		tamanhoSorvetePequeno = new JRadioButton("");
    		tamanhoSorvetePequeno.setVisible(false);
    		typeIcecreamPanel.add(tamanhoSorvetePequeno);
    		typeIcecreamGroup.add(tamanhoSorvetePequeno);
    	}
    	if(tamanhoSorveteGrande == null) {
    		tamanhoSorveteGrande = new JRadioButton("");
    		tamanhoSorveteGrande.setVisible(false);
    		typeIcecreamPanel.add(tamanhoSorveteGrande);
    		typeIcecreamGroup.add(tamanhoSorveteGrande);
    	}
    	
    	mainBox.add(typeIcecreamPanel);
    }
    
    private void AddConcludedIcecreamPanel() {
    	if(concludedIcecreamPanel == null) {
    		concludedIcecreamPanel = new JPanel();
    	}
    	concludedIcecream = new JButton("Escolhi");
    	concludedIcecream.setEnabled(false);
    	concludedIcecream.setVisible(false);
    	concludedIcecream.addActionListener(new PlusAction());
    	concludedIcecream.setActionCommand("concludedIcecream");
    	concludedIcecreamPanel.add(concludedIcecream);
    	mainBox.add(concludedIcecreamPanel);
    }
    
    private void addTotalLabel() {
    	if(pricePanel == null) {
    		pricePanel = new JPanel();
    	}
    	if(totalLabel == null) {
    		totalLabel = new JLabel("Total: ");
    		totalLabel.setForeground(Color.RED);
    		totalLabel.setFont(new Font("Serif", Font.PLAIN, 20));
    	}
    	pricePanel.add(totalLabel);
    	mainBox.add(pricePanel);
    }
    
    private void updateTotalLabel() {
    	if(Pedido.getPedidoAtual() != null) {
    		totalLabel.setText("Total: " + Pedido.getPedidoAtual().atribuirValorTotal());
    	}
    	else {
    		totalLabel.setText("Total: ");
    	}
    	
    }
    
    private void enableConcludedIcecream() {
    	concludedIcecream.setEnabled(true);
    }
    private void disableConcludedIcecream() {
    	concludedIcecream.setEnabled(false);
    }
    
    private void enableIcecreamBoxes(boolean casquinha){
    	if(casquinha) {
    		tamanhoSorvetePequeno.setText("casquinha");
    		tamanhoSorveteGrande.setText("Cascão");
    		plusIcecream.setVisible(true);
    	}
    	else {
    		tamanhoSorvetePequeno.setText("Copo pequeno");
    		tamanhoSorveteGrande.setText("Copo grande");
    		plusCup.setVisible(true);
    	}
    	tamanhoSorvetePequeno.setVisible(true);
    	tamanhoSorveteGrande.setVisible(true);
    
    }
    
    private void disableIcecreamBoxes() {
    	plusIcecream.setVisible(false);
    	plusCup.setVisible(false);
    	tamanhoSorvetePequeno.setVisible(false);
    	tamanhoSorveteGrande.setVisible(false);
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
    		comum.addActionListener(new FlavourAction());
    		comum.setActionCommand("AddComum" + "&" + saborComum);
    		saboresComunsButtons.add(comum);
    		commonPanel.add(comum);
    		comum.setVisible(false);
    	}
    	for(String saborEspecial : saboresEspeciais) {
    		JButton especial = new JButton(saborEspecial);
    		especial.addActionListener(new FlavourAction());
    		especial.setActionCommand("AddEspecial" + "&" + saborEspecial);
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
    
    private void AddIcecreamPlus() {
    	plusIcecream = new JButton("+");
    	plusIcecream.setVisible(false);
    	plusIcecream.addActionListener(new PlusAction());
    	plusIcecream.setActionCommand("addCasquinha");
    	typeIcecreamPanel.add(plusIcecream);
    	plusCup = new JButton("+");
    	plusCup.setVisible(false);
    	plusCup.addActionListener(new PlusAction());
    	plusCup.setActionCommand("addCopo");
    	typeIcecreamPanel.add(plusCup);
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
    		flavour.setEnabled(true);
    	}
    	for(JButton flavour : saboresSecundariosButtons) {
    		flavour.setVisible(true);
    		flavour.setEnabled(true);
    	}
    	
    	concludedIcecream.setVisible(true);
    }
    private void DisableFlavours() {
    	for(JButton flavour : saboresComunsButtons) {
    		flavour.setVisible(false);
    	}
    	for(JButton flavour : saboresSecundariosButtons) {
    		flavour.setVisible(false);
    	}
    	
    	concludedIcecream.setVisible(false);
    	disableConcludedIcecream();
    }
    
    public void actionPerformed(ActionEvent ae){
        String action = ae.getActionCommand();
        DisableWaterCommands();
        DisableFlavours();
        disableIcecreamBoxes();
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
        	//ActivateFlavours();
        	enableIcecreamBoxes(true);
        }
        else if(action.equals("Copo")) {
        	//ActivateFlavours();
        	enableIcecreamBoxes(false);
        }
        else if(action.equals("Concluded")) {
        	Pedido.finalizarPedido();
        	updateTotalLabel();
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
    			case "addCasquinha":
    				produtoAtual = new Casquinha(tamanhoSorvetePequeno.isSelected() ? TamanhoSorvete.PEQUENO : TamanhoSorvete.GRANDE);
    				ActivateFlavours();
    			break;
    			case "addCopo":
    				produtoAtual = new Copo(tamanhoSorvetePequeno.isSelected() ? TamanhoSorvete.PEQUENO : TamanhoSorvete.GRANDE);
    				ActivateFlavours();
    			break;
    			case "concludedIcecream":
    				Pedido.getPedidoAtual().addProduto(produtoAtual);
    				produtoAtual = null;
    				DisableFlavours();
    				disableIcecreamBoxes();
    			break;
    		}
    		updateTotalLabel();
    	}
    }
    
    
    private class FlavourAction implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String[] flavourCommands = e.getActionCommand().split("&");
    		Sorvete sorveteAtual = (Sorvete) produtoAtual;
			Sabor novoSabor = new Sabor();
    		switch (flavourCommands[0]) {
    			case "AddComum":
    				novoSabor.setSabor(TipoSabor.CONVENCIONAL, flavourCommands[1]);
    				
    			break;
    			case "AddEspecial":
    				novoSabor.setSabor(TipoSabor.ESPECIAL, flavourCommands[1]);
    			break;
    		}
    		if(sorveteAtual.addSabor(novoSabor)){
				Pedido.getPedidoAtual().addProduto(novoSabor);
				JButton cmd = (JButton)e.getSource();
				cmd.setEnabled(false);
			};
			if(sorveteAtual.isFull()) {
				enableConcludedIcecream();
			}
			updateTotalLabel();
    	}
    }
}
