#include <Arduino_FreeRTOS.h>
#include <FreeRTOSVariant.h>
#include <task.h>
#include <queue.h>
#include <semphr.h>
#include <stdio.h>
#include <stdlib.h>
#include "string.h"
//#include <iostream>

int led = 13;
QueueHandle_t Buffer_seno, Buffer_led,Buffer_serial;
TaskHandle_t xTask2Handle = NULL;

String conteudo = "";
char usar_buff[4];

struct Buff_struct {
  char ucMessageID1;
  char buff[4];
} xMessage;

#define QUEUE_ITEM_SIZE sizeof(usar_buff)
#define QUEUE_LENGTH 20

void vTaskled(void *pvParameters);
void vTaskseno(void *pvParameters);
void vReceiver(void *pvParameters);


// ### Recebe dados da serial
Buff_struct leStringSerial() {

  struct Buff_struct Usar;
  int c = 0;
  char caractere;
  String conteudo = "";
  // Enquanto receber algo pela serial
  while (Serial.available() > 0) {
    // Lê byte da serial
    caractere = Serial.read();
    //Serial.println(caractere);
    //Serial.println(c);
    Usar.buff[c] = caractere;
    // Ignora caractere de quebra de linha
    //if (caractere != '\n'){
    // Concatena valores
    // conteudo.concat(caractere);
    //}
    // Aguarda buffer serial ler próximo caractere
    //delay(10);
    vTaskDelay(10);
    c++;
  }
  Usar.buff[4]=0;
  //Serial.print("Recebi: ");
  //Serial.println(Usar.buff);
  return Usar;

}


//## Funcões para usar extensão de Taylor
double fatorial(int termos)   //função que calcula fatorial(!)
{
  float aux;
  aux = termos;
  while (termos > 1)
  {
  aux = aux * (termos - 1);
  termos--;
  }
  return (aux);
}

float power(float base, int expoente) //função potencia(x^y)
{
  float resultado;
  int i;

  resultado = 1;
  if (expoente == 0) return 1;
  for (i = 0; i < expoente; i++) resultado = resultado * base;
  return (resultado);
}
float serie_seno(float x, int termos)
{
  int i;
  float resultado;
  resultado = 0;

  for (i = 0; i < termos; i++)
  {
  resultado += power(-1, i) * power(x, 2 * i + 1) / fatorial(2 * i + 1);
  }
  return (resultado);
}

float seno(int a)
{
  int x = a;
  int termos = 10;
  float result;
  result = serie_seno(((x * 3.141592) / 180), termos);
  getchar();
  return result;
}



void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
  Serial.begin(9600);
  //while (!Serial) {
  //  ; // wait for serial port to connect. Needed for native USB, on LEONARDO, MICRO, YUN, and other 32u4 based boards.
  //}

  Buffer_seno = xQueueCreate(QUEUE_LENGTH, QUEUE_ITEM_SIZE);
  Buffer_serial = xQueueCreate(QUEUE_LENGTH, sizeof(float));
  Buffer_led = xQueueCreate(QUEUE_LENGTH, QUEUE_ITEM_SIZE);

  xTaskCreate(
  vTaskled
  ,  (const portCHAR *) "LED"
  ,  1024  // Stack size
  ,  NULL
  ,  3  // Priority
  ,  NULL );

  xTaskCreate(
  vTaskseno
  ,  (const portCHAR *) "SenoServer"
  ,  1024  // Stack size
  ,  NULL
  ,  1 // Priority
  ,  NULL );

  xTaskCreate(
  vReceiver
  ,  (const portCHAR *) "Serial"
  ,  1024  // Stack size
  ,  NULL
  ,  2 // Priority
  ,  NULL );

}


void loop() {

}
void vReceiver( void *pvParameters )
{
  const TickType_t xTicksToWait = pdMS_TO_TICKS( 100 );
  struct Buff_struct pxReceive;
  float result_seno;
 
  Serial.println("entro na Task Receiver");
  for (;;) {
  // Se receber algo pela serial
    if (Serial.available() > 0) {
      // Lê toda string recebida
      //struct Buff_struct_Receiver recebido;
      pxReceive = leStringSerial();
      Serial.println("Recebeu da Serial");
      pxReceive.buff[4]=0;
      Serial.println(pxReceive.buff);
      if ((pxReceive.buff[0] == 'B') and (pxReceive.buff[1] == 'L')) {
          xQueueSend(Buffer_led, &pxReceive.buff, 0);
          vTaskDelay(20);
          //Serial.println(uxQueueMessagesWaiting(Bufferled));
       } else if ((pxReceive.buff[0] == 'M') and (pxReceive.buff[1] == 'S')) {
          xQueueSend(Buffer_seno, &pxReceive.buff, 0);
          vTaskDelay(20);
    } else
         Serial.println("Não comunicou");
//    if ( Buffer_serial != 0 )
//    {
//      xQueueReceive(Buffer_serial, &result_seno, 10);
//      Serial.println(result_seno);   
//      Serial.print("Saindo na serial");
//      xQueueReset(Buffer_serial);
//   
//    }  


   
  }        
    
  }
}


void vTaskseno( void *pvParameters )
{

  UBaseType_t uxPriority;
  uxPriority = uxTaskPriorityGet( NULL );
  float result;
  float teste,teste1;

  Serial.println("Entrou na Task Seno");
  struct Buff_struct recebido;

  for (;;) {
  if ( Buffer_seno != 0 )
  {
    xQueueReceive(Buffer_seno, &recebido.buff,  portMAX_DELAY);
    //Serial.println(recebido.buff);
    {
    int num;
    num = atoi(&recebido.buff[2]);
    result = seno(num);
    Serial.println(result);
    xQueueSend(Buffer_serial, &result, 0); // nao funciona, não consigo deixar taskreceiver recebendo da fila pra enviar para o usuário
    xQueueReset(Buffer_seno);
    //vTaskPrioritySet( xTask2Handle, ( uxPriority + 1 ) );

    }
  }
  }

}
void vTaskled( void *pvParameters )
{

  UBaseType_t uxPriority;
  uxPriority = uxTaskPriorityGet( NULL );
  int time = 1;
  Serial.println("Entrou na Task Led");
  struct Buff_struct recebido;
  //vTaskPrioritySet( NULL, ( uxPriority - 2 ) );
  for (;;) {
//  if ( Buffer_led != 0 )
//  {
    if (xQueueReceive(Buffer_led, &recebido.buff, 0)==pdPASS){
    //Serial.println(recebido.buff);
    // Receive a message on the created queue.  Block for 10 ticks if a
    // message is not immediately available.
    time = int(recebido.buff[3]) - 48;
    //Serial.println(time);
    }
    digitalWrite(LED_BUILTIN, HIGH);
    vTaskDelay(500*time);
    digitalWrite(LED_BUILTIN, LOW);
    vTaskDelay(500*time);

    xQueueReset(Buffer_led);

  //}

  }
}
