package Segurança;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import DAO.JPAUtil;
import DAO.SenhaDAO;
import Model.Senha;

public class MAC {

	private Path url;
	private final Charset utf8 = StandardCharsets.UTF_8;
	protected JPAUtil conexaoBD = new JPAUtil();
	protected SenhaDAO dao = new SenhaDAO(conexaoBD);

	public MAC(final Path url) {
		this.url = url;
	}

	// --- MÉTODO QUE PEGA O(S) ENDEREÇO(S) MAC DIRETAMENTE DO PROMPT
	// (ARRAYLIST)
	public ArrayList<String> getMac() throws IOException {

		final ArrayList<String> mac = new ArrayList<>();
		final Process p = Runtime.getRuntime().exec(Messages.getString("MAC.0")); //$NON-NLS-1$

		try (BufferedReader input = new BufferedReader(new InputStreamReader(
				p.getInputStream()))) {

			String linha = null;
			int i = 0;
			while ((linha = input.readLine()) != null) {
				if (i > 2) {
					mac.add(linha.substring(0, 17));
				}
				i++;
			}
		}
		p.destroy();
		return mac;
	}

	// --- MÉTODO QUE PEGA O(S) ENDEREÇO(S) MAC DIRETAMENTE DO PROMPT (STRING)
	public String getMacString() throws IOException {
		final ArrayList<String> macs = getMac();
		String mac = Messages.getString("MAC.1"); //$NON-NLS-1$

		for (final String string : macs) {
			mac += string + Messages.getString("MAC.2"); //$NON-NLS-1$
		}

		return mac;
	}

	// --- MÉTODO QUE PEGA O(S) ENDEREÇO(S) MAC DO ARQUIVO TXT
	public ArrayList<String> getMacTxt() throws IOException {
		final ArrayList<String> mac = new ArrayList<>();

		try (BufferedReader input = Files.newBufferedReader(url, utf8)) {
			String linha = null;

			while ((linha = input.readLine()) != null) {
				mac.add(linha);
			}
		} catch (final NoSuchFileException e) {
			System.out.println(Messages.getString("MAC.3")); //$NON-NLS-1$
		}

		return mac;
	}

	public Path getUrl() {
		return this.url;
	}

	// --- MÉTODO QUE CRIA UM ARQUIVO TXT E O PREENCHE COM O(S) ENDEREÇO(S) MAC
	// COLETADO DO PROMPT
	public void setMacTxt(final Senha senha) throws IOException {

		// --- CRIA UM DIRETÓRIO
		Files.createDirectories(url.getParent());
		System.out.println(url.getParent());
		System.out.println(url);
		// --- OCULTA O DIRETÓRIO
		Runtime.getRuntime().exec(Messages.getString("MAC.4") + url.getParent()); //$NON-NLS-1$

		try (BufferedWriter writer = Files.newBufferedWriter(url, utf8)) {

			final ArrayList<String> mac = getMac();

			dao.setMacSenhas(senha, getMacString());

			for (final String string : mac) {
				writer.write(string + Messages.getString("MAC.5")); //$NON-NLS-1$
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	public void setUrl(final Path url) {
		this.url = url;
	}
}