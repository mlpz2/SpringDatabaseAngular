package com.mlpz.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	@Column(name = "id_a1")
	private Integer idA1;
	@Column(name = "id_a2")
	private Integer idA2;
	@Column(name = "id_a3")
	private Integer idA3;
	@Column(name = "id_a4")
	private Integer idA4;
	@Column(name = "id_a5")
	private Integer idA5;
	@Column(name = "id_a6")
	private Integer idA6;
	@Column(name = "id_a7")
	private Integer idA7;
	@Column(name = "id_a8")
	private Integer idA8;
	@Column(name = "id_a9")
	private Integer idA9;
	@Column(name = "id_a10")
	private Integer idA10;
	
	public Curso() {}

	public Curso(int id) {
		this.id = id;
	}
	
	public Curso(String nombre, Integer ...idA) {
		this.nombre = nombre;
		for (int i = 0; i < idA.length; i++) {
			switch (i+1) {
				case 1: {
					this.idA1 = idA[i];
					break;
				}
				case 2: {
					this.idA2 = idA[i];
					break;
				}
				case 3: {
					this.idA3 = idA[i];
					break;
				}
				case 4: {
					this.idA4 = idA[i];
					break;
				}
				case 5: {
					this.idA5 = idA[i];
					break;
				}
				case 6: {
					this.idA6 = idA[i];
					break;
				}
				case 7: {
					this.idA7 = idA[i];
					break;
				}
				case 8: {
					this.idA8 = idA[i];
					break;
				}
				case 9: {
					this.idA9 = idA[i];
					break;
				}
				case 10: {
					this.idA10 = idA[i];
					break;
				}
			
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdA1() {
		return idA1;
	}

	public void setIdA1(int idA1) {
		this.idA1 = idA1;
	}

	public Integer getIdA2() {
		return idA2;
	}

	public void setIdA2(int idA2) {
		this.idA2 = idA2;
	}

	public Integer getIdA3() {
		return idA3;
	}

	public void setIdA3(int idA3) {
		this.idA3 = idA3;
	}

	public Integer getIdA4() {
		return idA4;
	}

	public void setIdA4(int idA4) {
		this.idA4 = idA4;
	}

	public Integer getIdA5() {
		return idA5;
	}

	public void setIdA5(int idA5) {
		this.idA5 = idA5;
	}

	public Integer getIdA6() {
		return idA6;
	}

	public void setIdA6(int idA6) {
		this.idA6 = idA6;
	}

	public Integer getIdA7() {
		return idA7;
	}

	public void setIdA7(int idA7) {
		this.idA7 = idA7;
	}

	public Integer getIdA8() {
		return idA8;
	}

	public void setIdA8(int idA8) {
		this.idA8 = idA8;
	}

	public Integer getIdA9() {
		return idA9;
	}

	public void setIdA9(int idA9) {
		this.idA9 = idA9;
	}

	public Integer getIdA10() {
		return idA10;
	}

	public void setIdA10(int idA10) {
		this.idA10 = idA10;
	}

//	public List<Integer> getAsignaturas(){
//		List<Integer> aux = new ArrayList<Integer>();
//		if(idA1 != null) aux.add(idA1);
//		if(idA2 != null) aux.add(idA2);
//		if(idA3 != null) aux.add(idA3);
//		if(idA4 != null) aux.add(idA4);
//		if(idA5 != null) aux.add(idA5);
//		if(idA6 != null) aux.add(idA6);
//		if(idA7 != null) aux.add(idA7);
//		if(idA8 != null) aux.add(idA8);
//		if(idA9 != null) aux.add(idA9);
//		if(idA10 != null) aux.add(idA10);
//		return aux;
//	}

}
