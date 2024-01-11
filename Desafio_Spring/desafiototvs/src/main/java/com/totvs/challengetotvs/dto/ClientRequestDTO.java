package com.totvs.challengetotvs.dto;

import java.util.List;

import com.totvs.challengetotvs.models.Client;
import com.totvs.challengetotvs.models.Phone;

/**
 * A classe {@code ClienteRequestDTO} representa um objeto de transferência de
 * dados (DTO) utilizado para receber dados de um cliente em operações de
 * entrada na aplicação. Contém informações como nome, endereço, bairro e uma
 * lista de telefones associados ao cliente.
 *
 * <p>
 * Esta classe fornece construtores, getters e setters para acessar e manipular
 * os dados do cliente. Também oferece métodos para converter a lista de
 * telefones DTO para uma lista de objetos {@code Telefone} e para converter o
 * próprio DTO para um objeto {@code Cliente}.
 * </p>
 *
 * <p>
 * O método {@link #toClient()} realiza a conversão do DTO para um objeto
 * {@code Cliente}, validando os dados fornecidos na requisição e lançando uma
 * exceção se algum dado for inválido ou não fornecido.
 * </p>
 *
 * <p>
 * Exemplo de uso:
 * </p>
 * 
 * <pre>
 * {
 * 	&#64;code
 * // Criar um ClienteRequestDTO
 * 	ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO("Nome do Cliente", "Endereço do Cliente",
 * 			"Bairro do Cliente", List.of(TelefoneDTO.create("(11)1234-5678"), TelefoneDTO.create("(16)3324-5810")));
 *
 * // Converter o DTO para um objeto Cliente
 * 	Cliente cliente = clienteRequestDTO.toCliente();
 * }
 * </pre>
 *
 * @author Fernanda Renanta Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class ClientRequestDTO {
	/** O nome do cliente. */
	private String name;

	/** O endereço do cliente. */
	private String address;

	/** O bairro do cliente. */
	private String district;

	/** A lista de telefones associados ao cliente. */
	private List<PhoneDTO> phones;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public ClientRequestDTO() {
	}

	/**
	 * Construtor que inicializa os atributos da classe.
	 *
	 * @param name      o nome do cliente
	 * @param address   o endereço do cliente
	 * @param district  o bairro do cliente
	 * @param phones a lista de telefones associados ao cliente
	 */
	public ClientRequestDTO(String name, String address, String district, List<PhoneDTO> phones) {
		this.setName(name);
		this.setAddress(address);
		this.setDistrict(district);
		this.setPhones(phones);
	}

	/**
	 * Obtém o nome do cliente.
	 *
	 * @return o nome do cliente
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o nome do cliente.
	 *
	 * @param name o nome do cliente a ser definido
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtém o endereço do cliente.
	 *
	 * @return o endereço do cliente
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Define o endereço do cliente.
	 *
	 * @param address o endereço do cliente a ser definido
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Obtém o bairro do cliente.
	 *
	 * @return o bairro do cliente
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Define o bairro do cliente.
	 *
	 * @param district o bairro do cliente a ser definido
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * Obtém a lista de telefones associados ao cliente.
	 *
	 * @return a lista de telefones associados ao cliente
	 */
	public List<PhoneDTO> getPhones() {
		return phones;
	}

	/**
	 * Define a lista de telefones associados ao cliente.
	 *
	 * @param phones a lista de telefones a ser definida
	 */
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

	/**
	 * Converte a lista de telefones DTO para uma lista de objetos {@code Telefone}.
	 *
	 * @return a lista de telefones associados ao cliente
	 */
	public List<Phone> converterPhones() {

		if (phones == null) {
			return null;
		}
		return phones.stream().map(PhoneDTO::toPhone).toList();
	}

	/**
	 * Converte o objeto {@code ClienteRequestDTO} para um objeto {@code Cliente}.
	 *
	 * @return o objeto {@code Cliente} resultante
	 * @throws IllegalArgumentException se algum dos dados do cliente for inválido
	 *                                  ou não fornecido
	 */
	public Client toClient() {
		validateDataRequest();
		Client client = new Client(this.getName(), this.getAddress(), this.getDistrict());
		client.setPhones(converterPhones());
		return client;
	}

	/**
	 * Valida os dados fornecidos na requisição.
	 *
	 * @throws IllegalArgumentException se algum dos dados do cliente for inválido
	 *                                  ou não fornecido
	 */
	private String validateDataRequest() {

		if (getName() == null || getName().isBlank()) {
			throw new IllegalArgumentException("O nome do cliente não foi informado.");
		}

		if (getAddress() == null || getAddress().isBlank()) {
			throw new IllegalArgumentException("O endereço do cliente não foi informado.");
		}

		if (getDistrict() == null || getDistrict().isBlank()) {
			throw new IllegalArgumentException("O bairro do cliente não foi informado.");
		}

		if (getPhones() == null || getPhones().isEmpty()) {
			throw new IllegalArgumentException("O telefone do cliente não foi informado.");
		}

		return null;
	}
}
