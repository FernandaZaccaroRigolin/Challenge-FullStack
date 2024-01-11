package com.totvs.challengetotvs.dto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * A classe {@code ClienteRequestDTOTest} contém testes para a classe
 * {@code ClienteRequestDTO}. Cada método de teste aborda diferentes cenários de
 * conversão do DTO para um objeto {@code Cliente}.
 *
 * <p>
 * Os cenários de teste incluem casos em que dados inválidos ou ausentes são
 * fornecidos, bem como casos em que os dados são válidos. Utiliza-se a
 * biblioteca AssertJ para realizar as verificações dos testes.
 * </p>
 *
 * <p>
 * Este conjunto de testes abrange a lógica de validação de dados no método
 * {@link ClientRequestDTO#toClient()}.
 * </p>
 *
 * @author Fernanda Renata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class ClientRequestDTOTest {

	/**
	 * Testa o método {@link ClientRequestDTO#toClient()} para diferentes cenários.
	 *
	 * <p>
	 * Cenários de teste:
	 * </p>
	 * <ul>
	 * <li>Nome do cliente não informado.</li>
	 * <li>Endereço do cliente não informado.</li>
	 * <li>Bairro do cliente não informado.</li>
	 * <li>Telefone do cliente não informado.</li>
	 * <li>Dados válidos do cliente.</li>
	 * </ul>
	 */
	@Test
	public void testToCliente() {
		ClientRequestDTO clienteRequestDTO1 = new ClientRequestDTO(null, "Av. Doutor Osvaldo Cruz, 88",
				"Jardim do Bosque", List.of());

		assertThatThrownBy(() -> clienteRequestDTO1.toClient()).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("O nome do cliente não foi informado.");

		ClientRequestDTO clienteRequestDTO2 = new ClientRequestDTO("Carmem Lucia Maria", "", "Jardim do Bosque",
				List.of());

		assertThatThrownBy(() -> clienteRequestDTO2.toClient()).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("O endereço do cliente não foi informado.");

		ClientRequestDTO clienteRequestDTO3 = new ClientRequestDTO("Carmem Lucia Maria", "Av. Doutor Osvaldo Cruz, 88",
				"", List.of());

		assertThatThrownBy(() -> clienteRequestDTO3.toClient()).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("O bairro do cliente não foi informado.");

		ClientRequestDTO clienteRequestDTO4 = new ClientRequestDTO("Carmem Lucia Maria", "Av. Doutor Osvaldo Cruz, 88",
				"Jardim do Bosque", List.of());

		assertThatThrownBy(() -> clienteRequestDTO4.toClient()).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("O telefone do cliente não foi informado.");

		ClientRequestDTO clienteRequestDTO5 = new ClientRequestDTO("Carmem Lucia Maria", "Av. Doutor Osvaldo Cruz, 88",
				"Jardim do Bosque", List.of(PhoneDTO.create("(11)99751-8868"), PhoneDTO.create("(16)3337-2188")));

		assertThatCode(() -> clienteRequestDTO5.toClient()).doesNotThrowAnyException();
	}
}
