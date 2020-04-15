public class Comutador {

   //Atributos

   private String fabricante;
   private int nPortas;
   private int velocidade;
   private boolean vlan;
   private boolean qos;
   private boolean gbic;
   private int mtu;
   private String pacotes;

   //Construtores
   public Comutador(String fabricante) {
       this.fabricante = fabricante;
   }

   public Comutador(String fabricante, int nPortas, int velocidade, boolean vlan) {
       this.fabricante = fabricante;
       this.nPortas = nPortas;
       this.velocidade = velocidade;
       this.vlan = vlan;
       this.mtu = 1500;
   }

   public Comutador() {
       this.fabricante = "Intelbras";
       this.nPortas = 16;
       this.velocidade = 500;
       this.vlan = true;
       this.qos = false;
       this.gbic = false;
       this.mtu = 1500;
       this.pacotes = " ";
   }

   //Métodos da classe

   public String getFabricante() {
       return fabricante;
   }
   public int getnPortas() {
       return nPortas;
   }
   public int getVelocidade() {
       return velocidade;
   }
   public boolean isVlan() {
       return vlan;
   }
   public boolean isQos() {
       return qos;
   }
   public boolean isGbic() {
       return gbic;
   }
   public int getMtu() {
       return mtu;
   }
   public String getPacotes() {
       return pacotes;
   }

   public void definirMtu(int mtu){
       this.mtu = mtu;
   }

   public void enviarDados(String ipOrigem, String ipDestino, String pacote){
       this.pacotes = pacote;
   }

   public void enviarDados(String ipDestino, String pacote){
       this.pacotes = pacote;
   }

   public void alterarVelocidade(int v){
       this.velocidade = v;
   }

   public boolean definirVlan(){
       this.vlan = !this.vlan;
       return (this.vlan) ? true : false;
   }

   public boolean definirQos(){
       this.qos = !this.qos;
       return (this.qos) ? true : false;
   }

   public String bloquearPorta(int p){
       String status;
       if(p>0 && p<this.nPortas){
           status = "Porta bloqueada";
       }{
           status = "Porta inválida";
       }
       return (status);
   }



}

