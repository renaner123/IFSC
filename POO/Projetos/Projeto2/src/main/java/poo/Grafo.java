package poo;


import java.util.*;


public class Grafo {

    private static final String LABELLOCPADRAOGRAFO = "t";
    private static final String RANKDIRPADRAO = "TB";

    private String label;
    private String labelLoc;
    private String 	rankdir;
    private int fontSize =0;

    private Node node;
    private SubGrafo subGrafo;
    private ArrayList<Node> nos = new ArrayList<>();
    private ArrayList<SubGrafo> subGraph = new ArrayList<>();

    public Grafo(String label) {
        this.label = label;
        this.labelLoc = LABELLOCPADRAOGRAFO;
        this.rankdir = RANKDIRPADRAO;
    }

    public void addNode(String label, EnumNodeNames tipo){
        switch(tipo){
            case wan:
                nos.add(new Internet(label,tipo));
                break;
            case router:
                nos.add(new Roteador(label,tipo));
                break;
            case sw:
                nos.add(new Switch(label,tipo));
                break;
            case desktop:
            case ipCamera:
            case rackServer:
            case server:
                nos.add(new EndPoint(label,tipo));
                break;
            case firewall:
                nos.add(new Firewall(label,tipo));
                break;

            default:
                break;

        }

    }

