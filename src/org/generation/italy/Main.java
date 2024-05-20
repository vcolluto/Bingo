package org.generation.italy;

import java.util.ArrayList;
import java.util.Random;
/*
 * Scrivere un programma che simula il gioco "Bingo"

All'avvio del programma generare la scheda dell'utente con 15 numeri casuali da 1 a 90 tutti diversi tra loro.

Generare quindi i numeri estratti dal tabellone: i numeri vanno da 1 a 90 e non può essere estratto due volte lo stesso numero.

Dopo ogni numero estratto, verificare se l'utente ha fatto "cinquina" oppure "bingo"

 

Parte due (per lavoro autonomo):

Mostrare la scheda dell'utente su 3 righe diverse.

Dopo ogni numero estratto ristampare la scheda dell'utente evidenziando i numeri usciti (es con un asterisco) e chiedere di premere Invio per estrarre un altro numero.

Assicurarsi che la cinquina venga fatta sulla stessa riga.


Per i più "temerari": dare la possibilità all'utente di avere più di una scheda (chiedere all'utente all'avvio del programma quante schede vuole "acquistare")
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> schedaUtente = new ArrayList<Integer>();	//le prime 5 posizioni sono la prima riga, le successive 5 la seconda, ecc.
		
		Random r=new Random();
		int n;
		
		do {
			n=r.nextInt(90)+1;					//casuale da 1 a 90
			if (!schedaUtente.contains(n))
				schedaUtente.add(n);			//se il numero non è contenuto nella scheda lo aggiungo
		} while (schedaUtente.size()<15);		//torno indietro se nella scheda ci sono meno di 15 numeri

		System.out.println(schedaUtente);
	}

}