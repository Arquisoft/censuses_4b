package es.uniovi.asw.persistencia.impl;

import es.uniovi.asw.logica.Voter;
import es.uniovi.asw.persistencia.GeneradorPasswords;

public class GeneradorPasswordsImpl implements GeneradorPasswords {

	@Override
	public String generarPass(Voter votante) {
		
		int i, valor;
		char[] codigo = new char[10];
		char[] elementos = {'0','1','2','3','4','5','6','7','8','9',
						'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
						'o','p','q','r','s','t','u','v','w','x','y','z',
						'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
						'O','P','Q','R','S','T','U','V','W','X','Y','Z',
						'*','+','.',','};
		
		for(i = 0; i < codigo.length; i++){
			valor = (int)(Math.random() * elementos.length);
			codigo[i] = (char)elementos[valor];
		}
		
		return new String(codigo);
	}
}
