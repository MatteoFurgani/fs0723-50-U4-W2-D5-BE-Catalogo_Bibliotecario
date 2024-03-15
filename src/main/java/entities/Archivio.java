package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Archivio {

    private List<Pubblicazione> pubblicazioni;
    public Archivio() {

        pubblicazioni = new ArrayList<>();
    }

    public void aggiungiElemento(Pubblicazione elemento) {

        pubblicazioni.add(elemento);
    }

    public void rimuoviElementoPerISBN(String isbn) {
        pubblicazioni.removeIf(p -> p.getIsbn().equals(isbn));
    }

    public Optional<Pubblicazione> ricercaPerISBN(String isbn) {
        return pubblicazioni.stream().filter(p -> p.getIsbn().equals(isbn)).findFirst();
    }

    public List<Pubblicazione> ricercaPerAnnoPubblicazione(int anno) {
        return pubblicazioni.stream().filter(p -> p.getAnnoPubblicazione() == anno).toList();
    }

    public List<Pubblicazione> ricercaPerAutore(String cognome) {
        return pubblicazioni.stream().filter(p -> p instanceof Libri).filter(p -> {
            Libri libro = (Libri) p;
            return libro.getAutore().equals(cognome);
        }).toList();
    }



}
