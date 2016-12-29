package modelo;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="Vuelo",uniqueConstraints=@UniqueConstraint(columnNames={"ID", "NUMERO"} ) )
public class Vuelo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	
	@Column(name="NUMERO", nullable=false, unique=true)
	private int numero;
	
	@Transient
	public transient int longitudMillas;
	
	@Formula("longitud*3")
	public int longitudPies;
	
	@Basic
	@Column(name="LONGITUD", nullable=false)
	private int longitud;
	
	@Temporal(TemporalType.TIME)
	@Column(name="HORASALIDA", nullable=false)
	private Date horaSalida;
	
	public enum TipoVuelo {NACIONAL,EUROPA,ASIA,AMERICA};
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPOVUELO", nullable=false)
	private TipoVuelo tipoVuelo; 
		
	@Lob
	@Column(name="TEXTO", nullable=false)
	private String texto; 

	@Lob
	private char[] codigo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getLongitudMillas() {
		return longitudMillas;
	}
	public void setLongitudMillas(int longitudMillas) {
		this.longitudMillas = longitudMillas;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public Date getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}
	public TipoVuelo getTipo() {
		return tipoVuelo;
	}
	public void setTipo(TipoVuelo tipo) {
		this.tipoVuelo = tipo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
		
	public char[] getCodigo() {
		return codigo;
	}
	public void setCodigo(char[] codigo) {
		this.codigo = codigo;
	}
	
	
	public int getLongitudPies() {
		return longitudPies;
	}
	public void setLongitudPies(int longitudPies) {
		this.longitudPies = longitudPies;
	}
	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", numero=" + numero + ", longitud="
				+ longitud + ", horaSalida=" + horaSalida + ", tipoVuelo="
				+ tipoVuelo + ", texto=" + texto + ", codigo="
				+ Arrays.toString(codigo) + ",longPies="+ longitudPies+"]";
	}
	public TipoVuelo getTipoVuelo() {
		return tipoVuelo;
	}
	public void setTipoVuelo(TipoVuelo tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}
	
	
	
}
