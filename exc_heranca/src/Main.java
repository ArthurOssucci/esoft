public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 5, "Gasolina", "Sedan");
        Caminhao caminhao = new Caminhao("Volvo", "FH16", 2020, 2, "Diesel", 5);
        Onibus onibus = new Onibus("Mercedes", "OF-1721", 2019, 50, "Diesel", 6);
        CarroEletrico carroEletrico = new CarroEletrico("Tesla", "Model S", 2023, 5, "Sedan", 100);
        CaminhaoRefrigerado caminhaoRefrigerado = new CaminhaoRefrigerado("Scania", "R450", 2021, 2, "Diesel", 8, -10);
        
        carro.exibirDetalhes();
        System.out.println();
        caminhao.exibirDetalhes();
        System.out.println();
        onibus.exibirDetalhes();
        System.out.println();
        carroEletrico.exibirDetalhes();
        System.out.println();
        caminhaoRefrigerado.exibirDetalhes();
    }
}