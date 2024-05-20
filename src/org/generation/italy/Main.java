package org.generation.italy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


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

//sequenze di escape (bold, colore, ecc.):
//https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797


public class Main {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> schedeUtente=new ArrayList<ArrayList<Integer>>();	//le prime 5 posizioni sono la prima riga, le successive 5 la seconda, ecc.
		HashSet<Integer> numeriEstratti=new HashSet<Integer>();
		ArrayList<Integer> schedaUtente;
		
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		int n,i,j, estrattiRiga, estrattiScheda, nrSchede;
		boolean cinquina=false, bingo=false;
		boolean attesaBingo=false;		//indica se sono in attesa del bingo 
		
		System.out.println("Benvenuto nel gioco del Bingo!");
		System.out.print("Quante schede vuoi acquistare? ");
		nrSchede=sc.nextInt();
		sc.nextLine();
		
		//inizializzo l'array delle schede
		for (i=1;i<=nrSchede;i++) {		//per ogni scheda
			schedaUtente=new ArrayList<Integer>();
			schedeUtente.add(schedaUtente);
			do {
				n=r.nextInt(90)+1;					//casuale da 1 a 90
				if (!schedaUtente.contains(n))
					schedaUtente.add(n);			//se il numero non è contenuto nella scheda lo aggiungo
			} while (schedaUtente.size()<15);		//torno indietro se nella scheda ci sono meno di 15 numeri
		}
		
		
		
		//estrazione dei numeri del tabellone
		do {
			n=r.nextInt(90)+1;					//casuale da 1 a 90
			if (!numeriEstratti.contains(n)) {
				numeriEstratti.add(n);			//se il numero non è contenuto nella scheda lo aggiungo
				
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("Numero estratto: "+n);
				for (j=0;j<nrSchede;j++) {		//per ogni scheda
					schedaUtente=schedeUtente.get(j);
					
					estrattiRiga=0;
					estrattiScheda=0;
					//stampo la scheda su tre righe
					for (i=0;i<schedaUtente.size();i++) {
						if (numeriEstratti.contains(schedaUtente.get(i))) {	//se il numero della scheda è stato estratto lo evidenzio
							System.out.print("\u001b[1;34;34m");		//colore blu
							System.out.print("\u001b[1m");		//grassetto
							estrattiRiga++;
							estrattiScheda++;
							if (estrattiRiga==5)
								cinquina=true;
							if (estrattiScheda==15) {
								bingo=true;
							}
								
						}							
						else
							System.out.print("\u001b[0m");		//testo normale						
						System.out.print(schedaUtente.get(i)+" ");
						if (i==4||i==9)	{				//cambio riga => azzero il contatore della cinquina
							System.out.println();
							estrattiRiga=0;
						}
					}	
					System.out.print("\u001b[0m");		//testo normale		
					System.out.println("\n");
				}
				
				if (cinquina && !attesaBingo) {		// se ho fatto la cinquina e non sono in attesa del bingo mostro il messaggio "Cinquina"
					System.out.println("Cinquina!");
					attesaBingo=true;		//non mi interessa più la cinquina
				}	
				if (bingo)
					System.out.println("Bingo!");
				System.out.println("premi invio per continuare...");
				sc.nextLine();
				
			}
			
		} while (numeriEstratti.size()<90 && !bingo);		//torno indietro se nella scheda ci sono meno di 15 numeri e non ho fatto bingo
		sc.close();
	}

}

