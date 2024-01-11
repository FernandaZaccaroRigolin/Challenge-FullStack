package com.totvs.challengetotvs.models;

import java.util.List;
import java.util.UUID;

/**
 * A classe {@code Cliente} representa um cliente com informações como ID, nome,
 * endereço, bairro e lista de telefones..
 *
 * @author Fernanda Renata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class Client {

	/**
	 * Id do cliente gerado automaticamente.
	 */
	private UUID id;

	/**
	 * Nome do cliente.
	 */
	private String name;

	/**
	 * Endereço do cliente.
	 */
	private String address;

	/**
	 * Bairro do cliente.
	 */
	private String district;

	/**
	 * Lista de telefones associados ao cliente.
	 */
	private List<Phone> phones;

	/**
	 * Cria um novo cliente com um ID gerado automaticamente.
	 */
	public Client() {
		this.setId(UUID.randomUUID());
	}

	/**
	 * Cria um novo cliente com um ID gerado automaticamente e informações básicas.
	 *
	 * @param name     O nome do cliente.
	 * @param address  O endereço do cliente.
	 * @param district O bairro do cliente.
	 */
	public Client(String name, String address, String district) {
		this.setId(UUID.randomUUID());
		this.setName(name);
		this.setAddress(address);
		this.setDistrict(district);
	}

	/**
	 * Obtém o ID do cliente.
	 *
	 * @return O ID do cliente.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Define o ID do cliente.
	 *
	 * @param id O ID do cliente.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Obtém o nome do cliente.
	 *
	 * @return O nome do cliente.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o nome do cliente.
	 *
	 * @param name O nome do cliente.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtém o endereço do cliente.
	 *
	 * @return O endereço do cliente.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Define o endereço do cliente.
	 *
	 * @param address O endereço do cliente.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Obtém o bairro do cliente.
	 *
	 * @return O bairro do cliente.
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Define o bairro do cliente.
	 *
	 * @param district O bairro do cliente.
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * Define a lista de telefones associados ao cliente.
	 *
	 * @param phones A lista de telefones.
	 */
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	/**
	 * Obtém a lista de telefones associados ao cliente.
	 *
	 * @return A lista de telefones.
	 */
	public List<Phone> getPhones() {
		return phones;
	}
}
