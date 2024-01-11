package com.totvs.challengetotvs.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A classe {@code Telefone} representa um telefone com um número de telefone
 * válido para os formatos (99)99999-9999 ou (99)9999-9999. Também está
 * associada a um objeto {@link Client}.
 *
 * @author Fernanda Renata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class Phone {
	/** O número de telefone. */
	private String number;

	/** O cliente associado. */
	private Client client;

	/**
	 * Constrói um objeto {@code Telefone} com o número de telefone especificado.
	 *
	 * @param number o número de telefone a ser definido
	 * @throws IllegalArgumentException se o número de telefone fornecido for nulo
	 *                                  ou vazio
	 */
	public Phone(String number) {
		if (number == null || number.trim().isEmpty()) {
			throw new IllegalArgumentException("Número de telefone não pode ser nulo ou vazio.");
		}
		this.setNumber(number);
	}

	/**
	 * Obtém o número de telefone.
	 *
	 * @return o número de telefone
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Define o número de telefone.
	 *
	 * @param number o número de telefone a ser definido
	 * @throws IllegalArgumentException se o número de telefone fornecido for
	 *                                  inválido
	 */
	public void setNumber(String number) {
		if (validatePhone(number)) {
			this.number = number;
		} else {
			throw new IllegalArgumentException("Número de telefone inválido: " + number);
		}
	}

	/**
	 * Obtém o cliente associado.
	 *
	 * @return o cliente associado
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Define o cliente associado.
	 *
	 * @param client o cliente a ser definido
	 */
	public void setCliente(Client client) {
		this.client = client;
	}

	/**
	 * Valida o número de telefone fornecido.
	 *
	 * @param number o número de telefone a ser validado
	 * @return {@code true} se o número de telefone for válido para os formatos
	 *         (99)99999-9999 ou (99)9999-9999, {@code false} caso contrário
	 */
	public static boolean validatePhone(String number) {
		if (number == null || number.trim().isEmpty()) {
			return false;
		}
		Pattern pattern = Pattern.compile("\\(\\d{2}\\)\\d{4,5}-\\d{4}");
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();
	}
}
