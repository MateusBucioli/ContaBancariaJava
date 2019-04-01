package br.com.db1.contaBancaria;

public class Checker {
	public static void notNull(Object value, String field) {
		if(value == null) {
			throw new RuntimeException("Campo " + field + " é obrigatório.");
		}
	}
}
