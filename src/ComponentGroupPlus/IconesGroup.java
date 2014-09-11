package ComponentGroupPlus;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;

public class IconesGroup {

	// Diretorio padrão dos icones
	public static final String DIR_ICONES = Messages.getString("IconesGroup.0"); //$NON-NLS-1$

	/**
	 * Carrega uma imagem existente no mesmo pacote da classe ImageLoader
	 * 
	 * @param fileName
	 * @return
	 */
	public static ImageIcon createImageIcon(final String fileName) {
		try {
			final URL imageURL = IconesGroup.class.getResource(fileName);
			final ImageIcon icon = new ImageIcon(imageURL);
			return icon;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Carrega uma imagem que exista no diretório fornecido.
	 * 
	 * @param dir
	 *            - caminho completo do diretório
	 * @param fileName
	 *            - nome do arquivo
	 * @return
	 */
	public static ImageIcon createImageIcon(String dir, final String fileName) {
		try {
			if (!dir.endsWith(File.separator)) {
				dir = dir + File.separator;
			}

			final ImageIcon icon = new ImageIcon(dir + fileName);
			return icon;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// icones botoes 20x20
	private ImageIcon iconePesquisar = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.1")); //$NON-NLS-1$
	private ImageIcon iconeSalvar = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.2")); //$NON-NLS-1$
	private ImageIcon iconeLimpar = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.3")); //$NON-NLS-1$
	private ImageIcon iconeExcluir = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.4")); //$NON-NLS-1$
	private ImageIcon iconeAlterar = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.5")); //$NON-NLS-1$
	private ImageIcon iconeDoc = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.6")); //$NON-NLS-1$
	private ImageIcon iconeAta = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.7")); //$NON-NLS-1$
	private ImageIcon iconeCaixa = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.8")); //$NON-NLS-1$
	private ImageIcon iconeBox = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.9")); //$NON-NLS-1$
	private ImageIcon iconeCancelar = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.10")); //$NON-NLS-1$
	private ImageIcon iconeInserir = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.11")); //$NON-NLS-1$
	private ImageIcon iconeRetirar = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.12")); //$NON-NLS-1$
	private ImageIcon iconeAbrir = new ImageIcon(DIR_ICONES + "abrir.png");

	private ImageIcon icone = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.13")); //$NON-NLS-1$
	private ImageIcon imageAbout = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.14")); //$NON-NLS-1$
	// Icones principais 32x32
	private ImageIcon iconeAluno = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.15")); //$NON-NLS-1$

	private ImageIcon iconeAta32x = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.16")); //$NON-NLS-1$

	private ImageIcon iconeArquivo = new ImageIcon(DIR_ICONES + Messages.getString("IconesGroup.17")); //$NON-NLS-1$

	public Image createFaviIcon(final String fileName) {
		// coloca uma figura na barra de título da janela
		final URL url = IconesGroup.class.getResource(fileName);
		final Image faviIcon = Toolkit.getDefaultToolkit().getImage(url);
		return faviIcon;
	}

	public boolean dirExist() {
		final File file = new File(DIR_ICONES);
		return file.exists();
	}

	public ImageIcon getIcone() {
		return icone;
	}

	public ImageIcon getIconeAlterar() {
		return iconeAlterar;
	}

	public ImageIcon getIconeAluno() {
		return iconeAluno;
	}

	public ImageIcon getIconeArquivo() {
		return iconeArquivo;
	}

	public ImageIcon getIconeAta() {
		return iconeAta;
	}

	public ImageIcon getIconeAta32x() {
		return iconeAta32x;
	}

	public ImageIcon getIconeBox() {
		return iconeBox;
	}

	public ImageIcon getIconeCaixa() {
		return iconeCaixa;
	}

	public ImageIcon getIconeCancelar() {
		return iconeCancelar;
	}

	public ImageIcon getIconeDoc() {
		return iconeDoc;
	}

	public ImageIcon getIconeExcluir() {
		return iconeExcluir;
	}

	public ImageIcon getIconeInserir() {
		return iconeInserir;
	}

	public ImageIcon getIconeLimpar() {
		return iconeLimpar;
	}

	public ImageIcon getIconePesquisar() {
		return iconePesquisar;
	}

	public ImageIcon getIconeRetirar() {
		return iconeRetirar;
	}

	public ImageIcon getIconeSalvar() {
		return iconeSalvar;
	}

	public ImageIcon getImageAbout() {
		return imageAbout;
	}

	public void setIcone(final ImageIcon icone) {
		this.icone = icone;
	}

	public ImageIcon getIconeAbrir() {
		return iconeAbrir;
	}

	public void setIconeAbrir(ImageIcon iconeAbrir) {
		this.iconeAbrir = iconeAbrir;
	}

	public void setIconeAlterar(final ImageIcon iconeAlterar) {
		this.iconeAlterar = iconeAlterar;
	}

	public void setIconeAluno(final ImageIcon iconAluno) {
		this.iconeAluno = iconAluno;
	}

	public void setIconeArquivo(final ImageIcon iconArquivo) {
		this.iconeArquivo = iconArquivo;
	}

	public void setIconeAta(final ImageIcon iconeAta) {
		this.iconeAta = iconeAta;
	}

	public void setIconeAta32x(final ImageIcon iconAta) {
		this.iconeAta32x = iconAta;
	}

	public void setIconeBox(final ImageIcon iconeBox) {
		this.iconeBox = iconeBox;
	}

	public void setIconeCaixa(final ImageIcon iconeCaixa) {
		this.iconeCaixa = iconeCaixa;
	}

	public void setIconeCancelar(final ImageIcon iconeCancelar) {
		this.iconeCancelar = iconeCancelar;
	}

	public void setIconeDoc(final ImageIcon iconeDoc) {
		this.iconeDoc = iconeDoc;
	}

	public void setIconeExcluir(final ImageIcon iconeExcluir) {
		this.iconeExcluir = iconeExcluir;
	}

	public void setIconeInserir(final ImageIcon iconeInserir) {
		this.iconeInserir = iconeInserir;
	}

	public void setIconeLimpar(final ImageIcon iconeLimpar) {
		this.iconeLimpar = iconeLimpar;
	}

	public void setIconePesquisar(final ImageIcon iconePesquisar) {
		this.iconePesquisar = iconePesquisar;
	}

	public void setIconeRetirar(final ImageIcon iconeRetirar) {
		this.iconeRetirar = iconeRetirar;
	}

	public void setIconeSalvar(final ImageIcon iconeSalvar) {
		this.iconeSalvar = iconeSalvar;
	}

	public void setImageAbout(final ImageIcon imageAbout) {
		this.imageAbout = imageAbout;
	}
}
