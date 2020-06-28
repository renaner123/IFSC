//package poo;
//
//public class teste extends Grafo {
//
//    public SubGrafo(String label, String... nodes) {
//        super(label);
//        this.setLabelSubGrap(label);
//        this.addSubGrafo(label,nodes);
//        this.PadraoSubGrafo();
//    }
//
//
//    public void addSubGrafo(String label, String ... nodes){
//        String auxSub = "";
//        for(int i=0; i<nodes.length;i++){
//            for(Node aux : this.getNos()){
//                if(aux.getNomeNode().equals(nodes[i])){
//                    auxSub += "\t\t"  + aux.getNomeNode() +'\n';
//                }
//            }
//        }
//        System.out.println(auxSub);
//        this.getSubGraph().add(auxSub);
//    }
//
//    private void PadraoSubGrafo() {
//        String auxReturn = "";
//        System.out.println(this.getSubGraph() + " OI");
//        for (String aux : this.getSubGraph()) {
//            auxReturn += "\tsubgraph " + "cluster_" + this.getLabelSubGrap().toLowerCase() + "{\n" +
//                    "\t\tlabel="+ this.getLabelSubGrap() + "\n" +
//                    this.toStringNotNullSubGrafo() +
//                    "\t}" + "\n";
//        }
//        this.getSubGraph().add(auxReturn);
//    }
//
//    private String toStringNotNullSubGrafo(){
//        String auxReturn = "";
//        if(!this.getLabelLocSubGrafo().isEmpty()){
//            auxReturn += "\t\tlabelloc=\"" + this.getLabelLocSubGrafo() + "\"\n";
//        }if(this.getFontSubGrap()!=0){
//            auxReturn += "\t\tfontsize=" + this.getFontSubGrap() + "\n";
//        }if(!this.getStyleSubGrap().isEmpty()){
//            auxReturn += "\t\tstyle=" + this.getStyleSubGrap() + "\n";
//        }if(!this.getBgcolorSubGrap().isEmpty()){
//            auxReturn += "\t\tbgcolor=\"" + this.getBgcolorSubGrap() + "\"\n";
//        }
//        return auxReturn;
//    }
//
//
//    @Override
//    public String toString() {
//        return "SubGrafo{" +
//                "nos=" + nos +
//                '}';
//    }
//}
