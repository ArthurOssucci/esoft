class CarroEletrico extends Carro {
    private double bateriaKWh;

    public CarroEletrico(String marca, String modelo, int ano, int capacidadePassageiros, String tipoCarro, double bateriaKWh) {
        super(marca, modelo, ano, capacidadePassageiros, "Elétrico", tipoCarro);
        this.bateriaKWh = bateriaKWh;
    }

    public double calcularAutonomia() {
        return bateriaKWh * 5;
    }
}