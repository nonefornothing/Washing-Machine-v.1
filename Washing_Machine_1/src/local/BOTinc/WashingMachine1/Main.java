package local.BOTinc.WashingMachine1;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		HashSet<String> arrPakaian = new HashSet<String>();
		
		ArrayList<Integer> arrTotalPakaian = new ArrayList<Integer>();
		
		int pilihanMenu;
		int jlhPakaianKotor = 0, jlhPakaianBersih = 0;
		int jlhPakaianKotorPerPakaian = 0;
		int jlhPakaianAmbil=0;
		String namaPakaian;
		int pilihanLanjut = 0; //untuk semua pilihan lanjut tidak pada menu 1,2,3

		do {
			
			System.out.println("Menu Utama");
			System.out.println("1. input pakaian kotor");
			System.out.println("2. cuci pakaian yang kotor");
			System.out.println("3. ambil pakaian bersih");
			System.out.println("4. laporan pakaian pakaian kotor , pakaian bersih dan pakaian yang sudah diambil");
			System.out.println("5. keluar aplikasi");
		
			pilihanMenu = getAnInteger();
			
			if (pilihanMenu == 1) {//input pakaian kotor
				
				do {
					
					input.nextLine();
					System.out.println("Input Jenis Pakaian : ");
					namaPakaian = input.nextLine();
					arrPakaian.add(namaPakaian);
					
					System.out.println("Input Jumlah Pakaian Kotor : ");
					jlhPakaianKotorPerPakaian = getAnInteger();
					arrTotalPakaian.add(jlhPakaianKotorPerPakaian);
					
					
					System.out.println("Apakah masih ada pakian kotor lagi yang akan diinput ?");
					System.out.println("1. Ya");
					System.out.println("2. Tidak");
					
					pilihanLanjut = getAnInteger();
					
					if(pilihanLanjut == 2) {
						break;
					}
					
				}while(true);
				
				for(int i : arrTotalPakaian) {
					jlhPakaianKotor = jlhPakaianKotor + i;
				}
				
				
			}
			else if (pilihanMenu == 2) {//cuci pakaian
				
				do {
					
					int temp = 0;
					
					if(jlhPakaianKotor == 0) {
						System.err.println("Jumlah Pakaian Kotor berjumlah 0 , Masukkan nilai jumlah pakaian kotor");
						break;
					}
					else {
						System.out.println("Input Jumlah Pakaian Kotor yang akan di cuci : ");
						temp = getAnInteger();
						
						jlhPakaianKotor = jlhPakaianKotor - temp;
						jlhPakaianBersih = jlhPakaianBersih + temp;
						
						System.out.println("Apakah masih ada pakian kotor lagi yang akan diinput ?");
						System.out.println("1. Ya");
						System.out.println("2. Tidak");
						
						pilihanLanjut = getAnInteger();
						
						if(pilihanLanjut == 2) {
							break;
						}
					}

				}while(true);
				
			} 
			else if (pilihanMenu == 3) {//ambil pakaian bersih
				
				do {
					
					if(jlhPakaianBersih == 0) {
						System.err.println("Jumlah Pakaian Bersih berjumlah 0 , Masukkan nilai jumlah pakaian bersih");
						break;
					}
					else {
						
						int temp = 0;
						System.out.println("Input Jumlah Pakaian Bersih yang akan diambil : ");
						temp = getAnInteger();
					
						jlhPakaianBersih = jlhPakaianBersih - temp;
						jlhPakaianAmbil = jlhPakaianAmbil + temp;
						System.out.println(jlhPakaianAmbil);
						
						System.out.println("Apakah masih ada pakian kotor lagi yang akan diinput ?");
						System.out.println("1. Ya");
						System.out.println("2. Tidak");
						
						pilihanLanjut = getAnInteger();
						
						if(pilihanLanjut == 2) {
							break;
						}
						
					}	
					
				}while(true);
				
				
			}
			else if (pilihanMenu == 4){//laporan pakaian kotor & bersih
				//menampilkan laporan pakaian kotor, pakaian bersih, pakaian yang sudah diambil (nama dan total)
				
				System.out.println("Berikut Jenis Pakaian yang kotor :");
				for(String i : arrPakaian) {
					System.out.println(i);
				}		
				
				System.out.println("Total pakaian kotor : " +  jlhPakaianKotor);
				System.out.println("Total pakaian bersih : " + jlhPakaianBersih);
				System.out.println("Total pakaian yang sudah diambil : " + jlhPakaianAmbil);
				
			}
			else if (pilihanMenu == 5) {
				System.exit(0);
			}
			
		}while(true);
		
	}
	
	
	public static Integer getAnInteger() {
		while (true) {
			try {
				return input.nextInt();
			} catch (InputMismatchException e) {
				input.next();
				System.err.print("Try again: ");
			}
		}
	}

}
