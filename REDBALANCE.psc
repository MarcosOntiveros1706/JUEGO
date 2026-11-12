Algoritmo REDBALANCE
		Escribir "=======================================================";
		Escribir "=======================================================";
		Escribir " ___  ____ ___    ___   ____ _    ____ _  _ ____ ____ ";
		Escribir " |__] |___ |  \   |__]  |__| |    |__| |\ | |    |___ ";
		Escribir " |  \ |___ |__/   |__]  |  | |___ |  | | \| |___ |___ ";
		Escribir "=======================================================";
		Escribir "=======================================================";
		Escribir "PRESIONA ENTER PARA INICIAR";
		Esperar Tecla;
		Borrar Pantalla;
		Escribir "Cuatro cifras pendientes, cero billetes en el bolsillo y ni una sola puerta mas que tocar";
		Escribir "Tu unica salida es el hipodromo: multiplicas tus ultimas monedas en la pista o al amanecer vendran a cobrarte";
		Escribir " ";
		Escribir "Presiona ENTER para continuar";
		Esperar Tecla;
		Borrar Pantalla;
		Escribir "                           REGLAS                               ";
		Escribir "1. Al final de cada apuesta vendran a cobrarte parte de la deuda";
		Escribir "";
		Escribir "2. Esta parte puede variar entre $50 - $200";
		Escribir "";
		Escribir "3. Si no logras pagar a tiempo perderas de inmediato";
		Escribir "";
		Escribir "4. Ten en cuenta que lo apostado se restara a tu sado restante";
		Escribir "Presiona ENTER para continuar";
		Esperar Tecla;
		Borrar Pantalla;
		Definir caballoganador, apuesta, acumulado, saldo, saldorestante, pago, Deuda como real;
		saldo <- 1000;
		Deuda <- 5000;
		acumulado <- 0;
		Definir selecciondecaballo como entero;
		Definir pagardeuda Como Logico;
		
		Repetir
			Mientras deuda > 0 Hacer
				
				Escribir "===============================================";
				Escribir "Tu saldo es de:", saldo, "   =   ",  "Tu deuda es :", Deuda;
				Escribir "===============================================";
				Escribir "    Bienvenido a la carrera te caballos  ";
				Escribir "         Selecciona tu caballo           ";
				Escribir " 1.Relampago  2.Pegazo  3.Potro  4.Fenix ";
				Escribir "===============================================";
				Repetir
					leer selecciondecaballo;
					Segun selecciondecaballo Hacer
						1, 2, 3, 4:
							Escribir "tu saldo es de: ", saldo;
							Escribir "Ingresa tu apuesta inicial";
							leer apuesta;
							Escribir "Tu apuesta es de:", apuesta;
							saldorestante <- saldo - apuesta;
							Escribir "Tu saldo restante es: ", saldorestante;
							Borrar Pantalla;
							Si apuesta > saldo Entonces
								
								Escribir "Lo sentimos no cuentas con ese saldo";
								apuesta <- 0;
							SiNo
							 Si selecciondecaballo >= 1 y selecciondecaballo <= 4 Entonces
									caballoganador <- Aleatorio(1,4);
							 Finsi
								
							 Si caballoganador = selecciondecaballo Entonces
									saldo <- saldo + (apuesta * 1.50);
									Escribir " =================================== ";
									Escribir " = Tu caballo ha ganado la carrera = ";
									Escribir " =================================== ";
									Escribir " =================================== ";
									Escribir "  Tu nuevo saldo es de: ", saldo;   
									Escribir "=====================================";
							 SiNo
									saldo <- saldo - apuesta;
									Escribir " ================================== ";
									Escribir " = Tu caballo perdio la apuesta   = ";
									Escribir " ================================== ";
									Escribir "  Tu nuevo saldo es de:", saldo ;  
									Escribir "=================================== ";
							 FinSi
							Finsi
						De Otro Modo:
						   Escribir "Opcion no valida, ingresa un numero valido";
					FinSegun
				Hasta Que selecciondecaballo >= 1 & selecciondecaballo <= 4
				
				Escribir "Presiona ENTER para continuar";
				Esperar Tecla;
				Borrar Pantalla;
				
				acumulado <- acumulado + saldo;
				pago <- Aleatorio(50, 200);
				Escribir "El sol ya sali� y tus ", pago, " de deuda siguen sin aparecer.";
				Escribir "                      Pagaras tu deuda?                     ";
				Escribir "                            V/F                             ";
				leer pagardeuda;
				Si pagardeuda Entonces
					Deuda <- Deuda - pago;
					saldo <- saldo - pago;
					Escribir "iniciando siguiente ronda";
					Escribir "=====                    ";
					Esperar 1 Segundos;
					Borrar Pantalla;
					Escribir "iniciando siguiente ronda";
					Escribir "============             ";
					Esperar 1 Segundos;
					Borrar Pantalla;
					Escribir "iniciando siguiente ronda";
					Escribir "===================      ";
					Esperar 1 Segundos;
					Borrar Pantalla;
					Escribir "iniciando siguiente ronda";
					Escribir "=========================";
					esperar 1 Segundos;
					Borrar Pantalla;
				SiNo
					Escribir "=================================================";
					Escribir"Sin pago no hay ma�ana. Las sombras te alcanzaron.";
					Escribir "                 GAME OVER                       ";
					Escribir "=================================================";
					saldo <- 0;
				FinSi
			FinMientras
		Hasta Que saldo <= 0 o deuda <= 0
		
		Si saldo >= 1 y deuda <= 0 Entonces
			Escribir "================================================";
			Escribir "Felicidades eres libre para ver un nuevo ma�ana";
			Escribir "================================================";
		FinSi
		
FinAlgoritmo
