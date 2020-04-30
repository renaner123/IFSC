/*
  Projeto - Temômetro LCD com sensor LM35 e Arduino
  By - Zedequias Fonseca  -  08/2014
  http://vfeletronica.blogspot.com.br
*/
#include <stdint.h>
#include <LiquidCrystal.h> // Biblioteca para o LCD
#define TEMPORECEITA A
#define TEMPORECEITA B
#define TEMPORECEITA C
#define TEMPERATURAREICEITA A
#define TEMPERATURAREICEITA B
#define TEMPERATURAREICEITA C



// Variáveis
int tempPin = A0;          // Declaração do pino de entrada analógica 0 (A0) no Arduino
int potPin = A2;          // Declaração do pino de entrada analógica 0 (A0) no Arduino
int resistenciaPin = 7;
int sensorbomba = 9;    // sensor do tanque
float mAmostra;     // matriz para armazenar oito amostras para o cálculo da temperatura média
float mLeitura = 0.00; // variavel para armazena leitura da temperatura
int pLeitura = 0;
volatile int estado = 0;       // maquina de estado
int contReceita = 0;  // Auxiliar para buscar as receitas.
int buzzer = 4;
boolean processo = false; //false = manual, true = automático
double tempAtual;   // armazema temperatura atual do sensor
int botomMais = 3;
int botomMenos = 2;
int botomConfirma = 6;
int botomSelecionar = 5;
int buttonState = 0;
int leituraup = 0;
int leituradown = 0;
int contador = 0;

struct receitas{
  int t_receita;  // tempo da receita
  int T_receita;  // Temperatura da receita
};

LiquidCrystal lcd(13, 12, 11, 10, 9, 8); // Inicialização do display e pinos correspondentes

// ligar a bomba
void bomba_on(){
  digitalWrite(potPin, HIGH);
}
// desligar a bomba
void bomba_off(){
  digitalWrite(potPin, LOW);
}
// verificar nível da agua
bool check_water(){
  return digitalRead(sensorbomba) == HIGH;
  //struct receitas p1 = {30,20,50,35,60,70};
}

double verifica_temp(){
    mAmostra = (5 * analogRead(tempPin) * 100.0) / 1024.0;          
    mLeitura = analogRead(tempPin);  // ler porta analogica
    delay(500);
    return mAmostra;                 // imprime valor lido na porta analogica no Virtual Terminal 
                               // aguarda  
}

receitas receitasPadrao(int t, int T){
  receitas r;
  r.t_receita = t;
  r.T_receita = T;
  return r;
}

  receitas receita1 = receitasPadrao(20,20);
  receitas receita2 = receitasPadrao(30,50);
  receitas receita3 = receitasPadrao(40,110);
  receitas receitaEmProcesso;

void setup()
{

  pinMode(resistenciaPin, OUTPUT);
  pinMode(botomMais, INPUT);
  pinMode(botomMenos, INPUT);
  pinMode(botomConfirma, INPUT);
  pinMode(botomSelecionar, INPUT);
  
  Serial.begin(9600);                     // inicia comunicação serial
  lcd.begin(16, 3);                          // inicia e configura o número de linhas e colunas do LCD
  lcd.setCursor(1, 0);                      // seta posição do cursor (coluna, linha) do LCD
  lcd.print("Controlador de cerveja");  // imprime texto no LCD 
  delay(3000);   // aguarda 1s
  bomba_on();

}

