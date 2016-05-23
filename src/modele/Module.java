package modele;

import java.util.Objects;



public class Module {
    private int id;
    private String intitule;
    private String description;
    private int nb_jour;

    public Module (int id, String intitule, String description, int nb_jour){
        this.id = id;
        this.intitule = intitule;
        this.description = description;
        this.nb_jour = nb_jour;
    }
    public Module(){
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_jour() {
        return nb_jour;
    }

    public void setNb_jour(int nb_jour) {
        this.nb_jour = nb_jour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.intitule);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + this.nb_jour;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Module other = (Module) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nb_jour != other.nb_jour) {
            return false;
        }
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    
}
