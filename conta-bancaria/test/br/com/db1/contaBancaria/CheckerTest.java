package br.com.db1.contaBancaria;

import org.junit.Assert;
import org.junit.Test;

import br.com.db1.contaBancaria.Checker;


public class CheckerTest {
	
	@Test
	public void naoDeveRetornarErroQuandoValorNaoNulo() {
		Checker.notNull("valor", "nome");
	}
	
	@Test (expected = RuntimeException.class)
	public void deveRetornarCampoObrigatorio() {
		Checker.notNull(null, "nome");
	}
	
	@Test
	public void deveRetornarMensagemDeCampoObrigatorio() {
		try {
			
		} catch (RuntimeException ex) {
			Assert.assertEquals("Campo nome é obrigatório.", ex.getMessage());
		}
	}
}
