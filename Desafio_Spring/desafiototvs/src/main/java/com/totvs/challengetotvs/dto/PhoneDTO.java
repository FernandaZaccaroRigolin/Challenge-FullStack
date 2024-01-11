package com.totvs.challengetotvs.dto;

import com.totvs.challengetotvs.models.Phone;

/**
 * A classe {@code TelefoneDTO} representa um objeto de transferência de dados
 * (DTO) utilizado para representar informações de telefone em operações de
 * transferência de dados. Contém um número de telefone.
 *
 * <p>
 * Esta classe fornece métodos de criação a partir de um número de telefone,
 * conversão de um objeto {@code Telefone} para um objeto {@code TelefoneDTO}, e
 * validação dos dados do telefone.
 * </p>
 *
 * <p>
 * Os números de telefone são considerados inválidos se forem nulos, vazios ou
 * não estiverem no formato esperado.
 * </p>
 *
 * <p>
 * Para criar instâncias desta classe, você pode usar o método estático
 * {@link #create(String)}.
 * </p>
 *
 * <p>
 * Para converter um objeto {@code Telefone} em um {@code TelefoneDTO}, você
 * pode usar o método estático {@link #fromPhone(Phone)}.
 * </p>
 *
 * <p>
 * Para converter um {@code TelefoneDTO} de volta para um objeto
 * {@code Telefone}, você pode usar o método {@link #toPhone()}.
 * </p>
 *
 * <p>
 * A validação dos dados do telefone é feita automaticamente ao chamar o método
 * {@link #toPhone()}.
 * </p>
 *
 * <p>
 * Exemplo de uso:
 * </p>
 * 
 * <pre>
 * {
 * 	&#64;code
 * 	TelefoneDTO telefoneDTO = TelefoneDTO.create("(12)34567-8901");
 * 	Telefone telefone = telefoneDTO.toTelefone();
 * }
 * </pre>
 *
 * @author Fernanda REnata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class PhoneDTO {

	/** O número de telefone. */
	private String number;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public PhoneDTO() {
	}

	/**
	 * Método estático para criar uma instância de {@code TelefoneDTO} a partir de
	 * um número de telefone.
	 *
	 * @param number o número de telefone a ser definido
	 * @return a instância de {@code TelefoneDTO} criada
	 */
	public static PhoneDTO create(String number) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setNumber(number);
		return phoneDTO;
	}

	/**
	 * Método estático para criar uma instância de {@code TelefoneDTO} a partir de
	 * um objeto {@code Telefone}.
	 *
	 * @param phone o objeto {@code Telefone} a ser convertido
	 * @return a instância de {@code TelefoneDTO} criada
	 */
	public static PhoneDTO fromPhone(Phone phone) {
		return create(phone.getNumber());
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
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Converte o objeto {@code TelefoneDTO} para um objeto {@code Telefone}.
	 *
	 * @return o objeto {@code Telefone} resultante
	 * @throws IllegalArgumentException se o número de telefone for inválido ou não
	 *                                  fornecido
	 */
	public Phone toPhone() {
		validateDataRequest();
		return new Phone(this.getNumber());
	}

	/**
	 * Valida os dados fornecidos para o número de telefone.
	 *
	 * @throws IllegalArgumentException se o número de telefone for inválido ou não
	 *                                  fornecido
	 */
	private void validateDataRequest() {
		if (number == null || number.isBlank()) {
			throw new IllegalArgumentException("O telefone do cliente não foi informado.");
		}

		if (!Phone.validatePhone(number)) {
			throw new IllegalArgumentException(
					"Número de telefone inválido: " + number + " [máscara permitida (99)99999-9999 ou (99)9999-9999]");
		}
	}
}
