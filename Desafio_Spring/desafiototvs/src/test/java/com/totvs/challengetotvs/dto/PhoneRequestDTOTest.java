package com.totvs.challengetotvs.dto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/**
 * A classe {@code TelefoneRequestDTOTest} contém testes para a classe
 * {@code TelefoneDTO}. Cada método de teste aborda diferentes cenários de
 * conversão do DTO para um objeto {@code Telefone}.
 *
 * <p>
 * Os cenários de teste incluem casos em que o número de telefone está ausente,
 * possui um formato inválido ou está em um formato válido. Utiliza-se a
 * biblioteca AssertJ para realizar as verificações dos testes.
 * </p>
 *
 * <p>
 * Este conjunto de testes abrange a lógica de validação de dados no método
 * {@link PhoneDTO#toPhone()}.
 * </p>
 *
 * @author Fernanda Renata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class PhoneRequestDTOTest {

	/**
	 * Testa o método {@link PhoneDTO#toPhone()} para diferentes cenários.
	 *
	 * <p>
	 * Cenários de teste:
	 * </p>
	 * <ul>
	 * <li>Número de telefone não informado.</li>
	 * <li>Número de telefone em formato inválido.</li>
	 * <li>Número de telefone em formato válido.</li>
	 * </ul>
	 */
	@Test
	public void testToTelefone() {
		PhoneDTO telefoneDTO1 = PhoneDTO.create("");

		assertThatThrownBy(() -> telefoneDTO1.toPhone()).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("O telefone do cliente não foi informado.");

		PhoneDTO telefoneDTO2 = PhoneDTO.create("99751-8858");

		assertThatThrownBy(() -> telefoneDTO2.toPhone()).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Número de telefone inválido: 99751-8858");

		PhoneDTO telefoneDTO3 = PhoneDTO.create("(11)99751-8858");
		assertThatCode(() -> telefoneDTO3.toPhone()).doesNotThrowAnyException();

	}
}
