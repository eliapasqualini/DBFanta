package db;

import model.FantaSquadra;
import model.InserimentoAttaccante;

public class Test {
	
	public static void main(String[] args) {
		GiornataTable gt = new GiornataTable();
		LegheTable lt = new LegheTable();
		ClassificaTable ct = new ClassificaTable();
		FantaPartiteTable fpt = new FantaPartiteTable();
		PartiteTable pt = new PartiteTable();
		FantaSquadreTable fsq = new FantaSquadreTable();
		FantaCalciatoriTable fct = new FantaCalciatoriTable();
		CampionatoTable cat = new CampionatoTable();
		FantaAllenatoriTable fat = new FantaAllenatoriTable();
		AttaccanteTable at = new AttaccanteTable();
		System.out.println("Tutte le giornate");
		gt.selectGiornate();
		for(int giornata : gt.selectGiornate()) {
			System.out.println(giornata);
		}
		System.out.println("Nomi delle leghe");
		for(String s : lt.selectLegheName()) {
			System.out.println(s);
		}
		System.out.println("Classifica");
		for(FantaSquadra f : ct.selectTable(2)) {
			System.out.println(f.toString());
		}
		System.out.println("Partite della 5 Giornata ");
		pt.selectPartite(5);
		System.out.println("Fanta-Partite della 1 giornata");
		fpt.selectFantaPartite(1, 2);
		System.out.println("Le Fanta-Squadre della lega aa");
		for (FantaSquadra s : fsq.selectNameFantaSquadre("ignorante")) {
			System.out.println(s.getNome());
		}
		System.out.println("inserisci la formazione per la giornata 3 della squadra ab");
		//fft.insertFormazione("ab", 6);
		System.out.println(lt.selectIDLega("aa"));
		System.out.println(fct.selectFantaCalciatori(2, "ab").toString());
		System.out.println(fsq.numeroPartiteGiocate(2));
		System.out.println(cat.selectCampionati());
		System.out.println(fat.selectIdAllenatore("Elia", "Pasqualini"));

		for (InserimentoAttaccante a: at.selectInserimenti(3)) {
			System.out.println(a.getAttaccante());
		}
		fsq.updateVittora("j", 5, "77");
	}
		
}
