package com.totvs.challengetotvs.dto;

import java.util.List;

import com.totvs.challengetotvs.models.Client;

/**
 * A classe {@code ClienteResponseDTO} representa um objeto de transferência de
 * dados (DTO) utilizado para enviar dados de clientes como resposta a
 * requisições. Contém informações como ID, nome, endereço, bairro e uma lista
 * de telefones associados ao cliente.
 *
 * @author Fernanda Renata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class ClientResponseDTO {

	/** O ID do cliente. */
	private String id;

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
	public ClientResponseDTO() {
	}

	/**
	 * Construtor que inicializa os atributos da classe com base em um objeto
	 * {@code Cliente}.
	 *
	 * @param client o cliente a partir do qual os dados são extraídos
	 */
	public ClientResponseDTO(Client client) {
		this.setId(client.getId().toString());
		this.setName(client.getName());
		this.setAddress(client.getAddress());
		this.setDistrict(client.getDistrict());
		this.setPhones(client.getPhones().stream().map(PhoneDTO::fromPhone).toList());
	}

	/**
	 * Obtém o ID do cliente.
	 *
	 * @return o ID do cliente
	 */
	public String getId() {
		return id;
	}

	/**
	 * Define o ID do cliente.
	 *
	 * @param id o ID do cliente a ser definido
	 */
	public void setId(String id) {
		this.id = id;
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
}