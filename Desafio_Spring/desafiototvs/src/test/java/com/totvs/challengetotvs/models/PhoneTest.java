package com.totvs.challengetotvs.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * A classe {@code TelefoneTest} contém testes para a classe {@code Telefone}. O
 * método de teste {@link #testValidarTelefone()} aborda diferentes cenários de
 * validação de números de telefone.
 *
 * <p>
 * Os cenários de teste incluem números de telefone válidos e inválidos em
 * diversos formatos. Utiliza-se a biblioteca AssertJ para realizar as
 * verificações dos testes.
 * </p>
 *
 * 
 * @author Fernanda Renata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
public class PhoneTest {

	/**
	 * Testa o método {@link testValidarTelefone()} para diferentes cenários.
	 *
	 * <p>
	 * Cenários de teste:
	 * </p>
	 * <ul>
	 * <li>Números de telefone válidos em diferentes formatos.</li>
	 * <li>Números de telefone inválidos em diferentes formatos.</li>
	 * <li>Número de telefone nulo.</li>
	 * <li>Número de telefone vazio.</li>
	 * </ul>
	 */
	@Test
	public void testValidarTelefone() {

		assertThat(Phone.validatePhone("(11)1234-5678")).isTrue();
		assertThat(Phone.validatePhone("(16)3324-5810")).isTrue();
		assertThat(Phone.validatePhone("(21)98765-4321")).isTrue();

		assertThat(Phone.validatePhone("1234567890")).isFalse();
		assertThat(Phone.validatePhone("(11)12345-678")).isFalse();
		assertThat(Phone.validatePhone("(11)1234-56789")).isFalse();
		assertThat(Phone.validatePhone("(11)ABCD-EFGH")).isFalse();
		assertThat(Phone.validatePhone("(11)")).isFalse();
		assertThat(Phone.validatePhone("")).isFalse();
		assertThat(Phone.validatePhone(null)).isFalse();
	}
}
