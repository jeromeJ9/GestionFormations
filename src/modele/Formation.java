package modele;

import java.util.List;
import java.util.Objects;


public class Formation {
    private int id;
    private String intitule;
    private String description;
    private List<Module> module;
    private int nbJoursTotal;
    
   
    
    public Formation(){
    }

    public Formation(String intitule, String description) {
        this.intitule = intitule;
        this.description = description;
       
    }
    
    public Formation(int id,String intitule, String description, List<Module> module) {
        this.id = id;
        this.intitule = intitule;
        this.description = description;
        this.module = module;
    }

    public Formation(int id, String intitule, String description) {
        this.id = id;
        this.intitule = intitule;
        this.description = description;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Module> getModule() {
        return module;
    }

    public void setModule(List<Module> module) {
        this.module = module;
    }

    public int getNbJours() {
        return nbJoursTotal;
    }

    public void setNbJours(int nbJours) {
        this.nbJoursTotal = nbJours;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", intitule=" + intitule + ", description=" + description + ", module=" + module + ", nbJoursTotal=" + nbJoursTotal + '}';
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.intitule);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.module);
        hash = 67 * hash + this.nbJoursTotal;
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
        final Formation other = (Formation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nbJoursTotal != other.nbJoursTotal) {
            return false;
        }
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.module, other.module)) {
            return false;
        }
        return true;
    }

}
