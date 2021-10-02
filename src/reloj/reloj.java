/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

/**
 *
 * @author Angela
 */
public class reloj {

    private Hora hora;
    private Minuto minuto;
    private Segundo segundo;

    public reloj() {
        hora = new Hora();
        minuto = new Minuto();
        segundo = new Segundo();
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public int getHora() {
        return hora.getValor();
    }

    public void setMinuto(Minuto minuto) {
        this.minuto = minuto;
    }

    public int getMinuto() {
        return minuto.getValor();
    }

    public void setSegundo(Segundo segundo) {
        this.segundo = segundo;
    }

    public int getSegundo() {
        return segundo.getValor();
    }

    public void adelante() {
        segundo.avanzar();
        if (segundo.getValor() == 0) {
            minuto.avanzar();
            if (minuto.getValor() == 0) {
                hora.avanzar();
                if (hora.getValor() == 24) {
                    segundo.avanzar();
                }
            }
        }
    }

    public void retroceder() {
        if (segundo.getValor() >= 0) {
            if (segundo.getValor() > 0) {
                segundo.retroceder();
            }
            else if (segundo.getValor() == 0 && minuto.getValor() > 0) {
                minuto.retroceder();
                segundo.setValor(59);
                if (minuto.getValor() == 0 && hora.getValor() > 0) {
                    hora.retroceder();
                    minuto.setValor(59);
                }
            }
        }
    }

    public void restablecer() {
        int vresta = 0;
        hora.setValor(vresta);
        minuto.setValor(vresta);
        segundo.setValor(vresta);
    }

    public String mTiempo() {
        String str = String.format("(%d : %d : %d)", hora.getValor(), minuto.getValor(), segundo.getValor());
        return str;
    }
}
