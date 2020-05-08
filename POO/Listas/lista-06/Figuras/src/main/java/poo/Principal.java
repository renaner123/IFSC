package poo;

/**
 * Classe responsável por instanciar as classes do Exercicío Aplicativo para desenho vetoria
 * @author  Renan Rodolfo da Silva
 */
public class Principal {

    public static void main(String[] args) {

        System.out.println("Instanciando Ponto");
        Ponto p = new Ponto(2,3);
        p.desenhar();

        System.out.println("\n");
        System.out.println("Instanciando Linha");

        Linha l = new Linha(1,2,4,6);
        l.desenhar();

        System.out.println("\n");
        System.out.println("Instanciando Cubo");

        Cubo c = new Cubo(3,4,6);
        c.desenhar();
        System.out.println(c.calcularArea());

        System.out.println("\n");
        System.out.println("Instanciando Triangulo");

        Triangulo t = new Triangulo(2,2,3,4,5);
        t.desenhar();
        System.out.println(t.calcularArea());

        System.out.println("\n");
        System.out.println("Instanciando Circulo");

        Circulo circulo = new Circulo(3,3,4);
        circulo.desenhar();
        System.out.println(circulo.calcularArea());

        System.out.println("\n");
        System.out.println("Instanciando Retangulo");

        Retangulo r = new Retangulo(5,7,4,6);
        r.desenhar();
        System.out.println(r.calcularArea());
    }
}
