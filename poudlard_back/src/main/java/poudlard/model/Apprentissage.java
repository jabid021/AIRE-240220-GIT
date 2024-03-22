package poudlard.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="apprentissage")
public class Apprentissage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_apprentissage")
	private LocalDate dateApprentissage;
	
	@ManyToOne
	@JoinColumn(name="sorcier")
	private Sorcier sorcier;
	
	@ManyToOne
	@JoinColumn(name="sort")
	private Sort sort;
	
	
	public Apprentissage() {}


	public Apprentissage(Sorcier sorcier, Sort sort) {
		this.dateApprentissage=LocalDate.now();
		this.sorcier = sorcier;
		this.sort = sort;
	}
	
	
}
