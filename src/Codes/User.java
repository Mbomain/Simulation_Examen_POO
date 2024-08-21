package Codes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String nom;
    private double salaireMensuel;
    private List<Depense> depenses;

    public User(String nom, double salaireMensuel, List<Depense> depenses) {
        this.nom = nom;
        this.salaireMensuel = salaireMensuel;
        this.depenses = depenses;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setSalaireMensuel(double salaireMensuel) {
        this.salaireMensuel = salaireMensuel;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }

    public void ajouterDepense(Depense depense) {
        this.depenses.add(depense);
    }

    public List<Depense> toutesDepensesParCategorie(Depense.TypeDepense categorie) {
        ArrayList<Depense> depensesMemeCategorie = new ArrayList<>();
        for (Depense d : depenses) {
            if (d.getTypeDepense() == categorie) {
                depensesMemeCategorie.add(d);
            }
        }
        return depensesMemeCategorie;
    }

    public double totalDepensesParMois(Month mois) {
        double total = 0;
        for (Depense depense : depenses) {
            LocalDate dateDepense = depense.getDate().toLocalDate();
            if (dateDepense.getMonth() == mois) {
                total += depense.getMontant();
            }
        }
        return total;
    }

    public double budgetRestant(Month mois) {
        return this.salaireMensuel - this.totalDepensesParMois(mois);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.salaireMensuel, salaireMensuel) == 0 &&
                Objects.equals(nom, user.nom) &&
                Objects.equals(depenses, user.depenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, salaireMensuel, depenses);
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", salaireMensuel=" + salaireMensuel +
                ", depenses=" + depenses +
                '}';
    }
}
