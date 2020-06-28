package poo;


import java.io.FileInputStream;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Grafo inserir = new Grafo("First Grafo");

        ArrayList<Node> teste = new ArrayList<>();

        inserir.addNode("desktop",EnumNodeNames.desktop);
        inserir.addNode("desktop",EnumNodeNames.desktop);
        inserir.addNode("desktop",EnumNodeNames.desktop);
        inserir.addNode("Internet",EnumNodeNames.wan);
        inserir.addNode("roteador",EnumNodeNames.router);
        inserir.addNode("switch",EnumNodeNames.sw);
        inserir.addNode("WWW Server",EnumNodeNames.server);

        //inserir.mostrarNodesSalvos();


//    O nó endpoint (desktop, câmera IP, servidor) poderá estar associado a no máximo a um outro nó
//    O nó roteador poderá estar associado com 2 ou N outros nós
//    O nó firewall poderá estar associado com 2 ou N outros nós
//    O nó switch (comutador) poderá estar associado com 1 ou N outros nós
//    O nó Internet poderá estar associado com 1 ou N outros nós
//    wan -- router
//    router -- sw1
//    sw1 -- serverWWW
//    sw1 -- {desktop1 desktop2 desktop3} 1 ou N

        inserir.nodeOrigemToDestino("router1","sw1","desktop1");



        System.out.println(inserir.validarRestricoes());

//        for(Node aux : teste){
//            if(aux.getNomeNode().equals("firewall1")){
//                aux.setFontSize(14);
//            }else if(aux.getNomeNode().equals("wan1")){
//                aux.setShape("oval");
//            }
//        }

      // inserir.addSubGrafo("LAN","desktop1","desktop2","desktop3");
       //inserir.addSubGrafo("DMZ","server1");

        //System.out.println(inserir.toString());
//        ArrayList<SubGrafo> aaa = inserir.getSubGraph();
//        for(SubGrafo aux : aaa){
//            if(aux.getLabel().equals("LAN")){
//                aux.setBgcolor("yellow");
//            }if(aux.getLabel().equals("DMZ")){
//                aux.setBgcolor("lightyellow");
//            }
//
//        }
        //System.out.println(inserir.toString());










    }
}
