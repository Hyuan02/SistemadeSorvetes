
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Classe que representa a Tela do Sistema.
 * @author hyuan
 * @version (V1)
 */
public class TelaInicial extends JFrame implements ActionListener
{
    /**
     * Array que contem os nomes dos sabores "comuns" da sorveteria.
     */
    private String[] saboresComuns = {"Tangerina", "Tapioca", "Maracujá", "Graviola"};
    /**
     * Array que contem os nomes dos sabores "especiais" da sorveteria.
     */
    private String[] saboresEspeciais = {"Ceu Azul", "Meia-noite", "Choque de Alegria", "Capa vermelha"};
    
    
    // --- BOTOES PRINCIPAIS
    /**
     * Botão que simboliza a opção de casquinha.
     */
    JButton casquinha;
    /**
     * Botão que simboliza a opção de copo.
     */
    JButton copo;
    /**
     * Botão que simboliza a opção de agua.
     */
    JButton water;
    /**
     * Botão que simboliza a opção de concluir pedido.
     */
    JButton concludedBuying;
    // -- BOTOES SECUNDARIOS
    /**
     * Botão de adição de água.
     */
    JButton plusWater;
    /**
     * Botão de adição de sorvete de casquinha.
     */
    JButton plusIcecream;
    /**
     * Botão de adição de sorvete de copo
     */
    JButton plusCup;
    /**
     * Botão de conclusão de compra de sorvete.
     */
    JButton concludedIcecream;
    
    /**
     * Array que armazena os botões de sabor comum.
     */
    ArrayList <JButton> saboresComunsButtons = new ArrayList<JButton>();
    /**
     * Array que armazena os botões de sabor especial.
     */
    ArrayList <JButton> saboresSecundariosButtons = new ArrayList<JButton>();
    // -- CHECKBOXES
    /**
     * Radio para opcao de agua pequena.
     */
    JRadioButton tamanhoAguaPequeno;
    /**
     * Radio para opcao de agua grande.
     */
    JRadioButton tamanhoAguaGrande;
    /**
     * Radio para opcao de agua sem gas.
     */
    JRadioButton semGas;
    /**
     * Radio para opcao de agua com gas
     */
    JRadioButton comGas;
    /**
     * Radio para opcao de sorvete pequeno.
     */
    JRadioButton tamanhoSorvetePequeno;
    /**
     * Radio para opcao de sorvete grande.
     */
    JRadioButton tamanhoSorveteGrande;
    
    
    //-- PANELS
    /**
     * Painel principal.
     */
    JPanel mainPanel;
    /**
     * Painel para opcoes de agua.
     */
    JPanel waterPanel;
    /**
     * Painel para sabores comuns.
     */
    JPanel commonPanel;
    /**
     * Painel para sabores especiais.
     */
    JPanel secondPanel;
    /**
     * Painel que guarda opcoes de sorvete.
     */
    JPanel typeIcecreamPanel;
    /**
     * Painel para botao de concluido do sorvete.
     */
    JPanel concludedIcecreamPanel;
    /**
     * Painel para opcao de conclusao do pedido.
     */
    JPanel concludedBuyingPanel;
    /**
     * Painel para label de total do pedido.
     */
    JPanel pricePanel;
    
    //Boxes
    /**
     * Box para organizacao do layout.
     */
    Box mainBox;
   
    //-- GROUPS
    /**
     * Group de botoes de radio de agua.
     */
    ButtonGroup typeWaterGroup;
    /**
     * Group de botoes de radio de tipo de agua.
     */
    ButtonGroup typeGasGroup;
    /**
     * Group de bototes de radio de tipo de sorvete.
     */
    ButtonGroup typeIcecreamGroup;
    
    //-- LABELS
    /**
     * Label do total do pedido.
     */
    JLabel totalLabel;
    
    /**
     * Referencia para o produto atual a ser comprado.
     */
    static Produto produtoAtual; 
    
    /**
     * Inicia os componentes da tela.
     */
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
     
        
        this.addWindowListener(new java.awt.event.WindowAdapter() { // Adiciona um listener para caso o usuario queira fechar a aplicação.
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	if(JOptionPane.showConfirmDialog(mainPanel,"Total de caixa apurado" + Pedido.FinalizarCaixa(), "Deseja sair? ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            		System.exit(0);
            	}
            }
        });
    }
    
    
    
    
    /**
     * Adiciona botoes principais.
     */
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
    /**
     * Adiciona botao de concluir pedido.
     */
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
    /**
     * Adiciona checkboxes de agua.
     */
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
    /**
     * Adiciona checkboxes de sorvete.
     */
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
    /**
     * Adiciona botao de concluir sorvete.
     */
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
    /**
     * Adiciona label de total do pedido. 
     */
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
    /**
     * Atualiza texto do label.
     */
    private void updateTotalLabel() {
    	if(Pedido.getPedidoAtual() != null) { //Só adiciona total caso exista pedido.
    		totalLabel.setText("Total: " + Pedido.getPedidoAtual().atribuirValorTotal());
    	}
    	else {
    		totalLabel.setText("Total: ");
    	}
    	
    }
    /**
     * Ativa botao de concluir sorvete.
     */
    private void enableConcludedIcecream() {
    	concludedIcecream.setEnabled(true);
    }
    /**
     * Desativa botao de concluir sorvete.
     */
    private void disableConcludedIcecream() {
    	concludedIcecream.setEnabled(false);
    }
    /**
     * Mostra radios de sorvete e modifica texto.
     * @param casquinha - Caso o sorvete seja casquinha.
     */
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
    /**
     * Esconde radios de sorvete.
     */
    private void disableIcecreamBoxes() {
    	plusIcecream.setVisible(false);
    	plusCup.setVisible(false);
    	tamanhoSorvetePequeno.setVisible(false);
    	tamanhoSorveteGrande.setVisible(false);
    }
    /**
     * Adiciona botoes de sabor.
     */
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
    
    /**
     * Adiciona botao de adicionar agua.
     */
    private void AddWaterPlus() {
    	plusWater = new JButton("+");
    	plusWater.addActionListener(new PlusAction());
    	plusWater.setActionCommand("addWater");
    	waterPanel.add(plusWater);
    	plusWater.setVisible(false);
    }
    /**
     * Adiciona botao de adicionar sorvete.
     */
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
  
    /**
     * Mostra opcoes de escolha de agua.
     */
    private void ActivateWaterCommands() {
    	tamanhoAguaPequeno.setVisible(true);
    	tamanhoAguaGrande.setVisible(true);
    	semGas.setVisible(true);
    	comGas.setVisible(true);
    	plusWater.setVisible(true);
    }
    /**
     * Esconde opcoes de escolha de agua.
     */
    private void DisableWaterCommands() {
    	tamanhoAguaPequeno.setVisible(false);
    	tamanhoAguaGrande.setVisible(false);
    	semGas.setVisible(false);
    	comGas.setVisible(false);
    	plusWater.setVisible(false);
    }
    /**
     * Ativa botoes de sabor.
     */
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
    /**
     * Esconde botes de sabor.
     */
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
    
    /**
     * Metodo que chama função de um botão principal na interface.
     */
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
    
    /**
     * Metodo que chama função de um botão de adicionar ou concluir pedido na interface.
     * @author hyuan
     *
     */
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
    
    /**
     * Metodo que chama função de um botão de sabor.
     * @author hyuan
     *
     */
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
