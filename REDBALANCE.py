import os
import random
import time

print("=======================================================")
print("=======================================================")
print(" ___  ____ ___     ___   ____ _     ____ _  _ ____ ____ ")
print(" |__] |___ |  \\    |__]  |__| |     |__| |\\ | |    |___ ")
print(" |  \\ |___ |__/    |__]  |  | |___  |  | | \\| |___ |___ ")
print("=======================================================")
print("=======================================================")
print("PRESIONA ENTER PARA INICIAR")
input()
os.system("cls" if os.name == "nt" else "clear")

print(
    "Cuatro cifras pendientes, cero billetes en el bolsillo y ni una sola puerta"
    " más que tocar"
)
print(
    "Tu única salida es el hipódromo: multiplicas tus últimas monedas en la"
    " pista o al amanecer vendrán a cobrarte"
)
print(" ")
print("Presiona ENTER para continuar")
input()
os.system("cls" if os.name == "nt" else "clear")

print("                           REGLAS                               ")
print("1. Al final de cada apuesta vendran a cobrarte parte de la deuda")
print("")
print("2. Esta parte puede variar entre $50 - $200")
print("")
print("3. Si no logras pagar a tiempo perderas de inmediato")
print("")
print("4. Ten en cuenta que lo apostado se restara a tu sado restante")
print("Presiona ENTER para continuar")
input()
os.system("cls" if os.name == "nt" else "clear")

caballoganador = 0.0
apuesta = 0.0
acumulado = 0.0
Deuda = 5000.0
saldo = 1000.0
selecciondecaballo = 0
pagardeuda = False


while True:
  while Deuda > 0:
    print("===============================================")
    print("Tu saldo es de:", saldo, "   =   ", "Tu deuda es :", Deuda)
    print("===============================================")
    print("    Bienvenido a la carrera te caballos  ")
    print("          Selecciona tu caballo            ")
    print(" 1.Relampago  2.Pegazo  3.Potro  4.Fenix ")
    print("===============================================")

  
    while True:
      selecciondecaballo = int(input())

      # Equivalente a: Segun selecciondecaballo Hacer
      if selecciondecaballo in [1, 2, 3, 4]:
        print("tu saldo es de: ", saldo)
        print("Ingresa tu apuesta inicial")
        apuesta = float(input())
        print("Tu apuesta es de:", apuesta)
        saldorestante = saldo - apuesta
        print("Tu saldo restante es: ", saldorestante)
        os.system("cls" if os.name == "nt" else "clear")

        if apuesta > saldo:
          print("Lo sentimos no cuentas con ese saldo")
          apuesta = 0
        else:
          if selecciondecaballo >= 1 and selecciondecaballo <= 4:
            caballoganador = random.randint(1, 4)

          if caballoganador == selecciondecaballo:
            saldo = saldo + (apuesta * 1.50)
            print(" =================================== ")
            print(" = Tu caballo ha ganado la carrera = ")
            print(" =================================== ")
            print(" =================================== ")
            print("  Tu nuevo saldo es de: ", saldo)
            print("=====================================")
          else:
            saldo = saldo - apuesta
            print(" ================================== ")
            print(" = Tu caballo perdio la apuesta   = ")
            print(" ================================== ")
            print("  Tu nuevo saldo es de:", saldo)
            print("=================================== ")
      else:
        print("Opcion no valida, ingresa un numero valido")

      if selecciondecaballo >= 1 and selecciondecaballo <= 4:
        break

    print("Presiona ENTER para continuar")
    input()
    os.system("cls" if os.name == "nt" else "clear")

    acumulado = +saldo
    pago = random.randint(50, 200)
    print("El sol ya salió y tus", pago, "de deuda siguen sin aparecer.")
    print("                      Pagaras tu deuda?                      ")
    print("                            V/F                              ")

   
    entrada = input().upper()
    if entrada == "V" or entrada == "VERDADERO":
      pagardeuda = True
    else:
      pagardeuda = False

    if pagardeuda:
      Deuda = Deuda - pago
      saldo = saldo - pago
      print("iniciando siguiente ronda")
      print("=====                    ")
      time.sleep(1)
      os.system("cls" if os.name == "nt" else "clear")
      print("iniciando siguiente ronda")
      print("============             ")
      time.sleep(1)
      os.system("cls" if os.name == "nt" else "clear")
      print("iniciando siguiente ronda")
      print("===================      ")
      time.sleep(1)
      os.system("cls" if os.name == "nt" else "clear")
      print("iniciando siguiente ronda")
      print("=========================")
      time.sleep(1)
      os.system("cls" if os.name == "nt" else "clear")
    else:
      print("=================================================")
      print("Sin pago no hay mañana. Las sombras te alcanzaron.")
      print("                 GAME OVER                        ")
      print("=================================================")
      saldo = 0

  if Deuda <= 0:
    print("===============================================")
    print("Felcidades eres libre para ver un nuevo mañana")
    print("===============================================")
    break