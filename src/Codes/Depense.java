package Codes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Depense {
    private String description;
    private double montant;
    private LocalDateTime date;
    private TypeDepense typeDepense;

    public Depense(String description, double montant, TypeDepense typeDepense) {
        this.description = description;
        this.montant = montant;
        this.date = LocalDateTime.now();
        this.typeDepense = typeDepense;
    }

    public enum TypeDepense {
        Alimentation,
        Transport,
        Divertissement,
        ServicesPublics,
        Autres,
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TypeDepense getTypeDepense() {
        return typeDepense;
    }

    public void setTypeDepense(TypeDepense typeDepense) {
        this.typeDepense = typeDepense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depense depense = (Depense) o;
        return Double.compare(depense.montant, montant) == 0 &&
                Objects.equals(description, depense.description) &&
                Objects.equals(date, depense.date) &&
                typeDepense == depense.typeDepense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, montant, date, typeDepense);
    }

    @Override
    public String toString() {
        return "Depense{" +
                "description='" + description + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", typeDepense=" + typeDepense +
                '}';
    }
}
