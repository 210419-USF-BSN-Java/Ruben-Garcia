package models;
import java.io.Serializable;

public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; 
	private String name; 
	private Boolean statusowned; 
	private Double price; 
	
	public Item() {
		super(); 
	}
	
	public Item(Integer id, String name, Boolean statusowned, Double price) {
		this.id = id; 
		this.name = name; 
		this.statusowned = statusowned; 
		this.price = price; 
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem_name() {
		return name;
	}
	public void setItem_name(String item_name) {
		this.name = item_name;
	}
	public Boolean getStatusowned() {
		return statusowned;
	}
	public void setStatusowned(Boolean statusowned) {
		this.statusowned = statusowned;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((statusowned == null) ? 0 : statusowned.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (statusowned == null) {
			if (other.statusowned != null)
				return false;
		} else if (!statusowned.equals(other.statusowned))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "item [id=" + id + ", item_name=" + name + ", statusowned=" + statusowned + ", price=" + price
				+ "]";
	}
	
}
