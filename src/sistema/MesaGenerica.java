package sistema;


import java.util.*;

/**
 * 
 */
public abstract class MesaGenerica {
	
    private static int incrementoNumMesa = 0;
    private int numeroMesa;
    private Votante presidenteMesa;
    private String tipoMesa;
    
    /**
     * Default constructor
     */
    
    public MesaGenerica(Votante presidenteMesa , String tipoMesa) {
    	incrementoNumMesa += 1;
    	this.numeroMesa = incrementoNumMesa;
    	this.presidenteMesa = presidenteMesa;
    	this.tipoMesa = tipoMesa;
    }
    public abstract void asignarVotanteAFranjaHoraria(int franja, Votante votante);

    public abstract int cantTotalVotantesMesa();
    
    public abstract int turnosRestantesTodasLasFranjas();

    public  String consultarTipoMesa() {
    	return tipoMesa;
    }
    public abstract FranjaHoraria franjaConDisponibilidad();

    public abstract Map<Integer, List<Integer>> votantesDeFranjas();
    
    public int mostrarNumeroMesa() {
        // TODO implement here
        return numeroMesa;
    }
  
    public Votante consultarPresidenteMesa() {
    	return presidenteMesa;
    }
   
    public abstract boolean validarVotante(Votante votante);
    
	// Mesa.validarVotante -> metodo de mesa
	// Modificar de tal forma de aprovechar polimorfismo, cada mesa debe saber si el votante que le ingreso es valido
    // Determina si la mesa es valida para el votante
    public boolean esMesaValida(Votante votante) {
    	if(turnosRestantesTodasLasFranjas() > 0) {
    		//String tipoMesa = consultarTipoMesa();
    		// Si pude asignar el turno, lo devuelvo, sino devuelvo null
    		if(validarVotante(votante)) {
    			return true;
    		}  	
    	}
    	
    	return false;
    }
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("\nMesa: \n\tNumero de Mesa: ");
		cadena.append(numeroMesa);
		cadena.append(", \n\tTipo de Mesa: ").append(tipoMesa);
		cadena.append(presidenteMesa.toString(true));
		return cadena.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime + numeroMesa;
		result = prime * result + ((presidenteMesa == null) ? 0 : presidenteMesa.hashCode());
		result = prime * result + ((tipoMesa == null) ? 0 : tipoMesa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		if(!(obj instanceof MesaGenerica)) {
			return false;
		}
		MesaGenerica otraMesa = (MesaGenerica) obj;		
		return this.mostrarNumeroMesa() != otraMesa.mostrarNumeroMesa();
	}
	
	


}