    public void addSubGrafo(String label, String... nodes){
        subGraph.add(new SubGrafo(label,nodes));
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelLoc() {
        return labelLoc;
    }

    public String getRankdir() {
        return rankdir;
    }

    public void setRankdir(String rankdir) {
        this.rankdir = rankdir;
    }

    public void setLabelLoc(String labelLoc) {
        this.labelLoc = labelLoc;
    }

    public ArrayList<Node> getNos() {
        return nos;
    }

    public static String getLABELLOCPADRAOGRAFO() {
        return LABELLOCPADRAOGRAFO;
    }

    public static String getRANKDIRPADRAO() {
        return RANKDIRPADRAO;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public ArrayList<SubGrafo> getSubGraph() {
        return subGraph;
    }

    public void setSubGraph(ArrayList<SubGrafo> subGraph) {
        this.subGraph = subGraph;
    }

    public SubGrafo getSubGrafo() {
        return subGrafo;
    }

    public void mostrarNodesSalvos(){
        for(Node aux : this.nos){
            System.out.println(aux.getNomeNode() + " label="+aux.getLabel());
        }
    }


//    O nó endpoint (desktop, câmera IP, servidor) poderá estar associado a no máximo a um outro nó
//    O nó roteador poderá estar associado com 2 ou N outros nós
//    O nó firewall poderá estar associado com 2 ou N outros nós
//    O nó switch (comutador) poderá estar associado com 1 ou N outros nós
//    O nó Internet poderá estar associado com 1 ou N outros nós
//    wan -- router
//    router -- sw1
//    sw1 -- serverWWW
//    sw1 -- {desktop1 desktop2 desktop3} 1 ou N

    public boolean validarRestricoes(){
        for (Node auxNode : nos) {
            System.out.println(auxNode.getNomeNode() + " " +auxNode.getContRestricao());
            if(auxNode.getContRestricao()!=0) {
                if ((auxNode.getContRestricao() >= auxNode.getMinAssociacao() && auxNode.getContRestricao() <= auxNode.getMaxAssociacao())) {
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public void nodeOrigemToDestino(String nodeOrigem, String... nodesDestinos) {
        ArrayList<String> destinos = new ArrayList<>();
        //Precisa verificar se o destino é valido
        if (nodesDestinos.length > 1) {
            for (int i = 0; i < nodesDestinos.length; i++) {
                destinos.add(nodesDestinos[i]);
            }
        } else {
            destinos.add(nodesDestinos[0]);
        }
        for (Node auxNode : nos) {
            if(auxNode.getNomeNode().equals(nodeOrigem)) {
                if (auxNode.getArcos().size()>=1){
                    auxNode.setContRestricao(auxNode.getArcos().size()+destinos.size());
                }else {
                    auxNode.setContRestricao(destinos.size());
                }
            }
            for(String aux : destinos){
                if(auxNode.getNomeNode().equals(aux)){
                    auxNode.setContRestricao(auxNode.getContRestricao()+1);
                }
            }
        }
        for (Node auxNode : nos) {
            if (auxNode.getNomeNode().equals(nodeOrigem)) {
                addList(destinos, auxNode);
            }
        }
    }

//    public boolean nodeOrigemToDestino(String nodeOrigem, String... nodesDestinos) {
//        ArrayList<String> destinos = new ArrayList<>();
//
//        if (nodesDestinos.length > 1) {
//            for (int i = 0; i < nodesDestinos.length; i++) {
//                destinos.add(nodesDestinos[i]);
//            }
//        } else {
//            destinos.add(nodesDestinos[0]);
//        }
//        for (Node auxNode : nos) {
//            if(auxNode.getNomeNode().equals(nodeOrigem)) auxNode.setContRestricao(auxNode.getContRestricao()+1);
//            for(String aux : destinos){
//                if(auxNode.getNomeNode().equals(aux)){
//                    auxNode.setContRestricao(auxNode.getContRestricao()+1);
//                }
//            }
//        }
//        for (Node auxNode : nos) {
//            //verifica se node atual atende a restrição
//            if((auxNode.getContRestricao()>=auxNode.getMinAssociacao() && auxNode.getContRestricao() <= auxNode.getMaxAssociacao()) && auxNode.getNomeNode().equals(nodeOrigem)) {
//                //verifica se os arcos do node atendem a restricao
//                for (Node auxNode2 : nos) {
//                    for(String aux : destinos){
//                        if(auxNode2.getNomeNode().equals(aux)){
//                            if((auxNode2.getContRestricao()>=auxNode2.getMinAssociacao() && auxNode2.getContRestricao() <= auxNode2.getMaxAssociacao())){
//                                addList(destinos,auxNode);
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }
//

    private void addList(ArrayList<String> destinos, Node auxNode) {
        if (auxNode.getArcos().size() >= 1) {
            ArrayList<String> resultArray = new ArrayList<>(auxNode.getArcos().size() + destinos.size());
            resultArray.addAll(auxNode.getArcos());
            resultArray.addAll(destinos);
            auxNode.setArcos(resultArray);
        }else{
            auxNode.setArcos(destinos);
        }
    }

    // Gera uma String contendo os Arcos entre os nós do Grafo
    public String arcosEntreNosdoGrafo(){
        String toReturn="";
        for(Node aux : nos) {
            if(aux.getArcos().size()>=1) {
                toReturn += "" +
                        "\t" + aux.getNomeNode() + " -- " + aux.getArcos().toString().replace(",", "").replace("[", "{").replace("]", "}") + "\n" +
                        "";
            }
        }
        return toReturn;
    }
    //Gera uma String com todos os nós do grafo
    private String nosDoGrafro(){
        String toReturn="";
        for(Node aux : nos) {
            toReturn += "\t" +aux.toString() + "\n";
        }
        return toReturn;
    }
    //Padrao para montar um Grafo
    private String padraoGafro(){
        String auxReturn = "";
        auxReturn += "\n"+"\t" +"label = \"" + this.getLabel() + "\"" +'\n' +
                "\t" +"labelloc=" + " " + this.getLabelLoc() +";\n" +
                "\t" +"rankdir=" + " " + this.getRankdir() +";\n" +
                "\n"+
                "\t" +"node " + "[labelloc=" +node.getLABELLOCPADRAONODE() + " fontsize=" + node.getFONTEPADRAO() +  " shape=" + node.getSHAPEPADRAO() + "]\n";
        return auxReturn;
    }
    private String getPadraoSubGrafo(){
        String auxReturn = "";
        for(SubGrafo aux : this.subGraph){
            auxReturn += aux.padraoSubGrafo();
        }
        return auxReturn;
    }



    public String exportarFormatoDot(){
        return "";
    }
    public void salvarDiagramaNoDisco(String nomeDoArquivo, ArrayList<Grafo> grafo) {

    }
    public void lerDiagramaDoDisco(String nomeDoArquivo) {

    }

    @Override
    public String toString() {
        return "graph "+ this.getLabel().toLowerCase().replace(" ","") +"{" +
                this.padraoGafro() + "\n" + this.nosDoGrafro() + "\n"  + this.arcosEntreNosdoGrafo() +"\n" + this.getPadraoSubGrafo()+"\n" +
                "}";
    }




}
