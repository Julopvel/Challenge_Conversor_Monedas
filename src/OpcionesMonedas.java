
public class OpcionesMonedas {
    private double tasaCambioCOP_MXN = 229.61;
    private double tasaCambioCOP_USD = 3928.63;
    private double tasaCambioCOP_EUR = 4250.38;
    private double tasaCambioCOP_JPY = 26.11;
    private double tasaCambioCOP_CNY = 546.23;
    private double tasaCambioMXN_USD = 0.058;
    private double tasaCambioMXN_EUR = 0.054;
    private double tasaCambioMXN_JPY = 8.8;
    private double tasaCambioMXN_CNY = 0.42;
    private double tasaCambioUSD_EUR = 0.92;
    private double tasaCambioUSD_JPY = 150.46;
    private double tasaCambioUSD_CNY = 7.2;
    private double tasaCambioEUR_JPY = 162.89;
    private double tasaCambioEUR_CNY = 7.69;
    private double tasaCambioJPY_CNY = 0.048;
    private double cantidadDecimales = 1000000.0;

    public OpcionesMonedas() {
    }

    public double COP_MXN(double valor) {
        return (double)Math.round(valor / 229.61 * 1000000.0) / 1000000.0;
    }

    public double COP_USD(double valor) {
        return (double)Math.round(valor / this.tasaCambioCOP_USD * 1000000.0) / 1000000.0;
    }

    public double COP_EUR(double valor) {
        return (double)Math.round(valor / this.tasaCambioCOP_EUR * 1000000.0) / 1000000.0;
    }

    public double COP_JPY(double valor) {
        return (double)Math.round(valor / this.tasaCambioCOP_JPY * 1000000.0) / 1000000.0;
    }

    public double COP_CNY(double valor) {
        return (double)Math.round(valor / this.tasaCambioCOP_CNY * 1000000.0) / 1000000.0;
    }

    public double MXN_COP(double valor) {
        return (double)Math.round(valor * 229.61 * 1000000.0) / 1000000.0;
    }

    public double MXN_USD(double valor) {
        return (double)Math.round(valor * this.tasaCambioMXN_USD * 1000000.0) / 1000000.0;
    }

    public double MXN_EUR(double valor) {
        return (double)Math.round(valor * this.tasaCambioMXN_EUR * 1000000.0) / 1000000.0;
    }

    public double MXN_JPY(double valor) {
        return (double)Math.round(valor * this.tasaCambioMXN_JPY * 1000000.0) / 1000000.0;
    }

    public double MXN_CNY(double valor) {
        return (double)Math.round(valor * this.tasaCambioMXN_CNY * 1000000.0) / 1000000.0;
    }

    public double USD_COP(double valor) {
        return (double)Math.round(valor * this.tasaCambioCOP_USD * 1000000.0) / 1000000.0;
    }

    public double USD_MXN(double valor) {
        return (double)Math.round(valor / this.tasaCambioMXN_USD * 1000000.0) / 1000000.0;
    }

    public double USD_EUR(double valor) {
        return (double)Math.round(valor * this.tasaCambioUSD_EUR * 1000000.0) / 1000000.0;
    }

    public double USD_JPY(double valor) {
        return (double)Math.round(valor * this.tasaCambioUSD_JPY * 1000000.0) / 1000000.0;
    }

    public double USD_CNY(double valor) {
        return (double)Math.round(valor * this.tasaCambioUSD_CNY * 1000000.0) / 1000000.0;
    }

    public double EUR_COP(double valor) {
        return (double)Math.round(valor * this.tasaCambioCOP_EUR * 1000000.0) / 1000000.0;
    }

    public double EUR_MXN(double valor) {
        return (double)Math.round(valor / this.tasaCambioMXN_EUR * 1000000.0) / 1000000.0;
    }

    public double EUR_USD(double valor) {
        return (double)Math.round(valor / this.tasaCambioUSD_EUR * 1000000.0) / 1000000.0;
    }

    public double EUR_JPY(double valor) {
        return (double)Math.round(valor * this.tasaCambioEUR_JPY * 1000000.0) / 1000000.0;
    }

    public double EUR_CNY(double valor) {
        return (double)Math.round(valor * this.tasaCambioEUR_CNY * 1000000.0) / 1000000.0;
    }

    public double JPY_COP(double valor) {
        return (double)Math.round(valor * this.tasaCambioCOP_JPY * 1000000.0) / 1000000.0;
    }

    public double JPY_MXN(double valor) {
        return (double)Math.round(valor / this.tasaCambioMXN_JPY * 1000000.0) / 1000000.0;
    }

    public double JPY_USD(double valor) {
        return (double)Math.round(valor / this.tasaCambioUSD_JPY * 1000000.0) / 1000000.0;
    }

    public double JPY_EUR(double valor) {
        return (double)Math.round(valor / this.tasaCambioEUR_JPY * 1000000.0) / 1000000.0;
    }

    public double JPY_CNY(double valor) {
        return (double)Math.round(valor * this.tasaCambioJPY_CNY * 1000000.0) / 1000000.0;
    }

    public double CNY_COP(double valor) {
        return (double)Math.round(valor * this.tasaCambioCOP_CNY * 1000000.0) / 1000000.0;
    }

    public double CNY_MXN(double valor) {
        return (double)Math.round(valor / this.tasaCambioMXN_CNY * 1000000.0) / 1000000.0;
    }

    public double CNY_USD(double valor) {
        return (double)Math.round(valor / this.tasaCambioUSD_CNY * 1000000.0) / 1000000.0;
    }

    public double CNY_EUR(double valor) {
        return (double)Math.round(valor / this.tasaCambioEUR_CNY * 1000000.0) / 1000000.0;
    }

    public double CNY_JPY(double valor) {
        return (double)Math.round(valor / this.tasaCambioJPY_CNY * 1000000.0) / 1000000.0;
    }
}
