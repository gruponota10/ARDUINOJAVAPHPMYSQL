#include "DHT.h"

#define DHTPIN 2

#define DHTTYPE DHT11

DHT dht(DHTPIN, DHTTYPE);


void setup() {
  
  Serial.begin(9600);
  pinMode(7, OUTPUT);
  dht.begin();

}

void loop() {

  delay(2000);

  float h = dht.readHumidity();
  float t = dht.readTemperature();
  float hic = dht.computeHeatIndex(t, h, false);
  String c;

  if(analogRead(0)<300) c= "Chuva Forte"; 
  else if(analogRead(0)<500) c="Chovendo"; 
  else c ="Não Chove";
  delay(250);
  
  Serial.print(t);
  Serial.print("&");
  Serial.print(h);
  Serial.print("&");
  Serial.print(c);
  Serial.print("\n");



 
}
