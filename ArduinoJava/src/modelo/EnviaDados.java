package modelo;
import comunicacaoSerial.ArduinoSerial;

public class EnviaDados extends PropriedadesSensor
{
    
    
    public void Executar()
    {
        PropriedadesSensor prop = new PropriedadesSensor();
        AtualizaDados s = new AtualizaDados();
        ArduinoSerial arduino = new ArduinoSerial("COM1");
        
        Thread t = new Thread(){
            @Override
            public void run() {
                
                arduino.initialize();
                arduino.sleep(5000);
                
                while (true) {
                    
                    arduino.read();
                    
                    String leituraserial = arduino.getTexto();
                    String[] partes = leituraserial.split("&");
                    
                    prop.setValortemp(Double.parseDouble(partes[0]));
                    prop.setValorhumi(Double.parseDouble(partes[1]));
                    prop.setValorchuva(partes[2]);
                    
                    
                    
                    if( s.Salvar(prop, prop, prop) ){
                      System.out.println("Atualizado com Sucesso");
                    
                      
                    }
                    else{
                      System.out.println("Erro ao Atualizar");
                  } 
                  
                  arduino.sleep(1000);
                }
                
            } 
        };
     t.start();
    }
    
    
    
}
