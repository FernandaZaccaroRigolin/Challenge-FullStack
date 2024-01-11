package com.totvs.challengetotvs.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.challengetotvs.dto.ClientRequestDTO;
import com.totvs.challengetotvs.dto.ClientResponseDTO;
import com.totvs.challengetotvs.models.Client;
import com.totvs.challengetotvs.models.Phone;
import com.totvs.challengetotvs.services.ClientService;
import com.totvs.challengetotvs.services.PhoneService;

/**
 * A classe {@code ApiClienteController} é um controlador Spring que gerencia as
 * operações relacionadas aos clientes. Ele expõe endpoints RESTful para a
 * inserção de clientes.
 *
 * @author Fernanda Renata Zaccaro Rigolin
 * @version 1.0
 * @since 2024-01-06
 */
@RestController
public class ApiClientController {

	/** O serviço para operações relacionadas a clientes. */
	@Autowired
	private ClientService clientService;

	/** O serviço para operações relacionadas a telefones. */
	@Autowired
	private PhoneService phoneService;

	/**
	 * Endpoint para inserir um novo cliente.
	 *
	 * @param clientRequestDTO os dados do cliente a serem inseridos
	 * @return ResponseEntity representando o resultado da operação
	 */
	@CrossOrigin
	@PostMapping("/client")
	public ResponseEntity<?> insertClient(@RequestBody ClientRequestDTO clientRequestDTO) {
		try {
			Client client = clientRequestDTO.toClient();
			clientService.insertClient(client);

			for (Phone phone : client.getPhones()) {
				phoneService.insertPhone(phone);
			}

			ClientResponseDTO clientResponseDTO = new ClientResponseDTO(client);
			return ResponseEntity.status(HttpStatus.CREATED).body(clientResponseDTO);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
