package edu.mum.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Category {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
    
    String name;
    String description;
    
    @ManyToMany(mappedBy="categories",fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST,CascadeType.MERGE })
    private List<Item> items = new ArrayList<Item>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// Regular many-to-many
    public List<Item> getItems() { return items; }
    public void addItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Null item!");
        items.add(item);
        item.getCategories().add(this);
    }
    public void removeItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Null item!");
        items.remove(item);
        item.getCategories().remove(this);
    }

}