void loop()
{

    
  switch (estado)
  {          

      case 0 :            // Seleciona modo de operação, manual ou atuomático  

        lcd.clear();
        lcd.setCursor(1, 0);        // seta posição do cursor LCD
        lcd.print("Selecione Modo"); // imprime amostra da temperatura atual no LCD
        delay(2000);
        buttonState = digitalRead(botomSelecionar);

        if(buttonState==0){
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Manual"); // imprime amostra da temperatura atual no LCD   
          delay(1500);
          estado = 5;
          break;
        }else{
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Automatico"); // imprime amostra da temperatura atual no LCD[
          estado = 1;
          delay(1500);
          break;
        } 

      case 1: // Busca a receita no automático
        analogWrite(buzzer, 0);
        digitalWrite(resistenciaPin, LOW);

        if(contReceita==0){
          receitaEmProcesso = receita1;
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Receita1 selected"); // imprime amostra da temperatura atual no LCD
          delay(2000);
          Serial.println("Tempo da receita");    
          Serial.println(receitaEmProcesso.T_receita);
          estado = 2;
          delay(1000);
          break;
        }else if(contReceita==1){
          receitaEmProcesso = receita2;
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Receita2 selected"); // imprime amostra da temperatura atual no LCD
          delay(2000);
          Serial.println("Tempo da receita");    
          Serial.println(receitaEmProcesso.T_receita);
          estado = 2;
          break;
        }else if(contReceita==2){
          receitaEmProcesso = receita3;
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Receita3 selected"); // imprime amostra da temperatura atual no LCD
          Serial.println("Tempo da receita");    
          Serial.println(receitaEmProcesso.T_receita);
          delay(2000);
          estado = 2;
          break;
        }else if(contReceita ==5){
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Receita Manual"); // imprime amostra da temperatura atual no LCD
          Serial.println(receitaEmProcesso.T_receita);    
          estado = 2;
          break;
        }else{
          break;
        }
      case 2:
          analogWrite(buzzer, 0);
          digitalWrite(resistenciaPin, HIGH);
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Aquecendo a Agua"); // imprime amostra da temperatura atual no LCD   
        while(verifica_temp()<(receitaEmProcesso.T_receita/2)){
            delay(500);
        }

        estado = 3;
        break;


      case 3:
        lcd.clear();
        lcd.setCursor(1, 0);        // seta posição do cursor LCD   
        digitalWrite(resistenciaPin, LOW);
        lcd.print("Adicionar produto?"); // imprime amostra da temperatura atual no LCD
        analogWrite(buzzer, 500);
        delay(2000);
        buttonState = digitalRead(botomConfirma);
        analogWrite(buzzer, 0);
        if(buttonState==0){
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Nao adicionou"); // imprime amostra da temperatura atual no LCD   
          delay(1500);
        }else{
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Adicionado"); // imprime amostra da temperatura atual no LCD[
          delay(1500);
        } 
        digitalWrite(resistenciaPin, HIGH);
        lcd.clear();
        lcd.setCursor(1, 0);        // seta posição do cursor LCD
        lcd.println("Aquecendo a Agua"); // imprime amostra da temperatura atual no LCD  

        while(verifica_temp()<(receitaEmProcesso.T_receita)){
          delay(500);
        }
        estado = 4;
        break;

      case 4:
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          lcd.print("Finalizou receita"); // imprime amostra da temperatura atual no LCD   
          digitalWrite(resistenciaPin, LOW);
          analogWrite(buzzer, 700);
          delay(2000);
        Serial.println(contReceita);
        if(contReceita==0){
          contReceita = 1;
          estado = 1;
          analogWrite(buzzer, 0);
        }else if(contReceita==1){
          contReceita = 2;
          estado = 1;
          analogWrite(buzzer, 0);
        }else if(contReceita){ 
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          analogWrite(buzzer, 0);
          lcd.print("Programa encerrado"); // imprime amostra da temperatura atual no LCD  
        }else{
          contReceita = 0;
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          analogWrite(buzzer, 0);
          lcd.print("Programa encerrado"); // imprime amostra da temperatura atual no LCD  
        }
        break;
        case 5:
          lcd.clear();
          lcd.setCursor(1, 0);        // seta posição do cursor LCD
          contador = 0;
          lcd.clear();
          lcd.setCursor(1,0);
          lcd.print("Selecione Temp");
          while(true){
            leituraup = digitalRead(botomMais);
            leituradown = digitalRead(botomMenos);

          //leituradown = digitalRead(botao2);
          // Verifica se o objeto foi detectado pelo sensor
            if (leituraup == HIGH) 
            {  
              delay(300);
              // Incrementa o valor do contador
              contador = contador + 5;
              // Apaga o valor anterior
              lcd.clear();
              lcd.setCursor(1,0);
              lcd.print("Temperatura");
              // Mostra o valor do contador
              lcd.setCursor(13,0);
              lcd.print(contador);              
            } 
            if (leituradown == HIGH) 
            {  
              delay(300);
              // Incrementa o valor do contador
              if(contador > 0){
                contador = contador - 5;
                // Apaga o valor anterior
                lcd.setCursor(1,0);
                lcd.print("Temperatura");
                // Mostra o valor do contador
                lcd.setCursor(13,0);
                lcd.print(contador);

              }else{
                    lcd.setCursor(11,0);
                lcd.print("                ");
                // Mostra o valor do contador
                lcd.setCursor(11,0);
                lcd.print(contador);           
          
              }   
            } 
            buttonState = digitalRead(botomConfirma);
            if(buttonState==1){
              receitaEmProcesso.T_receita = contador;
              delay(1500);
              contReceita = 5;
              estado = 1;
              Serial.println(contador);
              break;
            }
          }












  }
    
}    
  

  



 /*
          if(tempAtual>=20){
          estado = 1;          
        }else{
          estado = 0;
        }
*/
