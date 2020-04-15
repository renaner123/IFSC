package poo;

public class Robo {

    private int posX;
    private int posY;
    private char frente;
    private int area;

    public Robo(int posX, int posY, char frente, int area) {

        if((posX <= area && posX >0) && (posY <= area)&& posY>0) {
            this.posX = posX;
            this.posY = posY;
            this.area = area;
        }else{
            System.out.println("Posição inicial deve ser menor que a área. Indo para posição padrão 2,3");
            this.posX = 2;
            this.posY = 3;
            this.area = area;
        }
        if((frente != 'N') && (frente != 'S') && (frente != 'O') && (frente != 'L')){
            System.out.println("Frente inválida. indo para frente padrão 'N' ");
            this.frente = 'N';
        }else{
            this.frente = frente;
        }
    }

    public Robo(){
        this(2,3,'N',8);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public char getFrente() {
        return frente;
    }

    public void setFrente(char frente) {
        this.frente = frente;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Robo{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", frente=" + frente +
                ", area=" + area +
                '}';
    }

    public String[] explorar(String comandos){
        /*
            N
          O   L
            S
         */
        // E D M
        /*       y y y y y y
                x
                x
                x
         */
        char c;
        String[] movimentacoes = new String[comandos.length()];

        if(comandos.length()>0 && comandos.length()<=100) {

            for (int i = 0; i < comandos.length(); i++) {
                c = comandos.charAt(i);
                char front = this.frente;
                int auxX = posX;
                int auxY = posY;
                char auxFrente = frente;

                if (c == 'E') {
                    if (front == 'N') {
                        this.frente = 'O';

                    } else if (front == 'S') {
                        this.frente = 'L';

                    } else if (front == 'O') {
                        this.frente = 'S';

                    } else if (front == 'L') {
                        this.frente = 'N';
                    }

                } else if (c == 'D') {

                    if (front == 'N') {
                        this.frente = 'L';

                    } else if (front == 'S') {
                        this.frente = 'O';

                    } else if (front == 'O') {
                        this.frente = 'N';

                    } else if (front == 'L') {
                        this.frente = 'S';
                    }

                } else if (c == 'M') {

                    if (this.frente == 'N') {
                        if (this.posX > 0) {
                            this.posX--;
                        } else {
                            //saida[i] =("Excedeu valaor de x");
                        }


                    } else if (this.frente == 'S') {
                        if (this.posX < this.area) {
                            this.posX++;
                        } else {
                            //saida[i] =("Excedeu valaor de x");
                        }

                    } else if (this.frente == 'O') {
                        if (this.posY > 0) {
                            this.posY--;
                        } else {
                            //saida[i] =("Excedeu valaor de y");
                        }

                    } else if (this.frente == 'L') {
                        if (this.posY < this.area) {
                            this.posY++;
                        } else {
                            //saida[i] =("Excedeu valaor de y");
                        }

                    }
                }

                movimentacoes[i]=("c " + c + " andou de: " + auxX + " " + auxY + " " + auxFrente + " para: " + this.getPosX() + " " + this.getPosY() + " " + this.getFrente());

            }
        }else{
            System.out.println("Lista de comandos deverá ter no mínimo 1 e no máximo 100 comandos");
        }

        return movimentacoes;
    }


}
