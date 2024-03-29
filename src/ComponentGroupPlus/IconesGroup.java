package ComponentGroupPlus;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;

public class IconesGroup {

	// Diretorio padr�o dos icones
		public static final String DIR_ICONES = "Icones/";

	// icones botoes 20x20
	private ImageIcon iconePesquisar = new ImageIcon(DIR_ICONES+"search.png");
	private ImageIcon iconeSalvar = new ImageIcon(DIR_ICONES+"save.png");
	private ImageIcon iconeLimpar = new ImageIcon(DIR_ICONES+"limpar.png");
	private ImageIcon iconeExcluir = new ImageIcon(DIR_ICONES+"delete.png");
	private ImageIcon iconeAlterar = new ImageIcon(DIR_ICONES+"atualizar.png");
	private ImageIcon iconeDoc = new ImageIcon(DIR_ICONES+"doc.png");
	private ImageIcon iconeAta = new ImageIcon(DIR_ICONES+"ata2.png");
	private ImageIcon iconeCaixa = new ImageIcon(DIR_ICONES+"caixa.png");
	private ImageIcon iconeBox = new ImageIcon(DIR_ICONES+"box2.jpg");
	private ImageIcon iconeCancelar = new ImageIcon(DIR_ICONES+"cancel.png");
	private ImageIcon iconeInserir = new ImageIcon(DIR_ICONES+"inserir.png");
	private ImageIcon iconeRetirar = new ImageIcon(DIR_ICONES+"retirar.png");
	private ImageIcon icone = new ImageIcon(DIR_ICONES+"ico.ico");
	private ImageIcon imageAbout = new ImageIcon(DIR_ICONES+"about.png");
	
	// Icones principais 32x32
	private ImageIcon iconeAluno = new ImageIcon(DIR_ICONES+"aluno.png");
	private ImageIcon iconeAta32x = new ImageIcon(DIR_ICONES+"ata.png");
	private ImageIcon iconeArquivo = new ImageIcon(DIR_ICONES+"arquivo.png");

	public boolean dirExist() {
		File file = new File(DIR_ICONES);
		return file.exists();
	}
	
	public ImageIcon getIconeInserir() {
		return iconeInserir;
	}
	public void setIconeInserir(ImageIcon iconeInserir) {
		this.iconeInserir = iconeInserir;
	}
	public ImageIcon getIconeRetirar() {
		return iconeRetirar;
	}
	public void setIconeRetirar(ImageIcon iconeRetirar) {
		this.iconeRetirar = iconeRetirar;
	}
	public ImageIcon getIconeBox() {
		return iconeBox;
	}
	public void setIconeBox(ImageIcon iconeBox) {
		this.iconeBox = iconeBox;
	}
	public ImageIcon getIconeAluno() {
		return iconeAluno;
	}
	public void setIconeAluno(ImageIcon iconAluno) {
		this.iconeAluno = iconAluno;
	}
	public ImageIcon getIconeAta32x() {
		return iconeAta32x;
	}
	public void setIconeAta32x(ImageIcon iconAta) {
		this.iconeAta32x = iconAta;
	}
	public ImageIcon getIconeArquivo() {
		return iconeArquivo;
	}
	public void setIconeArquivo(ImageIcon iconArquivo) {
		this.iconeArquivo = iconArquivo;
	}
	public ImageIcon getIconePesquisar() {
		return iconePesquisar;
	}
	public void setIconePesquisar(ImageIcon iconePesquisar) {
		this.iconePesquisar = iconePesquisar;
	}
	public ImageIcon getIconeSalvar() {
		return iconeSalvar;
	}
	public void setIconeSalvar(ImageIcon iconeSalvar) {
		this.iconeSalvar = iconeSalvar;
	}
	public ImageIcon getIconeLimpar() {
		return iconeLimpar;
	}
	public void setIconeLimpar(ImageIcon iconeLimpar) {
		this.iconeLimpar = iconeLimpar;
	}
	public ImageIcon getIconeExcluir() {
		return iconeExcluir;
	}
	public void setIconeExcluir(ImageIcon iconeExcluir) {
		this.iconeExcluir = iconeExcluir;
	}
	public ImageIcon getIconeAlterar() {
		return iconeAlterar;
	}
	public void setIconeAlterar(ImageIcon iconeAlterar) {
		this.iconeAlterar = iconeAlterar;
	}
	public ImageIcon getIconeDoc() {
		return iconeDoc;
	}
	public void setIconeDoc(ImageIcon iconeDoc) {
		this.iconeDoc = iconeDoc;
	}
	public ImageIcon getIconeAta() {
		return iconeAta;
	}
	public void setIconeAta(ImageIcon iconeAta) {
		this.iconeAta = iconeAta;
	}
	public ImageIcon getIconeCaixa() {
		return iconeCaixa;
	}
	public void setIconeCaixa(ImageIcon iconeCaixa) {
		this.iconeCaixa = iconeCaixa;
	}
	public ImageIcon getIconeCancelar() {
		return iconeCancelar;
	}
	public void setIconeCancelar(ImageIcon iconeCancelar) {
		this.iconeCancelar = iconeCancelar;
	}
	public ImageIcon getIcone() {
		return icone;
	}
	public void setIcone(ImageIcon icone) {
		this.icone = icone;
	}
	public ImageIcon getImageAbout() {
		return imageAbout;
	}
	public void setImageAbout(ImageIcon imageAbout) {
		this.imageAbout = imageAbout;
	}
	
	/**
	 * Carrega uma imagem existente no mesmo pacote da classe ImageLoader
	 * @param fileName
	 * @return
	 */
	public static ImageIcon createImageIcon(String fileName){
		try{
			URL imageURL = IconesGroup.class.getResource(fileName);
			ImageIcon icon = new ImageIcon(imageURL);
			return icon;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Carrega uma imagem que exista no diret�rio fornecido.
	 * @param dir - caminho completo do diret�rio
	 * @param fileName - nome do arquivo
	 * @return
	 */
	public static ImageIcon createImageIcon(String dir, String fileName){
		try{
			if(!dir.endsWith(File.separator)){
				dir = dir + File.separator;
			}

			ImageIcon icon = new ImageIcon(dir+fileName);
			return icon;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Image createFaviIcon (String fileName){
		// coloca uma figura na barra de t�tulo da janela
		URL url = IconesGroup.class.getResource(fileName);
		Image faviIcon = Toolkit.getDefaultToolkit().getImage(url);
		return faviIcon;
	}
}
