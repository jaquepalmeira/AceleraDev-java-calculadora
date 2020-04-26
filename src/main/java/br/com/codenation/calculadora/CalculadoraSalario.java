package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if(salarioBase < 1039.00){
			return Math.round(0.0);
		}
		else{
			double DescontoInss = calcularInss(salarioBase);
			double salarioLiquido = calcularIrrf(DescontoInss);
			return Math.round(salarioLiquido);
		}
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double percentual8 =salarioBase * 8 / 100;
		double percentual9 = salarioBase * 9 / 100;
		double percentual11 = salarioBase * 11 / 100;
		double salarioDescontoInss;

		if(salarioBase <= 1500.00){
			salarioDescontoInss = salarioBase - percentual8;
		}
		else if(salarioBase > 1500.00 && salarioBase <= 4000.00){
			salarioDescontoInss = salarioBase - percentual9;
		}
		else {
			salarioDescontoInss = salarioBase - percentual11;
		}
		return salarioDescontoInss;
	}

	private double calcularIrrf(double salarioDescontoInss){
		double isento = salarioDescontoInss;
		double percentual7 = salarioDescontoInss * 7.5 / 100;
		double percentual15 = salarioDescontoInss * 15 / 100;
		double salarioDescontoIrrf;

		if(salarioDescontoInss <= 3000.00){
			salarioDescontoIrrf = isento;
		}
		else if (salarioDescontoInss > 3000.00 && salarioDescontoInss <= 6000.00){
			salarioDescontoIrrf = salarioDescontoInss - percentual7;
		}
		else {
			salarioDescontoIrrf = salarioDescontoInss - percentual15;
		}
		return salarioDescontoIrrf;
	}
}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/