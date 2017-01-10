package domain;

import domain.antywirus;

import javax.persistence.*;

/**
 * Created by GSun12 on 21.12.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name="model.all", query = "select p from pakiet p"),
        @NamedQuery(name = "model.byfunkcje",query = "select p from pakiet p where p.funkcje=:funkcje "),
        @NamedQuery(name = "model.byantywirus",query = "select b from pakiet b where b.antywirus=:antywirus")
})
public class pakiet {

    private Long id_pakiet;
    private String nazwapakiet;
    private String funkcje;
    private Double cena;
    private antywirus antywirus;

    @Id
    @Column(name = "IDModel")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id_pakiet;
    }

    public void setId(Long id_pakiet) {
        this.id_pakiet = id_pakiet;
    }

    public String getNazwapakiet() {
        return nazwapakiet;
    }

    public void setNazwapakiet(String nazwapakiet) {
        this.nazwapakiet = nazwapakiet;
    }
    @Column(unique = true,nullable = false)
    public String getfunkcje() {
        return funkcje;
    }

    public void setfunkcje(String funkcje) {
        this.funkcje = funkcje;
    }

    public String getcena() {
        return cena;
    }

    public void setcena(String cena) {
        this.cena = cena;
    }
    @ManyToOne
    @JoinColumn(name = "antywirus_IDantywirus")
    public antywirus getAntywirus() {
        return antywirus;
    }

    public void setAntywirus(antywirus antywirus) {
        this.antywirus = antywirus;
    }
}
